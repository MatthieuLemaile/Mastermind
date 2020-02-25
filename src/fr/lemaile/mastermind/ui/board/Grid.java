package fr.lemaile.mastermind.ui.board;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Grid extends JPanel {

    public Grid(int nbAttempts, int nbPin, List<JButton> tabButtonBackgroundProposition) {
        super(new GridLayout(nbAttempts, nbPin, 5, 5));
        for (int i = 0; i < nbAttempts * nbPin; i++) {
            JButton buttonTempo = new JButton();
            buttonTempo.setMinimumSize(new Dimension(25, 25));
            buttonTempo.setMaximumSize(new Dimension(25, 25));
            buttonTempo.setPreferredSize(new Dimension(25, 25));
            tabButtonBackgroundProposition.add(buttonTempo);
            tabButtonBackgroundProposition.get(i).setBackground(Color.white);
            tabButtonBackgroundProposition.get(i).setEnabled(false);
            add(tabButtonBackgroundProposition.get(i), i);
        }
    }
}
