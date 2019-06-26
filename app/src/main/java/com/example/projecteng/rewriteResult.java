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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rewrite_result);
        mGrade = (TextView)findViewById(R.id.grade);
        mFinalScore = (TextView)findViewById(R.id.outOf);
        mRetryButton = (Button)findViewById(R.id.retry);
        endButton = (Button)findViewById(R.id.end);
        Bundle bundle = getIntent().getExtras();
        int score = bundle.getInt("finalScore");

        //wypisywanie ilosci punktow

        mFinalScore.setText("You scored " + score + " out of " + questionsRewrite.sentences.length);

        //instrukcje warunkowe ktore wyswietlaja napis zalezny od zdobytej ilosci punktow

        if (score == 5){
            mGrade.setText("Outstanding");
        }else if (score == 4){
            mGrade.setText("Good Work");
        }else if (score == 3) {
            mGrade.setText("Good Effort");
        }else {
            mGrade.setText("Go over your notes");
        }

        //przyciski odpowiedzialne za powrot do menu glownego i rozpoczecia od nowa

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
