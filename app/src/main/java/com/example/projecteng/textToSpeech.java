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
    private SeekBar SBspeed;
    private Button BS;
    private TextToSpeech speeching;
    private EditText ET;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_to_speech);

        speeching = new TextToSpeech(this, new TextToSpeech.OnInitListener() {


            @Override
            public void onInit(int status) {
                double wynik;
                wynik = speeching.setLanguage(Locale.ENGLISH);

                if(wynik != TextToSpeech.LANG_MISSING_DATA && status == TextToSpeech.SUCCESS && wynik != TextToSpeech.LANG_NOT_SUPPORTED ){
                    BS.setEnabled(true);
                }
                else {
                    BS.setEnabled(false);
                    Log.e("TTS", "ERROR(?).");
                }
            }

        });


        BS = findViewById(R.id.button5);


        ET = findViewById(R.id.edit);
        SBspeed = findViewById(R.id.seek_speed);

        BS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak();
            }
        });
    }
    private void speak() {
        float speed = (float) SBspeed.getProgress()/30;
        String text = ET.getText().toString();

        speeching.setSpeechRate(speed);
        speeching.speak(text, TextToSpeech.QUEUE_ADD, null);

    }
}
