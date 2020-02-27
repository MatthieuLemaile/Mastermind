package fr.lemaile.mastermind.ui.board;

import fr.lemaile.mastermind.controller.BoardEventListener;
import fr.lemaile.mastermind.model.Color;
import fr.lemaile.mastermind.ui.ColorMapper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import static fr.lemaile.mastermind.ui.Constant.ACTION_BUTTON_SIZE;
import static fr.lemaile.mastermind.ui.Constant.COLOR_BUTTON_SIZE;

public class BoardMenu extends JPanel {


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

        JButton buttonLeave = new JButton("Quitter");
        initDefaultButton(buttonValidate, actionEvent -> eventListener.validateCombination());
        initDefaultButton(buttonLeave, actionEvent -> eventListener.leaveMatch());

        add(Box.createRigidArea(new Dimension(0, 20)));
        add(buttonValidate);
        add(Box.createRigidArea(new Dimension(0, 5)));
        add(buttonLeave);
        add(Box.createRigidArea(new Dimension(0, 20)));

        add(getTextArea("By Marc L."));
        add(getTextArea("With Matthieu L"));
        add(getTextArea("v 1.3"));
    }

    private JLabel getTextArea(String text) {
        JLabel textVersion = new JLabel(text);
        textVersion.setAlignmentX(Component.CENTER_ALIGNMENT);
        return textVersion;
    }

    private void initDefaultButton(JButton button, ActionListener actionListener) {
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setMinimumSize(ACTION_BUTTON_SIZE);
        button.setMaximumSize(ACTION_BUTTON_SIZE);
        button.setPreferredSize(ACTION_BUTTON_SIZE);
        button.addActionListener(actionListener);
    }
}
