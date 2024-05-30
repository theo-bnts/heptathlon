package fr.bnts.heptathlon.client_server;

import fr.bnts.heptathlon.main_server.entities.Product;
import fr.bnts.heptathlon.main_server.entities.ProductCategory;
import fr.bnts.heptathlon.main_server.interfaces.Service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class ServiceImpl extends UnicastRemoteObject implements Service {
    protected ServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public Product getProduct(String reference) throws RemoteException {
        throw new RemoteException("Reserved for the main server");
    }

    @Override
    public List<Product> getProducts() throws RemoteException {
        throw new RemoteException("Reserved for the main server");
    }

    @Override
    public ProductCategory getProductCategory(int idCategory) throws RemoteException {
        throw new RemoteException("Reserved for the main server");
    }

    @Override
    public List<ProductCategory> getProductCategories() throws RemoteException {
        throw new RemoteException("Reserved for the main server");
    }
}
