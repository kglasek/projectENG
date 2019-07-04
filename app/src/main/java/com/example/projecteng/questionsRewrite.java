package com.example.projecteng;
/** Klasa pomocnicza do aktywnosci z przepisywaniem zadan w prawidlowej kolejnosci
 * przytrzymuje ona tablice stringow ze zdaniami i prawidlowymi odpowedziami oraz metody do zwracania tablic*/



public class questionsRewrite {

    /** \brief  tablice stringów przechowujące pytania i prawidlowe odpowiedzi
     */
    public static String[] correctans =new String [] {
            "She is not going to the game tonight",
           "He is meeting his friends after school",
            "Are you visiting your cousin this weekend?",
            "I am not going to the meeting after work.",
            "Is John playing football today?"
    };
    public  static String[] sentences = new String[]
            {
                    "going She to the tonight game  is not",
                    "is friends his He after school meeting",
                    "your Are this cousin you weekend visiting?",
                    "not after  to the meeting I going am work.",
                    "John football today Is playing?"
            };
    /** \brief Funkcja odpowiedzialna za zwracanie stringów z pytaniami
     *  @param a parametr określający numer pytania w tablicy
     * @return  zwraca pytanie
     */
    public String getSentence(int a) {
        String sent = sentences[a];
        return sent;
    }
    /** \brief Funkcja odpowiedzialna za zwracanie stringów
     * @param a parametr określający numer pytania w tablicy
     * @return  sprawdza zwracaną odpowiedź
     */
    public String check(int a) {
        String checksent = correctans[a];
        return checksent;
    }
    /** \brief Funkcja odpowiedzialna za zwracanie stringów z prawidłowymi odpowiedziami
     * @param a parametr określający numer odpowiedzi w tablicy
     * @return  zwraca pawidlowa odpowiedź
     */
    public String getCorrectAnswer(int a) {
        String answer = correctans[a];
        return answer;
    }
}
