package fr.bnts.heptathlon.main_server.rmi;

import fr.bnts.heptathlon.main_server.dao.*;
import fr.bnts.heptathlon.main_server.database.DatabaseConnector;
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
    DatabaseConnector databaseConnector;

    public ServiceImpl(DatabaseConnector database) throws RemoteException {
        super();
        this.databaseConnector = database;
    }

    @Override
    public ProductCategory getProductCategory(int id) throws RemoteException, SQLException {
        return ProductCategoryDAO.get(databaseConnector, id);
    }

    @Override
    public List<ProductCategory> getProductCategories() throws RemoteException, SQLException {
        return ProductCategoryDAO.get(databaseConnector);
    }

    @Override
    public void addProductCategory(ProductCategory productCategory) throws RemoteException, SQLException {
        ProductCategoryDAO.add(databaseConnector, productCategory);
    }

    @Override
    public Product getProduct(String id) throws RemoteException, SQLException {
        return ProductDAO.get(databaseConnector, id);
    }

    @Override
    public List<Product> getProducts() throws RemoteException, SQLException {
        return ProductDAO.get(databaseConnector);
    }

    @Override
    public List<Product> getProducts(ProductCategory category) throws RemoteException, SQLException {
        return ProductDAO.get(databaseConnector, category);
    }

    @Override
    public void updateProduct(Product product) throws RemoteException, SQLException {
        ProductDAO.update(databaseConnector, product);
    }

    @Override
    public void addProduct(Product product) throws RemoteException, SQLException {
        ProductDAO.add(databaseConnector, product);
    }

    @Override
    public List<InvoiceProduct> getInvoiceProducts(String checkoutId) throws RemoteException, SQLException {
        return InvoiceProductDAO.get(databaseConnector, checkoutId);
    }

    @Override
    public List<InvoiceProduct> getInvoiceProducts(Invoice invoice) throws RemoteException, SQLException {
        return InvoiceProductDAO.get(databaseConnector, invoice);
    }

    @Override
    public void addInvoiceProduct(InvoiceProduct invoiceProduct) throws RemoteException, SQLException {
        InvoiceProductDAO.add(databaseConnector, invoiceProduct);
    }

    @Override
    public Invoice getInvoice(String id) throws RemoteException, SQLException {
        return InvoiceDAO.get(databaseConnector, id);
    }

    @Override
    public List<Invoice> getInvoices() throws RemoteException, SQLException {
        return InvoiceDAO.get(databaseConnector);
    }

    @Override
    public void addInvoice(Invoice invoice) throws RemoteException, SQLException {
        InvoiceDAO.add(databaseConnector, invoice);
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
