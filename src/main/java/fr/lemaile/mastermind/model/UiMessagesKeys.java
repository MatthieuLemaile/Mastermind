package fr.lemaile.mastermind.model;

public enum UiMessagesKeys {
    MENU_WINDOW_TITLE("menu.windowTitle"),
    ABOUT_WINDOW_TITLE("about.windowTitle"),
    OPTION_WINDOW_TITLE("option.windowTitle"),
    MENU_CODE("button.menu"),
    MENU_NEW_GAME("menu.button.newGame"),
    MENU_LEAVE_GAME("menu.button.leaveGame"),
    MENU_OPTION("menu.button.option"),
    MENU_ABOUT("menu.button.about"),
    MENU_NEW_MATCH_ERROR("menu.error.newMatch"),
    PROPOSITION_PANEL_TITLE("board.propositionPanelTitle"),
    RESULT_PANEL_TITLE("board.resultPanelTitle"),
    END_MATCH_WON_SINGULAR("endMatch.wonSingular"),
    END_MATCH_WON_PLURAL("endMatch.wonPlural"),
    END_MATCH_LOST("endMatch.lost"),
    COLOR_PANEL_TITLE("board.colorPanelTitle"),
    VALIDATE_BUTTON_TEXT("board.button.validate"),
    QUIT_MATCH_BUTTON_TEXT("board.button.quitMatch"),
    SECRET_COMBINATION_TITLE("board.secretCombinationTitle"),
    OPTION_COLOR_MULTIPLE("option.colorMultiple"),
    OPTION_TRIAL_NUMBER("option.trialNumber"),
    OPTION_COLOR_NUMBER("option.colorNumber"),
    OPTION_PIN_NUMBER("option.pinNumber"),
    CREDIT("credit");

    private String code;

    UiMessagesKeys(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
