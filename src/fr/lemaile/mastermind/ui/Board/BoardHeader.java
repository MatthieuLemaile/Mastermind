package fr.lemaile.mastermind.ui.Board;

import javax.swing.*;
import java.awt.*;

public class BoardHeader extends JPanel {
    public BoardHeader() {
        super(new FlowLayout(FlowLayout.CENTER, 0, 15));

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

        this.add(textTitleM);
        this.add(textTitleA);
        this.add(textTitleS);
        this.add(textTitleT);
        this.add(textTitleE);
        this.add(textTitleR);
        this.add(textTitleMbis);
        this.add(textTitleI);
        this.add(textTitleN);
        this.add(textTitleD);
    }
}
