package fr.lemaile.mastermind.ui.option;

import fr.lemaile.mastermind.controller.OptionEventListener;
import fr.lemaile.mastermind.model.MatchParameters;

import javax.swing.*;
import java.awt.*;

import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class OptionWindow {

    private final JFrame optionFrame;

    public OptionWindow(MatchParameters matchParameters, OptionEventListener optionEventListener) {

        optionFrame = new JFrame();
        optionFrame.setTitle("Mastermind - options");

        OptionBody body = new OptionBody(matchParameters, optionEventListener);

        optionFrame.getContentPane().add(body, BorderLayout.CENTER);
        optionFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        optionFrame.pack();
        optionFrame.setLocationRelativeTo(optionFrame.getParent());
        optionFrame.setVisible(true);
    }

    public void closeWindow() {
        optionFrame.dispose();
    }
}
