package fr.lemaile.mastermind.ui.option.swing;

import fr.lemaile.mastermind.controller.OptionEventListener;
import fr.lemaile.mastermind.ui.UiComponentsUtils;

import javax.swing.*;
import java.awt.*;
import java.util.Locale;

import static fr.lemaile.mastermind.ui.UiComponentsUtils.LANGUAGE_BUTTON_SIZE;

public class LanguageSelector extends JPanel {

    public LanguageSelector(OptionEventListener optionEventListener) {
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        JButton buttonEN = UiComponentsUtils.createButton("EN", LANGUAGE_BUTTON_SIZE, actionEvent -> optionEventListener.selectLocale(new Locale("en")));
        JButton buttonFR = UiComponentsUtils.createButton("FR", LANGUAGE_BUTTON_SIZE, actionEvent -> optionEventListener.selectLocale(new Locale("fr")));

        this.add(buttonEN);
        add(Box.createRigidArea(new Dimension(0, 15)));
        this.add(buttonFR);
    }
}
