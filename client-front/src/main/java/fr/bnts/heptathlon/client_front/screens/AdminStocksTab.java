package fr.bnts.heptathlon.client_front.screens;

import fr.bnts.heptathlon.client_front.rmi.ServiceConnector;
import fr.bnts.heptathlon.main_server.database.DatabaseImpl;
import fr.bnts.heptathlon.main_server.database.Database;
import fr.bnts.heptathlon.main_server.entities.Product;
import fr.bnts.heptathlon.main_server.rmi.Service;
import fr.bnts.heptathlon.main_server.dao.ProductDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;

public class AdminStocksTab {
    private JPanel panel1;
    private JList<Product> listArticles;
    private final Database clientServerDatabase;

    public AdminStocksTab() throws SQLException, NotBoundException, RemoteException {
        clientServerDatabase = new DatabaseImpl();
        DefaultListModel<Product> listModel = getListModel();
        listArticles.setModel(listModel);
        listArticles.setCellRenderer(new ProductListCellRenderer());

        listArticles.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    Product selectedProduct = listArticles.getSelectedValue();
                    if (selectedProduct != null) {
                        try {
                            popupItemQuantity(selectedProduct);
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            }
        });
    }

    private DefaultListModel<Product> getListModel() throws NotBoundException, RemoteException, SQLException {
        Service service = ServiceConnector.connectToRemote();
        List<Product> products = service.getProducts(clientServerDatabase);

        DefaultListModel<Product> listModel = new DefaultListModel<>();
        for (Product product : products) {
            listModel.addElement(product);
        }
        return listModel;
    }

    private void popupItemQuantity(Product selectedProduct) throws SQLException {
        JSpinner spinner = new JSpinner(new SpinnerNumberModel(selectedProduct.getQuantity(), -1, 32767, 1));
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
            ProductDAO.update(clientServerDatabase, selectedProduct);
            System.out.println("Article : " + selectedProduct.getName() + ", Nouvelle quantité : " + newQuantity);
        }
    }

    public JPanel getPanel() {
        return panel1;
    }

    private static class ProductListCellRenderer extends DefaultListCellRenderer {
        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            if (value instanceof Product) {
                Product product = (Product) value;
                setText(product.getName() + " (Quantité en stock : " + product.getQuantity() + ")");
            }
            return this;
        }
    }
}