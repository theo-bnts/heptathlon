package fr.bnts.heptathlon.main_server.interfaces;

import fr.bnts.heptathlon.main_server.entities.ProductCategory;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface Service extends Remote {
    List<ProductCategory> getProductCategories() throws RemoteException;
}
