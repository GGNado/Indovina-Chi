package com.gigi;

import java.awt.*;

public class Persona {
    private String nome;
    private int sesso;
    private boolean haBarba;
    private boolean haBaffi;
    private boolean haCappello;
    private boolean haOcchiali;
    private int capelli;
    private int coloreCapelli;
    private int coloreOcchi;
    private String fotoPath;


    public Persona(String nome){
        this.nome = nome;
    }

    public Persona(String nome, int sesso, boolean haBarba, boolean haBaffi, boolean haCappello, boolean haOcchiali, int capelli, int coloreCapelli, int coloreOcchi, String fotoPath) {
        this.nome = nome;
        this.sesso = sesso;
        this.haBarba = haBarba;
        this.haBaffi = haBaffi;
        this.haCappello = haCappello;
        this.haOcchiali = haOcchiali;
        this.capelli = capelli;
        this.coloreCapelli = coloreCapelli;
        this.coloreOcchi = coloreOcchi;
        this.fotoPath = fotoPath;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getSesso() {
        return sesso;
    }

    public void setSesso(int sesso) {
        this.sesso = sesso;
    }

    public boolean isHaBarba() {
        return haBarba;
    }

    public void setHaBarba(boolean haBarba) {
        this.haBarba = haBarba;
    }

    public boolean isHaBaffi() {
        return haBaffi;
    }

    public void setHaBaffi(boolean haBaffi) {
        this.haBaffi = haBaffi;
    }

    public boolean isHaCappello() {
        return haCappello;
    }

    public void setHaCappello(boolean haCappello) {
        this.haCappello = haCappello;
    }

    public boolean isHaOcchiali() {
        return haOcchiali;
    }

    public void setHaOcchiali(boolean haOcchiali) {
        this.haOcchiali = haOcchiali;
    }

    public int getCapelli() {
        return capelli;
    }

    public void setCapelli(int capelli) {
        this.capelli = capelli;
    }

    public int getColoreCapelli() {
        return coloreCapelli;
    }

    public void setColoreCapelli(int coloreCapelli) {
        this.coloreCapelli = coloreCapelli;
    }

    public int getColoreOcchi() {
        return coloreOcchi;
    }

    public void setColoreOcchi(int coloreOcchi) {
        this.coloreOcchi = coloreOcchi;
    }

    public String getFotoPath() {
        return fotoPath;
    }

    public void setFotoPath(String fotoPath) {
        this.fotoPath = fotoPath;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nome='" + nome + '\'' +
                ", sesso=" + sesso +
                ", haBarba=" + haBarba +
                ", haBaffi=" + haBaffi +
                ", haCappello=" + haCappello +
                ", haOcchiali=" + haOcchiali +
                ", capelli=" + capelli +
                ", coloreCapelli=" + coloreCapelli +
                ", coloreOcchi=" + coloreOcchi +
                ", fotoPath='" + fotoPath + '\'' +
                '}';
    }
}
