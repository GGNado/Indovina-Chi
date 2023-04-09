package com.gigi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

public class Frame extends JFrame {
    private Game game;
    private ArrayList<Persona> persone;
    private ArrayList<JButton> bottoni;
    int x = 0;
    int y = 0;
    public Frame(ArrayList<Persona> persone){
        game = new Game();
        setTitle("Indovina chi");
        setSize(1400, 700);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.persone = persone;
        bottoni = new ArrayList<>();

        Random random = new Random();
        int randomNumber = random.nextInt(10);

        Persona personaScelta = persone.get(randomNumber);
        System.out.println(personaScelta);

        JPanel panel = new JPanel(null);
        panel.setBackground(Color.WHITE);

        String[] domande = {"È un uomo?", "È una donna?", "Ha gli occhiali?", "Ha il cappello?",
                            "Ha la barba?", "Ha i baffi?", "Ha i capelli lisci?"};
        JComboBox<String> domanda = new JComboBox<>(domande);
        domanda.setSelectedIndex(0);
        domanda.setBounds(1200, 50, domanda.getPreferredSize().width, domanda.getPreferredSize().height);
        panel.add(domanda);

        for (int i = 1; i <= 10; i++) {
            JButton la = new JButton("" + i);
            la.setFont(new Font("", Font.PLAIN, 1));
            la.setForeground(Color.WHITE);
            la.setBorderPainted(false);
            la.setFocusPainted(false);
            //la.setIcon(new ImageIcon("resources/img/" + i + ".jpg"));
            la.setIcon(new ImageIcon(persone.get(i-1).getFotoPath()));
            la.setBounds(x,y, la.getPreferredSize().width - 10, la.getPreferredSize().height);
            x += 150;
            if (i%7 == 0){
                y += 220;
                x = 0;
            }

            la.addActionListener(e -> {
                int x = JOptionPane.showConfirmDialog(null, "Confermi che il personaggio scelto dal PC è " + la.getText() + "?", "Confermi", JOptionPane.YES_NO_OPTION);
                if (x == 0){
                    if (personaScelta.equals(persone.get(Integer.parseInt(la.getText()) - 1))){
                        JOptionPane.showMessageDialog(null, "BRAVO MUSELLA, HAI VINTO", "WINNER MUFE", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            });

            panel.add(la);
            bottoni.add(la);
        }

        JButton eseguiDomanda = new JButton("Chiedi domanda");
        eseguiDomanda.setBounds(1200, 80, eseguiDomanda.getPreferredSize().width, eseguiDomanda.getPreferredSize().height);
        eseguiDomanda.addActionListener(e -> {
            for (JButton button : bottoni){
                int i = Integer.parseInt(button.getText());
                Persona personaBottone = persone.get(i-1);

                //HA CAPELLI LISCI
                if (domanda.getSelectedIndex() == 6){
                   game.controllaCapelli(personaScelta, personaBottone, button, 1);
                } else {
                    boolean risposta = game.controllaDomanda(domanda.getSelectedIndex(), personaScelta, personaBottone);
                    if (!risposta)
                        button.setVisible(false);
                }
            }
        });
        panel.add(eseguiDomanda);

        add(panel);
        setVisible(true);
    }
}
