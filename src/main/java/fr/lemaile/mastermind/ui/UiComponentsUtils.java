package fr.lemaile.mastermind.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.Serializable;

public class UiComponentsUtils implements Serializable {
    public static final Dimension COLOR_BUTTON_SIZE = new Dimension(50, 25);
    public static final Dimension ACTION_BUTTON_SIZE = new Dimension(110, 30);
    public static final Dimension MENU_ACTION_BUTTON_SIZE = new Dimension(250, 30);

    private UiComponentsUtils() {
        //Hide implit public constructor
    }

    public static JLabel getTextArea(String text) {
        JLabel textVersion = new JLabel(text);
        textVersion.setAlignmentX(Component.CENTER_ALIGNMENT);
        return textVersion;
    }

    public static JButton createButton(String title, Dimension dimension, ActionListener actionListener) {
        JButton button = new JButton(title);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setMinimumSize(dimension);
        button.setMaximumSize(dimension);
        button.setPreferredSize(dimension);
        button.addActionListener(actionListener);
        return button;
    }
}