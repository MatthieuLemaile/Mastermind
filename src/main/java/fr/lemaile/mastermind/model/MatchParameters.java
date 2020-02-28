package fr.lemaile.mastermind.model;

public class MatchParameters {
    private boolean canChooseSameColor;
    private int nbPin;
    private int nbPossibleAttempts;

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
}
