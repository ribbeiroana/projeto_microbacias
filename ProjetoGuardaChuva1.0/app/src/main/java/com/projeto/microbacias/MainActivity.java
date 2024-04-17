package com.michelle.microbacias;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.michelle.microbacias.view.Menu;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private EditText email, senha, email_registro, senha_registro, nome_registro, confirmeEmail;
    private Button botaoEntrar, botaoCriarConta, botaoRegistar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.editEmail);
        senha = findViewById(R.id.editSenha);
        botaoEntrar = findViewById(R.id.btEntrar);
        botaoCriarConta = findViewById(R.id.btCriarConta);
        email_registro = findViewById(R.id.reg_email);
        senha_registro = findViewById(R.id.reg_senha);

        // Inicialize o Firebase Authentication
        mAuth = FirebaseAuth.getInstance();

        ClickBtEntrar();

        // Botão CriarConta para mostrar a página de cadastro
        botaoCriarConta.setOnClickListener(view -> ClickBtCriarConta());
    }

    // Método para checar o login
    private void ClickBtEntrar() {
        botaoEntrar.setOnClickListener(view -> {
            if (email.getText().toString().trim().isEmpty() || senha.getText().toString().trim().isEmpty()) {
                Snackbar snackbar = Snackbar.make(view, "Por favor, preencha os campos com seu e-mail e senha", Snackbar.LENGTH_LONG);
                View snackbarView = snackbar.getView();
                snackbarView.setBackgroundColor(getResources().getColor(R.color.vermelho));
                snackbar.show();
            } else {
                // Obtenha o e-mail e a senha inseridos pelos usuários
                String email = this.email.getText().toString().trim();
                String senha = this.senha.getText().toString().trim();

                // Faça login com o Firebase Authentication
                mAuth.signInWithEmailAndPassword(email, senha)
                        .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // O login foi bem-sucedido
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    // Redireciona o usuário para a Activity Menu
                                    Intent intent = new Intent(MainActivity.this, Menu.class);
                                    startActivity(intent);
                                } else {
                                    // O login falhou
                                    Snackbar snackbar = Snackbar.make(view, "Falha no login. Verifique o e-mail e a senha.", Snackbar.LENGTH_LONG);
                                    View snackbarView = snackbar.getView();
                                    snackbarView.setBackgroundColor(getResources().getColor(R.color.vermelho));
                                    snackbar.show();
                                }
                            }
                        });
            }
        });
    }

    // Método para abrir a página de Cadastro e checar o registro
    private void ClickBtCriarConta() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.registrar, null);
        dialogBuilder.setView(dialogView);

        email_registro = dialogView.findViewById(R.id.reg_email);
        senha_registro = dialogView.findViewById(R.id.reg_senha);
        nome_registro = dialogView.findViewById(R.id.reg_nome);
        confirmeEmail = dialogView.findViewById(R.id.reg_confirmeEmail);
        botaoRegistar = dialogView.findViewById(R.id.btRegistrar);

        // Crie o AlertDialog
        final AlertDialog dialog = dialogBuilder.create();

        botaoRegistar.setOnClickListener(view -> {
            String nome = nome_registro.getText().toString().trim();
            String email = email_registro.getText().toString().trim();
            String confirmeEmail = this.confirmeEmail.getText().toString().trim();
            String senha = senha_registro.getText().toString().trim();

            if (nome.isEmpty() || email.isEmpty() || confirmeEmail.isEmpty() || senha.isEmpty()) {
                Snackbar snackbar = Snackbar.make(view, "Por favor, preencha todos os campos.", Snackbar.LENGTH_LONG);
                View snackbarView = snackbar.getView();
                snackbarView.setBackgroundColor(getResources().getColor(R.color.vermelho));
                snackbar.show();
            } else if (!email.equals(confirmeEmail)) {
                Snackbar snackbar = Snackbar.make(view, "Os e-mails digitados não coincidem.", Snackbar.LENGTH_LONG);
                View snackbarView = snackbar.getView();
                snackbarView.setBackgroundColor(getResources().getColor(R.color.vermelho));
                snackbar.show();
            }

            // Registro com Firebase Authentication
            mAuth.createUserWithEmailAndPassword(email, senha)
                    .addOnCompleteListener(MainActivity.this, task -> {
                        if (task.isSuccessful()) {
                            // Registro bem-sucedido
                            FirebaseUser user = mAuth.getCurrentUser();

                            // Redireciona o usuário para a Activity Menu
                            Intent intent = new Intent(MainActivity.this, Menu.class);
                            startActivity(intent);

                            // Fecha o diálogo de registro
                            dialog.dismiss();
                        } else {
                            // Registro falhou
                            Snackbar snackbar = Snackbar.make(view, "O Cadastro falhou. Tente novamente.", Snackbar.LENGTH_LONG);
                            View snackbarView = snackbar.getView();
                            snackbarView.setBackgroundColor(getResources().getColor(R.color.vermelho));
                            snackbar.show();
                        }
                    });
        });

        // Exiba o diálogo de registro
        dialog.show();
    }
}