package fr.lemaile.mastermind.ui.board.swing;

import javax.swing.*;
import java.awt.*;

public class BoardHeader extends JPanel {

    public static final Font FONT = new Font("Arial", Font.BOLD, 25);

    public BoardHeader() {
        super(new FlowLayout(FlowLayout.CENTER, 0, 15));

        this.add(getLetter("M ", Color.blue));
        this.add(getLetter("A ", Color.pink));
        this.add(getLetter("S ", Color.green));
        this.add(getLetter("T ", Color.red));
        this.add(getLetter("E ", Color.black));
        this.add(getLetter("R ", Color.orange));
        this.add(getLetter("M ", Color.blue));
        this.add(getLetter("I ", Color.green));
        this.add(getLetter("N ", Color.gray));
        this.add(getLetter("D", Color.orange));
    }

    private JLabel getLetter(String text, Color color) {
        JLabel textTitleM = new JLabel(text);
        textTitleM.setForeground(color);
        textTitleM.setFont(FONT);
        return textTitleM;
    }
}
