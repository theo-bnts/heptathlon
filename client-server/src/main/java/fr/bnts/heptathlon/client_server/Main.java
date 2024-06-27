package fr.bnts.heptathlon.client_server;

import fr.bnts.heptathlon.main_server.entities.Invoice;
import fr.bnts.heptathlon.main_server.entities.InvoiceProduct;
import fr.bnts.heptathlon.main_server.entities.Product;
import fr.bnts.heptathlon.main_server.rmi.Service;
import fr.bnts.heptathlon.main_server.entities.ProductCategory;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.setProperty("java.rmi.server.useCodebaseOnly", "false");

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

            System.out.println("Get all invoices");

            List<Invoice> invoices = service.getInvoices();

            for (Invoice invoice : invoices) {
                System.out.println(invoice);
            }

            System.out.println("Get all invoice products of the invoice " + invoices.getFirst().getId());

            List<InvoiceProduct> invoiceProducts = service.getInvoiceProducts(invoices.getFirst());

            for (InvoiceProduct invoiceProduct : invoiceProducts) {
                System.out.println(invoiceProduct);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
