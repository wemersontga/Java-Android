package com.wcasoft.megasena.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.wcasoft.megasena.R;
import com.wcasoft.megasena.helper.ConfiguracaoFirebase;
import com.wcasoft.megasena.model.Usuario;

public class LoginActivity extends AppCompatActivity {

    private EditText campoEmail, campoSenha;
    private Button btnEntrar;
    private ProgressBar progressBar;
    private Usuario usuario;
    private FirebaseAuth autenticaFirebase;

    private TextView cadastreSe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_Generico);
        setContentView(R.layout.activity_login);

        verificaUsuarioLogado();
        inicializarComponentes();
        progressBar.setVisibility(View.GONE);

        abrirCadastro();

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textoEmail = campoEmail.getText().toString();
                String textoSenha = campoSenha.getText().toString();

                if (!textoEmail.isEmpty()) {
                    if (!textoSenha.isEmpty()) {

                        usuario = new Usuario();
                        usuario.setEmail(textoEmail);
                        usuario.setSenha(textoSenha);
                        validarLogin(usuario);

                    } else {
                        Toast.makeText(LoginActivity.this, "Preencha a Senha", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(LoginActivity.this, "Preencha o E-mail", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    public void validarLogin(Usuario usuario) {

        progressBar.setVisibility(View.VISIBLE);
        autenticaFirebase = ConfiguracaoFirebase.getFirebaseAutenticacao();
        autenticaFirebase.signInWithEmailAndPassword(usuario.getEmail(), usuario.getSenha()) //metodo usado para logar "signInWithEmailAndPassword"
                .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful()){
                            progressBar.setVisibility(View.GONE);
                            Toast.makeText(LoginActivity.this, "Login OK.", Toast.LENGTH_SHORT).show();

                            startActivity(new Intent(LoginActivity.this, SplashActivity.class));
                            finish();
                        }else{
                            progressBar.setVisibility(View.GONE);
                            Toast.makeText(LoginActivity.this, "erro ao fazer login" , Toast.LENGTH_SHORT).show();
                        }
                    }
                });

}
    public void verificaUsuarioLogado() {

        autenticaFirebase = ConfiguracaoFirebase.getFirebaseAutenticacao();
            if(autenticaFirebase.getCurrentUser() != null) {
                startActivity(new Intent(LoginActivity.this, SplashActivity.class));
                finish();
}

}

    public void abrirCadastro() {
        cadastreSe = findViewById(R.id.textLoginCadastrar);
        cadastreSe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(LoginActivity.this, CadastroActivity.class);
                startActivity(i);

            }
        });

    }

    public void inicializarComponentes() {

        campoEmail = findViewById(R.id.editLoginEmail);
        campoSenha = findViewById(R.id.editLoginSenha);
        btnEntrar = findViewById(R.id.button_Entrar);
        progressBar = findViewById(R.id.progressLogin);

        campoEmail.requestFocus();

    }

}

