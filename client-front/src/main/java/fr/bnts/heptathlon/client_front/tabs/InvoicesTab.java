package fr.bnts.heptathlon.client_front.tabs;

import fr.bnts.heptathlon.main_server.dao.InvoiceFileDAO;
import fr.bnts.heptathlon.main_server.entities.Invoice;
import fr.bnts.heptathlon.main_server.rmi.Service;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

public class InvoicesTab {
    private final Service clientServerService;
    private final InvoiceFileDAO invoiceFileDAO;
    private List<Invoice> invoices;
    private JPanel panel1;
    private JTree invoicePublishedDateTree;

    public InvoicesTab(Service clientServerService, InvoiceFileDAO invoiceFileDAO) throws SQLException,
            RemoteException {
        this.clientServerService = clientServerService;
        this.invoiceFileDAO = invoiceFileDAO;

        this.refreshData();

        this.addEventListeners();
    }

    public void refreshData() throws SQLException, RemoteException {
        this.invoices = this.clientServerService.getInvoices()
                .stream()
                .sorted((invoice1, invoice2) -> invoice2.getPublishedDate().compareTo(invoice1.getPublishedDate()))
                .toList();

        DefaultTreeModel treeModel = createTreeModel(this.invoices);
        this.invoicePublishedDateTree.setModel(treeModel);
    }

    private DefaultTreeModel createTreeModel(List<Invoice> invoices) {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Factures");

        DateTimeFormatter yearFormatter = DateTimeFormatter.ofPattern("yyyy");
        DateTimeFormatter monthFormatter = DateTimeFormatter.ofPattern(
                "MMMM",
                Locale.FRENCH
        );
        DateTimeFormatter dayFormatter = DateTimeFormatter.ofPattern("dd");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        for (Invoice invoice : invoices) {
            LocalDate date = invoice.getPublishedDate().toLocalDate();
            String year = date.format(yearFormatter);
            String month = this.capitalize(date.format(monthFormatter));
            String day = date.format(dayFormatter);
            String time = invoice.getPublishedDate().toLocalTime().format(timeFormatter);

            DefaultMutableTreeNode yearNode = findOrCreateChild(root, year);
            DefaultMutableTreeNode monthNode = findOrCreateChild(yearNode, month);
            DefaultMutableTreeNode dayNode = findOrCreateChild(monthNode, day);

            DefaultMutableTreeNode invoiceNode = new DefaultMutableTreeNode(
                    invoice.getId() + " (Heure: " + time + ", Total: " + invoice.getPrice() + "€, Méthode de paiement: " + invoice.getPaymentMethod() + ")"
            );
            dayNode.add(invoiceNode);
        }
        return new DefaultTreeModel(root);
    }

    private String capitalize(String string) {
        return string.substring(0, 1).toUpperCase() + string.substring(1);
    }

    private DefaultMutableTreeNode findOrCreateChild(DefaultMutableTreeNode parent, String childName) {
        for (int i = 0; i < parent.getChildCount(); i++) {
            DefaultMutableTreeNode childNode = (DefaultMutableTreeNode) parent.getChildAt(i);
            if (childNode.getUserObject().equals(childName)) {
                return childNode;
            }
        }
        DefaultMutableTreeNode childNode = new DefaultMutableTreeNode(childName);
        parent.add(childNode);
        return childNode;
    }

    private void addEventListeners() {
        this.invoicePublishedDateTree.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    handleDoubleClick(e);
                }
            }
        });
    }

    private void handleDoubleClick(MouseEvent e) {
        TreePath path =
                this.invoicePublishedDateTree.getPathForLocation(e.getX(), e.getY());
        if (path != null) {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) path.getLastPathComponent();
            if (node.isLeaf()) {
                Invoice selectedInvoice = getInvoiceFromNode(node);
                if (selectedInvoice != null) {
                    try {
                        this.openInvoiceFile(selectedInvoice);
                    } catch (SQLException | NotBoundException |
                             IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }
    }

    private Invoice getInvoiceFromNode(DefaultMutableTreeNode node) {
        String nodeName = node.getUserObject().toString();
        String productId = nodeName.split("\\(")[0].trim();
        return this.invoices.stream()
                .filter(product -> product.getId().equals(productId))
                .findFirst()
                .orElse(null);
    }

    private void openInvoiceFile(Invoice invoice) throws SQLException, IOException, NotBoundException {
        byte[] invoiceFile = this.clientServerService.readInvoiceFile(invoice);

        this.invoiceFileDAO.write(invoice, invoiceFile);

        String invoiceFileFullPath = String.valueOf(this.invoiceFileDAO.getFullPath(invoice));

        if (Desktop.isDesktopSupported()) {
            Desktop.getDesktop().open(new File(invoiceFileFullPath));
        } else {
            JOptionPane.showMessageDialog(
                    this.panel1,
                    "Desktop n'est pas supporté",
                    "Impossible d'ouvrir le fichier",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    public JPanel getPanel() {
        return panel1;
    }
}
