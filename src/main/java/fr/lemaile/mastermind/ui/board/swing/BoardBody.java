package fr.lemaile.mastermind.ui.board.swing;

import fr.lemaile.mastermind.model.Color;
import fr.lemaile.mastermind.model.LocaleOption;
import fr.lemaile.mastermind.model.UiMessagesKeys;

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
        String propositionTitle = LocaleOption.getUiMessages().getString(UiMessagesKeys.PROPOSITION_PANEL_TITLE.getCode());
        propositionPanel = new GridPanel(nbAttempts, nbPin, propositionTitle);
        gridsPanel.add(propositionPanel);

        // => RESULT PANEL
        String resultPanelTitle = LocaleOption.getUiMessages().getString(UiMessagesKeys.RESULT_PANEL_TITLE.getCode());
        validationPanel = new GridPanel(nbAttempts, nbPin, resultPanelTitle);
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
