package com.rosu.recipelist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.FirebaseDatabase;

public class SuggerimentiActivity extends AppCompatActivity {

    boolean nomeInserito=false;
    boolean descrizioneInviata=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggerimenti);

        EditText txtNome = findViewById(R.id.txtNome);
        EditText txtDescrizione = findViewById(R.id.txtDescrizione);

        Button btnInvia= findViewById(R.id.btnInvia);
        btnInvia.setEnabled(false);
        btnInvia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Suggerimento suggerimento = new Suggerimento(txtNome.getText().toString(),txtDescrizione.getText().toString());
                FirebaseDatabase.getInstance().getReference( "suggerimenti").child(suggerimento.getNome()).setValue(suggerimento);
                txtNome.setText("");
                txtDescrizione.setText("");
                btnInvia.setEnabled(false);
                nomeInserito =false;
                descrizioneInviata=false;
            }
        });

        txtNome.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {}
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!txtNome.getText().toString().equals(""))
                {
                    nomeInserito=true;
                }
                if(nomeInserito && descrizioneInviata)
                {
                    btnInvia.setEnabled(true);
                }
            }
        });

        txtDescrizione.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {}
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!txtDescrizione.getText().toString().equals(""))
                {
                    descrizioneInviata=true;
                }
                if(nomeInserito && descrizioneInviata)
                {
                    btnInvia.setEnabled(true);
                }
            }
        });
    }
}