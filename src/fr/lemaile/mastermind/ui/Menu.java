package fr.lemaile.mastermind.ui;

import fr.lemaile.mastermind.controller.GameEventListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

import static fr.lemaile.mastermind.ui.Constant.MENU_ACTION_BUTTON_SIZE;

public class Menu extends JFrame {
    public Menu(GameEventListener gameEventListener) {
        setTitle("Mastermind - menu");

        JButton buttonNew = getButton("Nouveau match", actionEvent -> gameEventListener.startMatch());
        JButton buttonLeave = getButton("Leave game", actionEvent -> gameEventListener.exitGame());

        JPanel menuBody = new JPanel();
        menuBody.setLayout(new BoxLayout(menuBody, BoxLayout.PAGE_AXIS));
        menuBody.setBorder(new EmptyBorder(10, 10, 10, 10));
        menuBody.add(buttonNew);
        menuBody.add(Box.createRigidArea(new Dimension(0, 10)));
        menuBody.add(buttonLeave);

        Container contentPane = getContentPane();
        contentPane.add(menuBody, BorderLayout.CENTER);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(getParent());
        setVisible(true);
    }

    private JButton getButton(String text, ActionListener actionListener) {
        JButton buttonLeave = new JButton(text);
        buttonLeave.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonLeave.setMinimumSize(MENU_ACTION_BUTTON_SIZE);
        buttonLeave.setMaximumSize(MENU_ACTION_BUTTON_SIZE);
        buttonLeave.setPreferredSize(MENU_ACTION_BUTTON_SIZE);
        buttonLeave.addActionListener(actionListener);
        return buttonLeave;
    }
}
