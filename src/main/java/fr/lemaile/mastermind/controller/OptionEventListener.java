package fr.lemaile.mastermind.controller;

public interface OptionEventListener {
    void updateCanChooseSameColor(boolean canChooseSameColor);
    void closeOption();
    void selectAttemptsNumber(int attemptNumber);
    void selectNumberOfPossibleColor(int numberOfPossibleColor);
}