package fr.bnts.heptathlon.client_front.screens;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AdminStocksTab {
    private JPanel panel1;
    private JList<Item> listArticles;

    public AdminStocksTab() {
        DefaultListModel<Item> listModel = getListModel();
        listArticles.setModel(listModel);

        listArticles.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    Item selectedItem = listArticles.getSelectedValue();
                    if (selectedItem != null) {
                        popupItemQuantity(selectedItem);
                    }
                }
                super.mouseClicked(e);
            }
        });
    }

    private DefaultListModel<Item> getListModel() {
        DefaultListModel<Item> listModel = new DefaultListModel<>();
        List<Item> items = generateItems();
        for (Item item : items) {
            listModel.addElement(item);
        }
        return listModel;
    }

    private List<Item> generateItems() {
        List<Item> items = new ArrayList<>();
        Random random = new Random();
        for (int i = 1; i <= 100; i++) {
            items.add(new Item("Item " + i, random.nextInt(101)));
        }
        return items;
    }

    private void popupItemQuantity(Item selectedItem) {
        JSpinner spinner = new JSpinner(new SpinnerNumberModel(selectedItem.quantity, 0, 100, 1));
        JPanel panel = new JPanel();
        panel.add(new JLabel("Article sélectionné : " + selectedItem.name));
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
            //Faudra envoyer la nouvelle quantité au serveur
            System.out.println("Article : " + selectedItem.name + ", Nouvelle quantité : " + newQuantity);
        }
    }

    public JPanel getPanel() {
        return panel1;
    }

    private static class Item {
        String name;
        int quantity;

        Item(String name, int quantity) {
            this.name = name;
            this.quantity = quantity;
        }

        @Override
        public String toString() {
            return name + " (Quantité en stock : " + quantity + ")";
        }
    }
}
