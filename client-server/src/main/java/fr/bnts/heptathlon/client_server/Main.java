package fr.bnts.heptathlon.client_server;

import fr.bnts.heptathlon.main_server.entities.Invoice;
import fr.bnts.heptathlon.main_server.entities.InvoiceProduct;
import fr.bnts.heptathlon.main_server.entities.Product;
import fr.bnts.heptathlon.main_server.rmi.Service;
import fr.bnts.heptathlon.main_server.entities.ProductCategory;
import fr.bnts.heptathlon.main_server.tools.Database;
import fr.bnts.heptathlon.main_server.tools.DatabaseImpl;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        try {
            Database database = new DatabaseImpl();

            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            Service service = (Service) registry.lookup("Service");

            System.out.println("Get all product categories");

            List<ProductCategory> productCategories =
                    service.getProductCategories(database);

            for (ProductCategory productCategory : productCategories) {
                System.out.println(productCategory);
            }

            System.out.println("Get all products of the category " + productCategories.getFirst().getName());

            List<Product> products = service.getProducts(database,
                    productCategories.getFirst());

            for (Product product : products) {
                System.out.println(product);
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

            service.addInvoiceProduct(database, invoiceProductA);

            InvoiceProduct invoiceProductB = new InvoiceProduct(
                    UUID.randomUUID().toString(),
                    checkoutId,
                    (float)6,
                    3,
                    products.get(1)
            );

            service.addInvoiceProduct(database, invoiceProductB);

            System.out.println("Create invoice");

            Invoice invoice = new Invoice(
                    checkoutId,
                    LocalDateTime.now(),
                    (float)24,
                    "CARD"
            );

            service.addInvoice(database, invoice);

            System.out.println("Get all invoices");

            List<Invoice> invoices = service.getInvoices(database);

            for (Invoice invoice_ : invoices) {
                System.out.println(invoice_);
            }

            System.out.println("Get all invoice products of the invoice " + invoices.getFirst().getId());

            List<InvoiceProduct> invoiceProducts = service.getInvoiceProducts(database, invoices.getFirst());

            for (InvoiceProduct invoiceProduct : invoiceProducts) {
                System.out.println(invoiceProduct);
            }

            System.out.println("Send invoice test file");

            byte[] file = service.readInvoiceFile("client-server",
                    invoices.getFirst());

            service.writeInvoiceFile("main-server", invoices.getFirst(), file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
