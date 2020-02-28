package fr.lemaile.mastermind.ui.option;

import fr.lemaile.mastermind.controller.OptionEventListener;
import fr.lemaile.mastermind.model.MatchParameters;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ItemEvent;

import static fr.lemaile.mastermind.ui.Constant.MENU_ACTION_BUTTON_SIZE;

public class OptionBody extends JPanel {

    public OptionBody(MatchParameters matchParameters, OptionEventListener optionEventListener) {
        this.setBorder(new EmptyBorder(10, 10, 10, 10));
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        JCheckBox colorDuplicate = new JCheckBox("Couleur en plusieurs exemplaire possible", matchParameters.isCanChooseSameColor());
        colorDuplicate.addItemListener(e -> optionEventListener.updateCanChooseSameColor(ItemEvent.SELECTED == e.getStateChange()));
        colorDuplicate.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton buttonLeave = new JButton("Menu");
        buttonLeave.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonLeave.setMinimumSize(MENU_ACTION_BUTTON_SIZE);
        buttonLeave.setMaximumSize(MENU_ACTION_BUTTON_SIZE);
        buttonLeave.setPreferredSize(MENU_ACTION_BUTTON_SIZE);
        buttonLeave.addActionListener(actionEvent -> optionEventListener.closeOption());

        this.add(colorDuplicate);
        this.add(Box.createRigidArea(new Dimension(0, 15)));
        this.add(buttonLeave);
    }
}
