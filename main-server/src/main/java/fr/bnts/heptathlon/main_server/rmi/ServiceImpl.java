package fr.bnts.heptathlon.main_server.rmi;

import fr.bnts.heptathlon.main_server.dao.ProductCategoryDAO;
import fr.bnts.heptathlon.main_server.dao.ProductDAO;
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
    public Product getProduct(String reference) throws RemoteException, SQLException {
        return ProductDAO.get(reference);
    }

    @Override
    public List<Product> getProducts() throws RemoteException, SQLException {
        return ProductDAO.getAll();
    }

    @Override
    public ProductCategory getProductCategory(int id) throws RemoteException, SQLException {
        return ProductCategoryDAO.get(id);
    }

    @Override
    public List<ProductCategory> getProductCategories() throws RemoteException, SQLException {
        return ProductCategoryDAO.getAll();
    }
}
