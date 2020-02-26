package fr.lemaile.mastermind.ui.board;

import fr.lemaile.mastermind.ui.ColorMapper;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CombinationPanel extends JPanel {

    private List<JButton> combinationButton;

    public CombinationPanel(int nbPin) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JLabel textCombination = new JLabel("Combinaison secrète ");
        textCombination.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(textCombination);
        add(Box.createRigidArea(new Dimension(0, 10)));
        //COMBINATION GRID
        JPanel gridCombination = new JPanel(new GridLayout(1, nbPin, 5, 5));
        combinationButton = new ArrayList<>();
        for (int i = 0; i < nbPin; i++) {
            JButton combinationElement = new JButton();
            combinationElement.setMinimumSize(new Dimension(10, 30));
            combinationElement.setMaximumSize(new Dimension(10, 30));
            combinationElement.setPreferredSize(new Dimension(10, 30));
            combinationElement.setBackground(Color.white);
            combinationElement.setEnabled(false);
            gridCombination.add(combinationElement, i);
            combinationButton.add(combinationElement);
        }
        add(gridCombination);
    }

    public void resetCombination() {
        for (JButton element : combinationButton) {
            element.setBackground(Color.WHITE);
        }
    }

    public void showCombination(List<fr.lemaile.mastermind.model.Color> combination) {
        Iterator<JButton> uiIterator = combinationButton.iterator();
        Iterator<fr.lemaile.mastermind.model.Color> combinationIterator = combination.iterator();
        while (uiIterator.hasNext() && combinationIterator.hasNext()) {
            uiIterator.next().setBackground(ColorMapper.mapToUi(combinationIterator.next()));
        }
    }
}
