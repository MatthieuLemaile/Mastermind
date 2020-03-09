package fr.lemaile.mastermind.model;

public enum UiMessagesKeys {
    MENU_WINDOW_TITLE("menuWindowTitle"),
    ABOUT_WINDOW_TITLE("aboutWindowTitle"),
    OPTION_WINDOW_TITLE("optionWindowTitle"),
    MENU_CODE("menuCode"),
    MENU_NEW_GAME("menuNewGameButton"),
    MENU_LEAVE_GAME("menuLeaveGameButton"),
    MENU_OPTION("menuOptionButton"),
    MENU_ABOUT("menuAboutButton"),
    PROPOSITION_PANEL_TITLE("propositionPanelTitle"),
    RESULT_PANEL_TITLE("resultPanelTitle"),
    END_MATCH_WON_SINGULAR("endMatchWonSingular"),
    END_MATCH_WON_PLURAL("endMatchWonPlural"),
    END_MATCH_LOST("endMatchLost"),
    COLOR_PANEL_TITLE("colorPanelTitle"),
    VALIDATE_BUTTON_TEXT("validateButtonText"),
    QUIT_MATCH_BUTTON_TEXT("quitMatchButtonText"),
    SECRET_COMBINATION_TITLE("secretCombinationTitle"),
    OPTION_COLOR_MULTIPLE("optionColorMultiple"),
    OPTION_TRIAL_NUMBER("optionTrialNumber"),
    OPTION_COLOR_NUMBER("optionColorNumber"),
    OPTION_PIN_NUMBER("optionPinNumber"),
    CREDIT("credit");

    private String code;

    UiMessagesKeys(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
