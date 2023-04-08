package com.gigi;

import javax.swing.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Random;

public class Game {
    private ArrayList<Persona> persone;
    public Game(){
        persone = new ArrayList<>();
    }
    public void start() {
        JOptionPane.showMessageDialog(null, "La partita è iniziata! Chiedi le giuste domande!");
        Random random = new Random();
        int randomNumber = random.nextInt(21) + 1;
    }

    public boolean controllaDomanda(int index, Persona persona, Persona personaBottone){
        switch (index){
            case 0: //Uomo
                return persona.getSesso() == personaBottone.getSesso();
            case 1: //Donna
                return persona.getSesso() == personaBottone.getSesso();
            case 2:
                return persona.isHaOcchiali() == personaBottone.isHaOcchiali();
            case 3:
                return persona.isHaCappello() == personaBottone.isHaCappello();
            case 4:
                return persona.isHaBarba() == personaBottone.isHaBarba();
            case 5:
                return persona.isHaBaffi() == personaBottone.isHaBaffi();
            case 6:
                if (persona.getCapelli() == 1)
                    return true;


        }

        return false;
    }
}
