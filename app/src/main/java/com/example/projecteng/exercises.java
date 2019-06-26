package com.example.projecteng;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
/** Klasa odpowiada za aktywnosc zwiazana z wypelnianiem brakujacy pol
 * po wypelnieniu pol i wybraniu opcji sprawdzania prawidlowosci zadan sa przyznawane punkty*/

public class exercises extends AppCompatActivity {

    EditText e1;
    EditText e2,e3,e4;
    TextView t3;
    TextView t4,t5,t6,t7;;

    Button b1;
    String Str1 = new String("likes");
    String str2 = new String("hate");
    String str3 = new String("flies");
    String str4=new String("do you need");
    Integer score = new Integer(0);
    int counter=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises);
        e1 = (EditText)findViewById(R.id.plain_text_input);
        e2 = (EditText)findViewById(R.id.editText);
        e3 = (EditText)findViewById(R.id.editText2);
        e4 = (EditText)findViewById(R.id.editText3);
        t3=(TextView)findViewById(R.id.textView6);
        t4=(TextView)findViewById(R.id.textView7);
        t5=(TextView)findViewById(R.id.textView12);
        t6=(TextView)findViewById(R.id.textView16);
        t7=(TextView)findViewById(R.id.textView18);

        b1 = (Button)findViewById(R.id.button3);

        b1.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v) {
                String content = e1.getText().toString();
                String content2 = e2.getText().toString();
                String content3 = e3.getText().toString();
                String content4 = e4.getText().toString();

                //w instrukcjach warunkowych sprawdzana jest czy uzytkownik wypelnil poprawnie pole
                //do sprawdzania poprawnosci wykorzystywana jest funkcja equals(), ktora porownuje czy stringi sa jednakowe

                if (content.trim().equals(Str1)) {
                    t3.setTextColor(Color.GREEN);
                    t3.setText("+1");
                    //przy poprawnej odpowiedzi przyznawane sa punkty
                    counter = counter + 1;
                    updatecounter(counter);
                }
                if (content2.trim().equals(str2)) {
                    t4.setTextColor(Color.GREEN);
                    t4.setText("+1");
                    score = new Integer(score.intValue() + 1);
                    counter = counter + 1;
                    updatecounter(counter);
                }
                if (!content.trim().equals(Str1)) {
                    t3.setTextColor(Color.RED);
                    t3.setText("0");

                    counter = counter +0;
                    updatecounter(counter);
                }
                if (!content2.trim().equals(str2)) {
                    t4.setTextColor(Color.RED);
                    t4.setText("0");
                    counter = counter +0;
                    updatecounter(counter);
                }
                if (content3.trim().equals(str3)) {
                    t6.setTextColor(Color.GREEN);
                    t6.setText("+1");
                    score = new Integer(score.intValue() + 1);
                    counter = counter + 1;
                    updatecounter(counter);
                }
                if (!content3.trim().equals(str3)) {
                    t6.setTextColor(Color.RED);
                    t6.setText("0");

                    counter = counter +0;
                    updatecounter(counter);
                }
                if (content4.trim().equals(str4)) {
                    t7.setTextColor(Color.GREEN);
                    t7.setText("+1");
                    score = new Integer(score.intValue() + 1);
                    counter = counter + 1;
                    updatecounter(counter);
                }
                if (!content4.trim().equals(str4)) {
                    t7.setTextColor(Color.RED);
                    t7.setText("0");

                    counter = counter +0;
                    updatecounter(counter);
                }

            }

            private void updatecounter(int point) {
                    t5.setText("" + counter);

            }
        });
    }
}
