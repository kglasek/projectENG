package com.example.projecteng;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
/**klasa odpowiedzialna za dzialanie aktywnosci zwiazanej z quizem,
 * wykorzystuje ona pomocnicza klase quizquestions.java, ktora odpowiada za przechowywanie tablicy stringow z pytaniami i odpowiedziami*/

public class quiz extends AppCompatActivity {
    /** \brief pola tekstowe i przycisku
     */
    private quizquestion qquestion = new quizquestion(); /**< tworzenie obiektu z nowym pytaniem*/
    private TextView mScoreView;
    private TextView mQuestionView;
    private Button mButtonChoice1;
    private Button mButtonChoice2;
    private Button mButtonChoice3;
    private Button mButtonChoice4;

    private String mAnswer; /**< string zawierający prawidłową odpowiedź*/
    private int mScore = 0; /**< licznik punktów ustawiony na 0*/
    private int mQuestionNumber = 0; /**< licznik pytań ustawiony na 0*/

    /** \brief funkcja odpowiedzialna za tworzenie, wyświetlanie i wybór pytań
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        mScoreView = (TextView)findViewById(R.id.score);
        mQuestionView = (TextView)findViewById(R.id.question);
        mButtonChoice1 = (Button)findViewById(R.id.choice1);
        mButtonChoice2 = (Button)findViewById(R.id.choice2);
        mButtonChoice3 = (Button)findViewById(R.id.choice3);
        mButtonChoice4 = (Button)findViewById(R.id.quit);

        updateQuestion(); /**< wywołanie funkcji do aktualizacji pytania*/

        mButtonChoice1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                if (mButtonChoice1.getText() == mAnswer){
                    mScore++; /**< inkrementuje wynik przy poprawnej odpowiedzi*/
                    updateScore(mScore); /**< aktualizuje wyświetlany licznik punktów*/

                    /** \brief sprawdza ilość pytań przed zaktualizowaniem pytania
                     * jeśli ilość pytań doszła do końca, zostaje dokonane przyjście do ekranu wyników*/
                    if (mQuestionNumber == quizquestion.mQuestions.length) {
                        Intent i = new Intent(quiz.this, quizresults.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("finalScore", mScore);
                        i.putExtras(bundle);
                        quiz.this.finish();
                        startActivity(i);
                    } else {
                        updateQuestion();
                    }
                }
                else {
                    if (mQuestionNumber == quizquestion.mQuestions.length) {
                        Intent i = new Intent(quiz.this, quizresults.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("finalScore", mScore);
                        i.putExtras(bundle);
                        quiz.this.finish();
                        startActivity(i);
                    } else {
                        updateQuestion();
                    }
                }
            }
        });

        mButtonChoice2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if (mButtonChoice2.getText() == mAnswer){
                    mScore++;
                    updateScore(mScore);

                    /** \brief sprawdza ilość pytań przed zaktualizowaniem pytania
                     * jeśli ilość pytań doszła do końca, zostaje dokonane przyjście do ekranu wyników*/
                    if (mQuestionNumber == quizquestion.mQuestions.length) {
                        Intent i = new Intent(quiz.this, quizresults.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("finalScore", mScore);
                        i.putExtras(bundle);
                        quiz.this.finish();
                        startActivity(i);
                    } else {
                        updateQuestion();
                    }
                }
                else {
                    if (mQuestionNumber == quizquestion.mQuestions.length) {
                        Intent i = new Intent(quiz.this, quizresults.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("finalScore", mScore);
                        i.putExtras(bundle);
                        quiz.this.finish();
                        startActivity(i);
                    } else {
                        updateQuestion();
                    }
                }
            }
        });
        mButtonChoice3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                if (mButtonChoice3.getText() == mAnswer){
                    mScore++;
                    updateScore(mScore);

                    /** \brief perform check before you update the question*/
                    if (mQuestionNumber == quizquestion.mQuestions.length) {
                        Intent i = new Intent(quiz.this, quizresults.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("finalScore", mScore);
                        i.putExtras(bundle);
                        quiz.this.finish();
                        startActivity(i);
                    } else {
                        updateQuestion();
                    }
                }
                else {
                    if (mQuestionNumber == quizquestion.mQuestions.length) {
                        Intent i = new Intent(quiz.this, quizresults.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("finalScore", mScore);
                        i.putExtras(bundle);
                        quiz.this.finish();
                        startActivity(i);
                    } else {
                        updateQuestion();
                    }
                }
            }
        });
        /** \brief funckja przenosi po naciśnieciu przycisku od razu do ekranu końcowego*/
        mButtonChoice4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(quiz.this, quizresults.class);
                Bundle bundle = new Bundle();
                bundle.putInt("finalScore", mScore);
                i.putExtras(bundle);
                quiz.this.finish();
                startActivity(i);
            }
        });
    }
    /** \brief Funkcja odpowiedzialna za aktualizowanie pytań
     */
    private void updateQuestion(){
        /** \brief ustawianie pytania i 3 możliwych odpowiedzi
         */
        mQuestionView.setText(qquestion.getQuestion(mQuestionNumber));
        mButtonChoice1.setText(qquestion.getChoice1(mQuestionNumber));
        mButtonChoice2.setText(qquestion.getChoice2(mQuestionNumber));
        mButtonChoice3.setText(qquestion.getChoice3(mQuestionNumber));

        mAnswer = qquestion.getCorrectAnswer(mQuestionNumber);  /**< zmienna pobierajaca prawidłową odpowiedź*/
        mQuestionNumber++;  /**< inkrementacja pytania*/
    }

    /** \brief Funkcja odpowiedzialna za aktualizowanie ilości punktów za prawidłowe odpowiedzi
     *      * @param point parametr określający ilość punktów
     */
    private void updateScore(int point) {
        mScoreView.setText("" + mScore);
    }
}
