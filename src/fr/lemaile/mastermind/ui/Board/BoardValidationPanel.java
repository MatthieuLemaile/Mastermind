package fr.lemaile.mastermind.ui.Board;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class BoardValidationPanel extends JPanel {

    public BoardValidationPanel(int nbAttempts, int nbPin, List<JButton> tabButtonBackgroundResult) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JLabel textResult = new JLabel("Résultat");
        textResult.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(textResult);
        add(Box.createRigidArea(new Dimension(0, 10)));
        //RESULT GRID
        Grid gridResult = new Grid(nbAttempts, nbPin, tabButtonBackgroundResult);
        add(gridResult);
    }
}
