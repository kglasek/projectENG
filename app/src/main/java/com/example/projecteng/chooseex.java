package com.example.projecteng;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
/** Klasa sluzaca do wyboru aktywnosci zwiazanych z zadaniami do wypelnienia*/
public class chooseex extends AppCompatActivity {

    public Button przyciskpress; /**< przycisk odpowiedzialny za przejście do zadań przez wstawianie*/
    public Button rewritesent; /**< przycisk odpowiedzialny za przejście do zadań do wypełnienia*/
    /** \brief  Funkcja służąca do aktywacji przycisków w wyborze zadań do rozwiązania
     * wyszukuje w przycisk na podstawie ID, i za pomocą intecji po wybraniu przycisku przechodzi do następnej aktywności
     */
    public void init()
    {
        /*wykorzystana została metoda setOnClickListener, ktora pobiera informacje o nacisnieciu przycisku i przechodzi do nastepnej aktywnosci*/
        przyciskpress=(Button)findViewById(R.id.presentsimp);
        przyciskpress.setOnClickListener(new View.OnClickListener() {
                                             @Override
                                             public void onClick(View v) {
                                                 Intent czlearn = new Intent(chooseex.this,exercises.class);
                                                 startActivity(czlearn);
                                             }
                                         }
        );
        rewritesent=(Button)findViewById(R.id.presentcont);
        rewritesent.setOnClickListener(new View.OnClickListener() {
                                               @Override
                                               public void onClick(View v) {
                                                   Intent zadan = new Intent(chooseex.this,rewriteSent.class);
                                                   startActivity(zadan);
                                               }
                                           }
        );
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chooseex);
        init();
    }
}



