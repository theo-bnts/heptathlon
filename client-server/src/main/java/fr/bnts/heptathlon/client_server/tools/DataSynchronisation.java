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
import java.util.List;

public class DataSynchronisation {
    Service remoteService;
    Database remoteDatabase;
    Database database;

    public DataSynchronisation(Service remoteService,
                               Database remoteDatabase, Database database) {
        this.remoteService = remoteService;
        this.remoteDatabase = remoteDatabase;
        this.database = database;
    }

    public void initialiseDatabase() throws SQLException, RemoteException {
        synchroniseProductCategoriesFromRemote();
        synchroniseProductsFromRemote();
    }

    public void startSynchronisation() throws SQLException, IOException {
        synchronisePricesFromRemote();
        synchroniseInvoicesToRemote();
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
