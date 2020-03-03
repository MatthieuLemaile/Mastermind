package fr.lemaile.mastermind.ui.option.swing;

import fr.lemaile.mastermind.controller.OptionEventListener;
import fr.lemaile.mastermind.model.MatchParameters;
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
    private final OptionBody optionBody;

    public OptionWindowSwing(MatchParameters matchParameters, OptionEventListener optionEventListener, List<Integer> listOfPossibleAttempts, List<Integer> numberOfColorPossible, List<Integer> listOfPossiblePinNumber) {
        LOGGER.trace("Creating Option UI");
        optionFrame = new JFrame();
        optionFrame.setTitle("Mastermind - options");
        optionFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                optionEventListener.closeOption();
            }
        });

        optionBody = new OptionBody(matchParameters, optionEventListener, listOfPossibleAttempts, numberOfColorPossible, listOfPossiblePinNumber);

        optionFrame.getContentPane().add(optionBody, BorderLayout.CENTER);
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
        optionBody.displayError(errorMessage);
        optionFrame.pack();
    }

    @Override
    public void hideError() {
        optionBody.hideError();
        optionFrame.pack();
    }
}
