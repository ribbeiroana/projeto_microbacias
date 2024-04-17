package com.michelle.microbacias.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.michelle.microbacias.R;

public class Michelle extends AppCompatActivity {

    private CardView gitMichelle;
    private CardView artur;
    private CardView ana;
    private CardView valessa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_michelle);

        gitMichelle = findViewById(R.id.gitMichelle);
        artur = findViewById(R.id.artur);
        ana = findViewById(R.id.ana);
        valessa = findViewById(R.id.valessa);

        gitMichelle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Abra o link https://github.com/michellerdias em um navegador da web
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/michellerdias")));
            }
        });

        artur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Michelle.this, Artur.class);
                startActivity(i);
            }
        });

        ana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Michelle.this, Ana.class);
                startActivity(i);
            }
        });

        valessa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Michelle.this, Valessa.class);
                startActivity(i);
            }
        });
    }
}