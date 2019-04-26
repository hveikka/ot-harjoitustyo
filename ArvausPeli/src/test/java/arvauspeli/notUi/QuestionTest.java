package arvauspeli.notUi;

import arvauspeli.logics.Question;
import arvauspeli.logics.Questions;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class QuestionTest {

    Questions testQuestions;
    Question testQuestion;

    @Before
    public void setUp() {
        testQuestions = new Questions();
        testQuestion = new Question("main", "a", "b", "c", "oikea");
    }

    @Test
    public void addingQuestions() {
        testQuestions.addQuestion("a", "b", "c", "d", "e", 1);
        assertEquals(testQuestions.getEasyQuests().size(), 1);

    }
    @Test
    public void getsAndSets(){
        assertEquals(testQuestion.getA(), "a");
        assertEquals(testQuestion.getB(), "b");
        assertEquals(testQuestion.getC(), "c");
        assertEquals(testQuestion.getOikea(), "oikea");
        assertEquals(testQuestion.getQuest(), "main");
    }


}
