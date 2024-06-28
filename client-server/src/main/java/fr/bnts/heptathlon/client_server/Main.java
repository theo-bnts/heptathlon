package fr.bnts.heptathlon.client_server;

import fr.bnts.heptathlon.client_server.database.DatabaseImpl;
import fr.bnts.heptathlon.client_server.tools.DatabaseSynchronisation;
import fr.bnts.heptathlon.client_server.tools.InvoiceFileWriter;
import fr.bnts.heptathlon.client_server.tools.ServiceConnector;
import fr.bnts.heptathlon.main_server.database.Database;
import fr.bnts.heptathlon.main_server.entities.Invoice;
import fr.bnts.heptathlon.main_server.entities.InvoiceProduct;
import fr.bnts.heptathlon.main_server.entities.Product;
import fr.bnts.heptathlon.main_server.rmi.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        try {
            Service mainServerService = ServiceConnector.connect();

            Database mainServerDatabase = new fr.bnts.heptathlon.main_server.database.DatabaseImpl();

            Database clientServerDatabase = new DatabaseImpl();

            System.out.println("Sync products from main server");

            new DatabaseSynchronisation(mainServerService, mainServerDatabase, clientServerDatabase)
                    .synchronise();

            System.out.println("Add two invoice products");

            String checkoutId = UUID.randomUUID().toString();

            List<Product> products = mainServerService.getProducts(mainServerDatabase);

            InvoiceProduct invoiceProductA = new InvoiceProduct(
                    UUID.randomUUID().toString(),
                    checkoutId,
                    (float) 3,
                    2,
                    products.getFirst()
            );

            mainServerService.addInvoiceProduct(mainServerDatabase, invoiceProductA);

            InvoiceProduct invoiceProductB = new InvoiceProduct(
                    UUID.randomUUID().toString(),
                    checkoutId,
                    (float) 6,
                    3,
                    products.get(1)
            );

            mainServerService.addInvoiceProduct(mainServerDatabase, invoiceProductB);

            System.out.println("Create invoice");

            Invoice invoice = new Invoice(
                    checkoutId,
                    LocalDateTime.now(),
                    (float) 24,
                    "CARD"
            );

            mainServerService.addInvoice(mainServerDatabase, invoice);

            System.out.println("Get all invoices");

            List<Invoice> invoices = mainServerService.getInvoices(mainServerDatabase);

            for (Invoice invoice_ : invoices) {
                System.out.println(invoice_);
            }

            System.out.println("Get all invoice products of the invoice " + invoices.getFirst().getId());

            List<InvoiceProduct> invoiceProducts = mainServerService.getInvoiceProducts(mainServerDatabase, invoices.getFirst());

            for (InvoiceProduct invoiceProduct : invoiceProducts) {
                System.out.println(invoiceProduct);
            }

            System.out.println("Send invoice test file");

            InvoiceFileWriter.write(clientServerDatabase, "client-server",
                    invoices.getFirst());

            byte[] file = mainServerService.readInvoiceFile("client-server",
                    invoices.getFirst());

            mainServerService.writeInvoiceFile("main-server", invoices.getFirst(), file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
