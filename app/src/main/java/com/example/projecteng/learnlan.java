package com.example.projecteng;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.projecteng.flashcards.FlashcardsActivity;
public class learnlan extends AppCompatActivity {

/** Klasa sluzaca do wyboru aktywnosci zwiazanych z: czasami, zadaniami i fiszkami*/
    public Button przyciskczasy;   /**< przycisk odpowiedzialny za przejście do czasów w języku angielskim*/
    public Button przyciskzadania;  /**< przycisk odpowiedzialny za przejście do zadań*/
    public Button flashcardsButton;  /**< przycisk odpowiedzialny za przejście do fiszek*/
    /** \brief  Funkcja służąca do aktywacji przycisków
     * wyszukuje w przycisk na podstawie ID, i za pomocą intecji po wybraniu przycisku przechodzi do następnej aktywności
     */
    public void init()
    {
        przyciskczasy=(Button)findViewById(R.id.czasy);
        przyciskczasy.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View v) {
                                             Intent czlearn = new Intent(learnlan.this,engczasy.class);
                                             startActivity(czlearn);
                                         }
                                     }
        );
        przyciskzadania=(Button)findViewById(R.id.button4);
        przyciskzadania.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View v) {
                                             Intent zadan = new Intent(learnlan.this,chooseex.class);
                                             startActivity(zadan);
                                         }
                                     }
        );

        flashcardsButton = (Button)findViewById(R.id.flashcards);
        flashcardsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent flashcards = new Intent(learnlan.this, FlashcardsActivity.class);
                startActivity(flashcards);
            }
        });

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learnlan);
        init();
    }
}
