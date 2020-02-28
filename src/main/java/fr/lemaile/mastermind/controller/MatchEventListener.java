package fr.lemaile.mastermind.controller;

import fr.lemaile.mastermind.model.Color;

public interface MatchEventListener {
    void leaveMatch();

    void validateCombination();

    void proposeColor(Color color);
}
