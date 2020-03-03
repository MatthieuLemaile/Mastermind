package fr.lemaile.mastermind.controller;

import fr.lemaile.mastermind.model.Color;
import fr.lemaile.mastermind.model.MatchParameters;
import fr.lemaile.mastermind.ui.UiFactory;
import fr.lemaile.mastermind.ui.board.BoardWindow;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class MatchTest {

    @Mock
    private BoardWindow boardWindow;
    @Mock
    private GameEventListener gameListener;
    @Mock
    private UiFactory uiFactory;
    @Captor
    private ArgumentCaptor<List<Color>> colorCaptor;
    @Captor
    private ArgumentCaptor<Integer> pinCaptor;
    @Captor
    private ArgumentCaptor<Integer> possibleAttemptsCaptor;
    @Captor
    private ArgumentCaptor<Integer> rowNumberCaptor;
    private Match match;

    @BeforeEach
    public void setUp() {
        MatchParameters matchParameters = new MatchParameters();
        matchParameters.setNumberOfPossibleColors(8);
        matchParameters.setNbPin(5);
        matchParameters.setNbPossibleAttempts(12);
        Mockito.when(uiFactory.createBoardWindow(pinCaptor.capture(), possibleAttemptsCaptor.capture(), colorCaptor.capture(), Mockito.any(MatchEventListener.class))).thenReturn(boardWindow);
        match = new Match(matchParameters, gameListener, uiFactory);
    }

    @Test
    void should_close_window(){
        assertEquals(8, colorCaptor.getValue().size());
        assertEquals(5, pinCaptor.getValue());
        assertEquals(12, possibleAttemptsCaptor.getValue());

        match.leaveMatch();
        Mockito.verify(boardWindow).closeWindow();
        Mockito.verify(gameListener).openMenu();
    }

    @Test
    void should_be_red_only(){
        assertEquals(8, colorCaptor.getValue().size());
        assertEquals(5, pinCaptor.getValue());
        assertEquals(12, possibleAttemptsCaptor.getValue());
        Mockito.doNothing().when(boardWindow).displayResultRow(rowNumberCaptor.capture(), colorCaptor.capture());

        match.validateCombination();
        Assertions.assertEquals(0, rowNumberCaptor.getValue());
        List<Color> colorList = colorCaptor.getAllValues().get(1);
        Mockito.verify(boardWindow).displayResultRow(Mockito.anyInt(), Mockito.anyList());
        Assertions.assertEquals(5, colorList.size());
        colorList.forEach(c -> Assertions.assertEquals(Color.RED, c));
    }

    @Test
    void should_be_green_only_and_win(){
        assertEquals(8, colorCaptor.getValue().size());
        assertEquals(5, pinCaptor.getValue());
        assertEquals(12, possibleAttemptsCaptor.getValue());

        MatchParameters matchParameters = new MatchParameters();
        matchParameters.setNumberOfPossibleColors(1);
        matchParameters.setNbPin(5);
        matchParameters.setNbPossibleAttempts(12);
        matchParameters.setCanChooseSameColor(true);
        match = new Match(matchParameters, gameListener, uiFactory);

        match.proposeColor(Color.RED);
        match.proposeColor(Color.RED);
        match.proposeColor(Color.RED);
        match.proposeColor(Color.RED);
        match.proposeColor(Color.RED);

        Mockito.doNothing().when(boardWindow).displayResultRow(rowNumberCaptor.capture(), colorCaptor.capture());
        assertEquals(1, colorCaptor.getAllValues().get(1).size());
        assertEquals(5, pinCaptor.getAllValues().get(1));
        assertEquals(12, possibleAttemptsCaptor.getAllValues().get(1));

        match.validateCombination();
        Assertions.assertEquals(0, rowNumberCaptor.getValue());
        List<Color> colorList = colorCaptor.getAllValues().get(2);
        Mockito.verify(boardWindow).displayResultRow(Mockito.anyInt(), Mockito.anyList());
        Assertions.assertEquals(5, colorList.size());
        Assertions.assertEquals(Color.GREEN, colorList.get(0));

        Mockito.verify(boardWindow).showCombination(Mockito.anyList());
        Mockito.verify(boardWindow).displayMessage(Mockito.anyString());
        Mockito.verify(boardWindow).closeWindow();
        Mockito.verify(gameListener).openMenu();
    }

    @Test
    void cant_choose_same_color(){
        assertEquals(8, colorCaptor.getValue().size());
        assertEquals(5, pinCaptor.getValue());
        assertEquals(12, possibleAttemptsCaptor.getValue());

        MatchParameters matchParameters = new MatchParameters();
        matchParameters.setNumberOfPossibleColors(8);
        matchParameters.setNbPin(5);
        matchParameters.setNbPossibleAttempts(12);
        matchParameters.setCanChooseSameColor(false);
        match = new Match(matchParameters, gameListener, uiFactory);
    }
}