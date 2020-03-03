package fr.lemaile.mastermind.controller;

import fr.lemaile.mastermind.model.MatchParameters;
import fr.lemaile.mastermind.ui.UiFactory;
import fr.lemaile.mastermind.ui.option.OptionWindow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Option implements OptionEventListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(Option.class);
    private final GameEventListener gameEventListener;
    private final UiFactory uiFactory;
    private MatchParameters matchParameters;
    private OptionWindow optionWindow;

    public Option(MatchParameters matchParameters, GameEventListener gameEventListener, UiFactory uiFactory) {
        LOGGER.trace("Building options");
        this.gameEventListener = gameEventListener;
        this.matchParameters = matchParameters;
        this.uiFactory = uiFactory;
        openOption();
    }

    @Override
    public void updateCanChooseSameColor(boolean canChooseSameColor) {
        LOGGER.debug("Update canChooseSameColor to {}", canChooseSameColor);
        matchParameters.setCanChooseSameColor(canChooseSameColor);
        checkIncompatibilities();
    }

    @Override
    public void selectAttemptsNumber(int attemptNumber) {
        LOGGER.debug("Update number of possible attempts to {}", attemptNumber);
        matchParameters.setNbPossibleAttempts(attemptNumber);
    }

    @Override
    public void selectNumberOfPossibleColor(int numberOfPossibleColor) {
        LOGGER.debug("Update number of possible color to {}", numberOfPossibleColor);
        matchParameters.setNumberOfPossibleColors(numberOfPossibleColor);
        checkIncompatibilities();
    }

    @Override
    public void closeOption() {
        LOGGER.info("close options");
        optionWindow.closeWindow();
        gameEventListener.openMenu();
    }

    public void openOption() {
        LOGGER.info("Opening Options");
        List<Integer> numberOfColorPossible = IntStream.range(1, matchParameters.getNumberOfPossibleColors() + 1).boxed().collect(Collectors.toList());
        List<Integer> listOfPossibleAttempts = IntStream.range(1, 21).boxed().collect(Collectors.toList());
        this.optionWindow = uiFactory.createOptionWindow(matchParameters, this, listOfPossibleAttempts, numberOfColorPossible);
    }

    private void checkIncompatibilities() {
        if (matchParametersError()) {
            LOGGER.info("Match parameters errors");
            optionWindow.displayError("Vous ne pouvez avoir plus de case que de couleur si vous ne pouvez avoir plusieurs fois la même couleur.");
        } else {
            optionWindow.hideError();
        }
    }

    public boolean matchParametersError() {
        return !matchParameters.isCanChooseSameColor() && matchParameters.getNumberOfPossibleColors() < matchParameters.getNbPin();
    }
}
