package fr.lemaile.mastermind.controller;

import fr.lemaile.mastermind.model.Color;

public interface BoardEventListener {
    void leaveMatch();

    void validateCombination();
    void proposeColor(Color color);
}
