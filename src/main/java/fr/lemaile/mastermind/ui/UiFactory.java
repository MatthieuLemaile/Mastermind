package fr.lemaile.mastermind.ui;

import fr.lemaile.mastermind.controller.AboutEventListener;
import fr.lemaile.mastermind.controller.GameEventListener;
import fr.lemaile.mastermind.controller.MatchEventListener;
import fr.lemaile.mastermind.controller.OptionEventListener;
import fr.lemaile.mastermind.model.Color;
import fr.lemaile.mastermind.model.MatchParameters;
import fr.lemaile.mastermind.ui.about.AboutWindow;
import fr.lemaile.mastermind.ui.board.BoardWindow;
import fr.lemaile.mastermind.ui.option.OptionWindow;

import java.util.List;

public interface UiFactory {
    MenuWindow createMenuWindow(GameEventListener gameEventListener);

    AboutWindow createAboutWindow(AboutEventListener aboutEventListener);

    OptionWindow createOptionWindow(MatchParameters matchParameters, OptionEventListener optionEventListener, List<Integer> listOfPossibleAttempts, List<Integer> numberOfColorPossible, List<Integer> listOfPossiblePinNumber);

    BoardWindow createBoardWindow(int nbPin, int nbAttempts, List<Color> colorList, MatchEventListener matchEventListener);
}
