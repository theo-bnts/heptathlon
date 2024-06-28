package fr.bnts.heptathlon.main_server.rmi;

import fr.bnts.heptathlon.main_server.dao.*;
import fr.bnts.heptathlon.main_server.database.Database;
import fr.bnts.heptathlon.main_server.entities.Invoice;
import fr.bnts.heptathlon.main_server.entities.InvoiceProduct;
import fr.bnts.heptathlon.main_server.entities.Product;
import fr.bnts.heptathlon.main_server.entities.ProductCategory;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.List;

public class ServiceImpl extends UnicastRemoteObject implements Service {
    public ServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public ProductCategory getProductCategory(Database database, int id) throws RemoteException, SQLException {
        return ProductCategoryDAO.get(database, id);
    }

    @Override
    public List<ProductCategory> getProductCategories(Database database) throws RemoteException, SQLException {
        return ProductCategoryDAO.get(database);
    }

    @Override
    public void addProductCategory(Database database, ProductCategory productCategory) throws RemoteException, SQLException {
        ProductCategoryDAO.add(database, productCategory);
    }

    @Override
    public Product getProduct(Database database, String id) throws RemoteException, SQLException {
        return ProductDAO.get(database, id);
    }

    @Override
    public List<Product> getProducts(Database database) throws RemoteException, SQLException {
        return ProductDAO.get(database);
    }

    @Override
    public List<Product> getProducts(Database database, ProductCategory category) throws RemoteException, SQLException {
        return ProductDAO.get(database, category);
    }

    @Override
    public void addProduct(Database database, Product product) throws RemoteException, SQLException {
        ProductDAO.add(database, product);
    }

    @Override
    public List<InvoiceProduct> getInvoiceProducts(Database database, String checkoutId) throws RemoteException, SQLException {
        return InvoiceProductDAO.get(database, checkoutId);
    }

    @Override
    public List<InvoiceProduct> getInvoiceProducts(Database database, Invoice invoice) throws RemoteException, SQLException {
        return InvoiceProductDAO.get(database, invoice);
    }

    @Override
    public void addInvoiceProduct(Database database, InvoiceProduct invoiceProduct) throws RemoteException, SQLException {
        InvoiceProductDAO.add(database, invoiceProduct);
    }

    @Override
    public List<Invoice> getInvoices(Database database) throws RemoteException, SQLException {
        return InvoiceDAO.get(database);
    }

    @Override
    public void addInvoice(Database database, Invoice invoice) throws RemoteException, SQLException {
        InvoiceDAO.add(database, invoice);
    }

    @Override
    public String getInvoiceFileFullPath(String packageName, Invoice invoice) {
        return InvoiceFileDAO.getFullPath(packageName, invoice);
    }

    @Override
    public byte[] readInvoiceFile(String packageName, Invoice invoice) throws IOException {
        return InvoiceFileDAO.read(packageName, invoice);
    }

    @Override
    public void writeInvoiceFile(String packageName, Invoice invoice,
                                 byte[] file) throws IOException {
        InvoiceFileDAO.write(packageName, invoice, file);
    }
}
