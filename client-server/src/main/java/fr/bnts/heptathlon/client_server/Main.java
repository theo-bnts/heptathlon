package fr.bnts.heptathlon.client_server;

import fr.bnts.heptathlon.main_server.dao.ProductCategoryDAO;
import fr.bnts.heptathlon.main_server.dao.ProductDAO;
import fr.bnts.heptathlon.main_server.entities.Invoice;
import fr.bnts.heptathlon.main_server.entities.InvoiceProduct;
import fr.bnts.heptathlon.main_server.entities.Product;
import fr.bnts.heptathlon.main_server.rmi.Service;
import fr.bnts.heptathlon.main_server.entities.ProductCategory;
import fr.bnts.heptathlon.main_server.tools.Database;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        try {
            Registry mainServerRegistry = LocateRegistry.getRegistry("localhost", 1099);
            Service mainServerService = (Service) mainServerRegistry.lookup("Service");

            Database mainServerDatabase = new fr.bnts.heptathlon.main_server.tools.DatabaseImpl();
            Database clientServerDatabase = new fr.bnts.heptathlon.client_server.tools.DatabaseImpl();

            System.out.println("Sync products from main server");

            List<ProductCategory> productCategories =
                    mainServerService.getProductCategories(mainServerDatabase);

            for (ProductCategory productCategory : productCategories) {
                ProductCategoryDAO.add(clientServerDatabase, productCategory);
            }

            List<Product> products = mainServerService.getProducts(mainServerDatabase,
                    productCategories.getFirst());

            for (Product product : products) {
                ProductDAO.add(clientServerDatabase, product);
            }

            System.out.println("Add two invoice products");

            String checkoutId = UUID.randomUUID().toString();

            InvoiceProduct invoiceProductA = new InvoiceProduct(
                    UUID.randomUUID().toString(),
                    checkoutId,
                    (float)3,
                    2,
                    products.getFirst()
            );

            mainServerService.addInvoiceProduct(mainServerDatabase, invoiceProductA);

            InvoiceProduct invoiceProductB = new InvoiceProduct(
                    UUID.randomUUID().toString(),
                    checkoutId,
                    (float)6,
                    3,
                    products.get(1)
            );

            mainServerService.addInvoiceProduct(mainServerDatabase, invoiceProductB);

            System.out.println("Create invoice");

            Invoice invoice = new Invoice(
                    checkoutId,
                    LocalDateTime.now(),
                    (float)24,
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

            byte[] file = mainServerService.readInvoiceFile("client-server",
                    invoices.getFirst());

            mainServerService.writeInvoiceFile("main-server", invoices.getFirst(), file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
