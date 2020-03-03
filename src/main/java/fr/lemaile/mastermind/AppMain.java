package fr.lemaile.mastermind;

import fr.lemaile.mastermind.controller.Game;
import fr.lemaile.mastermind.ui.UiSwingFactory;

public class AppMain {

    public static void main(String[] args) {
        new Game(new UiSwingFactory());
    }

}
