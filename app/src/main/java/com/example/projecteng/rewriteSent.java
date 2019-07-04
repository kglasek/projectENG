package com.example.projecteng;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
/** Klasa, ktora odpowiada za funkcjonowanie aktywnosci zwiazanej z przepisywaniem zdan w odpowiedniej kolejnosci
 * uzywa ona pomocniczej klasy zawierajacej tablice stringow ze zdaniami oraz prawidlowymi odpowiedziami*/

public class rewriteSent extends AppCompatActivity {
    /** \brief pola tekstowe i przycisku
     */
    private questionsRewrite senttext = new questionsRewrite();  /**< tworzenie obiektu z nowym pytaniem*/
    private TextView mScoreView;
    private TextView mQuestionView;
    private EditText mEditText;
    private Button mButtonChoice1;
    private Button mButtonChoice2;

    private String mAnswer; /**< string zawierający prawidłową odpowiedź*/
    private int mScore = 0;  /**< licznik punktów ustawiony na 0*/
    private int sentenceNumber = 0; /**< licznik pytań ustawiony na 0*/

    /** \brief funkcja odpowiedzialna za tworzenie, wyświetlanie i wybór pytań
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rewrite_sent);
        mScoreView = (TextView)findViewById(R.id.score);
        mQuestionView = (TextView)findViewById(R.id.question);
        mEditText = (EditText)findViewById(R.id.editText3);
        mButtonChoice1 = (Button)findViewById(R.id.check);
        mButtonChoice2 = (Button)findViewById(R.id.quit);

        updateQuestion(); /**< wywołanie funkcji do aktualizacji pytania*/

        mButtonChoice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = mEditText.getText().toString();
                if (content.trim().equals(mAnswer)){
                    mScore++; /**< inkrementuje wynik przy poprawnej odpowiedzi*/
                    updateScore(mScore); /**< aktualizuje wyświetlany licznik punktów*/

                    /** \brief sprawdza ilość pytań przed zaktualizowaniem pytania
                     * jeśli ilość pytań doszła do końca, zostaje dokonane przyjście do ekranu wyników*/
                    if (sentenceNumber == questionsRewrite.sentences.length) {


                       Intent i = new Intent(rewriteSent.this, rewriteResult.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("finalScore", mScore);
                        i.putExtras(bundle);
                        rewriteSent.this.finish();
                        startActivity(i);
                    } else {
                        updateQuestion();
                    }
                }
                else {
                    if (sentenceNumber == questionsRewrite.sentences.length) {

                       Intent i = new Intent(rewriteSent.this, rewriteResult.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("finalScore", mScore);
                        i.putExtras(bundle);
                        rewriteSent.this.finish();
                        startActivity(i);
                    } else {
                        updateQuestion();
                    }
                }
            }
        });
        mButtonChoice2.setOnClickListener(new View.OnClickListener() {
            @Override
            /** \brief funckja przenosi po naciśnieciu przycisku od razu do ekranu końcowego*/
            public void onClick(View v) {
                Intent i = new Intent(rewriteSent.this, rewriteResult.class);
                Bundle bundle = new Bundle();
                bundle.putInt("finalScore", mScore);
                i.putExtras(bundle);
                rewriteSent.this.finish();
                startActivity(i);
            }
        });
    }
    /** \brief Funkcja odpowiedzialna za aktualizowanie pytań
     */
    private void updateQuestion(){

        mQuestionView.setText(senttext.getSentence(sentenceNumber)); /**< wypisuje pytanie */
        mAnswer = senttext.getCorrectAnswer(sentenceNumber); /**< zmienna pobierajaca prawidłową odpowiedź*/
        sentenceNumber++;  /**< inkrementacja pytania*/
    }

    /** \brief Funkcja odpowiedzialna za aktualizowanie ilości punktów za prawidłowe odpowiedzi
     * @param point parametr określający ilość punktów
     */
    private void updateScore(int point) {
        mScoreView.setText("" + mScore);
    }
}
