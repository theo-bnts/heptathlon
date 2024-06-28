package fr.bnts.heptathlon.client_server.tools;

import fr.bnts.heptathlon.main_server.dao.*;
import fr.bnts.heptathlon.main_server.database.Database;
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
    Service remoteService;
    Database remoteDatabase;
    Database database;
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public DataSynchronisation(Service remoteService,
                               Database remoteDatabase, Database database) {
        this.remoteService = remoteService;
        this.remoteDatabase = remoteDatabase;
        this.database = database;

        scheduleTasks();
    }

    private void scheduleTasks() {
        Runnable pricesTask = () -> {
            try {
                System.out.println("Synchronising prices from remote");
                synchronisePricesFromRemote();
            } catch (SQLException | RemoteException e) {
                e.printStackTrace();
            }
        };

        Runnable invoicesTask = () -> {
            try {
                System.out.println("Synchronising invoices to remote");
                synchroniseInvoicesToRemote();
            } catch (SQLException | IOException e) {
                e.printStackTrace();
            }
        };

        long initialDelayPrices = calculateInitialDelay(LocalTime.of(18, 2));
        long initialDelayInvoices = calculateInitialDelay(LocalTime.of(22, 0));

        scheduler.scheduleAtFixedRate(pricesTask, initialDelayPrices, TimeUnit.DAYS.toMillis(1), TimeUnit.MILLISECONDS);
        scheduler.scheduleAtFixedRate(invoicesTask, initialDelayInvoices, TimeUnit.DAYS.toMillis(1), TimeUnit.MILLISECONDS);
    }

    private long calculateInitialDelay(LocalTime targetTime) {
        LocalTime now = LocalTime.now();
        if (now.isAfter(targetTime)) {
            targetTime = targetTime.plusHours(24);
        }
        return Duration.between(now, targetTime).toMillis();
    }

    public void initialiseDatabase() throws SQLException, RemoteException {
        synchroniseProductCategoriesFromRemote();
        synchroniseProductsFromRemote();
    }

    public void synchroniseProductCategoriesFromRemote() throws SQLException, RemoteException {
        List<ProductCategory> productCategories =
                remoteService.getProductCategories(remoteDatabase);

        for (ProductCategory productCategory : productCategories) {
            ProductCategoryDAO.add(database, productCategory);
        }
    }

    public void synchroniseProductsFromRemote() throws SQLException, RemoteException {
        List<Product> products = remoteService.getProducts(remoteDatabase);

        for (Product product : products) {
            ProductDAO.add(database, product);
        }
    }

    private void synchronisePricesFromRemote() throws SQLException, RemoteException {
        List<Product> products = ProductDAO.get(database);

        for (Product product : products) {
            Product remoteProduct = remoteService.getProduct(remoteDatabase, product.getId());

            product.setPrice(remoteProduct.getPrice());

            ProductDAO.update(database, product);
        }
    }

    private void synchroniseInvoicesToRemote() throws SQLException, IOException {
        List<Invoice> invoices = InvoiceDAO.get(database);

        for (Invoice invoice : invoices) {
            Invoice remoteInvoice = remoteService.getInvoice(remoteDatabase, invoice.getId());

            if (remoteInvoice == null) {
                synchroniseInvoiceProductsToRemote(invoice);

                remoteService.addInvoice(remoteDatabase, invoice);

                readAndWriteInvoiceFileToRemote(invoice);
            }
        }
    }

    private void synchroniseInvoiceProductsToRemote(Invoice invoice) throws RemoteException, SQLException {
        List<InvoiceProduct> invoiceProducts = InvoiceProductDAO.get(database, invoice);

        for (InvoiceProduct invoiceProduct : invoiceProducts) {
            remoteService.addInvoiceProduct(remoteDatabase, invoiceProduct);
        }
    }

    private void readAndWriteInvoiceFileToRemote(Invoice invoice) throws RemoteException, IOException {
        byte[] invoiceFile = InvoiceFileDAO.read("client-server", invoice);
        remoteService.writeInvoiceFile("main-server", invoice, invoiceFile);
    }
}