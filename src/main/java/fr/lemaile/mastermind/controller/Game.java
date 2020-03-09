package fr.lemaile.mastermind.controller;


import fr.lemaile.mastermind.model.Color;
import fr.lemaile.mastermind.model.LocaleOption;
import fr.lemaile.mastermind.model.MatchParameters;
import fr.lemaile.mastermind.model.UiMessagesKeys;
import fr.lemaile.mastermind.ui.MenuWindow;
import fr.lemaile.mastermind.ui.UiFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Game implements GameEventListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(Game.class);
    private final UiFactory uiFactory;
    private MenuWindow menuWindow;
    private MatchParameters matchParameters;
    private Option option;
    private FactoryHelper factoryHelper;

    public Game(UiFactory uiFactory) {
        this(uiFactory, new FactoryHelper());
    }

    public Game(UiFactory uiFactory, FactoryHelper factoryHelper) {
        this.uiFactory = uiFactory;
        LOGGER.trace("Initialising Game");
        this.factoryHelper = factoryHelper;
        matchParameters = new MatchParameters();
        matchParameters.setCanChooseSameColor(true);
        matchParameters.setNbPin(5);
        matchParameters.setNbPossibleAttempts(12);
        matchParameters.setNumberOfPossibleColors(Color.values().length - 1);
        option = factoryHelper.makeOption(matchParameters, this, uiFactory);
        this.menuWindow = uiFactory.createMenuWindow(this);
        option.closeOption();
        LOGGER.info("Game initialised");
    }

    @Override
    public void reloadText() {
        LOGGER.trace("Reload text");
        menuWindow.reloadText();
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
        factoryHelper.makeAbout(this, uiFactory);
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
            menuWindow.showMessage(LocaleOption.getUiMessages().getString(UiMessagesKeys.MENU_NEW_MATCH_ERROR.getCode()));
        } else {
            factoryHelper.makeMatch(matchParameters, this, uiFactory);
            menuWindow.hide();
        }
    }

    static class FactoryHelper {
        public Option makeOption(MatchParameters matchParameters, GameEventListener gameEventListener, UiFactory uiFactory) {
            return new Option(matchParameters, gameEventListener, uiFactory);
        }

        public About makeAbout(GameEventListener gameEventListener, UiFactory uiFactory) {
            return new About(gameEventListener, uiFactory);
        }

        public Match makeMatch(MatchParameters matchParameters, GameEventListener gameEventListener, UiFactory uiFactory) {
            return new Match(matchParameters, gameEventListener, uiFactory);
        }
    }
}
