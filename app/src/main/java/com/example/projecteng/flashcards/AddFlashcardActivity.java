package com.example.projecteng.flashcards;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.projecteng.R;
import com.example.projecteng.entity.Flashcard;
/** Klasa odpowiedzialna za dodawanie fiszek*/
public class AddFlashcardActivity extends AppCompatActivity {
/** \brief pola tekstowe i przycisk*/
    private EditText english;
    private EditText polish;
    private Button submit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_flashcard_activity);

        this.english = (EditText) findViewById(R.id.english);
        this.polish = (EditText) findViewById(R.id.polish);
        this.submit = (Button) findViewById(R.id.submit);

        this.submit.setOnClickListener(new View.OnClickListener() {
            /** \brief funckja odpowiedzialna za wstawianie nowych fiszek*/
            @Override
            public void onClick(View v) {
                String englishWord = english.getText().toString(); /**< string odpowiedzialny za pole tekstowe które pobiera informacje od użytkownika*/
                String polishWord = polish.getText().toString(); /**< string odpowiedzialny za pole tekstowe które pobiera informacje od użytkownika*/
        /** \brief instrukcja warunkowa sprawdzająca prawidłowo wprowadzone dane
         *  przy błędnie wprowadzonych wyświetla błąd
         *  przy poprawnych tworzy nową instancje w bazies
         */
                if (englishWord.isEmpty() || polishWord.isEmpty()) {
                    TextView errorText = (TextView) findViewById(R.id.error);
                    errorText.setVisibility(View.VISIBLE);
                } else {
                    FlashcardCrud flashcardCrud = FlashcardCrud.getInstance();
                    flashcardCrud.create(new Flashcard(englishWord, polishWord));

                    Intent flashcards = new Intent(AddFlashcardActivity.this, FlashcardsActivity.class);
                    startActivity(flashcards);
                }
            }
        });
    }
}
