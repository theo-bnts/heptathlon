package fr.bnts.heptathlon.main_server.rmi;

import fr.bnts.heptathlon.main_server.dao.InvoiceDAO;
import fr.bnts.heptathlon.main_server.dao.InvoiceFileDAO;
import fr.bnts.heptathlon.main_server.dao.InvoiceProductDAO;
import fr.bnts.heptathlon.main_server.dao.ProductCategoryDAO;
import fr.bnts.heptathlon.main_server.dao.ProductDAO;
import fr.bnts.heptathlon.main_server.entities.Invoice;
import fr.bnts.heptathlon.main_server.entities.InvoiceProduct;
import fr.bnts.heptathlon.main_server.entities.Product;
import fr.bnts.heptathlon.main_server.entities.ProductCategory;
import fr.bnts.heptathlon.main_server.tools.Database;

import java.io.IOException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;

public class ServiceImpl extends UnicastRemoteObject implements Service {
    public ServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public List<ProductCategory> getProductCategories(Database database) throws RemoteException, SQLException {
        return ProductCategoryDAO.get(database);
    }

    @Override
    public ProductCategory getProductCategory(Database database, int id) throws RemoteException, SQLException {
        return ProductCategoryDAO.get(database, id);
    }

    @Override
    public Product getProduct(Database database, String id) throws RemoteException, SQLException {
        return ProductDAO.get(database, id);
    }

    @Override
    public List<Product> getProducts(Database database, ProductCategory category) throws RemoteException, SQLException {
        return ProductDAO.get(database, category);
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
