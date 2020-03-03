package fr.lemaile.mastermind.controller;

import fr.lemaile.mastermind.model.Color;
import fr.lemaile.mastermind.model.MatchData;
import fr.lemaile.mastermind.model.MatchParameters;
import fr.lemaile.mastermind.ui.UiFactory;
import fr.lemaile.mastermind.ui.board.BoardWindow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * This is the main game controller. It is able to control a match, and the whole game.
 * It should be divided into a game controller, and a match controller
 */
public class Match implements MatchEventListener {

    public static final Logger LOGGER = LoggerFactory.getLogger(Match.class);
    public static final Random RANDOM = new Random();
    private final List<Color> possibleColors;
    private final GameEventListener gameListener;
    private MatchData matchData;
    private BoardWindow boardWindow;

    public Match(MatchParameters matchParameters, GameEventListener gameListener, UiFactory uiFactory) {
        LOGGER.info("Creating match with params {}", matchParameters);
        this.gameListener = gameListener;
        this.possibleColors = Arrays.stream(Color.values())
                //remove "empty" color
                .filter(c -> c != Color.EMPTY)
                .limit(matchParameters.getNumberOfPossibleColors())
                .collect(Collectors.toList());
        initMatchData(matchParameters);
        boardWindow = uiFactory.createBoardWindow(matchData.getNbPin(), matchData.getNbPossibleAttempts(), possibleColors, this);
        LOGGER.trace("Match created");
    }


    private void initMatchData(MatchParameters matchParameters) {
        matchData = new MatchData(matchParameters.getNbPin(), matchParameters.getNbPossibleAttempts());
        //create combination
        pickCombination(matchParameters.isCanChooseSameColor());
    }

    private void pickCombination(boolean canChooseSameColor) {
        //Avoid touching at the original collection
        List<Color> toBeChoosen = new ArrayList<>(possibleColors);
        Collections.shuffle(toBeChoosen);

        List<Color> combination;
        if (canChooseSameColor) {
            combination = IntStream.range(0, matchData.getNbPin())
                    .mapToObj(i -> toBeChoosen.get(RANDOM.nextInt(toBeChoosen.size())))
                    .collect(Collectors.toList());
        } else {
            combination = IntStream.range(0, matchData.getNbPin())
                    .mapToObj(toBeChoosen::get)
                    .collect(Collectors.toList());
        }
        LOGGER.trace("Pick combination {}", combination);
        matchData.setCombination(combination);
    }

    @Override
    public void leaveMatch() {
        //The user will wait a bit less for the window to close, event if all the background process are not terminated.
        LOGGER.info("Leaving match");
        boardWindow.closeWindow();
        gameListener.openMenu();
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
                proposition.set(pin, Color.EMPTY);
                combination.set(pin, Color.EMPTY);
            }
        }

        for (int pin = 0; pin < proposition.size(); pin++) {
            if (combination.contains(proposition.get(pin)) && !proposition.get(pin).equals(Color.EMPTY)) {
                malPlace++;
                combination.set(combination.indexOf(proposition.get(pin)), Color.EMPTY);
                proposition.set(pin, Color.EMPTY);
            }
        }

        mauvais = matchData.getNbPin() - (bienPlace + malPlace);

        //Create a list of bienPlace greeen element.
        List<Color> result = createAnswer(bienPlace, malPlace, mauvais);

        //update answers in matchData
        matchData.getAnswers().set(matchData.getCurrentRow(), result);
        //display answers
        LOGGER.info("validate proposition {} against combination {}, result is good one, bad place, bad [{},{},{}], answer is {}",
                matchData.getPropositions().get(matchData.getCurrentRow()),
                matchData.getCombination(), bienPlace, malPlace, mauvais, result);
        boardWindow.displayResultRow(matchData.getCurrentRow(), result);

        updateRow();

        //The else if here is to avoid that winning at the last attempts make a double message.
        endGameCheck(bienPlace);
    }

    private void endGameCheck(int bienPlace) {
        if (bienPlace == matchData.getNbPin()) {
            LOGGER.info("Match end - Won");
            boardWindow.showCombination(matchData.getCombination());
            boardWindow.displayMessage("Félicitations !\nVous avez gagné en " + matchData.getCurrentRow() + " tentative(s)");
            this.leaveMatch();
        } else if (matchData.getCurrentRow() == matchData.getNbPossibleAttempts()) {
            LOGGER.info("Match end - Lost");
            boardWindow.showCombination(matchData.getCombination());
            boardWindow.displayMessage("Perdu. Réessayez.");
            this.leaveMatch();
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
        LOGGER.trace("color proposition {} for pin position {}", color, matchData.getCurrentPin());
        matchData.getPropositions().get(matchData.getCurrentRow()).set(matchData.getCurrentPin(), color);
        updateNumPin();
        boardWindow.displayPropositionRow(matchData.getCurrentRow(), matchData.getPropositions().get(matchData.getCurrentRow()));
    }

    private void updateNumPin() {
        matchData.setCurrentPin(matchData.getCurrentPin() == matchData.getNbPin() - 1 ? 0 : matchData.getCurrentPin() + 1);
    }

    private void updateRow() {
        matchData.setCurrentRow(matchData.getCurrentRow() + 1);
        matchData.setCurrentPin(0);
    }
}
