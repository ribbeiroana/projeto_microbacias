package com.michelle.microbacias.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.michelle.microbacias.R;

public class Valessa extends AppCompatActivity {

    private CardView linkedinvalessa;
    private CardView artur;
    private CardView ana;
    private CardView michelle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_valessa);

        linkedinvalessa = findViewById(R.id.linkedinvalessa);
        artur = findViewById(R.id.artur);
        ana = findViewById(R.id.ana);
        michelle = findViewById(R.id.michelle);

        linkedinvalessa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Abra o link https://github.com/michellerdias em um navegador da web
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/valessa-lopes-da-silva-3bbaa0127?utm_source=share&utm_campaign=share_via&utm_content=profile&utm_medium=ios_app")));
            }
        });

        artur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Valessa.this, Artur.class);
                startActivity(i);
            }
        });

        ana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Valessa.this, Ana.class);
                startActivity(i);
            }
        });

        michelle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Valessa.this, Michelle.class);
                startActivity(i);
            }
        });
    }
}
