package fr.lemaile.mastermind.ui.board;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Board extends JFrame {

    private BoardBody boardBody;
    private BoardMenu boardMenu;

    public Board(int nbPin, int nbAttempts, List<fr.lemaile.mastermind.model.Color> colorList, BoardEventListener boardEventListener) {

        //Base properties
        setTitle("MASTERMIND");

        //HEADER
        BoardHeader boardHeader = new BoardHeader();

        //BODY
        JPanel panelBody = new JPanel(new FlowLayout(FlowLayout.CENTER, 35, 0));

        //MENU
        boardMenu = new BoardMenu(colorList, boardEventListener);
        panelBody.add(boardMenu);

        //GRID PANEL
        boardBody = new BoardBody(nbAttempts, nbPin);
        panelBody.add(boardBody);

        //PLUS
        Container principalContainer = getContentPane();
        principalContainer.add("North", boardHeader);
        principalContainer.add("Center", panelBody);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //LANCER PREMIERE PARTIE
        disableGUI();
        JOptionPane.showMessageDialog(null, "Pour lancer une partie,\nappuyez sur le bouton \"Nouveau\"");
        pack();
        setLocationRelativeTo(getParent());
        setVisible(true);
    }

    public void resetBoard() {
        boardBody.resetBoard();
    }

    public void enableGUI() {
        boardMenu.enableGameButton();
    }

    public void disableGUI() {
        boardMenu.disableGameButton();
    }

    public void displayMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    public void showCombination(List<fr.lemaile.mastermind.model.Color> combination) {
        boardBody.showCombination(combination);
    }

    public void displayPropositionRow(int rowNumber, List<fr.lemaile.mastermind.model.Color> colors) {
        boardBody.displayPropositionRow(rowNumber, colors);
    }

    public void displayResultRow(int rowNumber, List<fr.lemaile.mastermind.model.Color> colors) {
        boardBody.displayResultRow(rowNumber, colors);
    }
}
