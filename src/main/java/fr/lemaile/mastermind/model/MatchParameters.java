package fr.lemaile.mastermind.model;

public class MatchParameters {
    private boolean canChooseSameColor;
    private int nbPin;
    private int nbPossibleAttempts;
    private int numberOfPossibleColors;

    public boolean isCanChooseSameColor() {
        return canChooseSameColor;
    }

    public void setCanChooseSameColor(boolean canChooseSameColor) {
        this.canChooseSameColor = canChooseSameColor;
    }

    public int getNbPin() {
        return nbPin;
    }

    public void setNbPin(int nbPin) {
        this.nbPin = nbPin;
    }

    public int getNbPossibleAttempts() {
        return nbPossibleAttempts;
    }

    public void setNbPossibleAttempts(int nbPossibleAttempts) {
        this.nbPossibleAttempts = nbPossibleAttempts;
    }

    public int getNumberOfPossibleColors() {
        return numberOfPossibleColors;
    }

    public void setNumberOfPossibleColors(int numberOfPossibleColors) {
        this.numberOfPossibleColors = numberOfPossibleColors;
    }

    @Override
    public String toString() {
        return "MatchParameters{" +
                "canChooseSameColor=" + canChooseSameColor +
                ", nbPin=" + nbPin +
                ", nbPossibleAttempts=" + nbPossibleAttempts +
                ", numberOfPossibleColors=" + numberOfPossibleColors +
                '}';
    }
}
