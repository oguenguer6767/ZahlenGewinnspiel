package controller;

import model.GewinnModel;
import view.GewinnView;

import javax.swing.*;
import java.awt.Color;

public class GewinnController {

    private GewinnModel model;
    private GewinnView view;

    public GewinnController(GewinnModel model, GewinnView view) {
        this.model = model;
        this.view = view;

        view.getSpielerEingabe().addActionListener(e -> spieleRunde());

        view.getNochEinmalButton().addActionListener(e -> neueRunde());
    }

    private void spieleRunde() {
        try {
            int spielerZahl = Integer.parseInt(
                    view.getSpielerEingabe().getText());

            if (spielerZahl < 1 || spielerZahl > 9) {
                JOptionPane.showMessageDialog(view,
                        "Bitte gib eine Zahl zwischen 1 und 9 ein!");
                return;
            }

            model.berechneComputerZahl();
            model.berechneRunde(spielerZahl);

            view.getComputerAnzeige().setText(
                    String.valueOf(model.getComputerZahl()));

            view.getRundenErgebnisLabel().setText(
                    "Rundenergebnis: " + model.getRundenErgebnis());

            view.getGesamtPunkteLabel().setText(
                    "Gesamtpunkte: " + model.getGesamtPunkte());

            if (model.hatGewonnen() || model.getRundenErgebnis() > 0) {
                view.getRundenErgebnisLabel().setBackground(Color.GREEN);
                view.getGesamtPunkteLabel().setBackground(Color.GREEN);

            } else if (model.hatVerloren()
                    || model.getRundenErgebnis() < 0) {
                view.getRundenErgebnisLabel().setBackground(Color.RED);
                view.getGesamtPunkteLabel().setBackground(Color.RED);

            } else {
                view.getRundenErgebnisLabel().setBackground(Color.WHITE);
                view.getGesamtPunkteLabel().setBackground(Color.WHITE);
            }

            view.getSpielerEingabe().setEnabled(false);
            view.getNochEinmalButton().setEnabled(true);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(view,
                    "Bitte gib eine gültige Zahl ein!");
        }
    }

    private void neueRunde() {
        view.getSpielerEingabe().setText("");
        view.getComputerAnzeige().setText("");
        view.getRundenErgebnisLabel().setText("Rundenergebnis: 0");
        view.getSpielerEingabe().requestFocus();
        view.getSpielerEingabe().setEnabled(true);
        view.getNochEinmalButton().setEnabled(false);
    }
}