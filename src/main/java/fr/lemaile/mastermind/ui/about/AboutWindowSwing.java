package fr.lemaile.mastermind.ui.about;

import fr.lemaile.mastermind.controller.AboutEventListener;
import fr.lemaile.mastermind.model.LocaleOption;
import fr.lemaile.mastermind.model.UiMessagesKeys;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import static fr.lemaile.mastermind.ui.UiComponentsUtils.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class AboutWindowSwing implements AboutWindow {

    private final JFrame aboutFrame;

    public AboutWindowSwing(AboutEventListener aboutEventListener) {
        aboutFrame = new JFrame();
        aboutFrame.setTitle(LocaleOption.getUiMessages().getString(UiMessagesKeys.ABOUT_WINDOW_TITLE.getCode()));
        aboutFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                aboutEventListener.closeAbout();
            }
        });

        JPanel aboutPanel = new JPanel();
        aboutPanel.setLayout(new BoxLayout(aboutPanel, BoxLayout.PAGE_AXIS));
        aboutPanel.setBorder(new EmptyBorder(15, 15, 15, 15));

        JButton buttonLeave = createButton(LocaleOption.getUiMessages().getString(UiMessagesKeys.MENU_CODE.getCode()),
                MENU_ACTION_BUTTON_SIZE, actionEvent -> aboutEventListener.closeAbout());

        JTextPane creditTextPane = getTextPane(Color.BLACK, buttonLeave.getBackground());
        creditTextPane.setText(LocaleOption.getUiMessages().getString(UiMessagesKeys.CREDIT.getCode()));
        aboutPanel.add(creditTextPane);
        aboutPanel.add(buttonLeave);

        aboutFrame.getContentPane().add(aboutPanel, BorderLayout.CENTER);
        aboutFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        aboutFrame.pack();
        aboutFrame.setLocationRelativeTo(aboutFrame.getParent());
        aboutFrame.setVisible(true);
    }

    @Override
    public void closeWindow() {
        aboutFrame.dispose();
    }
}
