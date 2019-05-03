package arvauspeli.logics;

import java.util.ArrayList;
import java.util.Collections;
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
    public int memory = -1;
    public int memory2 = -1;
    public int memory3 = -1;

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
            Collections.shuffle(easyQuestions);
        }
        if (diff == 2) {
            medQuestions.add(new Question(main, a, b, c, right));
            Collections.shuffle(medQuestions);
        }
        if (diff == 3) {
            hardQuestions.add(new Question(main, a, b, c, right));
            Collections.shuffle(hardQuestions);
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

    public void shuffle() {
        Collections.shuffle(easyQuestions);
        Collections.shuffle(medQuestions);
        Collections.shuffle(hardQuestions);
    }
    public void newGame(){
        memory = 0;
        memory2 = 0;
        memory3 = 0;
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

            memory++;
            return easyQuestions.get(memory);
        }
        if (difficulty == 2) {
            memory = 0;
            memory2++;

            return medQuestions.get(memory2);
        }
        if (difficulty == 3) {
            memory2 = 0;
            memory3++;

            return hardQuestions.get(memory3);
        }
        memory3 = 0;
        int number = ranm.nextInt(hardQuestions.size());
        while (number == memory) {
            number = ranm.nextInt(hardQuestions.size());
        }
        memory = number;

        return hardQuestions.get(number);
    }
}
