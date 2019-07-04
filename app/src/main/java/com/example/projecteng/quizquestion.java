package com.example.projecteng;
/** Klasa pomocnicza do klasy i aktywnosci quiz*/


public class quizquestion {
    /** \brief  tablice stringów przechowujące pytania i prawidlowe odpowiedzi
     */
    public static String[] mQuestions =new String [] {
            "What is the name of United Kingdom flag?",
            "What is the capital of England?",
            "Who is called 'bobby'?",
            "What is the Queen's name?",
            "What is a double-decker?",
            "What is 'stonehenge'?",
            "Which band was John Lennon a member of in the 1960s?"

    };


    private String mChoices [][] = {
            {"Black Jack", "Union Jack", "United FLag"},
            {"London", "Liverpool", "Dublin"},
            {"a fire fighter in Cardiff", "a police officer in London", "a waitress in Manchester"},
            {"Queen Ela I", "Queen Margaret IV", "Queen Elizabeth II"},
            {"A bus","A chocolate bar","A taxi"},
            {"a palace","a prehistoric monument","an old castle"},
            {"Sex Pistols","The Beatles","The Police"}

    };

    public String mCorrectAnswers[] = {"Union Jack", "London", "a police officer in London", "Queen Elizabeth II","A bus","a prehistoric monument","The Beatles"};


    /** \brief Funkcja odpowiedzialna za zwracanie stringów z pytaniami
     * @param a parametr określający numer pytania w tablicy
     * @return  zwraca pytanie
     */

    public String getQuestion(int a) {
        String question = mQuestions[a];
        return question;
    }

    /** \brief Funkcja odpowiedzialna za zwracanie stringów z wyborami
     * @param a parametr określający numer dostępnej odpowiedzi w tablicy
     * @return  zwraca wybor odpowiedzi
     */
    public String getChoice1(int a) {
        String choice0 = mChoices[a][0];
        return choice0;
    }
    /** \brief Funkcja odpowiedzialna za zwracanie stringów z wyborami
     * @param a parametr określający numer dostępnej odpowiedzi w tablicy
     * @return  zwraca wybor odpowiedzi
     */

    public String getChoice2(int a) {
        String choice1 = mChoices[a][1];
        return choice1;
    }
    /** \brief Funkcja odpowiedzialna za zwracanie stringów z wyborami
     * @param a parametr określający numer dostępnej odpowiedzi w tablicy
     * @return  zwraca wybor odpowiedzi
     */
    public String getChoice3(int a) {
        String choice2 = mChoices[a][2];
        return choice2;
    }
    /** \brief Funkcja odpowiedzialna za zwracanie stringów z prawidłową odpowiedzią
     * @param a parametr określający numer prawidłowej odpowiedzi w tablicy
     * @return  zwraca prawidłową odpowiedź
     */
    public String getCorrectAnswer(int a) {
        String answer = mCorrectAnswers[a];
        return answer;
    }
}
