package fr.lemaile.mastermind.controller;

import fr.lemaile.mastermind.model.Color;
import fr.lemaile.mastermind.model.MatchData;
import fr.lemaile.mastermind.ui.board.Board;
import fr.lemaile.mastermind.ui.board.BoardEventListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * This is the main game controller. It is able to control a match, and the whole game.
 * It should be divided into a game controller, and a match controller
 */
public class Match implements BoardEventListener {

    public static final Random RANDOM = new Random();
    public static final int NB_PIN = 5;
    public static final int NB_POSSIBLE_ATTEMPTS = 12;
    private MatchData matchData;
    private Board board;
    private List<Color> possibleColors;

    public void start() {
        initMatchData();
        initMainBoardUI();
    }

    private void initMatchData() {
        matchData = new MatchData(NB_PIN, NB_POSSIBLE_ATTEMPTS);

        //create combination
        possibleColors = Arrays.stream(Color.values())
                //remove "empty" color
                .filter(c -> c != Color.WHITE)
                .collect(Collectors.toList());
        pickCombination();
    }

    private void pickCombination() {
        List<Color> combination = IntStream.range(0, matchData.getNbPin())
                .mapToObj(i -> possibleColors.get(RANDOM.nextInt(possibleColors.size())))
                .collect(Collectors.toList());
        matchData.setCombination(combination);
    }

    private void initMainBoardUI() {
        board = new Board(matchData.getNbPin(), matchData.getNbPossibleAttempts(), possibleColors, this);
    }

    @Override
    public void leaveGame() {
        System.exit(0);
    }

    @Override
    public void newMatch() {
        //data reinitialisation
        matchData.resetData();
        //ui reinitialisation
        board.enableGUI();
        board.resetBoard();

        //starting game
        pickCombination();
        //Information
        board.displayMessage("Partie lancée !");
    }

    @Override
    public void validateCombination() {
        //compte le nb de bien placés / mal placés / mauvais
        int bienPlace = 0;
        int malPlace = 0;
        int mauvais;

        //intermediate variables to erase data later on. new List to avoid getting just reference to original list.
        List<Color> proposition = new ArrayList<>(matchData.getPropositions().get(matchData.getCurrentRow()));
        List<Color> combination = new ArrayList<>(matchData.getCombination());

        for (int pin = 0; pin < proposition.size(); pin++) {
            if (proposition.get(pin).equals(combination.get(pin))) {
                bienPlace++;
                proposition.set(pin, Color.WHITE);
                combination.set(pin, Color.WHITE);
            }
        }

        for (int pin = 0; pin < proposition.size(); pin++) {
            if (combination.contains(proposition.get(pin)) && !proposition.get(pin).equals(Color.WHITE)) {
                malPlace++;
                combination.set(combination.indexOf(proposition.get(pin)), Color.WHITE);
                proposition.set(pin, Color.WHITE);
            }
        }

        mauvais = NB_PIN - (bienPlace + malPlace);

        //Create a list of bienPlace greeen element.
        List<Color> result = createAnswer(bienPlace, malPlace, mauvais);

        //update answers in matchData
        matchData.getAnswers().set(matchData.getCurrentRow(), result);
        //display answers
        board.displayResultRow(matchData.getCurrentRow(), result);

        updateRow();

        //The else if here is to avoid that winning at the last attempts make a double message.
        endGameCheck(bienPlace);
    }

    private void endGameCheck(int bienPlace) {
        if (bienPlace == NB_PIN) {
            board.showCombination(matchData.getCombination());
            board.disableGUI();
            board.displayMessage("Félicitations !\nVous avez gagné en " + matchData.getCurrentRow() + " tentative(s)");
        } else if (matchData.getCurrentRow() == NB_POSSIBLE_ATTEMPTS) {
            board.showCombination(matchData.getCombination());
            board.disableGUI();
            board.displayMessage("Perdu. Réessayez.");
        }
    }

    private List<Color> createAnswer(int bienPlace, int malPlace, int mauvais) {
        List<Color> result = IntStream.range(0, bienPlace)
                .mapToObj(i -> Color.GREEN)
                .collect(Collectors.toList());

        //add malPlace orange element
        result.addAll(IntStream.range(0, malPlace)
                .mapToObj(i -> Color.ORANGE)
                .collect(Collectors.toList()));

        //add mauvais red element
        result.addAll(IntStream.range(0, mauvais)
                .mapToObj(i -> Color.RED)
                .collect(Collectors.toList()));
        return result;
    }

    @Override
    public void proposeColor(Color color) {
        matchData.getPropositions().get(matchData.getCurrentRow()).set(matchData.getCurrentPin(), color);
        updateNumPin();
        board.displayPropositionRow(matchData.getCurrentRow(), matchData.getPropositions().get(matchData.getCurrentRow()));
    }

    private void updateNumPin() {
        matchData.setCurrentPin(matchData.getCurrentPin() == 4 ? 0 : matchData.getCurrentPin() + 1);
    }

    private void updateRow() {
        matchData.setCurrentRow(matchData.getCurrentRow() + 1);
        matchData.setCurrentPin(0);
    }

}
