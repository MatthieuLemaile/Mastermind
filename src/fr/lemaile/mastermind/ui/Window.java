package fr.lemaile.mastermind.ui;

import fr.lemaile.mastermind.Traitement;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


import java.util.*;

public class Window extends JFrame implements ActionListener{
	
	private final int NBPIN = 5;
	private final int NBPARTY = 12;
	private final int NBCOLOR = 8;
	private ArrayList<Color> tabColor;
	private ArrayList<Color> tabCombination;
	private ArrayList<Color> tabCombinationCalcul;
	private ArrayList<Color> tabPropositionCalcul;
	private int bienPlace, malPlace, existePas;
	 
	private JLabel textTitleM = new JLabel("M ");
	private JLabel textTitleA = new JLabel("A ");
	private JLabel textTitleS = new JLabel("S ");
	private JLabel textTitleT = new JLabel("T ");
	private JLabel textTitleE = new JLabel("E ");
	private JLabel textTitleR = new JLabel("R ");
	private JLabel textTitleMbis = new JLabel("M ");
	private JLabel textTitleI = new JLabel("I ");
	private JLabel textTitleN = new JLabel("N ");
	private JLabel textTitleD = new JLabel("D");
	private JLabel textChoice = new JLabel("Choix");
	private JLabel textProposition = new JLabel("Proposition");
	private JLabel textResult = new JLabel("R�sultat");
	private JLabel textCombination = new JLabel("Combinaison secr�te ");
	private JLabel textAuthor = new JLabel("By Marc L.");
	private JLabel textVersion = new JLabel("v 1.1");
	
	private JButton buttonValidate = new JButton("Valider");
	private JButton buttonNew = new JButton("Nouveau");
	private JButton buttonLeave = new JButton("Quitter");
	
	private ArrayList<JButton> tabButtonColor;
	private ArrayList<JButton> tabButtonBackgroundProposition;
	private ArrayList<JButton> tabButtonBackgroundResult;
	private ArrayList<JButton> tabButtonBackgroundCombination;
	
	private Traitement app;

		public Window() {
		
		//MISCELLANEOUS PROPERTIES
		setTitle("MASTERMIND");
		tabColor = new <Color> ArrayList<Color>();
		tabButtonColor = new <JButton> ArrayList<JButton>();
		tabButtonBackgroundProposition = new <JButton> ArrayList<JButton>();
		tabButtonBackgroundResult = new <JButton> ArrayList<JButton>();
		tabButtonBackgroundCombination = new <JButton> ArrayList<JButton>();
		tabCombination = new ArrayList<Color>();
		tabCombinationCalcul = new ArrayList<Color>();
		tabPropositionCalcul = new ArrayList<Color>();
		
		Font font = new Font("Arial", Font.BOLD, 25);
		textTitleM.setForeground(Color.blue);
		textTitleM.setFont(font);
		textTitleA.setForeground(Color.pink);
		textTitleA.setFont(font);
		textTitleS.setForeground(Color.green);
		textTitleS.setFont(font);
		textTitleT.setForeground(Color.red);
		textTitleT.setFont(font);
		textTitleE.setForeground(Color.black);
		textTitleE.setFont(font);
		textTitleR.setForeground(Color.orange);
		textTitleR.setFont(font);
		textTitleMbis.setForeground(Color.blue);
		textTitleMbis.setFont(font);
		textTitleI.setForeground(Color.green);
		textTitleI.setFont(font);
		textTitleN.setForeground(Color.gray);
		textTitleN.setFont(font);
		textTitleD.setForeground(Color.orange);
		textTitleD.setFont(font);
		
		tabColor.add(Color.red);
		tabColor.add(Color.blue);
		tabColor.add(Color.green);
		tabColor.add(Color.orange);
		tabColor.add(Color.black);
		tabColor.add(Color.pink);
		tabColor.add(Color.yellow);
		tabColor.add(Color.gray);
		
		app = new Traitement();
		
		//CONTAINER
		Container principalContainer = getContentPane();
		
		//HEADER
		JPanel panelHeader = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 15));
		panelHeader.add(textTitleM);
		panelHeader.add(textTitleA);
		panelHeader.add(textTitleS);
		panelHeader.add(textTitleT);
		panelHeader.add(textTitleE);
		panelHeader.add(textTitleR);
		panelHeader.add(textTitleMbis);
		panelHeader.add(textTitleI);
		panelHeader.add(textTitleN);
		panelHeader.add(textTitleD);
		
		//BODY
		JPanel panelBody = new JPanel(new FlowLayout(FlowLayout.CENTER, 35, 0));
			//BUTTON PANEL
			JPanel panelButton = new JPanel();
			panelButton.setLayout(new BoxLayout(panelButton, BoxLayout.Y_AXIS));
			//panelButton.add(Box.createRigidArea(new Dimension(0, 10)));
			
			textChoice.setAlignmentX(Component.CENTER_ALIGNMENT);
			panelButton.add(textChoice);
			panelButton.add(Box.createRigidArea(new Dimension(0, 19)));
			
			for (int i=0;i<NBCOLOR;i++)
			{
				JButton buttonTempo = new JButton();
				buttonTempo.setAlignmentX(Component.CENTER_ALIGNMENT);
				buttonTempo.setMinimumSize(new Dimension(50, 25));
				buttonTempo.setMaximumSize(new Dimension(50, 25));
				buttonTempo.setPreferredSize(new Dimension(50, 25));
				buttonTempo.setBackground((Color) tabColor.get(i));
				tabButtonColor.add(buttonTempo);
				panelButton.add((JButton) tabButtonColor.get(i));
				panelButton.add(Box.createRigidArea(new Dimension(0, 5)));
			}
			
			buttonValidate.setAlignmentX(Component.CENTER_ALIGNMENT);
			buttonValidate.setMinimumSize(new Dimension(110, 80));
			buttonValidate.setMaximumSize(new Dimension(110, 80));
			buttonValidate.setPreferredSize(new Dimension(110, 30));
			buttonNew.setAlignmentX(Component.CENTER_ALIGNMENT);
			buttonNew.setMinimumSize(new Dimension(110, 80));
			buttonNew.setMaximumSize(new Dimension(110, 80));
			buttonNew.setPreferredSize(new Dimension(110, 30));
			buttonLeave.setAlignmentX(Component.CENTER_ALIGNMENT);
			buttonLeave.setMinimumSize(new Dimension(110, 80));
			buttonLeave.setMaximumSize(new Dimension(110, 80));
			buttonLeave.setPreferredSize(new Dimension(110, 30));
			
			panelButton.add(Box.createRigidArea(new Dimension(0, 20)));
			panelButton.add(buttonValidate);
			panelButton.add(Box.createRigidArea(new Dimension(0, 5)));
			panelButton.add(buttonNew);
			panelButton.add(Box.createRigidArea(new Dimension(0, 5)));
			panelButton.add(buttonLeave);
			panelButton.add(Box.createRigidArea(new Dimension(0, 20)));
			
			textAuthor.setAlignmentX(Component.CENTER_ALIGNMENT);
			panelButton.add(textAuthor);
			textVersion.setAlignmentX(Component.CENTER_ALIGNMENT);
			panelButton.add(textVersion);
			
			panelBody.add(panelButton);
			
			//GRID PANEL
			JPanel panelGrid = new JPanel();
			panelGrid.setLayout(new BoxLayout(panelGrid, BoxLayout.Y_AXIS));
			
			//GRIDPR PANEL
			JPanel panelGridPR = new JPanel(new FlowLayout(FlowLayout.CENTER, 35, 0));
			
			//PROPOSITION PANEL
			JPanel panelProposition = new JPanel();
			panelProposition.setLayout(new BoxLayout(panelProposition, BoxLayout.Y_AXIS));
			textProposition.setAlignmentX(Component.CENTER_ALIGNMENT);
			panelProposition.add(textProposition);
			panelProposition.add(Box.createRigidArea(new Dimension(0, 10)));
				//PROPOSITION GRID
				JPanel gridProposition = new JPanel(new GridLayout(NBPARTY,NBPIN, 5, 5));
				for (int i=0;i<NBPARTY*NBPIN;i++)
				{
					JButton buttonTempo = new JButton();
					buttonTempo.setMinimumSize(new Dimension(25, 25));
					buttonTempo.setMaximumSize(new Dimension(25, 25));
					buttonTempo.setPreferredSize(new Dimension(25, 25));
					tabButtonBackgroundProposition.add(buttonTempo);
					((JButton) tabButtonBackgroundProposition.get(i)).setBackground(Color.white);
					((JButton) tabButtonBackgroundProposition.get(i)).setEnabled(false);
					gridProposition.add((JButton) tabButtonBackgroundProposition.get(i), i);
				}
			panelProposition.add(gridProposition);
			panelGridPR.add(panelProposition);
			
			//RESULT PANEL
			JPanel panelResult = new JPanel();
			panelResult.setLayout(new BoxLayout(panelResult, BoxLayout.Y_AXIS));
			textResult.setAlignmentX(Component.CENTER_ALIGNMENT);
			panelResult.add(textResult);
			panelResult.add(Box.createRigidArea(new Dimension(0, 10)));
				//RESULT GRID
				JPanel gridResult = new JPanel(new GridLayout(NBPARTY,NBPIN, 5, 5));
				for (int i=0;i<NBPARTY*NBPIN;i++)
				{
					JButton buttonTempo = new JButton();
					buttonTempo.setMinimumSize(new Dimension(25, 25));
					buttonTempo.setMaximumSize(new Dimension(25, 25));
					buttonTempo.setPreferredSize(new Dimension(25, 25));
					tabButtonBackgroundResult.add(buttonTempo);
					((JButton) tabButtonBackgroundResult.get(i)).setBackground(Color.white);
					((JButton) tabButtonBackgroundResult.get(i)).setEnabled(false);
					gridResult.add((JButton) tabButtonBackgroundResult.get(i), i);
				}
			panelResult.add(gridResult);
			panelGridPR.add(panelResult);
		
			//COMBINATION PANEL
			JPanel panelCombination = new JPanel();
			panelCombination.setLayout(new BoxLayout(panelCombination, BoxLayout.Y_AXIS));
			textCombination.setAlignmentX(Component.CENTER_ALIGNMENT);
			panelCombination.add(textCombination);
			panelCombination.add(Box.createRigidArea(new Dimension(0, 10)));
				//COMBINATION GRID
				JPanel gridCombination = new JPanel(new GridLayout(1,NBPIN, 5, 5));
				for (int i=0;i<NBPIN;i++)
				{
					JButton buttonTempo = new JButton();
					buttonTempo.setMinimumSize(new Dimension(10, 30));
					buttonTempo.setMaximumSize(new Dimension(10, 30));
					buttonTempo.setPreferredSize(new Dimension(10, 30));
					tabButtonBackgroundCombination.add(buttonTempo);
					((JButton) tabButtonBackgroundCombination.get(i)).setBackground(Color.white);
					((JButton) tabButtonBackgroundCombination.get(i)).setEnabled(false);
					gridCombination.add((JButton) tabButtonBackgroundCombination.get(i), i);
				}
			panelCombination.add(gridCombination);
			
			panelGrid.add(panelGridPR);
			panelGrid.add(Box.createRigidArea(new Dimension(0, 10)));
			panelGrid.add(panelCombination);
			panelGrid.add(Box.createRigidArea(new Dimension(0, 10)));
		panelBody.add(panelGrid);
		
		//PLUS
		principalContainer.add("North", panelHeader);
		principalContainer.add("Center", panelBody);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//GESTION EVENEMENTS
		buttonValidate.addActionListener(this);
		buttonNew.addActionListener(this);
		buttonLeave.addActionListener(this);
		for (int i=0;i<NBCOLOR;i++)
		{
			((JButton) tabButtonColor.get(i)).addActionListener(this);
		}
		
		//LANCER PREMIERE PARTIE
		disableGUI();
		JOptionPane.showMessageDialog(null, "Pour lancer une partie,\nappuyez sur le bouton \"Nouveau\"");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		// *** QUITTER ***
		if(source == buttonLeave)
		{
            app.quit();
        }
		
		// *** NOUVELLE PARTIE ***
		else if (source == buttonNew)
		{
        	//R�initialisation interface graphique
			resetGUI();
        	//tirage combinaison
			tirerCombinaison();
			//Information
			JOptionPane.showMessageDialog(null, "Partie lanc�e !");
        }
		
		// *** VALIDER COMBINAISON ***
		else if (source == buttonValidate)
		{
        	//init compteurs
        	malPlace = 0;
        	bienPlace = 0;
        	existePas = 0;
        	
        	//On place les couleurs propos�es et la combinaison dans un tableau
        	app.resetNumPin();
        	for (int k=0;k<5;k++)
        	{
        		app.updateNumPin();
        		tabPropositionCalcul.set(k, tabButtonBackgroundProposition.get(app.getNumPin()).getBackground());
        		tabCombinationCalcul.set(k, tabCombination.get(k));
        	}
        	
        	//on regarde si une couleur propos�e est � la bonne place dans la combinaison
        	for (int i=0;i<5;i++)
        	{
        		if (tabPropositionCalcul.get(i) == tabCombinationCalcul.get(i) & tabPropositionCalcul.get(i) != Color.white)
        		{
        			bienPlace++;
        			tabCombinationCalcul.set(i, Color.white);
        			tabPropositionCalcul.set(i, Color.white);
        		}
        		
        	}
        	
        	//on regarde si une couleur propos�e apparait dans la combinaison
        	for (int i=0;i<5;i++)
        	{
        		for (int j=0;j<5;j++)
        		{
        			if (tabPropositionCalcul.get(i) == tabCombinationCalcul.get(j) & tabPropositionCalcul.get(i) != Color.white)
            		{
            			malPlace++;
            			tabCombinationCalcul.set(j, Color.white);
            			tabPropositionCalcul.set(i, Color.white);
            		}
        		}
        	}
        	
        	//Les autres couleurs n'existent pas
        	existePas = 5 - (bienPlace + malPlace);
        	
        	//Remplissage grille r�sultat
        	app.resetNumPin();
        	for (int k=0;k<bienPlace;k++)
        	{
        		app.updateNumPin();
        		((JButton) tabButtonBackgroundResult.get(app.getNumPin())).setBackground(Color.green);
        	}
        	for (int k=0;k<malPlace;k++)
        	{
        		app.updateNumPin();
        		((JButton) tabButtonBackgroundResult.get(app.getNumPin())).setBackground(Color.orange);
        	}
        	for (int k=0;k<existePas;k++)
        	{
        		app.updateNumPin();
        		((JButton) tabButtonBackgroundResult.get(app.getNumPin())).setBackground(Color.red);
        	}
        	
        	//Passer � la ligne suivante
        	app.resetNumPin();
        	app.incrementNumPartie();
        	        	     	
        	//Fin du jeu
        	if (bienPlace == 5) { //Gagn�
        		disableGUI();
        		for (int k=0;k<5;k++) {
        			tabButtonBackgroundCombination.get(k).setBackground((Color) tabCombination.get(k));
        		}
        		JOptionPane.showMessageDialog(null, "F�licitations !\nVous avez gagn� en "+app.getNumPartie()+" tentative(s)");
        	} if (app.getNumPartie() == 12) { //Perdu
        		disableGUI();
        		for (int k=0;k<5;k++) {
        			tabButtonBackgroundCombination.get(k).setBackground((Color) tabCombination.get(k));
        		}
	        	JOptionPane.showMessageDialog(null, "Nul !\nRecommencez.");
        	}
         }
		
		// *** PLACER LES COULEURS DANS LA GRILLE ***
		for (int i=0;i<NBCOLOR;i++)
		{
			if (source == tabButtonColor.get(i))
			{
				Color colorTempo = ((JButton) tabButtonColor.get(i)).getBackground();
				app.updateNumPin();
				((JButton) tabButtonBackgroundProposition.get(app.getNumPin())).setBackground(colorTempo);
	        }
		}
	}
	
	public void resetGUI()
	{
		app.resetNumPartie();
    	app.resetNumPin();
    	for (int i=0;i<NBPARTY*NBPIN;i++)
		{
			((JButton) tabButtonBackgroundProposition.get(i)).setBackground(Color.white);
			((JButton) tabButtonBackgroundResult.get(i)).setBackground(Color.white);
		}
    	for (int k=0;k<5;k++)
		{
			tabCombination.add(Color.white);
			tabCombinationCalcul.add(Color.white);
			tabPropositionCalcul.add(Color.white);
		}
    	buttonValidate.setEnabled(true);
    	for (int i=0;i<NBCOLOR;i++)
		{
			tabButtonColor.get(i).setEnabled(true);
		}
	}
	
	public void disableGUI()
	{
		buttonValidate.setEnabled(false);
		for (int i=0;i<NBCOLOR;i++)
		{
			tabButtonColor.get(i).setEnabled(false);
		}
		
	}
	
	public void tirerCombinaison()
	{
		for (int k=0;k<5;k++)
		{
			tabCombination.set(k, tabColor.get(app.aleatoire()));
			tabCombinationCalcul.set(k, Color.white);
			tabPropositionCalcul.set(k, Color.white);
			((JButton) tabButtonBackgroundCombination.get(k)).setBackground(Color.white);
			//Voir combinaison d�s le d�but
			//tabButtonBackgroundCombination.get(k).setBackground((Color) tabCombination.get(k));
		} 
	}
	

}
