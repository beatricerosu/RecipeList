package com.rosu.recipelist;

public class Suggerimento {

    private String nome;
    private  String descrizione;

    public Suggerimento(String n, String d)
    {
        nome=n;
        descrizione=d;
    }

    public String getNome() {
        return nome;
    }

    public String getDescrizione() {
        return descrizione;
    }
}
