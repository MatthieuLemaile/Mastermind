package fr.lemaile.mastermind;

import java.util.Random;

public class Traitement {

    public static final Random RANDOM = new Random();
    private int numPartie;
    private int numPin;

    private int i;

    public Traitement() {
        numPartie = 0;
        numPin = 0;
        i = 0;
    }

    public void quit() {
        System.exit(0);
    }

    public void incrementNumPartie() {
        numPartie++;
    }

    public void resetNumPartie() {
        numPartie = 0;
    }

    public int getNumPartie() {
        return numPartie;
    }

    public void incrementNumPin() {
        numPin++;
    }

    public void resetNumPin() {
        numPin = (numPartie * 5);
        i = 0;
    }

    public int getNumPin() {
        return numPin;
    }

    public void updateNumPin() {
        if (i <= 4) {
            numPin = (numPartie * 5) + i;
            i++;
        } else {
            i = 1;
            numPin = (numPartie * 5);
        }
    }

    public int aleatoire() {
        //random value between 0 (inclusive) and 8 (exclusive)
        return RANDOM.nextInt(8);
    }

}