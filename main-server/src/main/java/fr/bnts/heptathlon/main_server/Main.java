package fr.bnts.heptathlon.main_server;

import fr.bnts.heptathlon.main_server.dao.InvoiceFileDAO;
import fr.bnts.heptathlon.main_server.database.DatabaseConnector;
import fr.bnts.heptathlon.main_server.rmi.ServiceConnector;

import java.rmi.RemoteException;

public class Main {
    public static void main(String[] args) throws RemoteException {
        DatabaseConnector databaseConnector = new DatabaseConnector(
                args[2],
                Integer.parseInt(args[3]),
                "main_server",
                "main_server",
                "main_server"
        );

        InvoiceFileDAO invoiceFileDAO = new InvoiceFileDAO(args[4]);

        ServiceConnector serviceConnector = new ServiceConnector(
                args[0],
                Integer.parseInt(args[1]),
                "main_server",
                databaseConnector,
                invoiceFileDAO
        );
        serviceConnector.host();

        System.out.println("Main server is running");
    }
}
