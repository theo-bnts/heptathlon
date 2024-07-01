package fr.bnts.heptathlon.client_server;

import fr.bnts.heptathlon.client_server.tools.DataSynchronisation;
import fr.bnts.heptathlon.main_server.dao.InvoiceFileDAO;
import fr.bnts.heptathlon.main_server.database.DatabaseConnector;
import fr.bnts.heptathlon.main_server.rmi.Service;
import fr.bnts.heptathlon.main_server.rmi.ServiceConnector;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws NotBoundException, IOException, SQLException {

        ServiceConnector mainServerServiceConnector = new ServiceConnector(
                args[5],
                Integer.parseInt(args[6]),
                "main_server"
        );
        Service mainServerService = mainServerServiceConnector.connect();

        DatabaseConnector clientServerDatabase = new DatabaseConnector(
                args[2],
                Integer.parseInt(args[3]),
                "client_server",
                "client_server",
                "client_server"
        );

        InvoiceFileDAO invoiceFileDAO = new InvoiceFileDAO(args[4]);

        new DataSynchronisation(
                mainServerService,
                clientServerDatabase,
                invoiceFileDAO
        );

        System.out.println("Data synchronisation started");

        ServiceConnector clientServerServiceConnector = new ServiceConnector(
                args[0],
                Integer.parseInt(args[1]),
                "client_server",
                clientServerDatabase,
                invoiceFileDAO
        );
        clientServerServiceConnector.host();

        System.out.println("Client server is running");
    }
}
