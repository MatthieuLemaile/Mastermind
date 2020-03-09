package fr.lemaile.mastermind.controller;

import java.util.Locale;

public interface OptionEventListener {
    void updateCanChooseSameColor(boolean canChooseSameColor);

    void closeOption();

    void selectAttemptsNumber(int attemptNumber);

    void selectNumberOfPossibleColor(int numberOfPossibleColor);

    void selectNumberOfPin(int numberOfPin);

    void selectLocale(Locale locale);
}