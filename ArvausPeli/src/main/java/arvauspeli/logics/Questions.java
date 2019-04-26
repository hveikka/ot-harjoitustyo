package arvauspeli.logics;

import java.util.ArrayList;
import java.util.Random;

/**
 * Luokka kysymysten listaamista, arpomista ja järjestämistä varten.
 */
public class Questions {

    public ArrayList<Question> easyQuestions;
    public ArrayList<Question> medQuestions;
    public ArrayList<Question> hardQuestions;
    public int memory = 0;

    public Questions() {

        this.easyQuestions = new ArrayList();
        this.medQuestions = new ArrayList();
        this.hardQuestions = new ArrayList();

    }

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

    public ArrayList getEasyQuests() {
        return easyQuestions;
    }

    public ArrayList getMedQuests() {
        return medQuestions;
    }

    public ArrayList getHardQuests() {
        return hardQuestions;
    }

    /**
     * Metodi arpoo käyttäjälle satunnaisen kysymyksen listasta.
     *
     * @param difficulty ohjelma säätelee kysymysten vaikeutta.
     *
     * @return satunnainen kysymys
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

        return easyQuestions.get(0);
    }
}
