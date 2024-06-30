package fr.bnts.heptathlon.client_front.screens;

import fr.bnts.heptathlon.main_server.dao.ProductDAO;
import fr.bnts.heptathlon.main_server.dao.ProductCategoryDAO;
import fr.bnts.heptathlon.main_server.database.DatabaseConnector;
import fr.bnts.heptathlon.main_server.entities.Product;
import fr.bnts.heptathlon.main_server.entities.ProductCategory;
import fr.bnts.heptathlon.main_server.rmi.Service;
import fr.bnts.heptathlon.main_server.rmi.ServiceConnector;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

public class AdminProductsTab {
    private JPanel panel1;
    private JTree productCategoryList;
    private JTextField fieldFilterArticles;
    private final List<Product> allProducts;
    private final List<ProductCategory> allCategories;

    public AdminProductsTab() throws SQLException, NotBoundException, RemoteException {
        DatabaseConnector clientServerDatabase = new DatabaseConnector(
                "localhost",
                3307,
                "client_server",
                "client_server",
                "client_server"
        );

        ServiceConnector clientServerServiceConnector = new ServiceConnector(
                1100,
                "client_server",
                clientServerDatabase
        );
        Service clientServerService = clientServerServiceConnector.connect();

        allCategories = clientServerService.getProductCategories();
        allProducts = clientServerService.getProducts();

        DefaultTreeModel treeModel = createTreeModel(allCategories, allProducts);
        productCategoryList.setModel(treeModel);

        filterItems();
        addEventListeners();
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
                            product.getName() + " (Quantité: " + product.getQuantity() + ", Prix: " + product.getPrice() + " €)"
                    );
                    categoryNode.add(productNode);
                }
                root.add(categoryNode);
            }
        }
        return new DefaultTreeModel(root);
    }

    private void filterTree() {
        String filter = fieldFilterArticles.getText().toLowerCase();
        List<Product> filteredProducts = allProducts.stream()
                .filter(product -> product.getName().toLowerCase().contains(filter))
                .collect(Collectors.toList());
        DefaultTreeModel filteredTreeModel = createTreeModel(allCategories, filteredProducts);
        productCategoryList.setModel(filteredTreeModel);
    }

    private void filterItems() {
        fieldFilterArticles.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                filterTree();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                filterTree();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                filterTree();
            }
        });
    }

    private void addEventListeners() {
        productCategoryList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    handleDoubleClick(e);
                }
            }
        });
    }

    private void handleDoubleClick(MouseEvent e) {
        TreePath path = productCategoryList.getPathForLocation(e.getX(), e.getY());
        if (path != null) {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) path.getLastPathComponent();
            if (node.isLeaf()) {
                Product selectedProduct = getProductFromNode(node);
                if (selectedProduct != null) {
                    try {
                        popupItemQuantity(selectedProduct);
                    } catch (SQLException | NotBoundException | RemoteException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }
    }

    private Product getProductFromNode(DefaultMutableTreeNode node) {
        String nodeName = node.getUserObject().toString();
        String productName = nodeName.split(" \\(Quantité: ")[0];
        return allProducts.stream()
                .filter(product -> product.getName().equals(productName))
                .findFirst()
                .orElse(null);
    }

    private void popupItemQuantity(Product selectedProduct) throws SQLException, NotBoundException, RemoteException {
        JSpinner spinner =
                new JSpinner(new SpinnerNumberModel(selectedProduct.getQuantity(), -1, 32767, 1));
        JPanel panel = new JPanel();
        panel.add(new JLabel("Article sélectionné : " + selectedProduct.getName()));
        panel.add(spinner);

        int result = JOptionPane.showOptionDialog(
                null,
                panel,
                "Modifier la quantité en stock",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                new String[]{"Appliquer", "Annuler"},
                null
        );

        if (result == JOptionPane.OK_OPTION) {
            int newQuantity = (int) spinner.getValue();
            selectedProduct.setQuantity(newQuantity);

            DatabaseConnector clientServerDatabase = new DatabaseConnector(
                "localhost",
                3307,
                "client_server",
                "client_server",
                "client_server"
            );

            ServiceConnector clientServerServiceConnector = new ServiceConnector(
                1100,
                "client_server",
                clientServerDatabase
            );

            Service clientServerService = clientServerServiceConnector.connect();

            clientServerService.updateProduct(selectedProduct);

            refreshTree();
            System.out.println("Article : " + selectedProduct.getName() + ", Nouvelle quantité : " + newQuantity);
        }
    }

    private void refreshTree() throws SQLException, RemoteException, NotBoundException {
        allProducts.clear();

        DatabaseConnector clientServerDatabase = new DatabaseConnector(
                "localhost",
                3307,
                "client_server",
                "client_server",
                "client_server"
        );

        ServiceConnector clientServerServiceConnector = new ServiceConnector(
                1100,
                "client_server",
                clientServerDatabase
        );

        Service clientServerService = clientServerServiceConnector.connect();

        allProducts.addAll(clientServerService.getProducts());

        DefaultTreeModel treeModel = createTreeModel(allCategories, allProducts);
        productCategoryList.setModel(treeModel);
    }

    public JPanel getPanel() {
        return panel1;
    }
}
