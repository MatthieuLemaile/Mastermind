package fr.lemaile.mastermind.ui.board;

import fr.lemaile.mastermind.model.Color;

import java.util.List;

public interface BoardWindow {
    void closeWindow();

    void displayWonMatch(int nbEssai);

    void displayLostMatch();

    void showCombination(List<Color> combination);

    void displayPropositionRow(int rowNumber, List<Color> colors);

    void displayResultRow(int rowNumber, List<Color> colors);
}
