package com.example.projecteng;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;
/**Klasa odpowiadajaca za wyswietlanie wyniku koncowego quizu, zwraca ona ilosc zdobytych punktow
 *  oraz posiada mozliwosc przejsca do menu glownego i rozpoczecia quizu od poczatku*/
public class quizresults extends AppCompatActivity {
    private TextView mGrade, mFinalScore;
    private Button mRetryButton;
    private Button endButton;
    /** \brief funckcja odpowiedzialna za przypisanie aktywacji do przycisków oraz za wyświetlanie wyników
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizresults);
        /** \brief pola tekstowe i przyciski
         */
        mGrade = (TextView)findViewById(R.id.grade);
        mFinalScore = (TextView)findViewById(R.id.outOf);
        mRetryButton = (Button)findViewById(R.id.retry);
        endButton = (Button)findViewById(R.id.end);


        Bundle bundle = getIntent().getExtras();
        int score = bundle.getInt("finalScore"); /**< int określający zdobyte punkty; pobiera z wyniku klasy quiz*/

        mFinalScore.setText("You scored " + score + " out of " + quizquestion.mQuestions.length);  /**< wypisywanie ilości punktów*/

        /** \brief instrukcje warunkowe, które wyświetlają napis zależny od zdobytej ilości punktów*/
        if (score == 9){
            mGrade.setText("Outstanding");
        }else if (score == 8){
            mGrade.setText("Good Work");
        }else if (score == 7) {
            mGrade.setText("Good Effort");
        }else {
            mGrade.setText("Go over your notes");
        }

        /** \brief przyciski odpowiedzialne za powrót do menu głównego i rozpoczęcia quizu od nowa
         */
        mRetryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(quizresults.this, quiz.class));
                quizresults.this.finish();
            }
        });
        endButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(quizresults.this,MainActivity.class));
                quizresults.this.finish();
            }
        });


    }
}
