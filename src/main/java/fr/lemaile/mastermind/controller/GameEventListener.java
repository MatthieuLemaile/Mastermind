package fr.lemaile.mastermind.controller;

public interface GameEventListener {
    void reloadText();

    void openMenu();

    void openOptions();

    void openAbout();

    void exitGame();

    void startMatch();
}
