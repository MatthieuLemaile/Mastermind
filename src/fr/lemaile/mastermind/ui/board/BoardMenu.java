package fr.lemaile.mastermind.ui.board;

import fr.lemaile.mastermind.model.Color;
import fr.lemaile.mastermind.ui.ColorMapper;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class BoardMenu extends JPanel {

    private List<JButton> buttonColorList;
    private JButton buttonValidate = new JButton("Valider");

    public BoardMenu(List<Color> colorList, BoardEventListener eventListener) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel textChoice = new JLabel("Choix");
        textChoice.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(textChoice);
        add(Box.createRigidArea(new Dimension(0, 19)));

        buttonColorList = new ArrayList<>(colorList.size());
        colorList.forEach(color -> {
            JButton colorElement = new JButton();
            colorElement.setAlignmentX(Component.CENTER_ALIGNMENT);
            colorElement.setMinimumSize(new Dimension(50, 25));
            colorElement.setMaximumSize(new Dimension(50, 25));
            colorElement.setPreferredSize(new Dimension(50, 25));
            colorElement.setBackground(ColorMapper.mapToUi(color));
            colorElement.addActionListener(actionEvent -> eventListener.proposeColor(color));
            buttonColorList.add(colorElement);
            add(colorElement);
            add(Box.createRigidArea(new Dimension(0, 5)));
        });

        buttonValidate.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonValidate.setMinimumSize(new Dimension(110, 80));
        buttonValidate.setMaximumSize(new Dimension(110, 80));
        buttonValidate.setPreferredSize(new Dimension(110, 30));
        buttonValidate.addActionListener(actionEvent -> eventListener.validateCombination());
        JButton buttonNew = new JButton("Nouveau");
        buttonNew.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonNew.setMinimumSize(new Dimension(110, 80));
        buttonNew.setMaximumSize(new Dimension(110, 80));
        buttonNew.setPreferredSize(new Dimension(110, 30));
        buttonNew.addActionListener(actionEvent -> eventListener.newMatch());
        JButton buttonLeave = new JButton("Quitter");
        buttonLeave.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonLeave.setMinimumSize(new Dimension(110, 80));
        buttonLeave.setMaximumSize(new Dimension(110, 80));
        buttonLeave.setPreferredSize(new Dimension(110, 30));
        buttonLeave.addActionListener(actionEvent -> eventListener.leaveGame());

        add(Box.createRigidArea(new Dimension(0, 20)));
        add(buttonValidate);
        add(Box.createRigidArea(new Dimension(0, 5)));
        add(buttonNew);
        add(Box.createRigidArea(new Dimension(0, 5)));
        add(buttonLeave);
        add(Box.createRigidArea(new Dimension(0, 20)));

        JLabel textAuthor = new JLabel("By Marc L.");
        textAuthor.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(textAuthor);
        JLabel creditMatthieuL = new JLabel("With Matthieu L");
        creditMatthieuL.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(creditMatthieuL);
        JLabel textVersion = new JLabel("v 1.2");
        textVersion.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(textVersion);
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
