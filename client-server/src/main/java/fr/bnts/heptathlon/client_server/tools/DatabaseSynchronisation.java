package fr.bnts.heptathlon.client_server.tools;

import fr.bnts.heptathlon.main_server.dao.ProductCategoryDAO;
import fr.bnts.heptathlon.main_server.dao.ProductDAO;
import fr.bnts.heptathlon.main_server.database.Database;
import fr.bnts.heptathlon.main_server.entities.Product;
import fr.bnts.heptathlon.main_server.entities.ProductCategory;
import fr.bnts.heptathlon.main_server.rmi.Service;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;

public class DatabaseSynchronisation {
    Service remoteService;
    Database remoteDatabase;
    Database database;

    public DatabaseSynchronisation(Service remoteService,
                                   Database remoteDatabase, Database database) {
        this.remoteService = remoteService;
        this.remoteDatabase = remoteDatabase;
        this.database = database;
    }

    public void synchronise() throws SQLException, RemoteException {
        synchroniseProductCategories();
        synchroniseProducts();
    }

    public void synchroniseProductCategories() throws SQLException, RemoteException {
        List<ProductCategory> productCategories =
                remoteService.getProductCategories(remoteDatabase);

        for (ProductCategory productCategory : productCategories) {
            ProductCategoryDAO.add(database, productCategory);
        }
    }

    public void synchroniseProducts() throws SQLException, RemoteException {
        List<Product> products = remoteService.getProducts(remoteDatabase);
        System.out.println(products.size());
        for (Product product : products) {
            ProductDAO.add(database, product);
        }
    }
}
