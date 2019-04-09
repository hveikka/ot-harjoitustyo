package arvauspeli.logics;

import java.util.ArrayList;
import java.util.Random;

public class Questions {

    public ArrayList<Question> allQuestions;

    public Questions() {

        this.allQuestions = new ArrayList();

    }

    public void addQuestion(String main, String a, String b, String c, String oikea) { 
        allQuestions.add(new Question(main, a, b, c, oikea));
    }

    public ArrayList getQuests() { 
        return allQuestions;
    }

    public Question rollQuest() { 
        Random ranm = new Random();

        return allQuestions.get(ranm.nextInt(allQuestions.size()));
    }
}