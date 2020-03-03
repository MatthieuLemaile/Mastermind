package fr.lemaile.mastermind.ui.about;

import fr.lemaile.mastermind.controller.AboutEventListener;

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
        aboutFrame.setTitle("Mastermind - about");
        aboutFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                aboutEventListener.closeAbout();
            }
        });

        JPanel aboutPanel = new JPanel();
        aboutPanel.setLayout(new BoxLayout(aboutPanel, BoxLayout.PAGE_AXIS));
        aboutPanel.setBorder(new EmptyBorder(15, 15, 15, 15));

        JButton buttonLeave = createButton("Menu", MENU_ACTION_BUTTON_SIZE, actionEvent -> aboutEventListener.closeAbout());

        aboutPanel.add(getTextArea("By Marc L."));
        aboutPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        aboutPanel.add(getTextArea("With Matthieu L"));
        aboutPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        aboutPanel.add(getTextArea("version 1.6 SNAPSHOT"));
        aboutPanel.add(Box.createRigidArea(new Dimension(0, 15)));
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
