package fr.bnts.heptathlon.client_front.screens;

import fr.bnts.heptathlon.main_server.entities.Product;
import fr.bnts.heptathlon.main_server.rmi.Service;

import javax.swing.*;
import java.awt.*;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StoreHomeScreen {
    private JPanel panel;
    private JScrollPane availibleProductListPane;
    private JScrollPane addedToCartListPane;
    private JPanel bottomPane;
    private JLabel totalCartLabel;
    private JButton validCartButton;
    private JList<String> productsAddedToCartList;
    private JPanel productPanel;

    private Service clientServerService;
    private DefaultListModel<String> cartListModel;
    private Map<String, Integer> cart;
    private Map<String, Product> productMap;

    public StoreHomeScreen(Service clientServerService) throws RemoteException, SQLException {
        this.clientServerService = clientServerService;
        this.cart = new HashMap<>();
        this.productMap = new HashMap<>();
        this.cartListModel = new DefaultListModel<>();
        productsAddedToCartList.setModel(cartListModel);

        if (productPanel == null) {
            productPanel = new JPanel();
        }

        productPanel.setLayout(new BoxLayout(productPanel, BoxLayout.Y_AXIS));
        availibleProductListPane.setViewportView(productPanel);
        loadProducts();
        updateTotalCartLabel();
    }

    private void loadProducts() throws RemoteException, SQLException {
        List<Product> products = clientServerService.getProducts();
        for (Product product : products) {
            if (product.getQuantity() > 0) {
                JPanel productPane = new JPanel();
                productPane.setLayout(new FlowLayout());

                JLabel productLabel = new JLabel(product.getName() + " : " + product.getPrice() + "€");
                JButton addToCartButton = new JButton("+");
                JButton deleteToCartButton = new JButton("-");

                addToCartButton.addActionListener(e -> addToCart(product));
                deleteToCartButton.addActionListener(e -> removeFromCart(product));

                productPane.add(productLabel);
                productPane.add(addToCartButton);
                productPane.add(deleteToCartButton);

                productPanel.add(productPane);
                productMap.put(product.getName(), product);
            }
        }
        productPanel.revalidate();
        productPanel.repaint();
    }

    private void addToCart(Product product) {
        String productName = product.getName();
        if (cart.getOrDefault(productName, 0) < product.getQuantity()) {
            cart.put(productName, cart.getOrDefault(productName, 0) + 1);
            updateCartList();
            updateTotalCartLabel();
        }
    }

    private void removeFromCart(Product product) {
        String productName = product.getName();
        if (cart.containsKey(productName)) {
            int currentCount = cart.get(productName);
            if (currentCount > 1) {
                cart.put(productName, currentCount - 1);
            } else {
                cart.remove(productName);
            }
            updateCartList();
            updateTotalCartLabel();
        }
    }

    private void updateCartList() {
        cartListModel.clear();
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            String productName = entry.getKey();
            int count = entry.getValue();
            Product product = productMap.get(productName);
            cartListModel.addElement("x" + count + " - " + productName + " - " + (count * product.getPrice()) + "€");
        }
    }

    private void updateTotalCartLabel() {
        double total = 0;
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            String productName = entry.getKey();
            int count = entry.getValue();
            Product product = productMap.get(productName);
            total += count * product.getPrice();
        }
        totalCartLabel.setText("Total: " + total + "€");
    }

    public JPanel getPanel() {
        return panel;
    }
}
