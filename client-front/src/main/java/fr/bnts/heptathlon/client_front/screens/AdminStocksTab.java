package fr.bnts.heptathlon.client_front.screens;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdminStocksTab {
    private JPanel panel1;
    private JList list1;

    public AdminStocksTab() {
        DefaultListModel<String> listModel = new DefaultListModel<>();
        listModel.addElement("Item 1");
        listModel.addElement("Item 2");
        listModel.addElement("Item 3");
        listModel.addElement("Item 4");
        listModel.addElement("Item 5");


        list1.setModel(listModel);
        list1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println(list1.getSelectedValue());
                super.mouseClicked(e);
            }
        });
    }

    public JPanel getPanel() {
        return panel1;
    }
}
