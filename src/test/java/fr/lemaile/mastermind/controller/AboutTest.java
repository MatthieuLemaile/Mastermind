package fr.lemaile.mastermind.controller;

import fr.lemaile.mastermind.ui.UiFactory;
import fr.lemaile.mastermind.ui.about.AboutWindow;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AboutTest {

    @Mock
    private GameEventListener gameEventListener;
    @Mock
    private AboutWindow aboutWindow;
    @Mock
    private UiFactory uiFactory;
    private About about;

    @BeforeEach
    public void setUp() {
        Mockito.when(uiFactory.createAboutWindow(Mockito.any(About.class))).thenReturn(aboutWindow);
        about = new About(gameEventListener, uiFactory);
    }

    @Test
    void close_window_should_call_open_menu(){
        about.closeAbout();
        Mockito.verify(aboutWindow).closeWindow();
        Mockito.verify(gameEventListener).openMenu();
    }
}