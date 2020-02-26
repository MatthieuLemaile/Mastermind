package fr.lemaile.mastermind.ui.board;

import fr.lemaile.mastermind.model.Color;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class BoardValidationPanel extends JPanel {

    private Grid resultGrid;

    public BoardValidationPanel(int nbAttempts, int nbPin) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JLabel textResult = new JLabel("Résultat");
        textResult.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(textResult);
        add(Box.createRigidArea(new Dimension(0, 10)));
        //RESULT GRID
        resultGrid = new Grid(nbAttempts, nbPin);
        add(resultGrid);
    }

    public void resetGrid() {
        resultGrid.resetGrid();
    }

    public void displayRow(int rowNumber, List<Color> colors) {
        resultGrid.displayRow(rowNumber, colors);
    }
}
