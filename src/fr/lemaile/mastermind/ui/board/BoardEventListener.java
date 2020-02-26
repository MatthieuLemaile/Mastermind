package fr.lemaile.mastermind.ui.board;

import fr.lemaile.mastermind.model.Color;

public interface BoardEventListener {

    void leaveGame();

    void newMatch();

    void validateCombination();

    void proposeColor(Color color);
}
