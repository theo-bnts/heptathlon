package fr.bnts.heptathlon.client_front;

import fr.bnts.heptathlon.client_front.screens.TabContainer;
import fr.bnts.heptathlon.main_server.dao.InvoiceFileDAO;
import fr.bnts.heptathlon.main_server.database.DatabaseConnector;
import fr.bnts.heptathlon.main_server.rmi.Service;
import fr.bnts.heptathlon.main_server.rmi.ServiceConnector;

import javax.swing.*;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Main {
    public static void main(String[] args) throws NotBoundException, RemoteException {
        setUILook();

        ServiceConnector clientServerServiceConnector = new ServiceConnector(
                args[1],
                Integer.parseInt(args[2]),
                "client_server"
        );
        Service clientServerService = clientServerServiceConnector.connect();

        InvoiceFileDAO invoiceFileDAO = new InvoiceFileDAO(args[0]);

        TabContainer tabContainer;
        try {
            tabContainer = new TabContainer(clientServerService, invoiceFileDAO);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

        JFrame frame = new JFrame("Heptathlon");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setScreen(frame, tabContainer.getPanel());

        frame.setResizable(false);
        frame.setSize(1200, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static void setUILook() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception e1) {
            try {
                for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private static void setScreen(JFrame frame, JPanel panel) {
        frame.setContentPane(panel);
        frame.revalidate();
    }
}
