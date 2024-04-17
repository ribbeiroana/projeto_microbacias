package com.michelle.microbacias.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.michelle.microbacias.R;

public class Sobre extends AppCompatActivity {

    private CardView michelle, artur, ana, valessa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobre);

        michelle = findViewById(R.id.michelle);
        artur = findViewById(R.id.artur);
        ana = findViewById(R.id.ana);
        valessa = findViewById(R.id.valessa);

        michelle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Sobre.this, Michelle.class);
                startActivity(i);
            }
        });

        artur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Sobre.this, Artur.class);
                startActivity(i);
            }
        });

        ana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Sobre.this, Ana.class);
                startActivity(i);
            }
        });

        valessa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Sobre.this, Valessa.class);
                startActivity(i);
            }
        });


    }
}