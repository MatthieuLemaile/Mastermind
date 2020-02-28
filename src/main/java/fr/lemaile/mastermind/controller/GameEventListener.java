package fr.lemaile.mastermind.controller;

public interface GameEventListener {
    void openMenu();
    void openOptions();

    void openAbout();

    void exitGame();
    void startMatch();
}
