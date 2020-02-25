package fr.lemaile.mastermind.ui.Board;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class BoardMenu extends JPanel {

    public BoardMenu(int nbColor, List<Color> colorList, List<JButton> buttonColorList, JButton buttonValidate, JButton buttonNew, JButton buttonLeave) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel textChoice = new JLabel("Choix");
        textChoice.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(textChoice);
        add(Box.createRigidArea(new Dimension(0, 19)));

        for (int i = 0; i < nbColor; i++) {
            JButton buttonTempo = new JButton();
            buttonTempo.setAlignmentX(Component.CENTER_ALIGNMENT);
            buttonTempo.setMinimumSize(new Dimension(50, 25));
            buttonTempo.setMaximumSize(new Dimension(50, 25));
            buttonTempo.setPreferredSize(new Dimension(50, 25));
            buttonTempo.setBackground((Color) colorList.get(i));
            buttonColorList.add(buttonTempo);
            add((JButton) buttonColorList.get(i));
            add(Box.createRigidArea(new Dimension(0, 5)));
        }

        buttonValidate.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonValidate.setMinimumSize(new Dimension(110, 80));
        buttonValidate.setMaximumSize(new Dimension(110, 80));
        buttonValidate.setPreferredSize(new Dimension(110, 30));
        buttonNew.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonNew.setMinimumSize(new Dimension(110, 80));
        buttonNew.setMaximumSize(new Dimension(110, 80));
        buttonNew.setPreferredSize(new Dimension(110, 30));
        buttonLeave.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonLeave.setMinimumSize(new Dimension(110, 80));
        buttonLeave.setMaximumSize(new Dimension(110, 80));
        buttonLeave.setPreferredSize(new Dimension(110, 30));

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
        JLabel textVersion = new JLabel("v 1.1");
        textVersion.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(textVersion);
    }
}
