package fr.lemaile.mastermind.controller;

import fr.lemaile.mastermind.ui.UiFactory;
import fr.lemaile.mastermind.ui.about.AboutWindow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class About implements AboutEventListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(About.class);
    private final GameEventListener gameEventListener;
    private AboutWindow aboutWindow;

    public About(GameEventListener gameEventListener, UiFactory uiFactory) {
        LOGGER.info("Opening About");
        this.gameEventListener = gameEventListener;
        this.aboutWindow = uiFactory.createAboutWindow(this);
    }

    @Override
    public void closeAbout() {
        LOGGER.info("Closing About");
        aboutWindow.closeWindow();
        gameEventListener.openMenu();
    }
}
