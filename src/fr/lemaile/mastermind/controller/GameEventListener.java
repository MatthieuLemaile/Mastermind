package fr.lemaile.mastermind.controller;

public interface GameEventListener {
    void openMenu();

    void openOptions();

    void exitGame();
    void startMatch();
}
