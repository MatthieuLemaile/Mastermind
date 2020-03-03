package fr.lemaile.mastermind.ui.option;

public interface OptionWindow {
    void closeWindow();

    void displayError(String errorMessage);

    void hideError();
}
