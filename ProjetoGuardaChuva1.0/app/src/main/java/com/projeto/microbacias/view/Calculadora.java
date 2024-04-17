package com.michelle.microbacias.view;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.michelle.microbacias.R;
import android.widget.TextView;
public class Calculadora extends AppCompatActivity {

    EditText altura, angulo, largura;
    Button calcular;
    TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        altura = findViewById(R.id.editaltura);
        largura = findViewById(R.id.editlargura);
        angulo = findViewById(R.id.editangulo);
        calcular = findViewById(R.id.btcalcular);
        resultado = findViewById(R.id.volumeMicrobacia);

        calcular.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Calculo calc = new Calculo();
                // Exiba o resultado no TextView
                resultado.setText("Volume calculado: " + calc.getVolume());
            }
        });
    }
}