package fr.bnts.heptathlon.client_server.tools;

import fr.bnts.heptathlon.main_server.dao.*;
import fr.bnts.heptathlon.main_server.database.DatabaseConnector;
import fr.bnts.heptathlon.main_server.entities.Invoice;
import fr.bnts.heptathlon.main_server.entities.InvoiceProduct;
import fr.bnts.heptathlon.main_server.entities.Product;
import fr.bnts.heptathlon.main_server.entities.ProductCategory;
import fr.bnts.heptathlon.main_server.rmi.Service;

import java.io.IOException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalTime;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class DataSynchronisation {
    private final LocalTime PRICE_SYNCHRONISATION_TIME = LocalTime.of(6, 0);
    private final LocalTime INVOICE_SYNCHRONISATION_TIME = LocalTime.of(22, 0);

    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    Service remoteService;
    DatabaseConnector database;
    InvoiceFileDAO invoiceFileDAO;

    public DataSynchronisation(Service remoteService,
                               DatabaseConnector localDatabaseConnector,
                               InvoiceFileDAO invoiceFileDAO) {
        this.remoteService = remoteService;
        this.database = localDatabaseConnector;
        this.invoiceFileDAO = invoiceFileDAO;

        scheduleTasks();
    }

    private void scheduleTasks() {
        Runnable pricesTask = () -> {
            try {
                System.out.println("Synchronising prices from remote");
                synchronisePricesFromRemote();
            } catch (SQLException | RemoteException e) {
                throw new RuntimeException(e);
            }
        };

        Runnable invoicesTask = () -> {
            try {
                System.out.println("Synchronising invoices to remote");
                synchroniseInvoicesToRemote();
            } catch (SQLException | IOException e) {
                throw new RuntimeException(e);
            }
        };

        long initialDelayPrices = calculateInitialDelay(PRICE_SYNCHRONISATION_TIME);
        long initialDelayInvoices = calculateInitialDelay(INVOICE_SYNCHRONISATION_TIME);

        scheduler.scheduleAtFixedRate(pricesTask, initialDelayPrices, TimeUnit.DAYS.toMillis(1), TimeUnit.MILLISECONDS);
        scheduler.scheduleAtFixedRate(invoicesTask, initialDelayInvoices, TimeUnit.DAYS.toMillis(1), TimeUnit.MILLISECONDS);
    }

    private long calculateInitialDelay(LocalTime targetTime) {
        LocalTime now = LocalTime.now();
        long delay;

        if (now.isAfter(targetTime)) {
            delay = TimeUnit.DAYS.toMillis(1) -
                    Duration.between(LocalTime.MIDNIGHT, now).toMillis() +
                    Duration.between(LocalTime.MIDNIGHT, targetTime).toMillis();
        } else {
            delay = Duration.between(now, targetTime).toMillis();
        }

        return delay;
    }

    public void initialiseDatabase() throws SQLException, RemoteException {
        synchroniseProductCategoriesFromRemote();
        synchroniseProductsFromRemote();
    }

    public void synchroniseProductCategoriesFromRemote() throws SQLException, RemoteException {
        List<ProductCategory> productCategories =
                remoteService.getProductCategories();

        for (ProductCategory productCategory : productCategories) {
            ProductCategoryDAO.add(database, productCategory);
        }
    }

    public void synchroniseProductsFromRemote() throws SQLException, RemoteException {
        List<Product> products = remoteService.getProducts();

        for (Product product : products) {
            ProductDAO.add(database, product);
        }
    }

    private void synchronisePricesFromRemote() throws SQLException, RemoteException {
        List<Product> products = ProductDAO.get(database);

        for (Product product : products) {
            Product remoteProduct = remoteService.getProduct(product.getId());

            product.setPrice(remoteProduct.getPrice());

            ProductDAO.update(database, product);
        }
    }

    private void synchroniseInvoicesToRemote() throws SQLException, IOException {
        List<Invoice> invoices = InvoiceDAO.get(database);

        for (Invoice invoice : invoices) {
            Invoice remoteInvoice = remoteService.getInvoice(invoice.getId());

            if (remoteInvoice == null) {
                synchroniseInvoiceProductsToRemote(invoice);

                remoteService.addInvoice(invoice);

                readAndWriteInvoiceFileToRemote(invoice);
            }
        }
    }

    private void synchroniseInvoiceProductsToRemote(Invoice invoice) throws RemoteException, SQLException {
        List<InvoiceProduct> invoiceProducts = InvoiceProductDAO.get(database, invoice);

        for (InvoiceProduct invoiceProduct : invoiceProducts) {
            remoteService.addInvoiceProduct(invoiceProduct);
        }
    }

    private void readAndWriteInvoiceFileToRemote(Invoice invoice) throws RemoteException, IOException {
        byte[] invoiceFile = this.invoiceFileDAO.read(invoice);
        remoteService.writeInvoiceFile(invoice, invoiceFile);
    }
}