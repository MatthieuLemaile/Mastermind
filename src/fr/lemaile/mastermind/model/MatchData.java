package fr.lemaile.mastermind.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * This class represent all info for a match.
 */
public class MatchData {
    private int currentRow;
    private int currentPin;
    private int nbPin;
    private int nbPossibleAttempts;
    private List<Color> combination = new ArrayList<>();
    private List<List<Color>> propositions = new ArrayList<>();
    private List<List<Color>> answers = new ArrayList<>();

    public MatchData(int nbPin, int nbPossibleAttempts) {
        this.nbPin = nbPin;
        this.nbPossibleAttempts = nbPossibleAttempts;
    }

    public void resetData() {
        Color[] defaultCombinationColor = new Color[nbPin];
        Arrays.fill(defaultCombinationColor, Color.EMPTY);
        combination = Arrays.asList(defaultCombinationColor);


        propositions = new ArrayList<>(nbPossibleAttempts);
        IntStream.range(0, nbPossibleAttempts)
                .forEach(i -> {
                    Color[] defaultColor = new Color[nbPin];
                    Arrays.fill(defaultColor, Color.EMPTY);
                    propositions.add(Arrays.asList(defaultColor));
                });
        answers = new ArrayList<>(nbPossibleAttempts);
        IntStream.range(0, nbPossibleAttempts)
                .forEach(i -> {
                    Color[] defaultColor = new Color[nbPin];
                    Arrays.fill(defaultColor, Color.EMPTY);
                    answers.add(Arrays.asList(defaultColor));
                });
        currentRow = 0;
        currentPin = 0;
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

    public List<Color> getCombination() {
        return combination;
    }

    public void setCombination(List<Color> combination) {
        if (combination.size() != nbPin) {
            throw new IllegalArgumentException("Incorrect combination generated");
        }
        this.combination = combination;
    }

    public List<List<Color>> getPropositions() {
        return propositions;
    }

    public void setPropositions(List<List<Color>> propositions) {
        this.propositions = propositions;
    }

    public List<List<Color>> getAnswers() {
        return answers;
    }

    public void setAnswers(List<List<Color>> answers) {
        this.answers = answers;
    }

    public int getCurrentRow() {
        return currentRow;
    }

    public void setCurrentRow(int currentRow) {
        this.currentRow = currentRow;
    }

    public int getCurrentPin() {
        return currentPin;
    }

    public void setCurrentPin(int currentPin) {
        this.currentPin = currentPin;
    }
}
