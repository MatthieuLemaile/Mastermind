package fr.lemaile.mastermind.ui.option.swing;

import fr.lemaile.mastermind.controller.OptionEventListener;
import fr.lemaile.mastermind.model.LocaleOption;
import fr.lemaile.mastermind.model.MatchParameters;
import fr.lemaile.mastermind.model.UiMessagesKeys;
import fr.lemaile.mastermind.ui.option.OptionWindow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class OptionWindowSwing implements OptionWindow {

    private static final Logger LOGGER = LoggerFactory.getLogger(OptionWindowSwing.class);
    private final JFrame optionFrame;
    private final OptionBody gameOptionPanel;

    public OptionWindowSwing(MatchParameters matchParameters, OptionEventListener optionEventListener, List<Integer> listOfPossibleAttempts, List<Integer> numberOfColorPossible, List<Integer> listOfPossiblePinNumber) {
        LOGGER.trace("Creating Option UI");
        optionFrame = new JFrame();
        optionFrame.setTitle(LocaleOption.getUiMessages().getString(UiMessagesKeys.OPTION_WINDOW_TITLE.getCode()));
        optionFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                optionEventListener.closeOption();
            }
        });

        gameOptionPanel = new OptionBody(matchParameters, optionEventListener, listOfPossibleAttempts, numberOfColorPossible, listOfPossiblePinNumber);

        optionFrame.getContentPane().add(gameOptionPanel, BorderLayout.CENTER);
        optionFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        optionFrame.pack();
        optionFrame.setLocationRelativeTo(optionFrame.getParent());
        optionFrame.setVisible(true);
    }

    @Override
    public void closeWindow() {
        optionFrame.dispose();
    }

    @Override
    public void displayError(String errorMessage) {
        gameOptionPanel.displayError(errorMessage);
        optionFrame.pack();
    }

    @Override
    public void hideError() {
        gameOptionPanel.hideError();
        optionFrame.pack();
    }
}
