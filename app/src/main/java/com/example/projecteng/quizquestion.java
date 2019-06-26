package com.example.projecteng;
/** Klasa pomocnicza do klasy i aktywnosci quiz*/
//tablica stringow przechowyjaca pytania do quizu
public class quizquestion {
    public static String[] mQuestions =new String [] {
            "What is the name of United Kingdom flag?",
            "What is the capital of England?",
            "Who is called 'bobby'?",
            "What is the Queen's name?",
            "What is a double-decker?",
            "What is 'stonehenge'?",
            "Which band was John Lennon a member of in the 1960s?"

    };
//tablica stringow przechowujaca odpowiedzi do quizu

    private String mChoices [][] = {
            {"Black Jack", "Union Jack", "United FLag"},
            {"London", "Liverpool", "Dublin"},
            {"a fire fighter in Cardiff", "a police officer in London", "a waitress in Manchester"},
            {"Queen Ela I", "Queen Margaret IV", "Queen Elizabeth II"},
            {"A bus","A chocolate bar","A taxi"},
            {"a palace","a prehistoric monument","an old castle"},
            {"Sex Pistols","The Beatles","The Police"}

    };



    //tablica stringow przechowujaca prawidlowe odpowiedzi do pytan
    public String mCorrectAnswers[] = {"Union Jack", "London", "a police officer in London", "Queen Elizabeth II","A bus","a prehistoric monument","The Beatles"};


//metody

    public String getQuestion(int a) {
        String question = mQuestions[a];
        return question;
    }


    public String getChoice1(int a) {
        String choice0 = mChoices[a][0];
        return choice0;
    }


    public String getChoice2(int a) {
        String choice1 = mChoices[a][1];
        return choice1;
    }

    public String getChoice3(int a) {
        String choice2 = mChoices[a][2];
        return choice2;
    }

    public String getCorrectAnswer(int a) {
        String answer = mCorrectAnswers[a];
        return answer;
    }
}
