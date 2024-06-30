package fr.bnts.heptathlon.main_server;

import fr.bnts.heptathlon.main_server.database.DatabaseConnector;
import fr.bnts.heptathlon.main_server.rmi.ServiceConnector;

import java.rmi.RemoteException;

public class Main {
    public static void main(String[] args) throws RemoteException {
        DatabaseConnector databaseConnector = new DatabaseConnector(
                "localhost",
                3308,
                "main_server",
                "main_server",
                "main_server"
        );

        ServiceConnector serviceConnector = new ServiceConnector(
                1099,
                "main_server",
                databaseConnector
        );
        serviceConnector.host();

        System.out.println("Main server is running");
    }
}
