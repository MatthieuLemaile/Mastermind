package fr.lemaile.mastermind.controller;

import fr.lemaile.mastermind.ui.Menu;

public class Game implements GameEventListener {
    private Menu menu;

    public Game() {
        menu = new Menu(this);
    }

    @Override
    public void openMenu() {
        menu.setVisible(true);
    }

    @Override
    public void exitGame() {
        System.exit(0);
    }

    @Override
    public void startMatch() {
        new Match(5, 12, this);
        menu.setVisible(false);
    }
}
