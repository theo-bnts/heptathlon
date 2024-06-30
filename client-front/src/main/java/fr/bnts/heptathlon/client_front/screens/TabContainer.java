package fr.bnts.heptathlon.client_front.screens;

import fr.bnts.heptathlon.client_front.tabs.GrossSalesTab;
import fr.bnts.heptathlon.client_front.tabs.InvoicesTab;
import fr.bnts.heptathlon.client_front.tabs.ProductsTab;
import fr.bnts.heptathlon.client_front.tabs.StoreTab;
import fr.bnts.heptathlon.main_server.rmi.Service;

import javax.swing.*;
import java.awt.*;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;

public class TabContainer {
    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JPanel tabGrossSales;
    private JPanel tabProduct;
    private JPanel tabInvoices;
    private JPanel tabStore;

    private final StoreTab storeTab;
    private final ProductsTab productsTab;
    private final InvoicesTab invoicesTab;
    private final GrossSalesTab grossSalesTab;

    public TabContainer(Service clientServerService) throws SQLException, NotBoundException, RemoteException {
        tabbedPane1.setSelectedIndex(0);

        storeTab = new StoreTab(clientServerService);
        tabStore.setLayout(new BorderLayout());
        tabStore.add(storeTab.getPanel());

        productsTab = new ProductsTab(clientServerService);
        tabProduct.setLayout(new BorderLayout());
        tabProduct.add(productsTab.getPanel());

        invoicesTab = new InvoicesTab(clientServerService);
        tabInvoices.setLayout(new BorderLayout());
        tabInvoices.add(invoicesTab.getPanel());

        grossSalesTab = new GrossSalesTab(clientServerService);
        tabGrossSales.setLayout(new BorderLayout());
        tabGrossSales.add(grossSalesTab.getPanel());

        tabbedPane1.addChangeListener(e -> onTabChanged());
    }

    private void onTabChanged() {
        int selectedIndex = tabbedPane1.getSelectedIndex();
        try {
            switch (selectedIndex) {
                case 0 -> storeTab.refreshData();
                case 1 -> productsTab.refreshData();
                case 2 -> invoicesTab.refreshData();
            }
        } catch (RemoteException | SQLException | NotBoundException e) {
            throw new RuntimeException(e);
        }
    }

    public JPanel getPanel() {
        return panel1;
    }
}
