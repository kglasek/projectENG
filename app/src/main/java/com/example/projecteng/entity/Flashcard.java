package com.example.projecteng.entity;

import java.util.Objects;
/**klasa odpowiedzialna za baze danych*/
public class Flashcard {

    public static String TABLE_NAME = "flashcards";

    private Long id;  /**< long odpowiedzialny za id w bazie*/
    private String english; /**< string związany z pole w języku angielskim*/
    private String polish; /**< string związany z polem w języku polskim*/

    /** \brief referencje do zadeklarowanych pól*/
    public Flashcard(Long id, String english, String polish) {
        this.id = id;
        this.english = english;
        this.polish = polish;
    }

    public Flashcard(String english, String polish) {
        this(null, english, polish);
    }
    /** \brief Funkcja odpowiedzialna za  pobranie ID
     * @return  zwraca id
     */

    public Long getId() {
        return id;
    }
    /** \brief Funkcja odpowiedzialna za ustawienie ID
     */
    public void setId(Long id) {
        this.id = id;
    }
    /** \briefFunkcja odpowiedzialna za pobranie pola tekstowego
     * @return  zwraca pole tekstowe w angielskim
     */
    public String getEnglish() {
        return english;
    }
    /** \brief Funkcja odpowiedzialna za ustawienie pola tekstowego w j. angielskim
     */
    public void setEnglish(String english) {
        this.english = english;
    }
    /** \brief Funkcja odpowiedzialna za pobranie pola tekstowego
     * @return  zwraca pole tekstowe w j. polskim
     */
    public String getPolish() {
        return polish;
    }
    /** \brief Funkcja odpowiedzialna za ustawienie pola tekstowego w j. polskim
     */
    public void setPolish(String polish) {
        this.polish = polish;
    }
    /** \brief Funkcja odpowiedzialna za zwrócenie przez referencje pól tekstowy do stringa
     * @return  zwraca pola tekstowe
     */
    @Override
    public String toString() {
        return this.english + ": " + this.polish;
    }
    /** \brief Funkcja odpowiedzialna za sprawdzanie poprawności wypełnionych pól
     * @return  zwraca id czy jest równe innemu id
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flashcard flashcard = (Flashcard) o;
        return id.equals(flashcard.id);
    }
    /** \brief Funkcja odpowiedzialna za hash ID
     * @return  zwraca hash kod id
     */
    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
