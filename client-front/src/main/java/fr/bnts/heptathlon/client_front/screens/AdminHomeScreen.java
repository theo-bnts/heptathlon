package fr.bnts.heptathlon.client_front.screens;

import javax.swing.*;
import java.awt.*;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;

public class AdminHomeScreen {
    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JPanel tabGrossSales;
    private JPanel tabStocks;
    private JPanel tabInvoices;
    private JPanel tabProduct;

    public AdminHomeScreen() throws SQLException, NotBoundException, RemoteException {
        tabbedPane1.setSelectedIndex(0);

        AdminGrossSalesTab adminGrossSalesTab = new AdminGrossSalesTab();
        tabGrossSales.setLayout(new BorderLayout());
        tabGrossSales.add(adminGrossSalesTab.getPanel(), BorderLayout.CENTER);

        AdminStocksTab adminStocksTab = new AdminStocksTab();
        tabStocks.setLayout(new BorderLayout());
        tabStocks.add(adminStocksTab.getPanel(), BorderLayout.CENTER);

        AdminInvoicesTab adminInvoicesTab = new AdminInvoicesTab();
        tabInvoices.setLayout(new BorderLayout());
        tabInvoices.add(adminInvoicesTab.getPanel(), BorderLayout.CENTER);
    }

    public JPanel getPanel() {
        return panel1;
    }
}
