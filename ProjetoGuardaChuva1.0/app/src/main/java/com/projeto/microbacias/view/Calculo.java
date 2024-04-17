package com.michelle.microbacias.view;

import androidx.appcompat.app.AppCompatActivity;

import com.michelle.microbacias.R;
import com.michelle.microbacias.view.NovaMicrobacia;

public class Calculo extends AppCompatActivity {

    double anguloValue = Double.parseDouble(findViewById(R.id.editangulo).toString());
    double alturaValue = Double.parseDouble(findViewById(R.id.editaltura).toString());
    double larguraValue = Double.parseDouble(findViewById(R.id.editlargura).toString());

    double anguloRadianos = Math.toRadians(anguloValue);
    double alturaEfetiva = alturaValue * Math.cos(anguloRadianos);
    double volume = larguraValue * alturaEfetiva * 0.1718;

    public double getVolume() {
        return volume;
    }
}
