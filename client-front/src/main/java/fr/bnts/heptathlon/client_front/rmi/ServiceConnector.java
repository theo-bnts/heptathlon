package fr.bnts.heptathlon.client_front.rmi;

import fr.bnts.heptathlon.main_server.rmi.Service;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public abstract class ServiceConnector {
    public static String REMOTE_HOST = "localhost";
    public static int REMOTE_PORT = 1099;
    public static String REMOTE_SERVICE_NAME = "Service";

    public static Service connectToRemote() throws NotBoundException, RemoteException {
        Registry mainServerRegistry = LocateRegistry.getRegistry(REMOTE_HOST, REMOTE_PORT);
        return (Service) mainServerRegistry.lookup(REMOTE_SERVICE_NAME);
    }
}
