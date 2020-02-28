package fr.lemaile.mastermind.controller;

import fr.lemaile.mastermind.model.MatchParameters;
import fr.lemaile.mastermind.ui.option.OptionWindow;

public class Option implements OptionEventListener {

    private final GameEventListener gameEventListener;
    private MatchParameters matchParameters;
    private OptionWindow optionWindow;

    public Option(MatchParameters matchParameters, GameEventListener gameEventListener) {
        this.gameEventListener = gameEventListener;
        this.matchParameters = matchParameters;
        this.optionWindow = new OptionWindow(matchParameters, this);
    }

    @Override
    public void updateCanChooseSameColor(boolean canChooseSameColor) {
        matchParameters.setCanChooseSameColor(canChooseSameColor);
    }

    @Override
    public void closeOption() {
        optionWindow.dispose();
        gameEventListener.openMenu();
    }
}
