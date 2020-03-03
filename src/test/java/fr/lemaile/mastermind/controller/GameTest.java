package fr.lemaile.mastermind.controller;

import fr.lemaile.mastermind.model.MatchParameters;
import fr.lemaile.mastermind.ui.MenuWindow;
import fr.lemaile.mastermind.ui.UiFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class GameTest {

    @Mock
    private MenuWindow menuWindow;
    @Mock
    private Option option;
    @Mock
    private Game.FactoryHelper factoryHelper;
    @Mock
    private UiFactory uiFactory;
    @Captor
    private ArgumentCaptor<MatchParameters> matchParametersCaptor;
    private Game game;

    @BeforeEach
    public void setUp() {
        Mockito.when(uiFactory.createMenuWindow(Mockito.any(GameEventListener.class))).thenReturn(menuWindow);
        Mockito.when(factoryHelper.makeOption(matchParametersCaptor.capture(), Mockito.any(GameEventListener.class), Mockito.eq(uiFactory))).thenReturn(option);
        game = new Game(uiFactory, factoryHelper);
    }

    @Test
    void should_open_menu(){
        game.openMenu();
        Mockito.verify(uiFactory).createMenuWindow(game);
        Mockito.verify(menuWindow).show();
        Mockito.verify(factoryHelper).makeOption(Mockito.any(MatchParameters.class), Mockito.eq(game), Mockito.eq(uiFactory));
        Mockito.verify(option).closeOption();
    }

    @Test
    void should_build_option_with_right_params(){
        game.openOptions();
        Mockito.verify(uiFactory).createMenuWindow(game);
        Mockito.verify(menuWindow).hide();
        MatchParameters matchParameters = matchParametersCaptor.getValue();
        Assertions.assertEquals(5, matchParameters.getNbPin());
        Assertions.assertEquals(12, matchParameters.getNbPossibleAttempts());
        Assertions.assertEquals(8, matchParameters.getNumberOfPossibleColors());
        Assertions.assertTrue(matchParameters.isCanChooseSameColor());
    }

    @Test
    void should_open_about(){
        Mockito.when(factoryHelper.makeAbout(game, uiFactory)).thenReturn(Mockito.mock(About.class));
        game.openAbout();
        Mockito.verify(uiFactory).createMenuWindow(game);
        Mockito.verify(menuWindow).hide();
        Mockito.verify(factoryHelper).makeAbout(game, uiFactory);
    }

    @Test
    void should_throw_exception_when_bad_params(){
        Mockito.when(option.matchParametersError()).thenReturn(true);
        game.startMatch();
        Mockito.verify(factoryHelper, Mockito.never()).makeMatch(Mockito.any(MatchParameters.class), Mockito.any(GameEventListener.class), Mockito.eq(uiFactory));
        Mockito.verify(menuWindow, Mockito.never()).hide();
    }

    @Test
    void should_start_match(){
        Mockito.when(option.matchParametersError()).thenReturn(false);
        game.startMatch();
        Mockito.verify(uiFactory).createMenuWindow(game);
        Mockito.verify(menuWindow).hide();
        Mockito.verify(factoryHelper).makeMatch(matchParametersCaptor.capture(), Mockito.eq(game), Mockito.eq(uiFactory));
        MatchParameters matchParameters = matchParametersCaptor.getValue();
        Assertions.assertEquals(5, matchParameters.getNbPin());
        Assertions.assertEquals(12, matchParameters.getNbPossibleAttempts());
        Assertions.assertEquals(8, matchParameters.getNumberOfPossibleColors());
        Assertions.assertTrue(matchParameters.isCanChooseSameColor());
    }
}