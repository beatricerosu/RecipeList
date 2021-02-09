package com.rosu.recipelist;

public class Commento {

    private String nome;
    private String commento;
    private String  idPiatto;

    public Commento(String n, String c, String  idP)
    {
        nome=n;
        commento=c;
        idPiatto=idP;
    }

    public String getNome() {
        return nome;
    }

    public String getCommento() {
        return commento;
    }

    public String  getIdPiatto() {
        return idPiatto;
    }

}
