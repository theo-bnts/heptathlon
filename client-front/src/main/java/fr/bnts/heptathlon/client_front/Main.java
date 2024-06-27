package fr.bnts.heptathlon.client_front;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Créer une instance de JFrame
        JFrame frame = new JFrame("Heptathlon Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Créer une instance de homeScreen et ajouter le panel au frame
        HomeScreen homeScreen = new HomeScreen(frame);
        frame.setContentPane(homeScreen.getPanel());

        // Ajuster la taille et rendre visible
        frame.pack();
        frame.setLocationRelativeTo(null); // Centre la fenêtre
        frame.setVisible(true);
    }
}
