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
    /** \brief tworzymy 3 property: edit1, meaning, example następujących typów: EditText, TextView oraz TextView*/
    EditText edit1;
    private TextView Meaning;
    private TextView example;

    String url; /**< deklarujemy zmienną url typu String, w której będziemy przechowywać adres URL do API Oxford Dictionaries ze wskazanym językiem oraz ID danego slowa */

    /** \brief  tworzymy przeciążoną funkcję onCreate z argumentem Bundle savedInstanceState, w której przypisujemy naszym properties odpowiednie wartości*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oxford_dict);
        Meaning = findViewById(R.id.Meaning); /**< do property Meaning przypisujemy wartość zwracaną przez metodę findViewById z parametrem R.id.Meaning; przypisujemy do property Meaning ID naszego pola tekstowego, w którym ukazuje się znaczenie naszego wpisywanego wyrazu */
        example = findViewById(R.id.example); /**< do property example przypisujemy wartość zwracaną przez metodę findViewById z parametrem R.id.example; przypisujemy do property example ID naszego pola tekstowego, w którym ukazuje się przykładowe zdanie z naszym wyrazem */

        edit1 = findViewById(R.id.editText); /**< do property edit1 przypisujemy wartość zwracaną przez metodę findViewById z parametrem R.id.editText; przypisujemy do property edit1 ID naszego pola tekstowego formularza, w którym wpisujemy szukane słowo*/

    }
/** \brief  funkcja void requestApiButtonClick z argumentem View v
 * odpowiedzialna za tworzenie obiektu na podstawie klasy request
 * pobiera dane z api*/
    public void requestApiButtonClick(View v){
        url = dictionaryEntries(); /**< do zmiennej URL przypisujemy wartość zwracaną przez funkcję dictionaryEntries - tzw. "wygenerowany URL" przez tą funkcję, który jest dla każdego słowa unikalny*/
        Request request = new Request(this, Meaning, example); /**< tworzymy obiekt request klasy Request z parametrami this, Meaning, example*/
        request.execute(url); /**< wywołujemy metodę execute property request z parametrem url, dzięki czemu otrzymujemy zwracany generowany URL w postaci tekstowej*/

    }
    /** \brief   funkcja odpowiedzialna za zwracanie wygenerowanego dla każdego słowa URL */
    private String dictionaryEntries() {
        final String language = "en"; /**< wybieramy język angielski */
        final String word = edit1.getText().toString(); /**< do stałej zmiennej word typu String przypisujemy wartość zwracaną przez metodę getText().toString() property edit1; wskazujemy, aby wpisywane przez nas słowo było zapisywane do stałej*/
        final String fields = "pronunciations"; /**< bez znaczenia, nie jest wykorzystywane*/
        final String strictMatch = "false";
        final String word_id = word.toLowerCase(); /**< konwerujemy nasze słowo na małe litery*/
        return "https://od-api.oxforddictionaries.com:443/api/v1/entries/" + language + "/" + word_id; /**< zwracamy generowany URL*/
    }

}
