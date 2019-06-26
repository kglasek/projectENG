package com.example.projecteng;
/** Klasa pomocnicza do aktywnosci z przepisywaniem zadan w prawidlowej kolejnosci
 * przytrzymuje ona tablice stringow ze zdaniami i prawidlowymi odpowedziami oraz metody do zwracania tablic*/
public class questionsRewrite {
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
    public String getSentence(int a) {
        String sent = sentences[a];
        return sent;
    }
    public String check(int a) {
        String checksent = correctans[a];
        return checksent;
    }
    public String getCorrectAnswer(int a) {
        String answer = correctans[a];
        return answer;
    }
}
