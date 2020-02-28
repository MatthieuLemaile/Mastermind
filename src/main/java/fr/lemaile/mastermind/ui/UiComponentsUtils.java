package fr.lemaile.mastermind.ui;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

public class UiComponentsUtils implements Serializable {
    private UiComponentsUtils() {
        //Hide implit public constructor
    }

    public static JLabel getTextArea(String text) {
        JLabel textVersion = new JLabel(text);
        textVersion.setAlignmentX(Component.CENTER_ALIGNMENT);
        return textVersion;
    }
}