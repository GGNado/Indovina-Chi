package com.gigi;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public class Game {
    private ArrayList<Persona> persone;
    public Game(){
        persone = new ArrayList<>();
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
        }

        return false;
    }

    public boolean controllaCapelli(Persona personaScelta, Persona personaBottone, JButton button, int tipoCapelli) {
        if (personaScelta.getCapelli() == tipoCapelli) {
            if (personaBottone.getCapelli() != tipoCapelli) {
                button.setVisible(false);
                return true;
            }
        } else {
            if (personaBottone.getCapelli() == tipoCapelli) {
                button.setVisible(false);
                return false;
            }
        }

        return true;
    }

    public boolean controllaColoreCapelli(Persona personaScelta, Persona personaBottone, JButton button, int coloreCapelli){
        if (personaScelta.getColoreCapelli() == coloreCapelli) {
            if (personaBottone.getColoreCapelli() != coloreCapelli) {
                button.setVisible(false);
                return true;
            }
        } else {
            if (personaBottone.getColoreCapelli() == coloreCapelli) {
                button.setVisible(false);
                return false;
            }
        }

        return true;
    }

    public void inviaMessaggio(int index, Persona personaScelta){
        switch (index){
            case 0:
                if (personaScelta.getSesso() == 0)
                    creaMessaggio("Si, il personaggio che ho scelto è Uomo");
                else
                    creaMessaggio("No, il peronaggio che ho scelto non è uomo");
                break;
            case 1:
                if (personaScelta.getSesso() == 1)
                    creaMessaggio("Si, il personaggio che ho scelto è Donna");
                else
                    creaMessaggio("No, il personaggio che ho scelto non è Donna");
                break;
            case 2:
                if (personaScelta.isHaOcchiali())
                    creaMessaggio("Si, il personaggio che ho scelto ha gli occhiali");
                else
                    creaMessaggio("No, il personaggio che ho scelto non ha gl ìi occhiali");
                break;
            case 3:
                if (personaScelta.isHaCappello())
                    creaMessaggio("Si, il personaggio che ho scelto ha il cappello");
                else
                    creaMessaggio("No, il personaggio che ho scelto non ha il cappello");
                break;
            case 4:
                if (personaScelta.isHaBarba())
                    creaMessaggio("Si, il personaggio che ho scelto ha la barba");
                else
                    creaMessaggio("No, il personaggio che ho scelto non ha la barba");
                break;
            case 5:
                if (personaScelta.isHaBaffi())
                    creaMessaggio("Si, il personaggio che ho scelto ha i baffi");
                else
                    creaMessaggio("No, il personaggio che ho scelto non ha i baffi");
                break;
            case 6:
                if (personaScelta.getCapelli() == 1)
                    creaMessaggio("Si, il personaggio che ho scelto ha i capelli lisci");
                else
                    creaMessaggio("No, il personaggio che ho scelto non ha i capelli lisci");
                break;
            case 7:
                if (personaScelta.getCapelli() == 0)
                    creaMessaggio("Si, il personaggio che ho scelto è Calvo");
                else
                    creaMessaggio("No, il personaggio che ho scelto non è Calvo");
                break;
            case 8:
                if (personaScelta.getCapelli() == 2)
                    creaMessaggio("Si, il personaggio che ho scelto ha i capelli mossi");
                else
                    creaMessaggio("No, il personaggio che ho scelto non ha i capelli mossi");
                break;
            case 9:
                if (personaScelta.getCapelli() == 3)
                    creaMessaggio("Si, il personaggio che ho scelto ha i capelli ricci");
                else
                    creaMessaggio("No, il personaggio che ho scelto non ha i capelli ricci");
                break;
            case 10:
                if (personaScelta.getColoreCapelli() == 0)
                    creaMessaggio("Si, il personaggio che ho scelto ha i capelli Bianchi");
                else
                    creaMessaggio("No, il personaggio che ho scelto non ha i capelli Bianchi");
                break;
            case 11:
                if (personaScelta.getColoreCapelli() == 1)
                    creaMessaggio("Si, il personaggio che ho scelto ha i capelli Biondi");
                else
                    creaMessaggio("No, il personaggio che ho scelto non ha i capelli Bianchi");
                break;
            case 12:
                if (personaScelta.getColoreCapelli() == 2)
                    creaMessaggio("Si, il personaggio che ho scelto ha i capelli Rossi");
                else
                    creaMessaggio("No, il personaggio che ho scelto non ha i capelli Rossi");
                break;
            case 13:
                if (personaScelta.getColoreCapelli() == 3)
                    creaMessaggio("Si, il personaggio che ho scelto ha i capelli Marroni");
                else
                    creaMessaggio("No, il personaggio che ho scelto non ha i capelli Marroni");
                break;
            case 14:
                if (personaScelta.getColoreCapelli() == 4)
                    creaMessaggio("Si, il personaggio che ho scelto ha i capelli Neri");
                else
                    creaMessaggio("No, il personaggio che ho scelto non ha i capelli Neri");
                break;
        }
    }

    private void creaMessaggio(String str){
        JOptionPane.showMessageDialog(null, str);
    }
}
