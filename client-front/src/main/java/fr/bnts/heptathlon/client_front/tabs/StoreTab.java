package fr.bnts.heptathlon.client_front.tabs;

import fr.bnts.heptathlon.client_front.tools.InvoiceFileWriter;
import fr.bnts.heptathlon.main_server.dao.InvoiceFileDAO;
import fr.bnts.heptathlon.main_server.entities.Invoice;
import fr.bnts.heptathlon.main_server.entities.InvoiceProduct;
import fr.bnts.heptathlon.main_server.entities.Product;
import fr.bnts.heptathlon.main_server.entities.ProductCategory;
import fr.bnts.heptathlon.main_server.rmi.Service;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class StoreTab {
    private final Service clientServerService;
    private final InvoiceFileDAO invoiceFileDAO;
    private DefaultListModel<String> cartListModel;
    private Map<String, Integer> cart;
    private Map<String, Product> productMap;
    private JPanel panel;
    private JScrollPane availableProductListPane;
    private JScrollPane addedToCartListPane;
    private JPanel bottomPane;
    private JLabel totalCartLabel;
    private JButton validCartButton;
    private JList<String> productsAddedToCartList;
    private JTree productCategoryTree;

    public StoreTab(Service clientServerService,
                    InvoiceFileDAO invoiceFileDAO) throws RemoteException,
            SQLException {
        this.clientServerService = clientServerService;
        this.invoiceFileDAO = invoiceFileDAO;

        this.refreshData();

        addEventListeners();
    }

    public void refreshData() throws RemoteException, SQLException {
        this.cart = new HashMap<>();
        this.productMap = new HashMap<>();
        this.cartListModel = new DefaultListModel<>();
        this.productsAddedToCartList.setModel(cartListModel);

        loadProducts();
        updateTotalCartLabel();
        updateValidCartButton();
    }

    private void updateValidCartButton() {
        validCartButton.setEnabled(!cart.isEmpty());
    }

    private void loadProducts() throws RemoteException, SQLException {
        List<Product> products = this.clientServerService.getProducts();
        List<ProductCategory> categories = this.clientServerService.getProductCategories();
        DefaultTreeModel treeModel = createTreeModel(categories, products);
        this.productCategoryTree.setModel(treeModel);
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
                    if (product.getQuantity() > 0) {
                        DefaultMutableTreeNode productNode = new DefaultMutableTreeNode(
                                product.getName() + " (Quantité: " + product.getQuantity() + ", Prix: " + product.getPrice() + "€)"
                        );
                        categoryNode.add(productNode);
                        this.productMap.put(product.getName(), product);
                    }
                }
                if (categoryNode.getChildCount() > 0) {
                    root.add(categoryNode);
                }
            }
        }
        return new DefaultTreeModel(root);
    }

    private void addEventListeners() {
        this.productCategoryTree.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                handleProductCategoryTreeMouseClicked(e);
            }
        });

        productsAddedToCartList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                handleProductsAddedToCartListMouseClicked(e);
            }
        });

        validCartButton.addActionListener(e -> doCheckout());
    }

    private void handleProductCategoryTreeMouseClicked(MouseEvent e) {
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

    private void handleProductsAddedToCartListMouseClicked(MouseEvent e) {
        int index = productsAddedToCartList.locationToIndex(e.getPoint());
        if (index >= 0) {
            String selectedValue = productsAddedToCartList.getModel().getElementAt(index);
            String[] parts = selectedValue.split(" x ");
            if (parts.length > 1) {
                String productName = parts[1].split(" = ")[0].trim();
                Product selectedProduct = productMap.get(productName);
                if (selectedProduct != null) {
                    removeFromCart(selectedProduct);
                }
            }
        }
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
            updateValidCartButton(); // Mise à jour de l'état du bouton
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
            updateValidCartButton();
        }
    }

    private void updateCartList() {
        this.cartListModel.clear();
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            String productName = entry.getKey();
            int count = entry.getValue();
            Product product = productMap.get(productName);
            this.cartListModel.addElement(count + " x " + productName + " = " + (count * product.getPrice()) + "€");
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
        this.totalCartLabel.setText("Total: " + total + "€");
    }

    private void doCheckout() {
        double total = 0;
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            String productName = entry.getKey();
            int count = entry.getValue();
            Product product = this.productMap.get(productName);
            total += count * product.getPrice();
        }

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("Montant total à payer: " + total + "€"));

        JRadioButton cardButton = new JRadioButton("Carte");
        cardButton.setActionCommand("CARD");
        JRadioButton chequeButton = new JRadioButton("Chèque");
        chequeButton.setActionCommand("BANK_DRAFT");

        ButtonGroup paymentGroup = new ButtonGroup();
        paymentGroup.add(cardButton);
        paymentGroup.add(chequeButton);

        panel.add(cardButton);
        panel.add(chequeButton);

        JPanel buttonPanel = new JPanel();
        JButton payButton = new JButton("Payer");
        payButton.setEnabled(false);
        buttonPanel.add(payButton);

        panel.add(buttonPanel);

        ActionListener enablePayButtonListener = e -> payButton.setEnabled(true);

        cardButton.addActionListener(enablePayButtonListener);
        chequeButton.addActionListener(enablePayButtonListener);

        JOptionPane optionPane = new JOptionPane(panel, JOptionPane.PLAIN_MESSAGE, JOptionPane.OK_CANCEL_OPTION, null, new Object[]{payButton, "Annuler"}, payButton);
        JDialog dialog = optionPane.createDialog("Paiement");

        double finalTotal = total;
        payButton.addActionListener(e -> {
            String selectedPaymentMethod = paymentGroup.getSelection().getActionCommand();
            try {
                createInvoice(finalTotal, selectedPaymentMethod);
                JOptionPane.showMessageDialog(null, "Paiement réussi !");
                cart.clear();
                updateCartList();
                updateTotalCartLabel();
                loadProducts();
                updateValidCartButton();
                dialog.dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erreur lors de la création de la facture: " + ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        });

        dialog.setVisible(true);
    }

    private void createInvoice(double total, String paymentMethod) throws IOException, SQLException {
        String invoiceId = UUID.randomUUID().toString();
        LocalDateTime now = LocalDateTime.now();
        Invoice invoice = new Invoice(invoiceId, now, (float) total, paymentMethod);

        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            String productName = entry.getKey();
            int quantity = entry.getValue();
            Product product = productMap.get(productName);
            String invoiceProductId = UUID.randomUUID().toString();
            InvoiceProduct invoiceProduct = new InvoiceProduct(invoiceProductId, invoiceId, product.getPrice(), quantity, product);
            this.clientServerService.addInvoiceProduct(invoiceProduct);

            int newQuantity = product.getQuantity() - quantity;
            product.setQuantity(newQuantity);
            this.clientServerService.updateProduct(product);
        }

        this.clientServerService.addInvoice(invoice);
        writeInvoiceFile(invoice);
    }

    private void writeInvoiceFile(Invoice invoice) throws SQLException, IOException {
        InvoiceFileWriter.write(this.clientServerService, this.invoiceFileDAO, invoice);

        byte[] file = this.invoiceFileDAO.read(invoice);
        this.clientServerService.writeInvoiceFile(invoice, file);
    }

    public JPanel getPanel() {
        return panel;
    }
}
