package com.wcasoft.megasena.activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.wcasoft.megasena.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView txtResult1, txtResult2;
    int v1, v2, v3, v4, v5, v6, v7, v8, v9, v10;
    int saida0, saida1, saida2, saida3, saida4, saida5, saida6, saida7, saida8, saida9;
    ArrayList<Integer> lista = new ArrayList();
    ArrayList<Integer> lista2 = new ArrayList<>();
    HashSet<Integer> hSet = new HashSet();
    HashSet<Integer> hSet2 = new HashSet();

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setTheme(R.style.Theme_Generico); //muda o tema da com.wcasoft.megasena.com.wcasoft.megasena.activity.
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbarPrincipal); //import androidx.appcompat.widget.Toolbar;
        toolbar.setTitle("MegaSorte");
        setSupportActionBar(toolbar);

        txtResult1 = findViewById(R.id.resultado1);
        txtResult2 = findViewById(R.id.resultado2);

    }

    public boolean onCreateOptionsMenu(Menu menu){

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);

        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item){

        switch(item.getItemId()){
            case R.id.menu_Menu:

                    System.out.println("......................................");
                    System.out.println("...............Oi você clicou no Menu.");
                    System.out.println("......................................");

                    break;

            case R.id.menu_favorito:
                    System.out.println("......................................");
                    System.out.println(".......OI você clicou no item do Menu.");
                    System.out.println("......................................");

                    break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void geraNumerosAleatorios(View v) {

        Random rand = new Random();
        v1 = rand.nextInt(9) + 1;
        v2 = rand.nextInt(19) + 1;
        v3 = rand.nextInt(59) + 1;
        v4 = rand.nextInt(59) + 1;
        v5 = rand.nextInt(59) + 1;
        v6 = rand.nextInt(59) + 1;
        v7 = rand.nextInt(59) + 1;
        v8 = rand.nextInt(59) + 1;
        v9 = rand.nextInt(49) + 1;
        v10 = rand.nextInt(59) + 1;

        hSet.add(v1);
        hSet.add(v2);
        hSet.add(v3);
        hSet.add(v4);
        hSet.add(v5);
        hSet.add(v6);
        hSet.add(v7);
        hSet.add(v8);
        hSet.add(v9);
        hSet.add(v10);

        while (hSet.size() < 10) { // garante que o HashSet seja sempre igual a 10 números.
            System.out.println(">>>> Lista não atingiu o tamanho minimo de 10 itens.<<<<");
            System.out.println(">>>> novos números seram gerados pelo while.<<<<");
            Random rand2 = new Random();
            v1 = rand2.nextInt(9) + 1;
            v2 = rand2.nextInt(19) + 1;
            v3 = rand2.nextInt(59) + 1;
            v4 = rand2.nextInt(59) + 1;
            v5 = rand2.nextInt(59) + 1;
            v6 = rand2.nextInt(59) + 1;
            v7 = rand2.nextInt(59) + 1;
            v8 = rand2.nextInt(59) + 1;
            v9 = rand2.nextInt(49) + 1;
            v10 = 60;

            hSet.add(v1);
            hSet.add(v2);
            hSet.add(v3);
            hSet.add(v4);
            hSet.add(v5);
            hSet.add(v6);
            hSet.add(v7);
            hSet.add(v8);
            hSet.add(v9);
            hSet.add(v10);

            if (hSet.size() == 10) {
                break;
            }

        }


        System.out.println("Tamanho do HashSet: " + hSet.size());

        int cont = 0;
        for (int i : hSet) {
            cont++;

            lista.add(i);
            System.out.println("**********************************");
            System.out.println("Variavel contadora =: " + cont);
            System.out.println("valor de i: " + i);

        }
        Collections.sort(lista);

        saida0 = lista.get(0);
        saida1 = lista.get(1);
        saida2 = lista.get(2);
        saida3 = lista.get(3);
        saida4 = lista.get(4);
        saida5 = lista.get(5);
        saida6 = lista.get(6);
        saida7 = lista.get(7);
        saida8 = lista.get(8);
        saida9 = lista.get(9);

        System.out.println("************** final *************");
        System.out.println("Tamanho da lista1: " + lista.size());
        System.out.println("Lista ordenada1: " + lista);
        System.out.println("*********************************");

        //Para obter uma sáida deve-se usar o método HsetText() observando o tipo de dados de saída.
        // Se o tipo de dado de saída for do tipo "String", apenas o método HsetText() ja será o bastante.
        // Se o tipo de dado for outro, ex: int, double, é necessário converte-lo para String com "String.valueOf()",
        // ou concatena-lo com uma String para obter a conversão.

        // Exemplos abaixo:
        //Saída concatenando números inteiros ou ponto flutuante com String apenas.
        if (lista.size() == 16) {

            saida9 = lista.get(15);
            txtResult1.setText("Sena1:" + "\n" + "0" + saida0 + " : " + "0" + saida2 + " : " + "0" + saida4 + " : " + "0" + saida7 + " : " + "0" + saida8 + " : " + "0" + saida9);

        } else {
            txtResult1.setText("Sena1:" + "\n" + "0" + saida0 + " : " + "0" + saida2 + " : " + "0" + saida5 + " : " + "0" + saida7 + " : " + "0" + saida8 + " : " + "0" + saida9);
        }


        // OU
        //Saída com apenas números inteiros ou ponto flutuante: use o HsetText(String.valueOf()).
        //txtResult1.HsetText(String.valueOf(10.1));
        // OU
        //saída concatenando números inteiros ou ponto flutuante com "String", usando: HsetText(String.valueOf().
        //txtResult1.setText(String.valueOf("Mega Sena:" + "\n"+ "0" + sF0 + " : " + "0" + sF1 + " : " + "0" + sF5 + " : " + "0" + sF7 + " : " + "0" + sF8  + " : " + "0" + sF9));

        hSet.clear();
        lista.clear();

        geraNumerosAleatorios2();
    }


    public void geraNumerosAleatorios2() {

        Random rand3 = new Random();
        this.v1 = rand3.nextInt(9) + 1;
        this.v2 = rand3.nextInt(19) + 1;
        this.v3 = rand3.nextInt(29) + 1;
        this.v4 = rand3.nextInt(39) + 1;
        this.v5 = rand3.nextInt(49) + 1;
        this.v6 = rand3.nextInt(59) + 1;
        this.v7 = rand3.nextInt(29) + 1;
        this.v8 = rand3.nextInt(39) + 1;
        this.v9 = rand3.nextInt(49) + 1;
        this.v10 = rand3.nextInt(59) + 1;


        hSet2.add(this.v1);
        hSet2.add(this.v2);
        hSet2.add(this.v3);
        hSet2.add(this.v4);
        hSet2.add(this.v5);
        hSet2.add(this.v6);
        hSet2.add(this.v7);
        hSet2.add(this.v8);
        hSet2.add(this.v9);
        hSet2.add(this.v10);

        while (hSet2.size() < 10) { // garante que o HashSet seja sempre igual a 10 números.

            System.out.println(">>>> Lista não atingiu o tamanho minimo de 10 itens.<<<<");
            System.out.println(">>>> novos números serão gerados pelo while.<<<<");
            Random rand4 = new Random();
            this.v1 = rand4.nextInt(6) + 1;
            this.v2 = rand4.nextInt(12) + 1;
            this.v3 = rand4.nextInt(19) + 1;
            this.v4 = rand4.nextInt(19) + 1;
            this.v5 = rand4.nextInt(29) + 1;
            this.v6 = rand4.nextInt(39) + 1;
            this.v7 = rand4.nextInt(49) + 1;
            this.v8 = rand4.nextInt(59) + 1;
            this.v9 = rand4.nextInt(59) + 1;
            this.v10 = 60;

            hSet2.add(this.v1);
            hSet2.add(this.v2);
            hSet2.add(this.v3);
            hSet2.add(this.v4);
            hSet2.add(this.v5);
            hSet2.add(this.v6);
            hSet2.add(this.v7);
            hSet2.add(this.v8);
            hSet2.add(this.v9);
            hSet2.add(this.v10);

            if (hSet2.size() == 10) {
                break;
            }

        }
        System.out.println("Tamanho do HashSet2: " + hSet2.size());

        int contador = 0;
        for (Integer g : hSet2) {
            contador++;

            lista2.add(g);
            System.out.println("**********************************");
            System.out.println("Variavel contadora2 =: " + contador);
            System.out.println("Valor de hset2: " + g);

        }
        Collections.sort(lista2);

        this.saida0 = lista2.get(0);
        this.saida1 = lista2.get(1);
        this.saida2 = lista2.get(2);
        this.saida3 = lista2.get(3);
        this.saida4 = lista2.get(4);
        this.saida5 = lista2.get(5);
        this.saida6 = lista2.get(6);
        this.saida7 = lista2.get(7);
        this.saida8 = lista2.get(8);
        this.saida9 = lista2.get(9);

        System.out.println("************* final **************");
        System.out.println("Tamanho da lista2: " + lista2.size());
        System.out.println("Lista ordenada2: " + lista2);
        System.out.println("*********************************");

        txtResult2.setText("Sena2:" + "\n" + "0" + this.saida4 + " : " + "0" + this.saida5 + " : " + "0" + this.saida6 + " : " + "0" + this.saida7 + " : " + "0" + this.saida8 + " : " + "0" + this.saida9);

        hSet2.clear();
        lista2.clear();
        Toast.makeText(MainActivity.this, "Números Gerados!", Toast.LENGTH_LONG).show(); //escreve uma mensagem na tela.
    }

}

