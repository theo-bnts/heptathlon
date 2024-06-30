package fr.bnts.heptathlon.client_front.screens;

import fr.bnts.heptathlon.main_server.entities.Product;
import fr.bnts.heptathlon.main_server.entities.ProductCategory;
import fr.bnts.heptathlon.main_server.rmi.Service;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

    private JList<String> productsAddedToCartList;
    private JTree productCategoryTree;

    private JLabel totalCartLabel;
    private JButton validCartButton;

    private final Service clientServerService;

    private final DefaultListModel<String> cartListModel;
    private final Map<String, Integer> cart;
    private final Map<String, Product> productMap;

    public StoreHomeScreen(Service clientServerService) throws RemoteException, SQLException {
        this.clientServerService = clientServerService;
        this.cart = new HashMap<>();
        this.productMap = new HashMap<>();
        this.cartListModel = new DefaultListModel<>();
        productsAddedToCartList.setModel(cartListModel);

        loadProducts();
        addEventListeners();
        updateTotalCartLabel();
    }

    private void loadProducts() throws RemoteException, SQLException {
        List<Product> products = clientServerService.getProducts();
        List<ProductCategory> categories = clientServerService.getProductCategories();
        DefaultTreeModel treeModel = createTreeModel(categories, products);
        productCategoryTree.setModel(treeModel);
    }

    private DefaultTreeModel createTreeModel(List<ProductCategory> categories, List<Product> products) {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Produits");

        for (ProductCategory category : categories) {
            DefaultMutableTreeNode categoryNode = new DefaultMutableTreeNode(category.getName());
            List<Product> productsInCategory = products.stream()
                    .filter(product -> product.getCategory().getId() == category.getId())
                    .toList();
            if (!productsInCategory.isEmpty()) {
                for (Product product : productsInCategory) {
                    DefaultMutableTreeNode productNode = new DefaultMutableTreeNode(
                            product.getName() + " (Quantité: " + product.getQuantity() + ", Prix: " + product.getPrice() + "€)"
                    );
                    categoryNode.add(productNode);
                    productMap.put(product.getName(), product);
                }
                root.add(categoryNode);
            }
        }
        return new DefaultTreeModel(root);
    }

    private void addEventListeners() {
        productCategoryTree.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    TreePath path = productCategoryTree.getPathForLocation(e.getX(), e.getY());
                    if (path != null) {
                        DefaultMutableTreeNode node = (DefaultMutableTreeNode) path.getLastPathComponent();
                        if (node.isLeaf()) {
                            Product selectedProduct = getProductFromNode(node);
                            if (selectedProduct != null) {
                                addToCart(selectedProduct);
                            }
                        }
                    }
                }
            }
        });

        productsAddedToCartList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    int index = productsAddedToCartList.locationToIndex(e.getPoint());
                    if (index >= 0) {
                        String selectedValue = productsAddedToCartList.getModel().getElementAt(index);
                        String productName = selectedValue.split(" - ")[1].trim();
                        Product selectedProduct = productMap.get(productName);
                        if (selectedProduct != null) {
                            removeFromCart(selectedProduct);
                        }
                    }
                }
            }
        });
    }

    private Product getProductFromNode(DefaultMutableTreeNode node) {
        String nodeName = node.getUserObject().toString();
        String productName = nodeName.split(" \\(Quantité: ")[0].trim();
        return productMap.get(productName);
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
