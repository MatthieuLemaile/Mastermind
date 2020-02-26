package fr.lemaile.mastermind.ui;

import java.awt.*;

public class ColorMapper {

    private ColorMapper() {
        //This constructor hide the public implicit one.
    }

    public static Color mapToUi(fr.lemaile.mastermind.model.Color color) {
        Color returnValue;

        switch (color) {
            case WHITE:
                returnValue = Color.WHITE;
                break;
            case RED:
                returnValue = Color.RED;
                break;
            case BLUE:
                returnValue = Color.BLUE;
                break;
            case GREEN:
                returnValue = Color.GREEN;
                break;
            case ORANGE:
                returnValue = Color.ORANGE;
                break;
            case BLACK:
                returnValue = Color.BLACK;
                break;
            case PINK:
                returnValue = Color.PINK;
                break;
            case YELLOW:
                returnValue = Color.YELLOW;
                break;
            case GRAY:
                returnValue = Color.GRAY;
                break;
            default:
                returnValue = Color.WHITE;
        }
        return returnValue;
    }
}
