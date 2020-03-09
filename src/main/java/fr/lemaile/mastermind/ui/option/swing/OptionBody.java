package fr.lemaile.mastermind.ui.option.swing;

import fr.lemaile.mastermind.controller.OptionEventListener;
import fr.lemaile.mastermind.model.LocaleOption;
import fr.lemaile.mastermind.model.MatchParameters;
import fr.lemaile.mastermind.model.UiMessagesKeys;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.List;

import static fr.lemaile.mastermind.ui.UiComponentsUtils.*;

public class OptionBody extends JPanel {

    private JTextPane errorContainer;
    private final JButton buttonLeave;

    public OptionBody(MatchParameters matchParameters, OptionEventListener optionEventListener, List<Integer> listOfPossibleAttempts, List<Integer> numberOfColorPossible, List<Integer> listOfPossiblePinNumber) {
        this.setBorder(new EmptyBorder(10, 10, 10, 10));
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        JPanel optionsPanel = new JPanel();
        optionsPanel.setLayout(new BoxLayout(optionsPanel, BoxLayout.LINE_AXIS));
        optionsPanel.add(new GameOptionPanel(matchParameters, optionEventListener, listOfPossibleAttempts, numberOfColorPossible, listOfPossiblePinNumber));
        optionsPanel.add(new LanguageSelector(optionEventListener));

        errorContainer = getTextPane(Color.RED, this.getBackground());
        errorContainer.setMinimumSize(this.getMinimumSize());

        String menuText = LocaleOption.getUiMessages().getString(UiMessagesKeys.MENU_CODE.getCode());
        buttonLeave = createButton(menuText, MENU_ACTION_BUTTON_SIZE, actionEvent -> optionEventListener.closeOption());

        this.add(optionsPanel);
        this.add(Box.createRigidArea(new Dimension(0, 10)));
        this.add(errorContainer);
        this.add(buttonLeave);
    }

    public void displayError(String errorMessage){
        errorContainer.setText(errorMessage);
        buttonLeave.setEnabled(false);
    }

    public void hideError(){
        errorContainer.setText("");
        buttonLeave.setEnabled(true);
    }
}
