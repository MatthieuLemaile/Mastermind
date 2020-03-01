package fr.lemaile.mastermind.controller;

import fr.lemaile.mastermind.model.Color;
import fr.lemaile.mastermind.model.MatchParameters;
import fr.lemaile.mastermind.ui.MenuWindow;

public class Game implements GameEventListener {
    private MenuWindow menuWindow;
    private MatchParameters matchParameters;
    private Option option;
    private FactoryHelper factoryHelper;

    public Game() {
        this(new FactoryHelper());
    }

    public Game(FactoryHelper factoryHelper){
        this.factoryHelper = factoryHelper;
        this.menuWindow = factoryHelper.makeMenuWindow(this);
        matchParameters = new MatchParameters();
        matchParameters.setCanChooseSameColor(true);
        matchParameters.setNbPin(5);
        matchParameters.setNbPossibleAttempts(12);
        matchParameters.setNumberOfPossibleColors(Color.values().length-1);
        option = factoryHelper.makeOption(matchParameters, this);
        option.closeOption();
    }

    @Override
    public void openMenu() {
        menuWindow.show();
    }

    @Override
    public void openOptions() {
        menuWindow.hide();
    }

    @Override
    public void openAbout() {
        factoryHelper.makeAbout(this);
        menuWindow.hide();
    }

    @Override
    public void exitGame() {
        System.exit(0);
    }

    @Override
    public void startMatch() {
        if(option.matchParametersError()){
            throw new IllegalArgumentException("You must have at least same number of color than pin if you can pick color more than one time.");
        }
        factoryHelper.makeMatch(matchParameters, this);
        menuWindow.hide();
    }

    static class FactoryHelper {
        public MenuWindow makeMenuWindow(GameEventListener gameEventListener){
            return new MenuWindow(gameEventListener);
        }

        public Option makeOption(MatchParameters matchParameters, GameEventListener gameEventListener){
            return new Option(matchParameters, gameEventListener);
        }

        public About makeAbout(GameEventListener gameEventListener){
            return new About(gameEventListener);
        }

        public Match makeMatch(MatchParameters matchParameters, GameEventListener gameEventListener){
            return new Match(matchParameters, gameEventListener);
        }
    }
}
