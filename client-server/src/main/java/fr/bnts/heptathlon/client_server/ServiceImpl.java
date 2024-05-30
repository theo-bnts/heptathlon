package fr.bnts.heptathlon.client_server;

import fr.bnts.heptathlon.main_server.entities.ProductCategory;
import fr.bnts.heptathlon.main_server.Service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class ServiceImpl extends UnicastRemoteObject implements Service {
    protected ServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public List<ProductCategory> getProductCategories() throws RemoteException {
        throw new RemoteException("Reserved for the main server");
    }
}
