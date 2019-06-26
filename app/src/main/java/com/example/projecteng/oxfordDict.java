package com.example.projecteng;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/** Klasa odpowiedzialna za funkcjonowanie slownika angielskiego wykorzystujacego REST API  brytyjskiej uczelni Oxford*
 * wykorzystuje ona klase pomocnicza Request sluzaca do nazwiazania polaczenia z REST API
 */


public class oxfordDict extends AppCompatActivity {

    EditText edit1;
    private TextView Meaning;
    private TextView example;

    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oxford_dict);
        Meaning = findViewById(R.id.Meaning);
        example = findViewById(R.id.example);

        edit1 = findViewById(R.id.editText);
    }

    public void requestApiButtonClick(View v){
        url = dictionaryEntries();
        Request request = new Request(this, Meaning, example);
        request.execute(url);
    }

    private String dictionaryEntries() {
        final String language = "en";
        final String word = edit1.getText().toString();
        final String fields = "pronunciations";
        final String strictMatch = "false";
        final String word_id = word.toLowerCase();
        return "https://od-api.oxforddictionaries.com:443/api/v1/entries/" + language + "/" + word_id;
    }

}
