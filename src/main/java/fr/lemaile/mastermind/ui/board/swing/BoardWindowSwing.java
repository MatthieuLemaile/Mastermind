package fr.lemaile.mastermind.ui.board.swing;

import fr.lemaile.mastermind.controller.MatchEventListener;
import fr.lemaile.mastermind.model.Color;
import fr.lemaile.mastermind.model.LocaleOption;
import fr.lemaile.mastermind.model.UiMessagesKeys;
import fr.lemaile.mastermind.ui.board.BoardWindow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
public class BoardWindowSwing implements BoardWindow {

    private static final Logger LOGGER = LoggerFactory.getLogger(BoardWindowSwing.class);
    private final JFrame boardFrame;
    private BoardBody boardBody;

    public BoardWindowSwing(int nbPin, int nbAttempts, List<Color> colorList, MatchEventListener matchEventListener) {
        LOGGER.trace("Creating Board UI (Match)");
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
        JPanel mainContainer = new JPanel(new BorderLayout());
        mainContainer.add(boardHeader, BorderLayout.PAGE_START);
        mainContainer.add(panelBody, BorderLayout.CENTER);
        panelBody.setBorder(new EmptyBorder(5, 5, 20, 5));
        JScrollPane scrollPane = new JScrollPane(mainContainer, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.getVerticalScrollBar().setUnitIncrement(5);
        boardFrame.getContentPane().add(scrollPane, BorderLayout.CENTER);
        boardFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        //LANCER PREMIERE PARTIE
        boardFrame.pack();
        boardFrame.setLocationRelativeTo(boardFrame.getParent());
        boardFrame.setVisible(true);
    }

    @Override
    public void closeWindow() {
        boardFrame.dispose();
    }

    @Override
    public void displayWonMatch(int nbEssai) {
        String wonMessage;
        if (nbEssai > 1) {
            wonMessage = String.format(LocaleOption.getUiMessages().getString(UiMessagesKeys.END_MATCH_WON_PLURAL.getCode()), nbEssai);
        } else {
            wonMessage = LocaleOption.getUiMessages().getString(UiMessagesKeys.END_MATCH_WON_SINGULAR.getCode());
        }
        JOptionPane.showMessageDialog(null, wonMessage);
    }

    @Override
    public void displayLostMatch() {
        JOptionPane.showMessageDialog(null, LocaleOption.getUiMessages().getString(UiMessagesKeys.END_MATCH_LOST.getCode()));
    }

    @Override
    public void showCombination(List<Color> combination) {
        boardBody.showCombination(combination);
    }

    @Override
    public void displayPropositionRow(int rowNumber, List<Color> colors) {
        boardBody.displayPropositionRow(rowNumber, colors);
    }

    @Override
    public void displayResultRow(int rowNumber, List<Color> colors) {
        boardBody.displayResultRow(rowNumber, colors);
    }
}
