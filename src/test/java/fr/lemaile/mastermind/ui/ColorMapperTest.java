package fr.lemaile.mastermind.ui;

import fr.lemaile.mastermind.model.Color;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ColorMapperTest {


    @Test
    void mapToUiShouldReturnWHITE() {
        java.awt.Color color = ColorMapper.mapToUi(Color.EMPTY);
        assertEquals(java.awt.Color.WHITE, color);
    }

    @Test
    void mapToUiShouldReturnRED() {
        java.awt.Color color = ColorMapper.mapToUi(Color.RED);
        assertEquals(java.awt.Color.RED, color);
    }

    @Test
    void mapToUiShouldReturnBLUE() {
        java.awt.Color color = ColorMapper.mapToUi(Color.BLUE);
        assertEquals(java.awt.Color.BLUE, color);
    }

    @Test
    void mapToUiShouldReturnGREEN() {
        java.awt.Color color = ColorMapper.mapToUi(Color.GREEN);
        assertEquals(java.awt.Color.GREEN, color);
    }

    @Test
    void mapToUiShouldReturnORANGE() {
        java.awt.Color color = ColorMapper.mapToUi(Color.ORANGE);
        assertEquals(java.awt.Color.ORANGE, color);
    }

    @Test
    void mapToUiShouldReturnBLACK() {
        java.awt.Color color = ColorMapper.mapToUi(Color.BLACK);
        assertEquals(java.awt.Color.BLACK, color);
    }

    @Test
    void mapToUiShouldReturnPINK() {
        java.awt.Color color = ColorMapper.mapToUi(Color.PINK);
        assertEquals(java.awt.Color.PINK, color);
    }

    @Test
    void mapToUiShouldReturnYELLOW() {
        java.awt.Color color = ColorMapper.mapToUi(Color.YELLOW);
        assertEquals(java.awt.Color.YELLOW, color);
    }

    @Test
    void mapToUiShouldReturnGRAY() {
        java.awt.Color color = ColorMapper.mapToUi(Color.GRAY);
        assertEquals(java.awt.Color.GRAY, color);
    }
}