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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizresults);
        mGrade = (TextView)findViewById(R.id.grade);
        mFinalScore = (TextView)findViewById(R.id.outOf);
        mRetryButton = (Button)findViewById(R.id.retry);
        endButton = (Button)findViewById(R.id.end);


        Bundle bundle = getIntent().getExtras();
        int score = bundle.getInt("finalScore");

        //wypisywanie ilosci punktow

        mFinalScore.setText("You scored " + score + " out of " + quizquestion.mQuestions.length);

        //instrukcje warunkowe ktore wyswietlaja napis zalezny od zdobytej ilosci punktow

        if (score == 9){
            mGrade.setText("Outstanding");
        }else if (score == 8){
            mGrade.setText("Good Work");
        }else if (score == 7) {
            mGrade.setText("Good Effort");
        }else {
            mGrade.setText("Go over your notes");
        }

        //przyciski odpowiedzialne za powrot do menu glownego i rozpoczecia quizu od poczatku

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
