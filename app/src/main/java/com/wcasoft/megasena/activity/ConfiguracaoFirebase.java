package com.wcasoft.megasena.activity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

public class ConfiguracaoFirebase {

    private static DatabaseReference referenciaFirebase;
    private static FirebaseAuth Autenticacao;

 public static void FirebaseAuth(){

        if(Autenticacao == null){
            Autenticacao = FirebaseAuth.getInstance();
        }

}


}
