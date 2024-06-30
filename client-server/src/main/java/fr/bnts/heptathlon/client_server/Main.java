package fr.bnts.heptathlon.client_server;

import fr.bnts.heptathlon.client_server.tools.DataSynchronisation;
import fr.bnts.heptathlon.main_server.database.DatabaseConnector;
import fr.bnts.heptathlon.main_server.rmi.Service;
import fr.bnts.heptathlon.main_server.rmi.ServiceConnector;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws NotBoundException, IOException, SQLException {
        DatabaseConnector mainServerDatabase = new DatabaseConnector(
                "localhost",
                3308,
                "main_server",
                "main_server",
                "main_server"
        );
        DatabaseConnector clientServerDatabase = new DatabaseConnector(
                "localhost",
                3307,
                "client_server",
                "client_server",
                "client_server"
        );

        ServiceConnector mainServerServiceConnector = new ServiceConnector(
                "localhost",
                1099,
                "main_server",
                mainServerDatabase
        );
        Service mainServerService = mainServerServiceConnector.connect();

        new DataSynchronisation(
                mainServerService,
                clientServerDatabase
        );

        System.out.println("Data synchronisation started");

        ServiceConnector clientServerServiceConnector = new ServiceConnector(
                "localhost",
                1100,
                "client_server",
                clientServerDatabase
        );
        clientServerServiceConnector.host();

        System.out.println("Client server is running");
    }
}
