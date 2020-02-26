package fr.lemaile.mastermind.ui.board;

import fr.lemaile.mastermind.model.Color;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class BoardPropositionPanel extends JPanel {

    private Grid propositionGrid;

    public BoardPropositionPanel(int nbAttempts, int nbPin) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JLabel textProposition = new JLabel("Proposition");
        textProposition.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(textProposition);
        add(Box.createRigidArea(new Dimension(0, 10)));
        //PROPOSITION GRID
        propositionGrid = new Grid(nbAttempts, nbPin);
        add(propositionGrid);
    }

    public void resetGrid() {
        propositionGrid.resetGrid();
    }

    public void displayRow(int rowNumber, List<Color> colors) {
        propositionGrid.displayRow(rowNumber, colors);
    }
}
