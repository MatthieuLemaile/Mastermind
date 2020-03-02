package fr.lemaile.mastermind.controller;

import fr.lemaile.mastermind.model.MatchParameters;
import fr.lemaile.mastermind.ui.option.OptionWindow;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Option implements OptionEventListener {

    private final GameEventListener gameEventListener;
    private MatchParameters matchParameters;
    private OptionWindow optionWindow;
    private FactoryHelper factoryHelper;

    public Option(MatchParameters matchParameters, GameEventListener gameEventListener) {
        this(matchParameters, gameEventListener, new FactoryHelper());
    }

    public Option(MatchParameters matchParameters, GameEventListener gameEventListener, FactoryHelper factoryHelper) {
        this.gameEventListener = gameEventListener;
        this.matchParameters = matchParameters;
        this.factoryHelper = factoryHelper;
        openOption();
    }

    @Override
    public void updateCanChooseSameColor(boolean canChooseSameColor) {
        matchParameters.setCanChooseSameColor(canChooseSameColor);
        checkIncompatibilities();
    }

    @Override
    public void selectAttemptsNumber(int attemptNumber) {
        matchParameters.setNbPossibleAttempts(attemptNumber);
    }

    @Override
    public void selectNumberOfPossibleColor(int numberOfPossibleColor) {
        matchParameters.setNumberOfPossibleColors(numberOfPossibleColor);
        checkIncompatibilities();
    }

    @Override
    public void closeOption() {
        optionWindow.closeWindow();
        gameEventListener.openMenu();
    }

    public void openOption() {
        List<Integer> numberOfColorPossible = IntStream.range(1, matchParameters.getNumberOfPossibleColors() + 1).boxed().collect(Collectors.toList());
        List<Integer> listOfPossibleAttempts = IntStream.range(1, 21).boxed().collect(Collectors.toList());
        this.optionWindow = factoryHelper.makeOptionWindow(matchParameters, this, listOfPossibleAttempts, numberOfColorPossible);
    }

    private void checkIncompatibilities() {
        if (matchParametersError()) {
            optionWindow.displayError("Vous ne pouvez avoir plus de case que de couleur si vous ne pouvez avoir plusieurs fois la même couleur.");
        } else {
            optionWindow.hideError();
        }
    }

    public boolean matchParametersError() {
        return !matchParameters.isCanChooseSameColor() && matchParameters.getNumberOfPossibleColors() < matchParameters.getNbPin();
    }

    static class FactoryHelper{
        public OptionWindow makeOptionWindow(MatchParameters matchParameters, OptionEventListener optionEventListener, List<Integer> listOfPossibleAttempts, List<Integer> numberOfColorPossible){
            return new OptionWindow(matchParameters, optionEventListener, listOfPossibleAttempts, numberOfColorPossible);
        }
    }
}
