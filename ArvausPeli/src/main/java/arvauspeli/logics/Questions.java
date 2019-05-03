package arvauspeli.logics;

import java.util.ArrayList;
import java.util.Random;

/**
 * Luokka kysymysten listaamista, arpomista ja järjestämistä varten.
 */
public class Questions {

    /**
     *
     */
    public ArrayList<Question> easyQuestions;

    /**
     *
     */
    public ArrayList<Question> medQuestions;

    /**
     *
     */
    public ArrayList<Question> hardQuestions;

    /**
     *
     */
    public int memory = 0;

    /**
     *
     */
    public Questions() {

        this.easyQuestions = new ArrayList();
        this.medQuestions = new ArrayList();
        this.hardQuestions = new ArrayList();

    }

    /**
     * Lisää kysymyksen ja määrittelee oikean vastauksen sekä vaikeustason.
     *
     * @param main itse kysymys
     * @param a vastausvaihtoehto
     * @param b vastausvaihtoehto
     * @param diff vaikeustaso
     * @param right oikea vastausvaihtoehto
     * @param c vastausvaihtoehto
     */
    public void addQuestion(String main, String a, String b, String c, String right, int diff) {
        if (diff == 1) {
            easyQuestions.add(new Question(main, a, b, c, right));
        }
        if (diff == 2) {
            medQuestions.add(new Question(main, a, b, c, right));
        }
        if (diff == 3) {
            hardQuestions.add(new Question(main, a, b, c, right));
        }
    }

    /**
     *
     * @return
     */
    public ArrayList getEasyQuests() {
        return easyQuestions;
    }

    /**
     *
     * @return
     */
    public ArrayList getMedQuests() {
        return medQuestions;
    }

    /**
     *
     * @return
     */
    public ArrayList getHardQuests() {
        return hardQuestions;
    }

    /**
     * Metodi arpoo käyttäjälle satunnaisen kysymyksen listasta.
     *
     * @param difficulty säätelee kysymysten vaikeutta.
     *
     * @return palauttaa satunnaisen kysymyksen.
     */
    public Question rollQuest(int difficulty) {
        Random ranm = new Random();

        if (difficulty == 1) {
            int number = ranm.nextInt(easyQuestions.size());
            while (number == memory) {
                number = ranm.nextInt(easyQuestions.size());
            }
            memory = number;

            return easyQuestions.get(number);
        }
        if (difficulty == 2) {
            int number = ranm.nextInt(medQuestions.size());
            while (number == memory) {
                number = ranm.nextInt(medQuestions.size());
            }
            memory = number;

            return medQuestions.get(number);
        }
        if (difficulty == 3) {
            int number = ranm.nextInt(hardQuestions.size());
            while (number == memory) {
                number = ranm.nextInt(hardQuestions.size());
            }
            memory = number;

            return hardQuestions.get(number);
        }

        int number = ranm.nextInt(hardQuestions.size());
        while (number == memory) {
            number = ranm.nextInt(hardQuestions.size());
        }
        memory = number;

        return hardQuestions.get(number);
    }
}
