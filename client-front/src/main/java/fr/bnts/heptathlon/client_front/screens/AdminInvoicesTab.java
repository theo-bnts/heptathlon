package fr.bnts.heptathlon.client_front.screens;

import fr.bnts.heptathlon.main_server.entities.Invoice;
import fr.bnts.heptathlon.main_server.rmi.Service;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;

public class AdminInvoicesTab {
    private JPanel panel1;
    private JTree invoicePublishedDateTree;
    private final List<Invoice> invoices;
    private final Service clientServerService;

    public AdminInvoicesTab(Service clientServerService) throws SQLException, RemoteException {
        this.clientServerService = clientServerService;

        invoices = clientServerService.getInvoices();

        DefaultTreeModel treeModel = createTreeModel(invoices);
        invoicePublishedDateTree.setModel(treeModel);

        addEventListeners();
    }

    private DefaultTreeModel createTreeModel(List<Invoice> invoices) {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Factures");

        for (Invoice invoice : invoices) {
            DefaultMutableTreeNode invoiceNode = new DefaultMutableTreeNode(
                    invoice.getId() + " (Heure de publication: " + invoice.getPublishedDate() + ", Total: " + invoice.getPrice() + "$)"
            );
            root.add(invoiceNode);
        }
        return new DefaultTreeModel(root);
    }

    private void addEventListeners() {
        invoicePublishedDateTree.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    handleDoubleClick(e);
                }
            }
        });
    }

    private void handleDoubleClick(MouseEvent e) {
        TreePath path = invoicePublishedDateTree.getPathForLocation(e.getX(), e.getY());
        if (path != null) {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) path.getLastPathComponent();
            if (node.isLeaf()) {
                Invoice selectedInvoice = getInvoiceFromNode(node);
                if (selectedInvoice != null) {
                    try {
                        openInvoiceFile(selectedInvoice);
                    } catch (SQLException | NotBoundException | RemoteException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }
    }

    private Invoice getInvoiceFromNode(DefaultMutableTreeNode node) {
        String nodeName = node.getUserObject().toString();
        String productId = nodeName.split("\\(")[0].trim();
        return invoices.stream()
                .filter(product -> product.getId().equals(productId))
                .findFirst()
                .orElse(null);
    }

    private void openInvoiceFile(Invoice invoice) throws SQLException, RemoteException, NotBoundException {
        System.out.println("Opening invoice file: " + invoice.getId());
    }

    public JPanel getPanel() {
        return panel1;
    }
}
