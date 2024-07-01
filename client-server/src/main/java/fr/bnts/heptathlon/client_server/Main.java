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
                args[6],
                Integer.parseInt(args[7]),
                "main_server",
                "main_server",
                "main_server"
        );

        ServiceConnector mainServerServiceConnector = new ServiceConnector(
                args[4],
                Integer.parseInt(args[5]),
                "main_server",
                mainServerDatabase
        );
        Service mainServerService = mainServerServiceConnector.connect();

        DatabaseConnector clientServerDatabase = new DatabaseConnector(
                args[2],
                Integer.parseInt(args[3]),
                "client_server",
                "client_server",
                "client_server"
        );

        new DataSynchronisation(
                mainServerService,
                clientServerDatabase
        );

        System.out.println("Data synchronisation started");

        ServiceConnector clientServerServiceConnector = new ServiceConnector(
                args[0],
                Integer.parseInt(args[1]),
                "client_server",
                clientServerDatabase
        );
        clientServerServiceConnector.host();

        System.out.println("Client server is running");
    }
}
