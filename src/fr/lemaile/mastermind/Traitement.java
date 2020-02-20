package fr.lemaile.mastermind;

import java.util.Random;
import java.util.ArrayList;

public class Traitement {
	
	private int NumPartie;
	private int NumPin;
	private ArrayList tabCombination;
	
	private int i;
	
	public Traitement() {
		NumPartie=0;
		NumPin=0;
		tabCombination = new ArrayList();
		i=0;
	}
	
	public void quit()
	{
		System.exit(0);
	}
	
	public void incrementNumPartie()
	{
		NumPartie++;
	}
	
	public void resetNumPartie()
	{
		NumPartie=0;
	}
	
	public int getNumPartie()
	{
		return NumPartie;
	}
	
	public void incrementNumPin()
	{
		NumPin++;
	}
	
	public void resetNumPin()
	{
		NumPin=(NumPartie*5);
		i=0;
	}
	
	public int getNumPin()
	{
		return NumPin;
	}
	
	public void updateNumPin()
	{
		if (i<=4) {
			NumPin=(NumPartie*5)+i;
			i++;
		}
		else {
			i=1;
			NumPin=(NumPartie*5);
		}
	}
	
	public int aleatoire()
	{
		return (int) (Math.random() * 8);
	}

}
