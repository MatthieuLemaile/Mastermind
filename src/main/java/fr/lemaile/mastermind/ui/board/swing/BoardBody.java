package fr.lemaile.mastermind.ui.board.swing;

import fr.lemaile.mastermind.model.Color;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class BoardBody extends JPanel {

    private CombinationPanel combinationPanel;
    private GridPanel propositionPanel;
    private GridPanel validationPanel;

    public BoardBody(int nbAttempts, int nbPin) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        //GRIDPR PANEL
        JPanel gridsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 35, 0));

        // => PROPOSITION PANEL
        propositionPanel = new GridPanel(nbAttempts, nbPin, "Proposition");
        gridsPanel.add(propositionPanel);

        // => RESULT PANEL
        validationPanel = new GridPanel(nbAttempts, nbPin, "Résultat");
        gridsPanel.add(validationPanel);

        //COMBINATION PANEL
        combinationPanel = new CombinationPanel(nbPin);

        add(combinationPanel);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(gridsPanel);
        add(Box.createRigidArea(new Dimension(0, 10)));
    }

    public void showCombination(List<Color> combination) {
        combinationPanel.showCombination(combination);
    }

    public void displayPropositionRow(int rowNumber, List<Color> colors) {
        propositionPanel.displayRow(rowNumber, colors);
    }

    public void displayResultRow(int rowNumber, List<Color> colors) {
        validationPanel.displayRow(rowNumber, colors);
    }
}
