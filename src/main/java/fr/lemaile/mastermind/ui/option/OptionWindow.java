package fr.lemaile.mastermind.ui.option;

import fr.lemaile.mastermind.controller.OptionEventListener;
import fr.lemaile.mastermind.model.MatchParameters;

import javax.swing.*;
import java.awt.*;

public class OptionWindow extends JFrame {
    public OptionWindow(MatchParameters matchParameters, OptionEventListener optionEventListener) {
        setTitle("Mastermind - options");

        OptionBody body = new OptionBody(matchParameters, optionEventListener);

        getContentPane().add(body, BorderLayout.CENTER);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(getParent());
        setVisible(true);
    }
}
