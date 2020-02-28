package fr.lemaile.mastermind.controller;

import fr.lemaile.mastermind.ui.about.AboutWindow;

public class About implements AboutEventListener {

    private final GameEventListener gameEventListener;
    private AboutWindow aboutWindow;

    public About(GameEventListener gameEventListener) {
        this.gameEventListener = gameEventListener;
        this.aboutWindow = new AboutWindow(this);
    }

    @Override
    public void closeAbout() {
        aboutWindow.closeWindow();
        gameEventListener.openMenu();
    }
}
