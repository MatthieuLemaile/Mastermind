package fr.lemaile.mastermind.controller;

import fr.lemaile.mastermind.model.MatchParameters;
import fr.lemaile.mastermind.ui.Menu;

public class Game implements GameEventListener {
    private Menu menu;
    private MatchParameters matchParameters;

    public Game() {
        menu = new Menu(this);
        matchParameters = new MatchParameters();
        matchParameters.setCanChooseSameColor(true);
        matchParameters.setNbPin(5);
        matchParameters.setNbPossibleAttempts(12);
    }

    @Override
    public void openMenu() {
        menu.show();
    }

    @Override
    public void openOptions() {
        new Option(matchParameters, this);
        menu.hide();
    }

    @Override
    public void exitGame() {
        System.exit(0);
    }

    @Override
    public void startMatch() {
        new Match(matchParameters, this);
        menu.hide();
    }
}
