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

    public TabContainer(Service clientServerService) throws SQLException, NotBoundException, RemoteException {
        tabbedPane1.setSelectedIndex(0);

        StoreTab storeTab = new StoreTab(clientServerService);
        tabStore.setLayout(new BorderLayout());
        tabStore.add(storeTab.getPanel());

        ProductsTab productsTab = new ProductsTab(clientServerService);
        tabProduct.setLayout(new BorderLayout());
        tabProduct.add(productsTab.getPanel());

        GrossSalesTab grossSalesTab = new GrossSalesTab(clientServerService);
        tabGrossSales.setLayout(new BorderLayout());
        tabGrossSales.add(grossSalesTab.getPanel());

        InvoicesTab invoicesTab = new InvoicesTab(clientServerService);
        tabInvoices.setLayout(new BorderLayout());
        tabInvoices.add(invoicesTab.getPanel());
    }

    public JPanel getPanel() {
        return panel1;
    }
}
