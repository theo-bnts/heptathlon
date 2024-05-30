package fr.bnts.heptathlon.main_server.rmi;

import fr.bnts.heptathlon.main_server.entities.Product;
import fr.bnts.heptathlon.main_server.entities.ProductCategory;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;

public interface Service extends Remote {
    Product getProduct(String reference) throws RemoteException, SQLException;
    List<Product> getProducts() throws RemoteException, SQLException;
    List<Product> getProducts(ProductCategory category) throws RemoteException, SQLException;
    ProductCategory getProductCategory(int id) throws RemoteException, SQLException;
    List<ProductCategory> getProductCategories() throws RemoteException, SQLException;
}
