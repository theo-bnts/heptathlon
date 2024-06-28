package fr.bnts.heptathlon.client_server.rmi;

import fr.bnts.heptathlon.main_server.rmi.Service;
import fr.bnts.heptathlon.main_server.rmi.ServiceImpl;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public abstract class ServiceConnector {
    public static int PORT = 1100;
    public static String SERVICE_NAME = "Service";

    public static String REMOTE_HOST = "localhost";
    public static int REMOTE_PORT = 1099;
    public static String REMOTE_SERVICE_NAME = "Service";

    public static void host() throws RemoteException {
        Service service = new ServiceImpl();
        Registry registry = LocateRegistry.createRegistry(PORT);
        registry.rebind(SERVICE_NAME, service);
    }

    public static Service connectToRemote() throws NotBoundException, RemoteException {
        Registry mainServerRegistry = LocateRegistry.getRegistry(REMOTE_HOST, REMOTE_PORT);
        return (Service) mainServerRegistry.lookup(REMOTE_SERVICE_NAME);
    }
}
