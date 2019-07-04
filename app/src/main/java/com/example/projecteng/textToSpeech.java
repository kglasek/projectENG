package com.example.projecteng;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;

import java.util.Locale;

/**Klasa odpowiedzialna za dzialanie tekstu na mowe
 * wykorzystuje modul TextToSpeech*/

public class textToSpeech extends AppCompatActivity {
    /**  \brief tworzymy 4 property: SBSpeed, BS, speeching, ET następujących typów: SeekBar, Button, TextToSpeech oraz EditText*/
    private SeekBar SBspeed;
    private Button BS;
    private TextToSpeech speeching;
    private EditText ET;

/** \brief przeciążona funkcja onCreate odpowiedzialna za
 * przypisanie do property speeching nowego obiektu klasy TextToSpeech z przekazanymi argumentami: this (wprowadzony tekst przez użytkownika) oraz new TextToSpeech.OnInitListener()
 */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_to_speech);


        /**  \brief  przypisanie do property speeching nowego obiektu klasy TextToSpeech z przekazanymi argumentami: this (wprowadzony tekst przez użytkownika) oraz new TextToSpeech.OnInitListener()*/
        speeching = new TextToSpeech(this, new TextToSpeech.OnInitListener() {


            @Override
            public void onInit(int status) {
                double wynik;/**< deklaracja zmiennej wynik typu double,*/
                wynik = speeching.setLanguage(Locale.ENGLISH);/**< do zmiennej wynik przypisana jest wartość zwracana przez metodę setLanguage property speeching z przekazanym parametrem Locale.ENGLISH*/

/** \brief jeśli wartość zmiennej wynik jest różna od wartości property LANG_MISSING_DATA klasy TextToSpeech oraz gdy wartość zmiennej status jest równa wartości  property SUCCESS klasy TextToSpeech oraz gdy wartość zmiennej status jest różna od wartości property LANG_NOT_SUPPORTED klasy TextToSpeech
 * sprawdzamy, czy wybrany język jest obsługiwany przez TextToSpeech oraz czy status wypowiadania słów jest pozytywny (czy TextToSpeech może wypowiedzieć dane wyrazy podane przez użytkownika)*/

                if(wynik != TextToSpeech.LANG_MISSING_DATA && status == TextToSpeech.SUCCESS && wynik != TextToSpeech.LANG_NOT_SUPPORTED ){
                    BS.setEnabled(true);
                }
                else {
                    BS.setEnabled(false);
                    Log.e("TTS", "ERROR(?)."); /**< wyświetlenie komunikatu z błędem*/
                }
            }

        });


        BS = findViewById(R.id.button5);


        ET = findViewById(R.id.edit);
        SBspeed = findViewById(R.id.seek_speed);

        BS.setOnClickListener(new View.OnClickListener() {
            /** \brief przeciążona funkcja void onClick z wywołanym argumentem View v; odpowiedzialna za wypowiadanie słów*/
            @Override
            public void onClick(View v) {
                speak(); /**< aplikacja wypowiada słowa, wywołujemy funkcję speak */
            }
        });
    }
    private void speak() {
        float speed = (float) SBspeed.getProgress()/30; /**< deklarujemy zmienne speed oraz text, a następnie przypisujemy do nich odpowiednie wartości zwracanych funkcji*/

        String text = ET.getText().toString();

        speeching.setSpeechRate(speed);/**< wywołujemy metodę setSpeechRate property speeching z parametrem speed odpowiedzialną za ustawienie szybkości wypowiadania słów*/
        /** \brief wywołujemy metodę speak property speeching z parametrami text, TextToSpeech.QUEUE_ADD oraz nullem QUEUE_ADD powoduje dodawanie nowego wpisu na końcu kolejki.*/
        speeching.speak(text, TextToSpeech.QUEUE_ADD, null);

    }
}
