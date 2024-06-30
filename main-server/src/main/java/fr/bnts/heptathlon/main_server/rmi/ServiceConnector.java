package fr.bnts.heptathlon.main_server.rmi;

import fr.bnts.heptathlon.main_server.database.DatabaseConnector;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServiceConnector {
    public final int port;
    public final String serviceName;
    public final DatabaseConnector databaseConnector;

    public ServiceConnector(int port, String serviceName, DatabaseConnector database) {
        this.port = port;
        this.serviceName = serviceName;
        this.databaseConnector = database;
    }

    public void host() throws RemoteException {
        Service service = new ServiceImpl(this.databaseConnector);
        Registry registry = LocateRegistry.createRegistry(this.port);
        registry.rebind(this.serviceName, service);
    }

    public Service connect() throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry(this.port);
        return (Service) registry.lookup(this.serviceName);
    }
}
