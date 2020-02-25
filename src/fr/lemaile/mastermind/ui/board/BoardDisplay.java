package fr.lemaile.mastermind.ui.board;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class BoardDisplay extends JPanel {

    public BoardDisplay(int nbAttempts, int nbPin, List<JButton> tabButtonBackgroundProposition, List<JButton> tabButtonBackgroundResult, List<JButton> tabButtonBackgroundCombination) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        //GRIDPR PANEL
        JPanel panelGridPR = new JPanel(new FlowLayout(FlowLayout.CENTER, 35, 0));

        // => PROPOSITION PANEL
        BoardPropositionPanel propositionPanel = new BoardPropositionPanel(nbAttempts, nbPin, tabButtonBackgroundProposition);
        panelGridPR.add(propositionPanel);

        // => RESULT PANEL
        BoardValidationPanel validationPanel = new BoardValidationPanel(nbAttempts, nbPin, tabButtonBackgroundResult);
        panelGridPR.add(validationPanel);

        //COMBINATION PANEL
        AnswerPanel answerPanel = new AnswerPanel(nbPin, tabButtonBackgroundCombination);

        add(panelGridPR);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(answerPanel);
        add(Box.createRigidArea(new Dimension(0, 10)));
    }
}
