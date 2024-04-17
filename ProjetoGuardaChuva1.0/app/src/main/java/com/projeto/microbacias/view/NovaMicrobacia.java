package com.michelle.microbacias.view;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.os.Bundle;
import com.google.android.material.snackbar.Snackbar;
import com.michelle.microbacias.R;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import java.util.HashMap;
import java.util.Map;

public class NovaMicrobacia extends AppCompatActivity {
    private EditText editNomeProprietario, editCpf, editCep, editRua, editNumero, editaltura, editangulo, editlargura;
    private Button btcalcular, btsalvar;
    TextView resultado;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nova_microbacia);

        editNomeProprietario = findViewById(R.id.editNomeProprietario);
        editCpf = findViewById(R.id.editCpf);
        editCep = findViewById(R.id.editCep);
        editRua = findViewById(R.id.editRua);
        editNumero = findViewById(R.id.editNumero);
        btcalcular = findViewById(R.id.btcalcular);
        editaltura = findViewById(R.id.editaltura);
        editlargura = findViewById(R.id.editlargura);
        editangulo = findViewById(R.id.editangulo);
        resultado = findViewById(R.id.volumeMicrobacia);
        btsalvar = findViewById(R.id.btsalvar);

        btcalcular.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Calculo calc = new Calculo();
                // Exiba o resultado no TextView
                resultado.setText(calc.getVolume() + "m³");
            }
        });

        btsalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nomeProprietario = editNomeProprietario.getText().toString();
                String cpf = editCpf.getText().toString();
                String cep = editCep.getText().toString();
                String rua = editRua.getText().toString();
                String numero = editNumero.getText().toString();
                String altura = editaltura.getText().toString();
                String largura = editlargura.getText().toString();
                String angulo = editangulo.getText().toString();
                String resultadoText = resultado.getText().toString();

                // Verifique se os campos não estão vazios
                if (!nomeProprietario.isEmpty() && !cpf.isEmpty() && !cep.isEmpty() &&
                        !rua.isEmpty() && !numero.isEmpty() && !altura.isEmpty() && !largura.isEmpty() &&
                        !angulo.isEmpty() &&  !resultadoText.isEmpty()) {
                    FirebaseFirestore db = FirebaseFirestore.getInstance();
                    DocumentReference microbaciaRef = db.collection("microbacias").document();

                    // Crie um mapa de dados
                    Map<String, Object> microbacia = new HashMap<>();
                    microbacia.put("nomeProprietario", nomeProprietario);
                    microbacia.put("cpf", cpf);
                    microbacia.put("cep", cep);
                    microbacia.put("rua", rua);
                    microbacia.put("numero", numero);
                    microbacia.put("altura", altura);
                    microbacia.put("largura", largura);
                    microbacia.put("angulo", angulo);
                    microbacia.put("volume", resultadoText);

                    // Adicione os dados ao Firestore
                    microbaciaRef.set(microbacia)
                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Snackbar snackbar = Snackbar.make(view, "Microbacia cadastrada!", Snackbar.LENGTH_LONG);
                                    View snackbarView = snackbar.getView();
                                    snackbarView.setBackgroundColor(getResources().getColor(R.color.azul_claro));
                                    snackbar.show();
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Snackbar snackbar = Snackbar.make(view, "Tente novamente.", Snackbar.LENGTH_LONG);
                                    View snackbarView = snackbar.getView();
                                    snackbarView.setBackgroundColor(getResources().getColor(R.color.vermelho));
                                    snackbar.show();
                                }
                            });
                }
            }
        });
    }
}