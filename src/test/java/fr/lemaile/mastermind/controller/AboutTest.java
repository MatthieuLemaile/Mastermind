package fr.lemaile.mastermind.controller;

import fr.lemaile.mastermind.ui.about.AboutWindow;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AboutTest {

    @Mock
    private GameEventListener gameEventListener;
    @Mock
    private AboutWindow aboutWindow;
    @Mock
    private About.FactoryHelper factoryHelper;
    private About about;

    @BeforeEach
    public void setUp(){
        Mockito.when(factoryHelper.makeAboutWindow(Mockito.any(About.class))).thenReturn(aboutWindow);
        about = new About(gameEventListener, factoryHelper);
    }

    @Test
    void close_window_should_call_open_menu(){
        about.closeAbout();
        Mockito.verify(aboutWindow).closeWindow();
        Mockito.verify(gameEventListener).openMenu();
    }
}