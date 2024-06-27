package fr.bnts.heptathlon.client_front;

import fr.bnts.heptathlon.client_front.screens.AdminHomeScreen;
import fr.bnts.heptathlon.client_front.screens.HomeScreen;
import fr.bnts.heptathlon.client_front.screens.StoreHomeScreeen;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        setUILook();

        JFrame frame = new JFrame("Heptathlon");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        HomeScreen homeScreen = new HomeScreen();
        setScreen(frame, homeScreen.getPanel());

        frame.setResizable(false);
        frame.setSize(1200, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        homeScreenListeners(frame, homeScreen);
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

    private static void homeScreenListeners(JFrame frame, HomeScreen homeScreen) {
        homeScreen.getEcranAdministrateurButton().addActionListener(e -> {
            AdminHomeScreen adminHomeScreen = new AdminHomeScreen();
            setScreen(frame, adminHomeScreen.getPanel());
        });

        homeScreen.getEcranCaisseButton().addActionListener(e -> {
            StoreHomeScreeen storeHomeScreeen = new StoreHomeScreeen();
            setScreen(frame, storeHomeScreeen.getPanel());
        });
    }
}
