package fr.lemaile.mastermind.ui;

import fr.lemaile.mastermind.controller.GameEventListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

import static fr.lemaile.mastermind.ui.UiComponentsUtils.MENU_ACTION_BUTTON_SIZE;
import static fr.lemaile.mastermind.ui.UiComponentsUtils.createButton;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class MenuWindow {

    private final JFrame menuFrame;

    public MenuWindow(GameEventListener gameEventListener) {

        menuFrame = new JFrame();

        menuFrame.setTitle("Mastermind - menu");

        JButton buttonNew = createButton("Nouveau match", MENU_ACTION_BUTTON_SIZE, actionEvent -> gameEventListener.startMatch());
        JButton buttonLeave = createButton("Leave game", MENU_ACTION_BUTTON_SIZE, actionEvent -> gameEventListener.exitGame());
        JButton buttonOption = createButton("Options", MENU_ACTION_BUTTON_SIZE, actionEvent -> gameEventListener.openOptions());
        JButton buttonAbout = createButton("À propos", MENU_ACTION_BUTTON_SIZE, actionEvent -> gameEventListener.openAbout());

        JPanel menuBody = new JPanel();
        menuBody.setLayout(new BoxLayout(menuBody, BoxLayout.PAGE_AXIS));
        menuBody.setBorder(new EmptyBorder(10, 10, 10, 10));
        menuBody.add(buttonNew);
        menuBody.add(Box.createRigidArea(new Dimension(0, 10)));
        menuBody.add(buttonOption);
        menuBody.add(Box.createRigidArea(new Dimension(0, 10)));
        menuBody.add(buttonAbout);
        menuBody.add(Box.createRigidArea(new Dimension(0, 10)));
        menuBody.add(buttonLeave);

        Container contentPane = menuFrame.getContentPane();
        contentPane.add(menuBody, BorderLayout.CENTER);

        menuFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        menuFrame.pack();
        menuFrame.setLocationRelativeTo(menuFrame.getParent());
        menuFrame.setVisible(true);
    }

    public void hide() {
        menuFrame.setVisible(false);
    }

    public void show() {
        menuFrame.setVisible(true);
    }
}
