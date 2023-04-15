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
    private boolean risposta;
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
        int randomNumber = random.nextInt(21) + 1;

        Persona personaScelta = persone.get(randomNumber);
        System.out.println(personaScelta);

        JPanel panel = new JPanel(null);
        panel.setBackground(Color.WHITE);

        String[] domande = {"È un uomo?", "È una donna?", "Ha gli occhiali?", "Ha il cappello?",
                            "Ha la barba?", "Ha i baffi?", "Ha i capelli lisci?", "È calvo?",
                            "Ha i capelli mossi?", "Ha i capelli ricci?", "Ha i capelli di colore Bianco?",
                            "Ha i capelli di colore Biondi?", "Ha i capelli di colore Rossi?",
                            "Ha i capelli di colore Marroni?", "Ha i capelli di colore Nero?"};
        JComboBox<String> domanda = new JComboBox<>(domande);
        domanda.setSelectedIndex(0);
        domanda.setBounds(1100, 50, domanda.getPreferredSize().width, domanda.getPreferredSize().height);
        panel.add(domanda);

        for (int i = 1; i <= 21; i++) {
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
                int x = JOptionPane.showConfirmDialog(null, "Confermi che il personaggio scelto dal PC è " + persone.get(Integer.parseInt(la.getText()) - 1).getNome() + "?", "Confermi", JOptionPane.YES_NO_OPTION);
                if (x == 0){
                    if (personaScelta.equals(persone.get(Integer.parseInt(la.getText()) - 1))){
                        JOptionPane.showMessageDialog(null, "BRAVO HAI VINTO", "Complimenti", JOptionPane.INFORMATION_MESSAGE);
                        int riavviare = JOptionPane.showConfirmDialog(null, "Vuoi rigiocare?", "Riavviare?", JOptionPane.YES_NO_OPTION);
                        if (riavviare == JOptionPane.YES_OPTION)
                            System.out.println("riavvio");
                        else
                            this.dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Sbagliato", "", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            });
            la.addMouseListener(new MouseAdapter(){
                @Override
                public void mouseClicked(MouseEvent e){
                    if (SwingUtilities.isRightMouseButton(e)){
                        Persona personaInfo = persone.get(Integer.parseInt(la.getText()) - 1);
                        JOptionPane.showMessageDialog(null, "Nome: " + personaInfo.getNome() +
                                                                                    "\nSesso: " +  personaInfo.intSessoToString() +
                                                                                    "\nCapelli: " + personaInfo.intCapelliToString() +
                                                                                    "\nColore Capelli: " + personaInfo.intColoreCapelliToString() +
                                                                                    "\nColore Occhi: " + personaInfo.intColoreOcchiToString() +
                                                                                    "\nCappello:  " + personaInfo.boolToString(personaInfo.isHaCappello()) +
                                                                                    "\nBarba: " + personaInfo.boolToString(personaInfo.isHaBarba()) +
                                                                                    "\nBaffi: " + personaInfo.boolToString(personaInfo.isHaBaffi()) +
                                                                                    "\nOcchiali: " + personaInfo.boolToString(personaInfo.isHaOcchiali()), "Scheda Personaggio", JOptionPane.INFORMATION_MESSAGE);
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

                switch (domanda.getSelectedIndex()){
                    case 6:
                        //Capelli lisci 1
                        risposta = game.controllaCapelli(personaScelta, personaBottone, button, 1);
                        break;
                    case 7:
                        //Capelli calvo 0
                        risposta = game.controllaCapelli(personaScelta, personaBottone, button, 0);
                        break;
                    case 8:
                        //Capelli Mossi
                        risposta = game.controllaCapelli(personaScelta, personaBottone, button, 2);
                        break;
                    case 9:
                        //CapelliRicci
                        risposta = game.controllaCapelli(personaScelta, personaBottone, button, 3);
                        break;
                    case 10:
                        //Capelli Bianchi
                        risposta = game.controllaColoreCapelli(personaScelta, personaBottone, button, 0);
                        break;
                    case 11:
                        //Capelli Biondi
                        risposta = game.controllaColoreCapelli(personaScelta, personaBottone, button, 1);
                        break;
                    case 12:
                        //Capelli Rossi
                        risposta = game.controllaColoreCapelli(personaScelta, personaBottone, button, 2);
                        break;
                    case 13:
                        //Capelli Marroni
                        risposta = game.controllaColoreCapelli(personaScelta, personaBottone, button, 3);
                        break;
                    case 14:
                        //Capelli Neri
                        risposta = game.controllaColoreCapelli(personaScelta, personaBottone, button, 4);
                        break;
                    default:
                        risposta = game.controllaDomanda(domanda.getSelectedIndex(), personaScelta, personaBottone);
                        if (!risposta)
                            button.setVisible(false);
                }


                /*if (domanda.getSelectedIndex() == 6){
                    risposta = game.controllaCapelli(personaScelta, personaBottone, button, 1);
                } else {
                    risposta = game.controllaDomanda(domanda.getSelectedIndex(), personaScelta, personaBottone);
                    if (!risposta)
                        button.setVisible(false);
                }*/
            }
            game.inviaMessaggio(domanda.getSelectedIndex(), personaScelta);
        });
        panel.add(eseguiDomanda);

        add(panel);
        setVisible(true);
    }
}
