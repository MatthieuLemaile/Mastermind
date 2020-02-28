package fr.lemaile.mastermind.ui;

import fr.lemaile.mastermind.controller.GameEventListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

import static fr.lemaile.mastermind.ui.Constant.MENU_ACTION_BUTTON_SIZE;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Menu {

    private final JFrame menuFrame;

    public Menu(GameEventListener gameEventListener) {

        menuFrame = new JFrame();

        menuFrame.setTitle("Mastermind - menu");

        JButton buttonNew = getButton("Nouveau match", actionEvent -> gameEventListener.startMatch());
        JButton buttonLeave = getButton("Leave game", actionEvent -> gameEventListener.exitGame());
        JButton buttonOption = getButton("Options", actionEvent -> gameEventListener.openOptions());

        JPanel menuBody = new JPanel();
        menuBody.setLayout(new BoxLayout(menuBody, BoxLayout.PAGE_AXIS));
        menuBody.setBorder(new EmptyBorder(10, 10, 10, 10));
        menuBody.add(buttonNew);
        menuBody.add(Box.createRigidArea(new Dimension(0, 10)));
        menuBody.add(buttonOption);
        menuBody.add(Box.createRigidArea(new Dimension(0, 10)));
        menuBody.add(buttonLeave);

        Container contentPane = menuFrame.getContentPane();
        contentPane.add(menuBody, BorderLayout.CENTER);

        menuFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        menuFrame.pack();
        menuFrame.setLocationRelativeTo(menuFrame.getParent());
        menuFrame.setVisible(true);
    }

    public void closeWindow() {
        menuFrame.dispose();
    }

    public void hide() {
        menuFrame.setVisible(false);
    }

    public void show() {
        menuFrame.setVisible(true);
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
