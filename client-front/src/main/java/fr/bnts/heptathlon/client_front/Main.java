package fr.bnts.heptathlon.client_front;

import fr.bnts.heptathlon.client_front.screens.AdminHomeScreen;
import fr.bnts.heptathlon.client_front.screens.HomeScreen;
import fr.bnts.heptathlon.client_front.screens.StoreHomeScreen;
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
                "localhost",
                3307,
                "client_server",
                "client_server",
                "client_server"
        );

        ServiceConnector clientServerServiceConnector = new ServiceConnector(
                1100,
                "client_server",
                clientServerDatabase
        );

        Service clientServerService = clientServerServiceConnector.connect();

        JFrame frame = new JFrame("Heptathlon");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        HomeScreen homeScreen = new HomeScreen();
        setScreen(frame, homeScreen.getPanel());

        frame.setResizable(false);
        frame.setSize(1200, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        homeScreenListeners(frame, homeScreen, clientServerService);
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

    private static void homeScreenListeners(JFrame frame, HomeScreen homeScreen, Service clientServerService) {
        homeScreen.getEcranAdministrateurButton().addActionListener(e -> {
            AdminHomeScreen adminHomeScreen;
            try {
                adminHomeScreen = new AdminHomeScreen(clientServerService);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
            setScreen(frame, adminHomeScreen.getPanel());
        });

        homeScreen.getEcranCaisseButton().addActionListener(e -> {
            StoreHomeScreen storeHomeScreen;
            try {
                storeHomeScreen = new StoreHomeScreen(clientServerService);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
            setScreen(frame, storeHomeScreen.getPanel());
        });
    }
}
