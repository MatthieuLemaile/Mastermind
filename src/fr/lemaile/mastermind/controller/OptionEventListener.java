package fr.lemaile.mastermind.controller;

public interface OptionEventListener {
    void updateCanChooseSameColor(boolean canChooseSameColor);

    void closeOption();
}
