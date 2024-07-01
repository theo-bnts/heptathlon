package fr.bnts.heptathlon.client_front;

import fr.bnts.heptathlon.client_front.screens.TabContainer;
import fr.bnts.heptathlon.main_server.database.DatabaseConnector;
import fr.bnts.heptathlon.main_server.rmi.Service;
import fr.bnts.heptathlon.main_server.rmi.ServiceConnector;

import javax.swing.*;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Main {
    public static void main(String[] args) throws NotBoundException, RemoteException {
        setUILook();

        DatabaseConnector clientServerDatabase = new DatabaseConnector(
                args[2],
                Integer.parseInt(args[3]),
                "client_server",
                "client_server",
                "client_server"
        );

        ServiceConnector clientServerServiceConnector = new ServiceConnector(
                args[0],
                Integer.parseInt(args[1]),
                "client_server",
                clientServerDatabase
        );

        Service clientServerService = clientServerServiceConnector.connect();

        JFrame frame = new JFrame("Heptathlon");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        TabContainer tabContainer;
        try {
            tabContainer = new TabContainer(clientServerService);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
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
