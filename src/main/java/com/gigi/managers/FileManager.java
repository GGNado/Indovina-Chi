package com.gigi.managers;

import com.gigi.Persona;
import org.bspfsystems.yamlconfiguration.file.YamlConfiguration;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class FileManager {
    private YamlConfiguration yamlConfiguration;

    public FileManager(File file){
            yamlConfiguration = YamlConfiguration.loadConfiguration(file);
    }

    public Persona getPersona(int id){
        Persona persona = new Persona(yamlConfiguration.getString("Personaggi." + id + ".nome"),
                                      yamlConfiguration.getInt("Personaggi." + id + ".sesso"),
                                      yamlConfiguration.getBoolean("Personaggi." + id + ".barba"),
                                      yamlConfiguration.getBoolean("Personaggi." + id + ".baffi"),
                                      yamlConfiguration.getBoolean("Personaggi." + id + ".cappello"),
                                      yamlConfiguration.getBoolean("Personaggi." + id + ".occhiali"),
                                      yamlConfiguration.getInt("Personaggi." + id + ".capelli"),
                                      yamlConfiguration.getInt("Personaggi." + id + ".colore_capelli"),
                                      yamlConfiguration.getInt("Personaggi." + id + ".colore_occhi"),
                                      yamlConfiguration.getString("Personaggi." + id + ".foto"));

        return persona;
    }

}
