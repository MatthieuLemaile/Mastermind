package fr.lemaile.mastermind.ui;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.Serializable;

public class UiComponentsUtils implements Serializable {
    public static final Dimension COLOR_BUTTON_SIZE = new Dimension(50, 25);
    public static final Dimension ACTION_BUTTON_SIZE = new Dimension(110, 30);
    public static final Dimension LANGUAGE_BUTTON_SIZE = new Dimension(80, 30);
    public static final Dimension MENU_ACTION_BUTTON_SIZE = new Dimension(250, 30);

    private UiComponentsUtils() {
        //Hide implit public constructor
    }

    public static JLabel getTextField(String text) {
        JLabel textVersion = new JLabel(text);
        textVersion.setAlignmentX(Component.CENTER_ALIGNMENT);
        return textVersion;
    }

    public static JTextPane getTextPane(Color foregroundColor, Color backgroundColor) {
        JTextPane textPane = new JTextPane();
        textPane.setEditable(false);
        textPane.setCursor(null);
        textPane.setFocusable(false);
        textPane.setForeground(foregroundColor);
        textPane.setBackground(backgroundColor);

        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        textPane.getStyledDocument().setParagraphAttributes(0, textPane.getStyledDocument().getLength(), center, false);

        return textPane;
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