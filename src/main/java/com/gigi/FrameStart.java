package com.gigi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FrameStart extends JFrame {
    public FrameStart(ArrayList<Persona> persone){
        setTitle("Indovina Chi 1.0.0");
        setSize(300, 300);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(null);
        panel.setBackground(new Color(255, 230, 0));
        JLabel titolo = new JLabel("Indovina chi vuoi tu!");
        titolo.setFont(new Font("Apple Casual", Font.BOLD, 20));
        titolo.setBounds(45, 20, titolo.getPreferredSize().width, titolo.getPreferredSize().height);
        panel.add(titolo);

        JButton start = new JButton("Giochiamo");
        JButton exit = new JButton("Torna al Desktop");
        JButton riconoscimetni = new JButton("Riconoscimenti");

        start.setBounds(100, 100, 100, 25);
        riconoscimetni.setBounds(75, 140, 150, 25);
        exit.setBounds(75, 180, 150, 25);

        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Frame(persone);
            }
        });

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        riconoscimetni.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Gioco sviluppato da MassaLubrense INC\nMassa Luigi\nMusella Christian\nPontecorvo Guido\nSorrentino Alessandro");
            }
        });
        panel.add(exit);
        panel.add(riconoscimetni);
        panel.add(start);

        add(panel);
        setVisible(true);
    }
}
