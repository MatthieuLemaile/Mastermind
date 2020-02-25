package fr.lemaile.mastermind.ui.board;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class BoardPropositionPanel extends JPanel {

    public BoardPropositionPanel(int nbAttempts, int nbPin, List<JButton> tabButtonBackgroundProposition) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JLabel textProposition = new JLabel("Proposition");
        textProposition.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(textProposition);
        add(Box.createRigidArea(new Dimension(0, 10)));
        //PROPOSITION GRID
        Grid gridProposition = new Grid(nbAttempts, nbPin, tabButtonBackgroundProposition);
        add(gridProposition);
    }
}
