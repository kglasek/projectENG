package com.example.projecteng;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.io.IOException;
import java.io.InputStream;

/**Klasa obsluguje wyswietlanie wybranego czasu, zeby zmienic czas trzeba wybrać przycisk odpowiadajacy za zmiane tresci
 * przy wyborze czasu zostaje wyswietlony opis
 * opisy sa pobierane z plikow tekstowych i wypisywane na ekranie w polu tekstowym*/

public class engczasy extends AppCompatActivity {
    TextView simpletext;
    private Button presentsimple;
    private Button presentcont;
    private Button presentperf;
    private Button pastsimp;
    private Button pastcont;
    private Button pastperf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_engczasy);

       /*zmapowane przyciski*/
        presentsimple = (Button)findViewById(R.id.presentsimp);
        simpletext = (TextView) findViewById(R.id.showtext);
        presentcont = (Button)findViewById(R.id.prescont);
        presentperf=(Button)findViewById(R.id.presperf);
        pastsimp=(Button)findViewById(R.id.pastsimp);
        pastcont=(Button)findViewById(R.id.pastcont);
        pastperf=(Button)findViewById(R.id.pastperf);

        /*do wyboru czasu w jezyku angielskim zostaly uzyte Buttony, ktore przy wyborze zmieniaja wyswietlany tekst
        * Uzyta zostala funkcja setOnClickListener do dzialania przycisku*/
        presentsimple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                simpletext.setMovementMethod(new ScrollingMovementMethod());
                String text="";
                try{
                    //za pomoca funkcji InputStream wyciagane sa dane z pliku tekstowego
                    InputStream is = getAssets().open("presentsimp.txt");
                    int size =is.available();
                    byte[] buffer=new byte[size];
                    is.read(buffer);
                    is.close();
                    text=new String(buffer);
                }
                catch (IOException ex)
                {
                    ex.printStackTrace();
                }
                simpletext.setText(text);
            }
        });

        //czynnosci dla kazdego przysku sa takie same

        presentcont.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                simpletext.setMovementMethod(new ScrollingMovementMethod());
                String text="";
                try{
                    InputStream is = getAssets().open("presentcont.txt");

                    int size =is.available();
                    byte[] buffer=new byte[size];
                    is.read(buffer);
                    is.close();
                    text=new String(buffer);
                }
                catch (IOException ex)
                {
                    ex.printStackTrace();
                }
                simpletext.setText(text);
            }
        });

        presentperf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                simpletext.setMovementMethod(new ScrollingMovementMethod());
                String text="";
                try{
                    InputStream is = getAssets().open("presentperf.txt");
                    int size =is.available();
                    byte[] buffer=new byte[size];
                    is.read(buffer);
                    is.close();
                    text=new String(buffer);
                }
                catch (IOException ex)
                {
                    ex.printStackTrace();
                }
                simpletext.setText(text);
            }
        });

        pastsimp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                simpletext.setMovementMethod(new ScrollingMovementMethod());
                String text="";
                try{
                    InputStream is = getAssets().open("pastsimp.txt");
                    int size =is.available();
                    byte[] buffer=new byte[size];
                    is.read(buffer);
                    is.close();
                    text=new String(buffer);
                }
                catch (IOException ex)
                {
                    ex.printStackTrace();
                }
                simpletext.setText(text);
            }
        });
        pastcont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                simpletext.setMovementMethod(new ScrollingMovementMethod());
                String text="";
                try{
                    InputStream is = getAssets().open("pastcont.txt");
                    int size =is.available();
                    byte[] buffer=new byte[size];
                    is.read(buffer);
                    is.close();
                    text=new String(buffer);
                }
                catch (IOException ex)
                {
                    ex.printStackTrace();
                }
                simpletext.setText(text);
            }
        });

        pastperf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                simpletext.setMovementMethod(new ScrollingMovementMethod());
                String text="";
                try{
                    InputStream is = getAssets().open("pastperf.txt");
                    int size =is.available();
                    byte[] buffer=new byte[size];
                    is.read(buffer);
                    is.close();
                    text=new String(buffer);
                }
                catch (IOException ex)
                {
                    ex.printStackTrace();
                }
                simpletext.setText(text);
            }
        });
    }
}
