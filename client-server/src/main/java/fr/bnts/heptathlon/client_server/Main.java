package fr.bnts.heptathlon.client_server;

import fr.bnts.heptathlon.main_server.entities.Invoice;
import fr.bnts.heptathlon.main_server.entities.InvoiceProduct;
import fr.bnts.heptathlon.main_server.entities.Product;
import fr.bnts.heptathlon.main_server.rmi.Service;
import fr.bnts.heptathlon.main_server.entities.ProductCategory;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            Service service = (Service) registry.lookup("Service");

            System.out.println("Get all product categories");

            List<ProductCategory> productCategories = service.getProductCategories();

            for (ProductCategory productCategory : productCategories) {
                System.out.println(productCategory);
            }

            System.out.println("Get all products of the category " + productCategories.getFirst().getName());

            List<Product> products = service.getProducts(productCategories.getFirst());

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

            service.addInvoiceProduct(invoiceProductA);

            InvoiceProduct invoiceProductB = new InvoiceProduct(
                    UUID.randomUUID().toString(),
                    checkoutId,
                    (float)6,
                    3,
                    products.get(1)
            );

            service.addInvoiceProduct(invoiceProductB);

            System.out.println("Create invoice");

            Invoice invoice = new Invoice(
                    checkoutId,
                    LocalDateTime.now(),
                    (float)24,
                    "CARD"
            );

            service.addInvoice(invoice);

            System.out.println("Get all invoices");

            List<Invoice> invoices = service.getInvoices();

            for (Invoice invoice_ : invoices) {
                System.out.println(invoice_);
            }

            System.out.println("Get all invoice products of the invoice " + invoices.getFirst().getId());

            List<InvoiceProduct> invoiceProducts = service.getInvoiceProducts(invoices.getFirst());

            for (InvoiceProduct invoiceProduct : invoiceProducts) {
                System.out.println(invoiceProduct);
            }

            System.out.println("Send invoice test file");

            Path fileFullPath =
                    Paths.get("../client-server/src/main/resources" +
                            "/test-invoice.txt");

            byte[] file = Files.readAllBytes(fileFullPath);

            service.sendInvoiceFile(invoices.getFirst(), file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
