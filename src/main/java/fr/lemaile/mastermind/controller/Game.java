package fr.lemaile.mastermind.controller;


import fr.lemaile.mastermind.model.Color;
import fr.lemaile.mastermind.model.MatchParameters;
import fr.lemaile.mastermind.ui.MenuWindow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Game implements GameEventListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(Game.class);
    private MenuWindow menuWindow;
    private MatchParameters matchParameters;
    private Option option;
    private FactoryHelper factoryHelper;

    public Game() {
        this(new FactoryHelper());
    }

    public Game(FactoryHelper factoryHelper) {
        LOGGER.trace("Initialising Game");
        this.factoryHelper = factoryHelper;
        this.menuWindow = factoryHelper.makeMenuWindow(this);
        matchParameters = new MatchParameters();
        matchParameters.setCanChooseSameColor(true);
        matchParameters.setNbPin(5);
        matchParameters.setNbPossibleAttempts(12);
        matchParameters.setNumberOfPossibleColors(Color.values().length-1);
        option = factoryHelper.makeOption(matchParameters, this);
        option.closeOption();
        LOGGER.info("Game initialised");
    }

    @Override
    public void openMenu() {
        LOGGER.trace("Open menu");
        menuWindow.show();
    }

    @Override
    public void openOptions() {
        LOGGER.trace("Open options");
        option.openOption();
        menuWindow.hide();
    }

    @Override
    public void openAbout() {
        LOGGER.trace("Open about");
        factoryHelper.makeAbout(this);
        menuWindow.hide();
    }

    @Override
    public void exitGame() {
        LOGGER.info("Exiting game");
        System.exit(0);
    }

    @Override
    public void startMatch() {
        LOGGER.trace("Starting game");
        if (option.matchParametersError()) {
            LOGGER.error("Number of color/pin and color reusage inconsistent");
            //display this to user.
        } else {
            factoryHelper.makeMatch(matchParameters, this);
            menuWindow.hide();
        }
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
