package fr.lemaile.mastermind.ui;

import fr.lemaile.mastermind.controller.GameEventListener;
import fr.lemaile.mastermind.model.LocaleOption;
import fr.lemaile.mastermind.model.UiMessagesKeys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

import static fr.lemaile.mastermind.ui.UiComponentsUtils.MENU_ACTION_BUTTON_SIZE;
import static fr.lemaile.mastermind.ui.UiComponentsUtils.createButton;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class MenuWindowSwing implements MenuWindow {

    private static final Logger LOGGER = LoggerFactory.getLogger(MenuWindowSwing.class);
    private final JFrame menuFrame;
    private final JButton buttonNew;
    private final JButton buttonLeave;
    private final JButton buttonOption;
    private final JButton buttonAbout;

    public MenuWindowSwing(GameEventListener gameEventListener) {

        LOGGER.trace("Creating Menu UI");
        menuFrame = new JFrame();

        menuFrame.setTitle(LocaleOption.getUiMessages().getString(UiMessagesKeys.MENU_WINDOW_TITLE.getCode()));

        String newGameButtonText = LocaleOption.getUiMessages().getString(UiMessagesKeys.MENU_NEW_GAME.getCode());
        String leaveGameButtonText = LocaleOption.getUiMessages().getString(UiMessagesKeys.MENU_LEAVE_GAME.getCode());
        String optionButtonText = LocaleOption.getUiMessages().getString(UiMessagesKeys.MENU_OPTION.getCode());
        String aboutButtonText = LocaleOption.getUiMessages().getString(UiMessagesKeys.MENU_ABOUT.getCode());
        buttonNew = createButton(newGameButtonText, MENU_ACTION_BUTTON_SIZE, actionEvent -> gameEventListener.startMatch());
        buttonLeave = createButton(leaveGameButtonText, MENU_ACTION_BUTTON_SIZE, actionEvent -> gameEventListener.exitGame());
        buttonOption = createButton(optionButtonText, MENU_ACTION_BUTTON_SIZE, actionEvent -> gameEventListener.openOptions());
        buttonAbout = createButton(aboutButtonText, MENU_ACTION_BUTTON_SIZE, actionEvent -> gameEventListener.openAbout());

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
        LOGGER.trace("Menu UI Created");
    }

    @Override
    public void reloadText() {
        menuFrame.setTitle(LocaleOption.getUiMessages().getString(UiMessagesKeys.MENU_WINDOW_TITLE.getCode()));
        String newGameButtonText = LocaleOption.getUiMessages().getString(UiMessagesKeys.MENU_NEW_GAME.getCode());
        String leaveGameButtonText = LocaleOption.getUiMessages().getString(UiMessagesKeys.MENU_LEAVE_GAME.getCode());
        String optionButtonText = LocaleOption.getUiMessages().getString(UiMessagesKeys.MENU_OPTION.getCode());
        String aboutButtonText = LocaleOption.getUiMessages().getString(UiMessagesKeys.MENU_ABOUT.getCode());
        buttonNew.setText(newGameButtonText);
        buttonAbout.setText(aboutButtonText);
        buttonLeave.setText(leaveGameButtonText);
        buttonOption.setText(optionButtonText);
    }

    @Override
    public void hide() {
        LOGGER.trace("Menu UI hidden");
        menuFrame.setVisible(false);
    }

    @Override
    public void show() {
        LOGGER.trace("Menu UI showed");
        menuFrame.setVisible(true);
    }

    @Override
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }
}
