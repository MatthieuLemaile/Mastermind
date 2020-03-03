package fr.lemaile.mastermind.ui;

import fr.lemaile.mastermind.controller.AboutEventListener;
import fr.lemaile.mastermind.controller.GameEventListener;
import fr.lemaile.mastermind.controller.MatchEventListener;
import fr.lemaile.mastermind.controller.OptionEventListener;
import fr.lemaile.mastermind.model.Color;
import fr.lemaile.mastermind.model.MatchParameters;
import fr.lemaile.mastermind.ui.about.AboutWindow;
import fr.lemaile.mastermind.ui.about.AboutWindowSwing;
import fr.lemaile.mastermind.ui.board.BoardWindow;
import fr.lemaile.mastermind.ui.board.swing.BoardWindowSwing;
import fr.lemaile.mastermind.ui.option.OptionWindow;
import fr.lemaile.mastermind.ui.option.swing.OptionWindowSwing;

import java.util.List;

public class UiSwingFactory implements UiFactory {
    @Override
    public MenuWindow createMenuWindow(GameEventListener gameEventListener) {
        return new MenuWindowSwing(gameEventListener);
    }

    @Override
    public AboutWindow createAboutWindow(AboutEventListener aboutEventListener) {
        return new AboutWindowSwing(aboutEventListener);
    }

    @Override
    public OptionWindow createOptionWindow(MatchParameters matchParameters, OptionEventListener optionEventListener, List<Integer> listOfPossibleAttempts, List<Integer> numberOfColorPossible, List<Integer> listOfPossiblePinNumber) {
        return new OptionWindowSwing(matchParameters, optionEventListener, listOfPossibleAttempts, numberOfColorPossible, listOfPossiblePinNumber);
    }

    @Override
    public BoardWindow createBoardWindow(int nbPin, int nbAttempts, List<Color> colorList, MatchEventListener matchEventListener) {
        return new BoardWindowSwing(nbPin, nbAttempts, colorList, matchEventListener);
    }
}
