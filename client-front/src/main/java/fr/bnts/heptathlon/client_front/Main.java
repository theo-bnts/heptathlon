package fr.bnts.heptathlon.client_front;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        JFrame frame = new JFrame("Heptathlon Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        HomeScreen homeScreen = new HomeScreen(frame);
        frame.setContentPane(homeScreen.getPanel());

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
