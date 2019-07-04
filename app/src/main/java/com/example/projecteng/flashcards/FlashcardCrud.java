package com.example.projecteng.flashcards;;

import com.example.projecteng.entity.Flashcard;

import java.util.ArrayList;
import java.util.List;
/** klasa odpowiedzialna za przechowywanie fiszek*/
public class FlashcardCrud {

    private static long counter = 1;
    private static final FlashcardCrud instance = new FlashcardCrud();

    private List<Flashcard> flashcards;
/**  \brief ustawianie referencji na listę tablic*/
    private FlashcardCrud() {
        this.flashcards = new ArrayList<>();
/**  \briefustawianie referencji na dodanie nowych fiszek do bazy*/
        this.flashcards.add(new Flashcard(counter++, "sword", "miecz"));
        this.flashcards.add(new Flashcard(counter++, "word", "słowo"));
        this.flashcards.add(new Flashcard(counter++, "string", "struna"));
        this.flashcards.add(new Flashcard(counter++, "spoon", "łyżka"));
        this.flashcards.add(new Flashcard(counter++, "fork", "widelec"));
        this.flashcards.add(new Flashcard(counter++, "knife", "nóż"));
        this.flashcards.add(new Flashcard(counter++, "world", "świat"));
        this.flashcards.add(new Flashcard(counter++, "weapon", "broń"));
        this.flashcards.add(new Flashcard(counter++, "death", "śmierć"));
        this.flashcards.add(new Flashcard(counter++, "elevator", "winda"));
        this.flashcards.add(new Flashcard(counter++, "candy", "cukierek"));
    }
    /** \brief funkcja odpowiedzialna za instancję
     * @return zwraca instancje
     */
    public static FlashcardCrud getInstance() {
        return instance;
    }
    /** \brief lista fiszek
     * @return zwraca referencję na pobrane fiszki
     */

    public List<Flashcard> getAll() {
        return this.flashcards;
    }
    /** \brief funkcja odpowiedzialna za pobranie fiszki
     * @param id parametr związany z id fiszki
     * @return zwraca fiszke
     */
    public Flashcard getOne(Long id) {
        Flashcard flashcard = null;
        for (Flashcard f : this.flashcards) {
            if (f.getId().equals(id)) {
                flashcard = f;
                break;
            }
        }

        return flashcard;
    }
    /** \brief funkcja odpowiedzialna za tworzenie fiszki
     * @param flashcard parametr z nową fiszką
     * @return zwraca zależnie od instrukcji warunkowej bool dodania nowej karty
     */
    public boolean create(Flashcard flashcard) {
        if (flashcard.getEnglish() == null || flashcard.getPolish() == null) {
            return false;
        }

        flashcard.setId(counter++);
        this.flashcards.add(flashcard);
        return true;
    }
    /** \brief funkcja odpowiedzialna za edycję fiszki
     * @param id parametr związany z id fiszki
     * @param flashcardUpdated parametr odpowiedzialny za edycje fiszki
     * @return zwraca zależnie od instrukcji warunkowej bool czy dokonano zmiany
     */
    public boolean update(Long id, Flashcard flashcardUpdated) {
        if (flashcardUpdated.getEnglish() == null || flashcardUpdated.getPolish() == null) {
            return false;
        }

        Flashcard flashcard = null;
        for (Flashcard f : this.flashcards) {
            if (f.getId().equals(id)) {
                flashcard = f;
                break;
            }
        }

        if (flashcard == null) {
            return false;
        }

        flashcard.setEnglish(flashcardUpdated.getEnglish());
        flashcard.setPolish(flashcardUpdated.getPolish());

        return true;
    }
    /** \brief funkcja odpowiedzialna za usuwanie fiszki
     * @param id parametr związany z id fiszki
     * @return zwraca referencje na usuniętą fiszkę
     */
    public boolean delete(Long id) {
        Flashcard flashcard = null;
        for (Flashcard f : this.flashcards) {
            if (f.getId().equals(id)) {
                flashcard = f;
                break;
            }
        }

        return this.flashcards.remove(flashcard);
    }
}
