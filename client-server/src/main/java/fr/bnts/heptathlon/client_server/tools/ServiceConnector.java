package fr.bnts.heptathlon.client_server.tools;

import fr.bnts.heptathlon.main_server.rmi.Service;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public abstract class ServiceConnector {
    public static Service connect() throws NotBoundException, RemoteException {
        Registry mainServerRegistry = LocateRegistry.getRegistry("localhost", 1099);
        return (Service)mainServerRegistry.lookup("Service");
    }
}
