package fr.lemaile.mastermind.ui.board;

import fr.lemaile.mastermind.model.Color;
import fr.lemaile.mastermind.ui.ColorMapper;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GridPanel extends JPanel {

    public static final Dimension GRID_ELEMENT_SIZE = new Dimension(25, 25);
    private List<List<JButton>> rows;

    public GridPanel(int nbAttempts, int nbPin, String title) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JLabel titleLabel = new JLabel(title);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(titleLabel);
        add(Box.createRigidArea(new Dimension(0, 10)));
        //GRID
        JPanel grid = createGrid(nbAttempts, nbPin);
        this.add(grid);
    }

    private JPanel createGrid(int nbAttempts, int nbPin) {
        JPanel grid = new JPanel(new GridLayout(nbAttempts, nbPin, 5, 5));
        rows = new ArrayList<>(nbAttempts);
        for (int attempts = 0; attempts < nbAttempts; attempts++) {
            List<JButton> row = new ArrayList<>(nbPin);
            for (int pin = 0; pin < nbPin; pin++) {
                JButton gridElement = new JButton();
                gridElement.setMinimumSize(GRID_ELEMENT_SIZE);
                gridElement.setMaximumSize(GRID_ELEMENT_SIZE);
                gridElement.setPreferredSize(GRID_ELEMENT_SIZE);
                gridElement.setBackground(java.awt.Color.WHITE);
                gridElement.setEnabled(false);
                row.add(gridElement);
                grid.add(gridElement);
            }
            rows.add(row);
        }
        return grid;
    }

    public void resetGrid() {
        for (List<JButton> row : rows) {
            for (JButton element : row) {
                element.setBackground(java.awt.Color.WHITE);
            }
        }
    }

    public void displayRow(int rowNumber, List<Color> colors) {
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
