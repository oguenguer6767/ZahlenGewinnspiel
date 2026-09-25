package view;

import javax.swing.*;
import java.awt.*;

public class GewinnView extends JFrame {

    private JLabel gesamtPunkteLabel;
    private JLabel rundenErgebnisLabel;

    private JTextField spielerEingabe;
    private JTextField computerAnzeige;

    private JButton nochEinmalButton;

    public GewinnView() {
        setTitle("Zahlen-Gewinnspiel");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 250);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout(10, 10));

        gesamtPunkteLabel = new JLabel("Gesamtpunkte: 30");
        rundenErgebnisLabel = new JLabel("Rundenergebnis: 0");

        gesamtPunkteLabel.setOpaque(true);
        rundenErgebnisLabel.setOpaque(true);

        gesamtPunkteLabel.setBackground(Color.WHITE);
        rundenErgebnisLabel.setBackground(Color.WHITE);

        JPanel statusPanel = new JPanel(new GridLayout(1, 2, 10, 0));
        statusPanel.add(gesamtPunkteLabel);
        statusPanel.add(rundenErgebnisLabel);

        spielerEingabe = new JTextField();
        computerAnzeige = new JTextField();
        computerAnzeige.setEditable(false);

        JPanel eingabePanel = new JPanel(new GridLayout(2, 2, 10, 10));
        eingabePanel.add(new JLabel("Deine Zahl (1-9):"));
        eingabePanel.add(spielerEingabe);
        eingabePanel.add(new JLabel("Computerzahl:"));
        eingabePanel.add(computerAnzeige);

        nochEinmalButton = new JButton("Noch einmal!");
        nochEinmalButton.setEnabled(false);

        add(statusPanel, BorderLayout.NORTH);
        add(eingabePanel, BorderLayout.CENTER);
        add(nochEinmalButton, BorderLayout.SOUTH);

        setVisible(true);
    }

    public JLabel getGesamtPunkteLabel() {
        return gesamtPunkteLabel;
    }

    public JLabel getRundenErgebnisLabel() {
        return rundenErgebnisLabel;
    }

    public JTextField getSpielerEingabe() {
        return spielerEingabe;
    }

    public JTextField getComputerAnzeige() {
        return computerAnzeige;
    }

    public JButton getNochEinmalButton() {
        return nochEinmalButton;
    }
}