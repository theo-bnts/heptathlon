package fr.bnts.heptathlon.client_server;

import fr.bnts.heptathlon.client_server.database.DatabaseImpl;
import fr.bnts.heptathlon.client_server.rmi.ServiceConnector;
import fr.bnts.heptathlon.client_server.tools.DataSynchronisation;
import fr.bnts.heptathlon.client_server.tools.InvoiceFileWriter;
import fr.bnts.heptathlon.main_server.dao.InvoiceDAO;
import fr.bnts.heptathlon.main_server.dao.InvoiceProductDAO;
import fr.bnts.heptathlon.main_server.dao.ProductDAO;
import fr.bnts.heptathlon.main_server.database.Database;
import fr.bnts.heptathlon.main_server.entities.Invoice;
import fr.bnts.heptathlon.main_server.entities.InvoiceProduct;
import fr.bnts.heptathlon.main_server.entities.Product;
import fr.bnts.heptathlon.main_server.rmi.Service;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class Main {
    public static void main(String[] args) throws NotBoundException, IOException, SQLException {
        Service mainServerService = ServiceConnector.connectToRemote();

        Database mainServerDatabase = new fr.bnts.heptathlon.main_server.database.DatabaseImpl();

        Database clientServerDatabase = new DatabaseImpl();

        new DataSynchronisation(mainServerService, mainServerDatabase, clientServerDatabase);

        System.out.println("----- EXAMPLE -----");

        List<Product> products = ProductDAO.get(clientServerDatabase);

        String checkoutId = UUID.randomUUID().toString();

        InvoiceProduct invoiceProductA = new InvoiceProduct(
                UUID.randomUUID().toString(),
                checkoutId,
                (float) 3,
                2,
                products.getFirst()
        );

        InvoiceProduct invoiceProductB = new InvoiceProduct(
                UUID.randomUUID().toString(),
                checkoutId,
                (float) 6,
                3,
                products.get(1)
        );

        Invoice invoice = new Invoice(
                checkoutId,
                LocalDateTime.now(),
                (float) 24,
                "CARD"
        );

        InvoiceProductDAO.add(clientServerDatabase, invoiceProductA);
        InvoiceProductDAO.add(clientServerDatabase, invoiceProductB);
        InvoiceDAO.add(clientServerDatabase, invoice);

        InvoiceFileWriter.write(clientServerDatabase, "client-server", invoice);
    }
}
