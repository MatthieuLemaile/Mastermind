package fr.lemaile.mastermind.controller;

import fr.lemaile.mastermind.model.MatchParameters;
import fr.lemaile.mastermind.ui.MenuWindow;

public class Game implements GameEventListener {
    private MenuWindow menuWindow;
    private MatchParameters matchParameters;

    public Game() {
        menuWindow = new MenuWindow(this);
        matchParameters = new MatchParameters();
        matchParameters.setCanChooseSameColor(true);
        matchParameters.setNbPin(4);
        matchParameters.setNbPossibleAttempts(10);
    }

    @Override
    public void openMenu() {
        menuWindow.show();
    }

    @Override
    public void openOptions() {
        new Option(matchParameters, this);
        menuWindow.hide();
    }

    @Override
    public void openAbout() {
        new About(this);
        menuWindow.hide();
    }

    @Override
    public void exitGame() {
        System.exit(0);
    }

    @Override
    public void startMatch() {
        new Match(matchParameters, this);
        menuWindow.hide();
    }
}
