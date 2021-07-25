package com.wcasoft.megasena.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.wcasoft.megasena.R;
import com.wcasoft.megasena.helper.ConfiguracaoFirebase;
import com.wcasoft.megasena.model.Usuario;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class CadastroActivity extends AppCompatActivity {

    private EditText campoNome, campoEmail, campoSenha;
    private Button btnCadastrar;
    private ProgressBar progressBar;
    private Usuario usuario;
    private FirebaseAuth autenticaFirebase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_Generico);
        setContentView(R.layout.activity_cadastro);

        inicializarComponentes();

        //cadastrar usuario;
        progressBar.setVisibility(View.GONE);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String textoNome = campoNome.getText().toString();
                String textoEmail = campoEmail.getText().toString();
                String textoSenha = campoSenha.getText().toString();

                if(!textoNome.isEmpty()){
                    if(!textoEmail.isEmpty()){
                        if(!textoSenha.isEmpty()){

                            usuario = new Usuario();
                            usuario.setNome(textoNome);
                            usuario.setEmail(textoEmail);
                            usuario.setSenha(textoSenha);

                            cadastrar(usuario);

                        }else{
                            Toast.makeText(CadastroActivity.this, "Preencha a Senha", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(CadastroActivity.this, "Preencha o E-mail", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(CadastroActivity.this, "Preencha o Nome", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void cadastrar(Usuario usuario) {

        progressBar.setVisibility(View.VISIBLE);
        autenticaFirebase = ConfiguracaoFirebase.getFirebaseAutenticacao();
        autenticaFirebase.createUserWithEmailAndPassword(usuario.getEmail(), usuario.getSenha()) // método usado para cadastrar "createUserWithEmailAndPassword"
                .addOnCompleteListener(CadastroActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful()){
                            progressBar.setVisibility(View.GONE);
                            Toast.makeText(CadastroActivity.this, "Cadastrado com sucesso.", Toast.LENGTH_SHORT).show();

                            startActivity(new Intent(CadastroActivity.this, LoginActivity.class));
                            finish();
                        }else{
                            progressBar.setVisibility(View.GONE);
                            String erroExcessao ="";
                            try{
                                throw task.getException();
                            } catch(FirebaseAuthWeakPasswordException e){
                                erroExcessao = "Digite uma senha mais forte.";
                            } catch(FirebaseAuthInvalidCredentialsException e){
                                erroExcessao = "Por favor digite um e-mail válido.";
                            } catch(FirebaseAuthUserCollisionException e){
                                erroExcessao = "Esta conta ja foi cadastrada.";
                            } catch(Exception e){
                                erroExcessao = "Ao cadastrar usuario" + e.getMessage();
                            }
                            Toast.makeText(CadastroActivity.this, "erro" + erroExcessao, Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    public void inicializarComponentes() {

        campoNome = findViewById(R.id.editCadastroNome);
        campoEmail = findViewById(R.id.editCadastroEmail);
        campoSenha = findViewById(R.id.editCadastroSenha);
        btnCadastrar = findViewById(R.id.button_Cadastrar);
        progressBar = findViewById(R.id.progressCadastro);

        campoNome.requestFocus();
    }

}

