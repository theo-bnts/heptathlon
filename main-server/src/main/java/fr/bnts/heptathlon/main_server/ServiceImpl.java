package fr.bnts.heptathlon.main_server;

import fr.bnts.heptathlon.main_server.entities.ProductCategory;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ServiceImpl extends UnicastRemoteObject implements Service {
    protected ServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public List<ProductCategory> getProductCategories() throws RemoteException {
        List<ProductCategory> categories = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3308/main_server", "main_server", "main_server");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM PRODUCT_CATEGORY");

            while (resultSet.next()) {
                int id = resultSet.getInt("ID_PRODUCT_CATEGORY");
                String name = resultSet.getString("NAME");
                categories.add(new ProductCategory(id, name));
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return categories;
    }
}
