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
    List<ProductCategory> getProductCategories() throws RemoteException, SQLException;
    ProductCategory getProductCategory(int id) throws RemoteException, SQLException;

    Product getProduct(String id) throws RemoteException, SQLException;
    List<Product> getProducts(ProductCategory category) throws RemoteException, SQLException;

    List<InvoiceProduct> getInvoiceProducts(String checkoutId) throws RemoteException, SQLException;
    List<InvoiceProduct> getInvoiceProducts(Invoice invoice) throws RemoteException,
            SQLException;
    void addInvoiceProduct(InvoiceProduct invoiceProduct) throws RemoteException, SQLException;

    List<Invoice> getInvoices() throws RemoteException, SQLException;
    void addInvoice(Invoice invoice) throws RemoteException, SQLException;

    void sendInvoiceFile(Invoice invoice, byte[] file) throws IOException;
}
