package fr.lemaile.mastermind.ui.board;

import fr.lemaile.mastermind.model.Color;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class BoardBody extends JPanel {

    private CombinationPanel combinationPanel;
    private BoardPropositionPanel propositionPanel;
    private BoardValidationPanel validationPanel;

    public BoardBody(int nbAttempts, int nbPin) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        //GRIDPR PANEL
        JPanel panelGridPR = new JPanel(new FlowLayout(FlowLayout.CENTER, 35, 0));

        // => PROPOSITION PANEL
        propositionPanel = new BoardPropositionPanel(nbAttempts, nbPin);
        panelGridPR.add(propositionPanel);

        // => RESULT PANEL
        validationPanel = new BoardValidationPanel(nbAttempts, nbPin);
        panelGridPR.add(validationPanel);

        //COMBINATION PANEL
        combinationPanel = new CombinationPanel(nbPin);

        add(panelGridPR);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(combinationPanel);
        add(Box.createRigidArea(new Dimension(0, 10)));
    }

    public void showCombination(List<Color> combination) {
        combinationPanel.showCombination(combination);
    }

    public void resetBoard() {
        propositionPanel.resetGrid();
        validationPanel.resetGrid();
        combinationPanel.resetCombination();
    }

    public void displayPropositionRow(int rowNumber, List<Color> colors) {
        propositionPanel.displayRow(rowNumber, colors);
    }

    public void displayResultRow(int rowNumber, List<Color> colors) {
        validationPanel.displayRow(rowNumber, colors);
    }
}
