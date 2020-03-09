package fr.lemaile.mastermind.ui.option.swing;

import fr.lemaile.mastermind.controller.OptionEventListener;
import fr.lemaile.mastermind.model.LocaleOption;
import fr.lemaile.mastermind.model.MatchParameters;
import fr.lemaile.mastermind.model.UiMessagesKeys;
import fr.lemaile.mastermind.ui.UiComponentsUtils;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.util.List;


public class GameOptionPanel extends JPanel {

    public GameOptionPanel(MatchParameters matchParameters, OptionEventListener optionEventListener, List<Integer> listOfPossibleAttempts, List<Integer> numberOfColorPossible, List<Integer> listOfPossiblePinNumber) {
        this.setBorder(new EmptyBorder(10, 10, 10, 10));
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        String optionColorMultiple = LocaleOption.getUiMessages().getString(UiMessagesKeys.OPTION_COLOR_MULTIPLE.getCode());
        JCheckBox colorDuplicate = new JCheckBox(optionColorMultiple, matchParameters.isCanChooseSameColor());
        colorDuplicate.addItemListener(e -> optionEventListener.updateCanChooseSameColor(ItemEvent.SELECTED == e.getStateChange()));
        colorDuplicate.setAlignmentX(Component.CENTER_ALIGNMENT);

        JComboBox<Integer> attemptsSelector = new JComboBox(listOfPossibleAttempts.toArray());
        attemptsSelector.setSelectedIndex(matchParameters.getNbPossibleAttempts() - 1);
        attemptsSelector.addItemListener(itemEvent -> {
            if (ItemEvent.SELECTED == itemEvent.getStateChange()) {
                optionEventListener.selectAttemptsNumber((Integer) itemEvent.getItem());
            }
        });


        JComboBox<Integer> colorNumberSelector = new JComboBox(numberOfColorPossible.toArray());
        colorNumberSelector.setSelectedIndex(matchParameters.getNumberOfPossibleColors() - 1);
        colorNumberSelector.addItemListener(itemEvent -> {
            if (ItemEvent.SELECTED == itemEvent.getStateChange()) {
                optionEventListener.selectNumberOfPossibleColor((Integer) itemEvent.getItem());
            }
        });

        JComboBox<Integer> pinNumberSelector = new JComboBox(listOfPossiblePinNumber.toArray());
        pinNumberSelector.setSelectedIndex(matchParameters.getNbPin() - 1);
        pinNumberSelector.addItemListener(itemEvent -> {
            if (ItemEvent.SELECTED == itemEvent.getStateChange()) {
                optionEventListener.selectNumberOfPin((Integer) itemEvent.getItem());
            }
        });

        this.add(colorDuplicate);
        this.add(Box.createRigidArea(new Dimension(0, 15)));
        String optionTrialNumber = LocaleOption.getUiMessages().getString(UiMessagesKeys.OPTION_TRIAL_NUMBER.getCode());
        this.add(UiComponentsUtils.getTextField(optionTrialNumber));
        this.add(Box.createRigidArea(new Dimension(0, 15)));
        this.add(attemptsSelector);
        this.add(Box.createRigidArea(new Dimension(0, 15)));
        String optionColorNumber = LocaleOption.getUiMessages().getString(UiMessagesKeys.OPTION_COLOR_NUMBER.getCode());
        this.add(UiComponentsUtils.getTextField(optionColorNumber));
        this.add(Box.createRigidArea(new Dimension(0, 15)));
        this.add(colorNumberSelector);
        this.add(Box.createRigidArea(new Dimension(0, 10)));
        String optionPinNumber = LocaleOption.getUiMessages().getString(UiMessagesKeys.OPTION_PIN_NUMBER.getCode());
        this.add(UiComponentsUtils.getTextField(optionPinNumber));
        this.add(Box.createRigidArea(new Dimension(0, 15)));
        this.add(pinNumberSelector);
    }
}
