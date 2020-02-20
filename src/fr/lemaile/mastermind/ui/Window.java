package fr.lemaile.mastermind.ui;

import fr.lemaile.mastermind.Traitement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Window extends JFrame implements ActionListener {

    private static final int NB_PIN = 5;
    private static final int NB_TRIALS = 12;
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

    public Window() {

        //Base properties
        pack();
        setLocationRelativeTo(getParent());
        setVisible(true);
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

        Font font = new Font("Arial", Font.BOLD, 25);
        JLabel textTitleM = new JLabel("M ");
        textTitleM.setForeground(Color.blue);
        textTitleM.setFont(font);
        JLabel textTitleA = new JLabel("A ");
        textTitleA.setForeground(Color.pink);
        textTitleA.setFont(font);
        JLabel textTitleS = new JLabel("S ");
        textTitleS.setForeground(Color.green);
        textTitleS.setFont(font);
        JLabel textTitleT = new JLabel("T ");
        textTitleT.setForeground(Color.red);
        textTitleT.setFont(font);
        JLabel textTitleE = new JLabel("E ");
        textTitleE.setForeground(Color.black);
        textTitleE.setFont(font);
        JLabel textTitleR = new JLabel("R ");
        textTitleR.setForeground(Color.orange);
        textTitleR.setFont(font);
        JLabel textTitleMbis = new JLabel("M ");
        textTitleMbis.setForeground(Color.blue);
        textTitleMbis.setFont(font);
        JLabel textTitleI = new JLabel("I ");
        textTitleI.setForeground(Color.green);
        textTitleI.setFont(font);
        JLabel textTitleN = new JLabel("N ");
        textTitleN.setForeground(Color.gray);
        textTitleN.setFont(font);
        JLabel textTitleD = new JLabel("D");
        textTitleD.setForeground(Color.orange);
        textTitleD.setFont(font);

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

        JLabel textChoice = new JLabel("Choix");
        textChoice.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelButton.add(textChoice);
        panelButton.add(Box.createRigidArea(new Dimension(0, 19)));

        for (int i = 0; i < NB_COLOR; i++) {
            JButton buttonTempo = new JButton();
            buttonTempo.setAlignmentX(Component.CENTER_ALIGNMENT);
            buttonTempo.setMinimumSize(new Dimension(50, 25));
            buttonTempo.setMaximumSize(new Dimension(50, 25));
            buttonTempo.setPreferredSize(new Dimension(50, 25));
            buttonTempo.setBackground((Color) colorList.get(i));
            buttonColorList.add(buttonTempo);
            panelButton.add((JButton) buttonColorList.get(i));
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

        JLabel textAuthor = new JLabel("By Marc L.");
        textAuthor.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelButton.add(textAuthor);
        JLabel textVersion = new JLabel("v 1.1");
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
        JLabel textProposition = new JLabel("Proposition");
        textProposition.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelProposition.add(textProposition);
        panelProposition.add(Box.createRigidArea(new Dimension(0, 10)));
        //PROPOSITION GRID
        JPanel gridProposition = new JPanel(new GridLayout(NB_TRIALS, NB_PIN, 5, 5));
        for (int i = 0; i < NB_TRIALS * NB_PIN; i++) {
            JButton buttonTempo = new JButton();
            buttonTempo.setMinimumSize(new Dimension(25, 25));
            buttonTempo.setMaximumSize(new Dimension(25, 25));
            buttonTempo.setPreferredSize(new Dimension(25, 25));
            tabButtonBackgroundProposition.add(buttonTempo);
            tabButtonBackgroundProposition.get(i).setBackground(Color.white);
            tabButtonBackgroundProposition.get(i).setEnabled(false);
            gridProposition.add(tabButtonBackgroundProposition.get(i), i);
        }
        panelProposition.add(gridProposition);
        panelGridPR.add(panelProposition);

        //RESULT PANEL
        JPanel panelResult = new JPanel();
        panelResult.setLayout(new BoxLayout(panelResult, BoxLayout.Y_AXIS));
        JLabel textResult = new JLabel("R�sultat");
        textResult.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelResult.add(textResult);
        panelResult.add(Box.createRigidArea(new Dimension(0, 10)));
        //RESULT GRID
        JPanel gridResult = new JPanel(new GridLayout(NB_TRIALS, NB_PIN, 5, 5));
        for (int i = 0; i < NB_TRIALS * NB_PIN; i++) {
            JButton buttonTempo = new JButton();
            buttonTempo.setMinimumSize(new Dimension(25, 25));
            buttonTempo.setMaximumSize(new Dimension(25, 25));
            buttonTempo.setPreferredSize(new Dimension(25, 25));
            tabButtonBackgroundResult.add(buttonTempo);
            tabButtonBackgroundResult.get(i).setBackground(Color.white);
            tabButtonBackgroundResult.get(i).setEnabled(false);
            gridResult.add(tabButtonBackgroundResult.get(i), i);
        }
        panelResult.add(gridResult);
        panelGridPR.add(panelResult);

        //COMBINATION PANEL
        JPanel panelCombination = new JPanel();
        panelCombination.setLayout(new BoxLayout(panelCombination, BoxLayout.Y_AXIS));
        JLabel textCombination = new JLabel("Combinaison secr�te ");
        textCombination.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelCombination.add(textCombination);
        panelCombination.add(Box.createRigidArea(new Dimension(0, 10)));
        //COMBINATION GRID
        JPanel gridCombination = new JPanel(new GridLayout(1, NB_PIN, 5, 5));
        for (int i = 0; i < NB_PIN; i++) {
            JButton buttonTempo = new JButton();
            buttonTempo.setMinimumSize(new Dimension(10, 30));
            buttonTempo.setMaximumSize(new Dimension(10, 30));
            buttonTempo.setPreferredSize(new Dimension(10, 30));
            tabButtonBackgroundCombination.add(buttonTempo);
            tabButtonBackgroundCombination.get(i).setBackground(Color.white);
            tabButtonBackgroundCombination.get(i).setEnabled(false);
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

            //On place les couleurs propos�es et la combinaison dans un tableau
            app.resetNumPin();
            for (int k = 0; k < 5; k++) {
                app.updateNumPin();
                tabPropositionCalcul.set(k, tabButtonBackgroundProposition.get(app.getNumPin()).getBackground());
                tabCombinationCalcul.set(k, tabCombination.get(k));
            }

            //on regarde si une couleur propos�e est � la bonne place dans la combinaison
            for (int i = 0; i < 5; i++) {
                if (tabPropositionCalcul.get(i) == tabCombinationCalcul.get(i) && tabPropositionCalcul.get(i) != Color.white) {
                    bienPlace++;
                    tabCombinationCalcul.set(i, Color.white);
                    tabPropositionCalcul.set(i, Color.white);
                }

            }

            //on regarde si une couleur propos�e apparait dans la combinaison
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

            //Remplissage grille r�sultat
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
            if (bienPlace == 5) { //Gagn�
                disableGUI();
                for (int k = 0; k < 5; k++) {
                    tabButtonBackgroundCombination.get(k).setBackground((Color) tabCombination.get(k));
                }
                JOptionPane.showMessageDialog(null, "F�licitations !\nVous avez gagn� en " + app.getNumPartie() + " tentative(s)");
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
        for (int i = 0; i < NB_TRIALS * NB_PIN; i++) {
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
            //Voir combinaison d�s le d�but
            //tabButtonBackgroundCombination.get(k).setBackground((Color) tabCombination.get(k));
        }
    }


}
