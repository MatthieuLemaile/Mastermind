package fr.lemaile.mastermind.ui.board;

import fr.lemaile.mastermind.controller.MatchEventListener;
import fr.lemaile.mastermind.model.Color;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.List;

/**
 * This class represent the main game window.
 */
public class Board extends JFrame {

    private BoardBody boardBody;
    private BoardMenu boardMenu;

    public Board(int nbPin, int nbAttempts, List<Color> colorList, MatchEventListener matchEventListener) {

        //Base properties
        setTitle("MASTERMIND");

        //HEADER
        BoardHeader boardHeader = new BoardHeader();

        //BODY
        JPanel panelBody = new JPanel(new FlowLayout(FlowLayout.CENTER, 35, 0));

        //MENU
        boardMenu = new BoardMenu(colorList, matchEventListener);
        panelBody.add(boardMenu);

        //GRID PANEL
        boardBody = new BoardBody(nbAttempts, nbPin);
        panelBody.add(boardBody);

        //PLUS
        Container principalContainer = getContentPane();
        principalContainer.add(boardHeader, BorderLayout.PAGE_START);
        principalContainer.add(panelBody, BorderLayout.CENTER);
        panelBody.setBorder(new EmptyBorder(5, 5, 20, 5));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        //LANCER PREMIERE PARTIE
        pack();
        setLocationRelativeTo(getParent());
        setVisible(true);
    }

    public void displayMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    public void showCombination(List<Color> combination) {
        boardBody.showCombination(combination);
    }

    public void displayPropositionRow(int rowNumber, List<Color> colors) {
        boardBody.displayPropositionRow(rowNumber, colors);
    }

    public void displayResultRow(int rowNumber, List<Color> colors) {
        boardBody.displayResultRow(rowNumber, colors);
    }
}
