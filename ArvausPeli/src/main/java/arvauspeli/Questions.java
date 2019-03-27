package arvauspeli;

import java.util.ArrayList;
import java.util.Random;

public class Questions {

    public ArrayList<Question> AllQuestions;

    public Questions() {
        
        this.AllQuestions = new ArrayList();

        AllQuestions.add(new Question("mikä on isoin?", "2", "3", "1", "3"));
        AllQuestions.add(new Question("mikä on paras?", "pulla", "pitsa", "nauris", "pitsa"));
        AllQuestions.add(new Question("mikä on ikäsi?", "26", "22", "1", "22"));
        AllQuestions.add(new Question("milloin Suomi itsenäistyi?", "2011", "1995", "1917", "1917"));

    }
    


    public ArrayList getQuests(){
        return AllQuestions;
    }
    public Question rollQuest(){
                Random ranm = new Random();

        return AllQuestions.get(ranm.nextInt(AllQuestions.size()));
    }
}
