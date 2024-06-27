package fr.bnts.heptathlon.client_front;

import javax.swing.*;

public class AdminScreen {
    private JPanel panel1;
    private JButton consulterLesStocksButton;
    private JButton calculerChiffreDAffairesButton;
    private JButton listerArticlesButton;
    private JButton listerFacturesButton;
    private JFrame parentFrame;

    public AdminScreen(JFrame frame) {
        this.parentFrame = frame;
    }

    public JPanel getPanel() {
        return panel1;
    }
}
