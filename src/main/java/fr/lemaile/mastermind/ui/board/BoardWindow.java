package fr.lemaile.mastermind.ui.board;

import fr.lemaile.mastermind.controller.MatchEventListener;
import fr.lemaile.mastermind.model.Color;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 * This class represent the main game window.
 */
/* It is better to create a JFrame object inside, instead of extends it, especially for complex class.
 * Too much methods override. Safer code, as we expose only what's needed.
 */
public class BoardWindow {

    private BoardBody boardBody;
    private final JFrame boardFrame;

    public BoardWindow(int nbPin, int nbAttempts, List<Color> colorList, MatchEventListener matchEventListener) {

        boardFrame = new JFrame();
        //Base properties
        boardFrame.setTitle("MASTERMIND");
        boardFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                matchEventListener.leaveMatch();
            }
        });

        //HEADER
        BoardHeader boardHeader = new BoardHeader();

        //BODY
        JPanel panelBody = new JPanel(new FlowLayout(FlowLayout.CENTER, 35, 0));

        //MENU
        BoardMenu boardMenu = new BoardMenu(colorList, matchEventListener);
        panelBody.add(boardMenu);

        //GRID PANEL
        boardBody = new BoardBody(nbAttempts, nbPin);
        panelBody.add(boardBody);

        //PLUS
        Container principalContainer = boardFrame.getContentPane();
        principalContainer.add(boardHeader, BorderLayout.PAGE_START);
        principalContainer.add(panelBody, BorderLayout.CENTER);
        panelBody.setBorder(new EmptyBorder(5, 5, 20, 5));
        boardFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        //LANCER PREMIERE PARTIE
        boardFrame.pack();
        boardFrame.setLocationRelativeTo(boardFrame.getParent());
        boardFrame.setVisible(true);
    }

    public void closeWindow() {
        boardFrame.dispose();
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
