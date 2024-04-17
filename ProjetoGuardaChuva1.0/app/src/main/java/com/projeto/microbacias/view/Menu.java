package com.michelle.microbacias.view;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import com.michelle.microbacias.R;

public class Menu extends AppCompatActivity implements View.OnClickListener {
    private static  CardView novaMicrobacia, microbaciasCadastradas, tutorial, sobre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        novaMicrobacia = findViewById(R.id.novaMicrobacia);
        microbaciasCadastradas = findViewById(R.id.microbaciasCadastradas);
        tutorial = findViewById(R.id.tutorial);
        sobre = findViewById(R.id.sobre);

        novaMicrobacia.setOnClickListener(this);
        microbaciasCadastradas.setOnClickListener(this);
        tutorial.setOnClickListener(this);
        sobre.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        Intent i;
        if (view.getId() == R.id.novaMicrobacia){
            i = new Intent(this, NovaMicrobacia.class);
            startActivity(i);
        }
        if (view.getId() == R.id.microbaciasCadastradas){
            i = new Intent(this, MicrobaciasCadastradas.class);
            startActivity(i);
        }
        if (view.getId() == R.id.tutorial){
            i = new Intent(this, Tutorial.class);
            startActivity(i);
        }
        if (view.getId() == R.id.sobre){
            i = new Intent(this, Sobre.class);
            startActivity(i);
        }
    }
}