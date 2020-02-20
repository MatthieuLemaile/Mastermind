package fr.lemaile.mastermind;

import fr.lemaile.mastermind.ui.Window;

public class AppMain {

	public static void main(String[] args) {
		Window fenetre = new Window();
		fenetre.pack();
		fenetre.setLocationRelativeTo(fenetre.getParent()); 
		fenetre.setVisible(true);
	}

}
