package fr.bnts.heptathlon.main_server.rmi;

import fr.bnts.heptathlon.main_server.dao.InvoiceFileDAO;
import fr.bnts.heptathlon.main_server.database.DatabaseConnector;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.RMISocketFactory;

public class ServiceConnector {
    public final String host;
    public final int port;
    public final String serviceName;
    public final DatabaseConnector databaseConnector;
    public final InvoiceFileDAO invoiceFileDAO;

    public ServiceConnector(String host, int port, String serviceName) {
        this.host = host;
        this.port = port;
        this.serviceName = serviceName;
        this.databaseConnector = null;
        this.invoiceFileDAO = null;
    }

    public ServiceConnector(String host, int port, String serviceName,
                            DatabaseConnector database, InvoiceFileDAO invoiceFileDAO) {
        this.host = host;
        this.port = port;
        this.serviceName = serviceName;
        this.databaseConnector = database;
        this.invoiceFileDAO = invoiceFileDAO;
    }

    public void host() throws RemoteException {
        Service service = new ServiceImpl(this.databaseConnector, this.invoiceFileDAO);
        Registry registry = LocateRegistry.createRegistry(
                this.port,
                new CustomSocketFactory(),
                new CustomSocketFactory()
        );
        registry.rebind(this.serviceName, service);
    }

    public Service connect() throws RemoteException, NotBoundException {
        Registry registry =
                LocateRegistry.getRegistry(this.host, this.port,
                        new CustomSocketFactory());
        return (Service) registry.lookup(this.serviceName);
    }

    private static class CustomSocketFactory extends RMISocketFactory {
        @Override
        public Socket createSocket(String host, int port) throws IOException {
            Socket socket = new Socket(host, port);
            socket.setSoTimeout(0);
            socket.setSoLinger(false, 0);
            return socket;
        }

        @Override
        public ServerSocket createServerSocket(int port) throws IOException {
            return new ServerSocket(port);
        }
    }
}
