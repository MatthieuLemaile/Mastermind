package fr.lemaile.mastermind.model;

import java.util.ResourceBundle;

public class LocaleOption {

    private static ResourceBundle uiMessages = ResourceBundle.getBundle("uiMessages");

    private LocaleOption() {
        //hide implicit public constructor.
    }

    public static ResourceBundle getUiMessages() {
        return uiMessages;
    }

    public static void setUiMessages(ResourceBundle uiMessages) {
        LocaleOption.uiMessages = uiMessages;
    }
}