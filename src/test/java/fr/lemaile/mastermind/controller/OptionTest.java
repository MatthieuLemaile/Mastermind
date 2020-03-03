package fr.lemaile.mastermind.controller;

import fr.lemaile.mastermind.model.MatchParameters;
import fr.lemaile.mastermind.ui.UiFactory;
import fr.lemaile.mastermind.ui.option.OptionWindow;
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

@ExtendWith(MockitoExtension.class)
class OptionTest {

    @Mock
    private GameEventListener gameEventListener;
    @Mock
    private OptionWindow optionWindow;
    @Mock
    private UiFactory uiFactory;
    @Captor
    private ArgumentCaptor<List<Integer>> possibleAttemptsCaptor;
    @Captor
    private ArgumentCaptor<List<Integer>> numberOfColorCaptor;
    @Captor
    private ArgumentCaptor<List<Integer>> numberOfPinCaptor;
    private MatchParameters matchParameters;
    private Option option;

    @BeforeEach
    public void setUp() {
        matchParameters = new MatchParameters();
        matchParameters.setCanChooseSameColor(true);
        matchParameters.setNbPossibleAttempts(12);
        matchParameters.setNbPin(5);
        matchParameters.setNumberOfPossibleColors(8);
        Mockito.when(uiFactory.createOptionWindow(Mockito.eq(matchParameters), Mockito.any(OptionEventListener.class), possibleAttemptsCaptor.capture(), numberOfColorCaptor.capture(), numberOfPinCaptor.capture())).thenReturn(optionWindow);
        option = new Option(matchParameters, gameEventListener, uiFactory);
    }

    @Test
    void should_update_match_param_can_choose_same_color(){
        Assertions.assertEquals(20, possibleAttemptsCaptor.getValue().size());
        Assertions.assertEquals(8, numberOfColorCaptor.getValue().size());
        Assertions.assertEquals(7, numberOfPinCaptor.getValue().size());

        option.updateCanChooseSameColor(false);
        Assertions.assertFalse(matchParameters.isCanChooseSameColor());
        Mockito.verify(optionWindow).hideError();
    }

    @Test
    void should_update_match_param_nb_possible_attemtps(){
        Assertions.assertEquals(20, possibleAttemptsCaptor.getValue().size());
        Assertions.assertEquals(8, numberOfColorCaptor.getValue().size());
        Assertions.assertEquals(7, numberOfPinCaptor.getValue().size());

        option.selectAttemptsNumber(8);
        Assertions.assertEquals(8, matchParameters.getNbPossibleAttempts());
    }

    @Test
    void should_update_match_param_nb_possible_color() {
        Assertions.assertEquals(20, possibleAttemptsCaptor.getValue().size());
        Assertions.assertEquals(8, numberOfColorCaptor.getValue().size());
        Assertions.assertEquals(7, numberOfPinCaptor.getValue().size());

        option.selectNumberOfPossibleColor(5);
        Assertions.assertEquals(5, matchParameters.getNumberOfPossibleColors());
        Mockito.verify(optionWindow).hideError();
    }

    @Test
    void should_update_matc_param_nb_possible_pin() {
        Assertions.assertEquals(20, possibleAttemptsCaptor.getValue().size());
        Assertions.assertEquals(8, numberOfColorCaptor.getValue().size());
        Assertions.assertEquals(7, numberOfPinCaptor.getValue().size());

        option.selectNumberOfPin(3);
        Assertions.assertEquals(3, matchParameters.getNbPin());
        Mockito.verify(optionWindow).hideError();
    }

    @Test
    void should_display_error() {
        Assertions.assertEquals(20, possibleAttemptsCaptor.getValue().size());
        Assertions.assertEquals(8, numberOfColorCaptor.getValue().size());
        Assertions.assertEquals(7, numberOfPinCaptor.getValue().size());

        option.selectNumberOfPossibleColor(4);
        Assertions.assertEquals(4, matchParameters.getNumberOfPossibleColors());
        Mockito.verify(optionWindow).hideError();
        option.updateCanChooseSameColor(false);
        Assertions.assertFalse(matchParameters.isCanChooseSameColor());
        Mockito.verify(optionWindow).displayError("Vous ne pouvez avoir plus de case que de couleur si vous ne pouvez avoir plusieurs fois la même couleur.");
    }

    @Test
    void should_close_option(){
        Assertions.assertEquals(20, possibleAttemptsCaptor.getValue().size());
        Assertions.assertEquals(8, numberOfColorCaptor.getValue().size());
        Assertions.assertEquals(7, numberOfPinCaptor.getValue().size());

        option.closeOption();
        Mockito.verify(optionWindow).closeWindow();
        Mockito.verify(gameEventListener).openMenu();
    }
}