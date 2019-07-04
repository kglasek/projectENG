package com.example.projecteng;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
/**Klasa odpowiedzialna za wypisywanie wyniku koncowego aktywnosci do przepisywania zdan w poprawnej kolejnosci*/
public class rewriteResult extends AppCompatActivity {
    private TextView mGrade, mFinalScore;
    private Button mRetryButton;
    private Button endButton;

    /** \brief funckcja odpowiedzialna za przypisanie aktywacji do przycisków oraz za wyświetlanie wyników
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rewrite_result);

        /** \brief pola tekstowe i przyciski
         */
        mGrade = (TextView)findViewById(R.id.grade);
        mFinalScore = (TextView)findViewById(R.id.outOf);
        mRetryButton = (Button)findViewById(R.id.retry);
        endButton = (Button)findViewById(R.id.end);
        Bundle bundle = getIntent().getExtras();
        int score = bundle.getInt("finalScore"); /**< int określający zdobyte punkty; pobiera z wyniku klasy rewriteSent*/

        mFinalScore.setText("You scored " + score + " out of " + questionsRewrite.sentences.length); /**< wypisywanie ilości punktów*/

        /** \brief instrukcje warunkowe, które wyświetlają napis zależny od zdobytej ilości punktów*/

        if (score == 5){
            mGrade.setText("Outstanding");
        }else if (score == 4){
            mGrade.setText("Good Work");
        }else if (score == 3) {
            mGrade.setText("Good Effort");
        }else {
            mGrade.setText("Go over your notes");
        }

        /** \brief przyciski odpowiedzialne za powrót do menu głównego i rozpoczęcia quizu od nowa
         */
        mRetryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(rewriteResult.this, rewriteSent.class));
                rewriteResult.this.finish();
            }
        });
        endButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(rewriteResult.this,MainActivity.class));
                rewriteResult.this.finish();
            }
        });



    }
}
