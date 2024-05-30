package fr.bnts.heptathlon.main_server.rmi;

import fr.bnts.heptathlon.main_server.dao.InvoiceDAO;
import fr.bnts.heptathlon.main_server.dao.InvoiceProductDAO;
import fr.bnts.heptathlon.main_server.dao.ProductCategoryDAO;
import fr.bnts.heptathlon.main_server.dao.ProductDAO;
import fr.bnts.heptathlon.main_server.entities.Invoice;
import fr.bnts.heptathlon.main_server.entities.InvoiceProduct;
import fr.bnts.heptathlon.main_server.entities.Product;
import fr.bnts.heptathlon.main_server.entities.ProductCategory;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;

public class ServiceImpl extends UnicastRemoteObject implements Service {
    public ServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public List<ProductCategory> getProductCategories() throws RemoteException, SQLException {
        return ProductCategoryDAO.get();
    }

    @Override
    public ProductCategory getProductCategory(int id) throws RemoteException, SQLException {
        return ProductCategoryDAO.get(id);
    }

    @Override
    public Product getProduct(String id) throws RemoteException, SQLException {
        return ProductDAO.get(id);
    }

    @Override
    public List<Product> getProducts(ProductCategory category) throws RemoteException, SQLException {
        return ProductDAO.get(category);
    }

    @Override
    public List<Invoice> getInvoices() throws RemoteException, SQLException {
        return InvoiceDAO.get();
    }

    @Override
    public List<InvoiceProduct> getInvoiceProducts(Invoice invoice) throws RemoteException, SQLException {
        return InvoiceProductDAO.get(invoice);
    }
}
