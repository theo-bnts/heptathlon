package fr.bnts.heptathlon.main_server.rmi;

import fr.bnts.heptathlon.main_server.database.Database;
import fr.bnts.heptathlon.main_server.entities.Invoice;
import fr.bnts.heptathlon.main_server.entities.InvoiceProduct;
import fr.bnts.heptathlon.main_server.entities.Product;
import fr.bnts.heptathlon.main_server.entities.ProductCategory;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;

public interface Service extends Remote {
    ProductCategory getProductCategory(Database database, int id) throws RemoteException, SQLException;

    List<ProductCategory> getProductCategories(Database database) throws RemoteException, SQLException;

    void addProductCategory(Database database, ProductCategory productCategory) throws RemoteException, SQLException;

    Product getProduct(Database database, String id) throws RemoteException, SQLException;

    List<Product> getProducts(Database database) throws RemoteException, SQLException;

    List<Product> getProducts(Database database, ProductCategory category) throws RemoteException, SQLException;

    void updateProduct(Database database, Product product) throws RemoteException, SQLException;

    void addProduct(Database database, Product product) throws RemoteException, SQLException;

    List<InvoiceProduct> getInvoiceProducts(Database database, String checkoutId) throws RemoteException, SQLException;

    List<InvoiceProduct> getInvoiceProducts(Database database, Invoice invoice) throws RemoteException,
            SQLException;

    void addInvoiceProduct(Database database, InvoiceProduct invoiceProduct) throws RemoteException, SQLException;

    Invoice getInvoice(Database database, String id) throws RemoteException, SQLException;

    List<Invoice> getInvoices(Database database) throws RemoteException, SQLException;

    void addInvoice(Database database, Invoice invoice) throws RemoteException, SQLException;

    String getInvoiceFileFullPath(String packageName, Invoice invoice) throws RemoteException;

    byte[] readInvoiceFile(String packageName, Invoice invoice) throws RemoteException, IOException;

    void writeInvoiceFile(String packageName, Invoice invoice, byte[] file) throws IOException;
}
