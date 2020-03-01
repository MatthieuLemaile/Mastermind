package fr.lemaile.mastermind.controller;

import fr.lemaile.mastermind.ui.about.AboutWindow;

public class About implements AboutEventListener {

    private final GameEventListener gameEventListener;
    private AboutWindow aboutWindow;

    public About(GameEventListener gameEventListener) {
        this(gameEventListener, new FactoryHelper());
    }

    public About(GameEventListener gameEventListener, FactoryHelper factoryHelper) {
        this.gameEventListener = gameEventListener;
        this.aboutWindow = factoryHelper.makeAboutWindow(this);
    }

    @Override
    public void closeAbout() {
        aboutWindow.closeWindow();
        gameEventListener.openMenu();
    }

    static class FactoryHelper {
        public AboutWindow makeAboutWindow(AboutEventListener aboutEventListener) {
            return new AboutWindow(aboutEventListener);
        }
    }
}
