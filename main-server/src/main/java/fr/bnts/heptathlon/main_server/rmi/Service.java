package fr.bnts.heptathlon.main_server.rmi;

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
    ProductCategory getProductCategory(int id) throws RemoteException, SQLException;

    List<ProductCategory> getProductCategories() throws RemoteException, SQLException;

    void addProductCategory(ProductCategory productCategory) throws RemoteException, SQLException;

    Product getProduct(String id) throws RemoteException, SQLException;

    List<Product> getProducts() throws RemoteException, SQLException;

    List<Product> getProducts(ProductCategory category) throws RemoteException, SQLException;

    void updateProduct(Product product) throws RemoteException, SQLException;

    void addProduct(Product product) throws RemoteException, SQLException;

    List<InvoiceProduct> getInvoiceProducts(Invoice invoice) throws RemoteException,
            SQLException;

    void addInvoiceProduct(InvoiceProduct invoiceProduct) throws RemoteException, SQLException;

    Invoice getInvoice(String id) throws RemoteException, SQLException;

    List<Invoice> getInvoices() throws RemoteException, SQLException;

    void addInvoice(Invoice invoice) throws RemoteException, SQLException;

    String getInvoiceFileFullPath(String packageName, Invoice invoice) throws RemoteException;

    byte[] readInvoiceFile(String packageName, Invoice invoice) throws RemoteException, IOException;

    void writeInvoiceFile(String packageName, Invoice invoice, byte[] file) throws IOException;
}
