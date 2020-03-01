package fr.lemaile.mastermind.ui.option;

import fr.lemaile.mastermind.controller.OptionEventListener;
import fr.lemaile.mastermind.model.MatchParameters;
import fr.lemaile.mastermind.ui.UiComponentsUtils;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.util.List;

import static fr.lemaile.mastermind.ui.UiComponentsUtils.*;


public class OptionBody extends JPanel {

    private JTextArea errorContainer;
    private final JButton buttonLeave;

    public OptionBody(MatchParameters matchParameters, OptionEventListener optionEventListener, List<Integer> listOfPossibleAttempts, List<Integer> numberOfColorPossible) {
        this.setBorder(new EmptyBorder(10, 10, 10, 10));
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        JCheckBox colorDuplicate = new JCheckBox("Couleur en plusieurs exemplaire possible", matchParameters.isCanChooseSameColor());
        colorDuplicate.addItemListener(e -> optionEventListener.updateCanChooseSameColor(ItemEvent.SELECTED == e.getStateChange()));
        colorDuplicate.setAlignmentX(Component.CENTER_ALIGNMENT);

        buttonLeave = createButton("Menu", MENU_ACTION_BUTTON_SIZE, actionEvent -> optionEventListener.closeOption());
        errorContainer = new JTextArea();
        errorContainer.setEditable(false);
        errorContainer.setCursor(null);
        errorContainer.setFocusable(false);
        errorContainer.setLineWrap(true);
        errorContainer.setWrapStyleWord(true);
        errorContainer.setBackground(buttonLeave.getBackground());
        errorContainer.setForeground(Color.RED);

        JComboBox<Integer> attemptsSelector = new JComboBox(listOfPossibleAttempts.toArray());
        attemptsSelector.setSelectedIndex(matchParameters.getNbPossibleAttempts()-1);
        attemptsSelector.addItemListener(itemEvent -> {
            if(ItemEvent.SELECTED == itemEvent.getStateChange()){
                optionEventListener.selectAttemptsNumber((Integer) itemEvent.getItem());
            }
        });


        JComboBox<Integer> colorNumberSelector = new JComboBox(numberOfColorPossible.toArray());
        colorNumberSelector.setSelectedIndex(matchParameters.getNumberOfPossibleColors()-1);
        colorNumberSelector.addItemListener(itemEvent -> {
            if(ItemEvent.SELECTED == itemEvent.getStateChange()){
                optionEventListener.selectNumberOfPossibleColor((Integer) itemEvent.getItem());
            }
        });

        this.add(colorDuplicate);
        this.add(Box.createRigidArea(new Dimension(0, 15)));
        this.add(UiComponentsUtils.getTextArea("Nombre d'essai ?"));
        this.add(Box.createRigidArea(new Dimension(0, 15)));
        this.add(attemptsSelector);
        this.add(Box.createRigidArea(new Dimension(0, 15)));
        this.add(UiComponentsUtils.getTextArea("Nombre de couleurs ?"));
        this.add(Box.createRigidArea(new Dimension(0, 15)));
        this.add(colorNumberSelector);
        this.add(Box.createRigidArea(new Dimension(0, 10)));
        this.add(errorContainer);
        this.add(buttonLeave);
    }

    public void displayError(String errorMessage){
        errorContainer.setText(errorMessage);
        buttonLeave.setEnabled(false);
    }

    public void hideError(){
        errorContainer.setText("");
        buttonLeave.setEnabled(true);
    }
}
