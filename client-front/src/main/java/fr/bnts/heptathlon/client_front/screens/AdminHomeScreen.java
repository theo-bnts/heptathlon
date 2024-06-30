package fr.bnts.heptathlon.client_front.screens;

import fr.bnts.heptathlon.main_server.rmi.Service;

import javax.swing.*;
import java.awt.*;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;

public class AdminHomeScreen {
    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JPanel tabGrossSales;
    private JPanel tabInvoices;
    private JPanel tabProduct;

    public AdminHomeScreen(Service clientServerService) throws SQLException, NotBoundException, RemoteException {
        tabbedPane1.setSelectedIndex(0);

        AdminGrossSalesTab adminGrossSalesTab = new AdminGrossSalesTab();
        tabGrossSales.setLayout(new BorderLayout());
        tabGrossSales.add(adminGrossSalesTab.getPanel());

        AdminInvoicesTab adminInvoicesTab = new AdminInvoicesTab();
        tabInvoices.setLayout(new BorderLayout());
        tabInvoices.add(adminInvoicesTab.getPanel());

        AdminProductsTab adminProductsTab = new AdminProductsTab(clientServerService);
        tabProduct.setLayout(new BorderLayout());
        tabProduct.add(adminProductsTab.getPanel());
    }

    public JPanel getPanel() {
        return panel1;
    }
}
