package fr.bnts.heptathlon.client_server;

import fr.bnts.heptathlon.main_server.entities.Product;
import fr.bnts.heptathlon.main_server.rmi.Service;
import fr.bnts.heptathlon.main_server.entities.ProductCategory;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            Service service = (Service) registry.lookup("Service");

            List<Product> products = service.getProducts();

            for (Product product : products) {
                System.out.println(product);
            }

            List<ProductCategory> productCategories = service.getProductCategories();

            for (ProductCategory productCategory : productCategories) {
                System.out.println(productCategory);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
