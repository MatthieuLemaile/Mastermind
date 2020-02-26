package fr.lemaile.mastermind.ui.board;

import fr.lemaile.mastermind.ui.ColorMapper;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Grid extends JPanel {

    private List<List<JButton>> rows;

    public Grid(int nbAttempts, int nbPin) {
        super(new GridLayout(nbAttempts, nbPin, 5, 5));
        rows = new ArrayList<>(nbAttempts);
        for (int attempts = 0; attempts < nbAttempts; attempts++) {
            List<JButton> row = new ArrayList<>(nbPin);
            for (int pin = 0; pin < nbPin; pin++) {
                JButton gridElement = new JButton();
                gridElement.setMinimumSize(new Dimension(25, 25));
                gridElement.setMaximumSize(new Dimension(25, 25));
                gridElement.setPreferredSize(new Dimension(25, 25));
                gridElement.setBackground(Color.WHITE);
                gridElement.setEnabled(false);
                row.add(gridElement);
                this.add(gridElement);
            }
            rows.add(row);
        }
    }

    public void resetGrid() {
        for (List<JButton> row : rows) {
            for (JButton element : row) {
                element.setBackground(Color.WHITE);
            }
        }
    }

    public void displayRow(int rowNumber, List<fr.lemaile.mastermind.model.Color> colors) {
        if (rowNumber < 0 || rowNumber > rows.size()) {
            throw new IllegalArgumentException("This is not a valid row number");
        }
        Iterator<JButton> uiIterator = rows.get(rowNumber).iterator();
        Iterator<fr.lemaile.mastermind.model.Color> colorIterator = colors.iterator();
        while (uiIterator.hasNext() && colorIterator.hasNext()) {
            uiIterator.next().setBackground(ColorMapper.mapToUi(colorIterator.next()));
        }
    }
}
