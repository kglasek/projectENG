package com.example.projecteng;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
/** Klasa glownej aktywnosci sluzy ona jako menu glowne*/
public class MainActivity extends AppCompatActivity {

    private Button buttonone;  /**< przycisk odpowiedzialny za przejście do menu z wyborem aktywnosci zwiazanych z: czasami, zadaniami i fiszkami*/
    private Button thirdbutton;  /**< przycisk odpowiedzialny za przejście do quizu*/
    private Button fourthbutton;  /**< przycisk odpowiedzialny za przejście do słownika*/
    private Button nextButton;  /**< przycisk odpowiedzialny za przejście do tekstu na mowę*/
    /** \brief  Funkcja służąca do aktywacji przycisków
     * wyszukuje w przycisk na podstawie ID, i za pomocą intecji po wybraniu przycisku przechodzi do następnej aktywności
     */
    private void init()
    {
        buttonone=(Button)findViewById(R.id.button);
        buttonone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent exerc = new Intent(MainActivity.this,learnlan.class);
                startActivity(exerc);
            }
        }
        );
        thirdbutton=(Button)findViewById(R.id.button3);
        thirdbutton.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View v) {
                                             Intent quiz = new Intent(MainActivity.this,quiz.class);
                                             startActivity(quiz);
                                         }
                                     }
        );
       fourthbutton=(Button)findViewById(R.id.button4);
        fourthbutton.setOnClickListener(new View.OnClickListener() {
                                           @Override
                                           public void onClick(View v) {
                                               Intent oxfordD = new Intent(MainActivity.this,oxfordDict.class);
                                               startActivity(oxfordD);
                                           }
                                       }
        );
        nextButton=(Button)findViewById(R.id.button6);
        nextButton.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                Intent ttosp = new Intent(MainActivity.this,textToSpeech.class);
                                                startActivity(ttosp);
                                            }
                                        }
        );
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
}
