package fr.lemaile.mastermind.ui.board.swing;

import fr.lemaile.mastermind.controller.MatchEventListener;
import fr.lemaile.mastermind.model.Color;
import fr.lemaile.mastermind.model.LocaleOption;
import fr.lemaile.mastermind.model.UiMessagesKeys;
import fr.lemaile.mastermind.ui.ColorMapper;
import fr.lemaile.mastermind.ui.UiComponentsUtils;

import javax.swing.*;
import java.awt.*;
import java.util.List;

import static fr.lemaile.mastermind.ui.UiComponentsUtils.*;

public class BoardMenu extends JPanel {

    public BoardMenu(List<Color> colorList, MatchEventListener eventListener) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        add(getTextField(LocaleOption.getUiMessages().getString(UiMessagesKeys.COLOR_PANEL_TITLE.getCode())));
        add(Box.createRigidArea(new Dimension(0, 19)));

        colorList.forEach(color -> {
            JButton colorElement = createButton(null, COLOR_BUTTON_SIZE, actionEvent -> eventListener.proposeColor(color));
            colorElement.setBackground(ColorMapper.mapToUi(color));
            add(colorElement);
            add(Box.createRigidArea(new Dimension(0, 5)));
        });

        String validateButtonText = LocaleOption.getUiMessages().getString(UiMessagesKeys.VALIDATE_BUTTON_TEXT.getCode());
        JButton buttonValidate = UiComponentsUtils.createButton(validateButtonText, ACTION_BUTTON_SIZE, actionEvent -> eventListener.validateCombination());
        String quitButtonText = LocaleOption.getUiMessages().getString(UiMessagesKeys.QUIT_MATCH_BUTTON_TEXT.getCode());
        JButton buttonLeave = UiComponentsUtils.createButton(quitButtonText, ACTION_BUTTON_SIZE, actionEvent -> eventListener.leaveMatch());

        add(Box.createRigidArea(new Dimension(0, 20)));
        add(buttonValidate);
        add(Box.createRigidArea(new Dimension(0, 5)));
        add(buttonLeave);
        add(Box.createRigidArea(new Dimension(0, 20)));
    }
}
