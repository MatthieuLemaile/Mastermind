package fr.lemaile.mastermind.ui.board;

import fr.lemaile.mastermind.model.Color;
import fr.lemaile.mastermind.ui.ColorMapper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class BoardMenu extends JPanel {

    public static final Dimension COLOR_BUTTON_SIZE = new Dimension(50, 25);
    public static final Dimension ACTION_BUTTON_SIZE = new Dimension(110, 30);
    private List<JButton> buttonColorList;
    private JButton buttonValidate = new JButton("Valider");

    public BoardMenu(List<Color> colorList, BoardEventListener eventListener) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        add(getTextArea("Choix"));
        add(Box.createRigidArea(new Dimension(0, 19)));

        buttonColorList = new ArrayList<>(colorList.size());
        colorList.forEach(color -> {
            JButton colorElement = new JButton();
            colorElement.setAlignmentX(Component.CENTER_ALIGNMENT);
            colorElement.setMinimumSize(COLOR_BUTTON_SIZE);
            colorElement.setMaximumSize(COLOR_BUTTON_SIZE);
            colorElement.setPreferredSize(COLOR_BUTTON_SIZE);
            colorElement.setBackground(ColorMapper.mapToUi(color));
            colorElement.addActionListener(actionEvent -> eventListener.proposeColor(color));
            buttonColorList.add(colorElement);
            add(colorElement);
            add(Box.createRigidArea(new Dimension(0, 5)));
        });

        JButton buttonNew = new JButton("Nouveau");
        JButton buttonLeave = new JButton("Quitter");
        initDefaultButton(buttonValidate, actionEvent -> eventListener.validateCombination());
        initDefaultButton(buttonNew, actionEvent -> eventListener.newMatch());
        initDefaultButton(buttonLeave, actionEvent -> eventListener.leaveGame());

        add(Box.createRigidArea(new Dimension(0, 20)));
        add(buttonValidate);
        add(Box.createRigidArea(new Dimension(0, 5)));
        add(buttonNew);
        add(Box.createRigidArea(new Dimension(0, 5)));
        add(buttonLeave);
        add(Box.createRigidArea(new Dimension(0, 20)));

        add(getTextArea("By Marc L."));
        add(getTextArea("With Matthieu L"));
        add(getTextArea("v 1.2"));
    }

    private JLabel getTextArea(String text) {
        JLabel textVersion = new JLabel(text);
        textVersion.setAlignmentX(Component.CENTER_ALIGNMENT);
        return textVersion;
    }

    private void initDefaultButton(JButton buttonNew, ActionListener actionListener) {
        buttonNew.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonNew.setMinimumSize(ACTION_BUTTON_SIZE);
        buttonNew.setMaximumSize(ACTION_BUTTON_SIZE);
        buttonNew.setPreferredSize(ACTION_BUTTON_SIZE);
        buttonNew.addActionListener(actionListener);
    }

    public void enableGameButton() {
        buttonValidate.setEnabled(true);
        buttonColorList.forEach(b -> b.setEnabled(true));
    }

    public void disableGameButton() {
        buttonValidate.setEnabled(false);
        buttonColorList.forEach(b -> b.setEnabled(false));
    }
}
