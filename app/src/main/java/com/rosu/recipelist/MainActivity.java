package com.rosu.recipelist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnVedi=findViewById(R.id.btnVedi);
        btnVedi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent vediIntent=new Intent(MainActivity.this,VediPiattiActivity.class);
                startActivity(vediIntent);

            }
        });

        Button btnSuggerisci=findViewById(R.id.btnSuggerisci);
        btnSuggerisci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent suggerisciIntent=new Intent(MainActivity.this,SuggerimentiActivity.class);
                startActivity(suggerisciIntent);
            }
        });

        Button btnDescrizione=findViewById(R.id.btnDescrizione);
        btnDescrizione.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent descrizioneIntent=new Intent(MainActivity.this,DescrizioneActivity.class);
                startActivity(descrizioneIntent);
            }
        });

    }
}