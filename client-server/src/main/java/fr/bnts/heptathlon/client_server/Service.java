package fr.bnts.heptathlon.client_server;

import fr.bnts.heptathlon.client_server.entities.ProductCategory;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface Service extends Remote {
    List<ProductCategory> getProductCategories() throws RemoteException;
}
