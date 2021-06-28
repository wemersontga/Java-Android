package com.wcasoft.megasena;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivityHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_Splash); //muda o tema da activity.
            setContentView(R.layout.activity_main_home);

            Thread thread = new Thread(){
                public void run(){
                    try{

                        sleep(5000);
                    }catch(Exception e){
                        e.printStackTrace();
                    }finally {
                        Intent ini = new Intent(MainActivityHome.this, MainActivity.class);
                        startActivity(ini);
                    }

                }
            };thread.start();


    }

}
