package com.rosu.recipelist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DescrizioneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descrizione);

        TextView txtMostra=findViewById(R.id.txtMostra);
        txtMostra.setText("Dall'amore per il cibo la passione per la cucina" +
                "\n L'app di RecipeList per smartphone si rinnova nell'aspetto e nella funzionalità, più semplice, più completa e sempre di più di aiuto in cucina. \n" +
                "\n Esplora la nuova App:\n" +
                "Le ricette: Trovi tutte le ricette. Ogni giorno ti suggeriamo una ricetta per farti ispirare. \n" +
                "\n I suggerimenti: Puoi scrivere i suggerimenti inserendo il tuo nome e magari una ricetta che ti piacerebbe fosse pubblicata.\n" +
                "\n I commenti: Puoi scrivere i commenti per dare un giudizio al piatto oppure per chiedere informazioni sul procedimento,ma non solo.");
    }
}