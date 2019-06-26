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
    private questionsRewrite senttext = new questionsRewrite();
    private TextView mScoreView;
    private TextView mQuestionView;
    private EditText mEditText;
    private Button mButtonChoice1;
    private Button mButtonChoice2;

    private String mAnswer;
    private int mScore = 0;
    private int sentenceNumber = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rewrite_sent);
        mScoreView = (TextView)findViewById(R.id.score);
        mQuestionView = (TextView)findViewById(R.id.question);
        mEditText = (EditText)findViewById(R.id.editText3);
        mButtonChoice1 = (Button)findViewById(R.id.check);
        mButtonChoice2 = (Button)findViewById(R.id.quit);

        updateQuestion();

        mButtonChoice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = mEditText.getText().toString();
                if (content.trim().equals(mAnswer)){
                    mScore++;
                    updateScore(mScore);

                    //perform check before you update the question
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

    private void updateQuestion(){
        mQuestionView.setText(senttext.getSentence(sentenceNumber));
        mAnswer = senttext.getCorrectAnswer(sentenceNumber);
        sentenceNumber++;
    }


    private void updateScore(int point) {
        mScoreView.setText("" + mScore);
    }
}
