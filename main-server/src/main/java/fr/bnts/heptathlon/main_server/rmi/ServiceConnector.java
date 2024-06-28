package fr.bnts.heptathlon.main_server.rmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public abstract class ServiceConnector {
    public static int PORT = 1099;
    public static String SERVICE_NAME = "Service";

    public static void host() throws RemoteException {
        Service service = new ServiceImpl();
        Registry registry = LocateRegistry.createRegistry(PORT);
        registry.rebind(SERVICE_NAME, service);
    }
}
