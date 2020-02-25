package fr.lemaile.mastermind.ui.Board;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class AnswerPanel extends JPanel {

    public AnswerPanel(int nbPin, List<JButton> tabButtonBackgroundCombination) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JLabel textCombination = new JLabel("Combinaison secrète ");
        textCombination.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(textCombination);
        add(Box.createRigidArea(new Dimension(0, 10)));
        //COMBINATION GRID
        JPanel gridCombination = new JPanel(new GridLayout(1, nbPin, 5, 5));
        for (int i = 0; i < nbPin; i++) {
            JButton buttonTempo = new JButton();
            buttonTempo.setMinimumSize(new Dimension(10, 30));
            buttonTempo.setMaximumSize(new Dimension(10, 30));
            buttonTempo.setPreferredSize(new Dimension(10, 30));
            tabButtonBackgroundCombination.add(buttonTempo);
            tabButtonBackgroundCombination.get(i).setBackground(Color.white);
            tabButtonBackgroundCombination.get(i).setEnabled(false);
            gridCombination.add((JButton) tabButtonBackgroundCombination.get(i), i);
        }
        add(gridCombination);
    }
}
