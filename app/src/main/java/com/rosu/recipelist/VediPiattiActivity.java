package com.rosu.recipelist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class VediPiattiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vedi_piatti);//

        ImageView imgCarbonara = findViewById(R.id.imgCarbonara);
        imgCarbonara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent piattoIntent=new Intent(VediPiattiActivity.this, PiattoActivity.class);
                piattoIntent.putExtra("piatto","carbonara");
                startActivity(piattoIntent);
            }
        });


        ImageView imgStrudel = findViewById(R.id.imgStrudel);
        imgStrudel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent piattoIntent=new Intent(VediPiattiActivity.this, PiattoActivity.class);
                piattoIntent.putExtra("piatto","strudel");
                startActivity(piattoIntent);
            }
        });
        ImageView imgTiramisu = findViewById(R.id.imgTiramisu);
        imgTiramisu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent piattoIntent=new Intent(VediPiattiActivity.this, PiattoActivity.class);
                piattoIntent.putExtra("piatto","tiramisu");
                startActivity(piattoIntent);
            }
        });
        ImageView imgRisotto = findViewById(R.id.imgRisotto);
        imgRisotto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent piattoIntent=new Intent(VediPiattiActivity.this, PiattoActivity.class);
                piattoIntent.putExtra("piatto","risotto");
                startActivity(piattoIntent);
            }
        });
        ImageView imgPolpette = findViewById(R.id.imgPolpette);
        imgPolpette.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent piattoIntent=new Intent(VediPiattiActivity.this, PiattoActivity.class);
                piattoIntent.putExtra("piatto","polpette");
                startActivity(piattoIntent);
            }
        });
        ImageView imgSalmone= findViewById(R.id.imgSalmone);
        imgSalmone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent piattoIntent=new Intent(VediPiattiActivity.this, PiattoActivity.class);
                piattoIntent.putExtra("piatto","salmone");
                startActivity(piattoIntent);
            }
        });
        ImageView imgLasagne = findViewById(R.id.imgLasagne);
        imgLasagne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent piattoIntent=new Intent(VediPiattiActivity.this, PiattoActivity.class);
                piattoIntent.putExtra("piatto","lasagne");
                startActivity(piattoIntent);
            }
        });
        ImageView imgFrittelle = findViewById(R.id.imgFrittelle);
        imgFrittelle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent piattoIntent=new Intent(VediPiattiActivity.this, PiattoActivity.class);
                piattoIntent.putExtra("piatto","frittelle");
                startActivity(piattoIntent);
            }
        });
        ImageView imgCrostata= findViewById(R.id.imgCrostata);
        imgCrostata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent piattoIntent=new Intent(VediPiattiActivity.this, PiattoActivity.class);
                piattoIntent.putExtra("piatto","crostata");
                startActivity(piattoIntent);
            }
        });
        ImageView imgBaba = findViewById(R.id.imgBaba);
        imgBaba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent piattoIntent=new Intent(VediPiattiActivity.this, PiattoActivity.class);
                piattoIntent.putExtra("piatto","baba");
                startActivity(piattoIntent);
            }
        });

    }
}