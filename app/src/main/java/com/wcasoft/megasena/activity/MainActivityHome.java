package com.wcasoft.megasena.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.wcasoft.megasena.R;

public class MainActivityHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setTheme(R.style.Theme_Splash); //muda o tema da com.wcasoft.megasena.com.wcasoft.megasena.activity.
            setContentView(R.layout.activity_main_home);

            Thread thread = new Thread(){
                public void run(){
                    try{

                        sleep(3500);
                    }catch(Exception e){
                        e.printStackTrace();
                    }finally {
                        //startActivity(new Intent(MainActivityHome.this, MainActivity.class));
                        Intent ini = new Intent(MainActivityHome.this, MainActivity.class);
                        startActivity(ini);
                    }

                }
            };thread.start();


    }

}
