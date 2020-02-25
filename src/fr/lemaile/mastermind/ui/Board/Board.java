package fr.lemaile.mastermind.ui.Board;

import fr.lemaile.mastermind.Traitement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Board extends JFrame implements ActionListener {

    private static final int NB_PIN = 5;
    private static final int NB_ATTEMPTS = 12;
    private static final int NB_COLOR = 8;
    private List<Color> colorList;
    private List<Color> tabCombination;
    private List<Color> tabCombinationCalcul;
    private List<Color> tabPropositionCalcul;
    private JButton buttonValidate = new JButton("Valider");
    private JButton buttonNew = new JButton("Nouveau");
    private JButton buttonLeave = new JButton("Quitter");

    private List<JButton> buttonColorList;
    private List<JButton> tabButtonBackgroundProposition;
    private List<JButton> tabButtonBackgroundResult;
    private List<JButton> tabButtonBackgroundCombination;

    private Traitement app;

    public Board() {

        //Base properties
        setTitle("MASTERMIND");

        //MISCELLANEOUS PROPERTIES
        colorList = List.of(Color.red,
                Color.blue,
                Color.green,
                Color.orange,
                Color.black,
                Color.pink,
                Color.yellow,
                Color.gray);
        buttonColorList = new ArrayList<>();
        tabButtonBackgroundProposition = new ArrayList<>();
        tabButtonBackgroundResult = new ArrayList<>();
        tabButtonBackgroundCombination = new ArrayList<>();
        tabCombination = new ArrayList<>();
        tabCombinationCalcul = new ArrayList<>();
        tabPropositionCalcul = new ArrayList<>();

        app = new Traitement();

        //HEADER
        BoardHeader boardHeader = new BoardHeader();

        //BODY
        JPanel panelBody = new JPanel(new FlowLayout(FlowLayout.CENTER, 35, 0));

        //MENU
        BoardMenu boardMenu = new BoardMenu(NB_COLOR, colorList, buttonColorList, buttonValidate, buttonNew, buttonLeave);
        panelBody.add(boardMenu);

        //GRID PANEL
        BoardDisplay boardDisplay = new BoardDisplay(NB_ATTEMPTS, NB_PIN, tabButtonBackgroundProposition, tabButtonBackgroundResult, tabButtonBackgroundCombination);
        panelBody.add(boardDisplay);

        //PLUS
        Container principalContainer = getContentPane();
        principalContainer.add("North", boardHeader);
        principalContainer.add("Center", panelBody);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //GESTION EVENEMENTS
        buttonValidate.addActionListener(this);
        buttonNew.addActionListener(this);
        buttonLeave.addActionListener(this);
        for (int i = 0; i < NB_COLOR; i++) {
            buttonColorList.get(i).addActionListener(this);
        }

        //LANCER PREMIERE PARTIE
        disableGUI();
        JOptionPane.showMessageDialog(null, "Pour lancer une partie,\nappuyez sur le bouton \"Nouveau\"");
        pack();
        setLocationRelativeTo(getParent());
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        // *** QUITTER ***
        if (source == buttonLeave) {
            app.quit();
        }

        // *** NOUVELLE PARTIE ***
        else if (source == buttonNew) {
            //R�initialisation interface graphique
            resetGUI();
            //tirage combinaison
            tirerCombinaison();
            //Information
            JOptionPane.showMessageDialog(null, "Partie lanc�e !");
        }

        // *** VALIDER COMBINAISON ***
        else if (source == buttonValidate) {
            //init compteurs
            int malPlace = 0;
            int bienPlace = 0;
            int existePas = 0;

            //On place les couleurs proposées et la combinaison dans un tableau
            app.resetNumPin();
            for (int k = 0; k < 5; k++) {
                app.updateNumPin();
                tabPropositionCalcul.set(k, tabButtonBackgroundProposition.get(app.getNumPin()).getBackground());
                tabCombinationCalcul.set(k, tabCombination.get(k));
            }

            //on regarde si une couleur proposéée est à la bonne place dans la combinaison
            for (int i = 0; i < 5; i++) {
                if (tabPropositionCalcul.get(i) == tabCombinationCalcul.get(i) && tabPropositionCalcul.get(i) != Color.white) {
                    bienPlace++;
                    tabCombinationCalcul.set(i, Color.white);
                    tabPropositionCalcul.set(i, Color.white);
                }

            }

            //on regarde si une couleur proposée apparait dans la combinaison
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (tabPropositionCalcul.get(i) == tabCombinationCalcul.get(j) && tabPropositionCalcul.get(i) != Color.white) {
                        malPlace++;
                        tabCombinationCalcul.set(j, Color.white);
                        tabPropositionCalcul.set(i, Color.white);
                    }
                }
            }

            //Les autres couleurs n'existent pas
            existePas = 5 - (bienPlace + malPlace);

            //Remplissage grille résultat
            app.resetNumPin();
            for (int k = 0; k < bienPlace; k++) {
                app.updateNumPin();
                tabButtonBackgroundResult.get(app.getNumPin()).setBackground(Color.green);
            }
            for (int k = 0; k < malPlace; k++) {
                app.updateNumPin();
                tabButtonBackgroundResult.get(app.getNumPin()).setBackground(Color.orange);
            }
            for (int k = 0; k < existePas; k++) {
                app.updateNumPin();
                tabButtonBackgroundResult.get(app.getNumPin()).setBackground(Color.red);
            }

            //Passer � la ligne suivante
            app.resetNumPin();
            app.incrementNumPartie();

            //Fin du jeu
            if (bienPlace == 5) { //Gagné
                disableGUI();
                for (int k = 0; k < 5; k++) {
                    tabButtonBackgroundCombination.get(k).setBackground((Color) tabCombination.get(k));
                }
                JOptionPane.showMessageDialog(null, "Félicitations !\nVous avez gagné en " + app.getNumPartie() + " tentative(s)");
            }
            if (app.getNumPartie() == 12) { //Perdu
                disableGUI();
                for (int k = 0; k < 5; k++) {
                    tabButtonBackgroundCombination.get(k).setBackground((Color) tabCombination.get(k));
                }
                JOptionPane.showMessageDialog(null, "Nul !\nRecommencez.");
            }
        }

        // *** PLACER LES COULEURS DANS LA GRILLE ***
        for (int i = 0; i < NB_COLOR; i++) {
            if (source == buttonColorList.get(i)) {
                Color colorTempo = buttonColorList.get(i).getBackground();
                app.updateNumPin();
                tabButtonBackgroundProposition.get(app.getNumPin()).setBackground(colorTempo);
            }
        }
    }

    public void resetGUI() {
        app.resetNumPartie();
        app.resetNumPin();
        for (int i = 0; i < NB_ATTEMPTS * NB_PIN; i++) {
            tabButtonBackgroundProposition.get(i).setBackground(Color.white);
            tabButtonBackgroundResult.get(i).setBackground(Color.white);
        }
        for (int k = 0; k < 5; k++) {
            tabCombination.add(Color.white);
            tabCombinationCalcul.add(Color.white);
            tabPropositionCalcul.add(Color.white);
        }
        buttonValidate.setEnabled(true);
        for (int i = 0; i < NB_COLOR; i++) {
            buttonColorList.get(i).setEnabled(true);
        }
    }

    public void disableGUI() {
        buttonValidate.setEnabled(false);
        for (int i = 0; i < NB_COLOR; i++) {
            buttonColorList.get(i).setEnabled(false);
        }

    }

    public void tirerCombinaison() {
        for (int k = 0; k < 5; k++) {
            tabCombination.set(k, colorList.get(app.aleatoire()));
            tabCombinationCalcul.set(k, Color.white);
            tabPropositionCalcul.set(k, Color.white);
            tabButtonBackgroundCombination.get(k).setBackground(Color.white);
            //Voir combinaison dès le début
            //tabButtonBackgroundCombination.get(k).setBackground((Color) tabCombination.get(k));
        }
    }


}
