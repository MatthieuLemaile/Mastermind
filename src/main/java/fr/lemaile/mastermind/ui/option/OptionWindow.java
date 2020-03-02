package fr.lemaile.mastermind.ui.option;

import fr.lemaile.mastermind.controller.OptionEventListener;
import fr.lemaile.mastermind.model.MatchParameters;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class OptionWindow {

    private final JFrame optionFrame;
    private final OptionBody optionBody;

    public OptionWindow(MatchParameters matchParameters, OptionEventListener optionEventListener, List<Integer> listOfPossibleAttempts, List<Integer> numberOfColorPossible) {

        optionFrame = new JFrame();
        optionFrame.setTitle("Mastermind - options");
        optionFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                optionEventListener.closeOption();
            }
        });

        optionBody = new OptionBody(matchParameters, optionEventListener, listOfPossibleAttempts, numberOfColorPossible);

        optionFrame.getContentPane().add(optionBody, BorderLayout.CENTER);
        optionFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        optionFrame.pack();
        optionFrame.setLocationRelativeTo(optionFrame.getParent());
        optionFrame.setVisible(true);
    }

    public void closeWindow() {
        optionFrame.dispose();
    }

    public void displayError(String errorMessage) {
        optionBody.displayError(errorMessage);
        optionFrame.pack();
    }

    public void hideError() {
        optionBody.hideError();
        optionFrame.pack();
    }
}
