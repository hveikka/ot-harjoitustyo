package arvauspeli.notUi;

import arvauspeli.logics.Question;
import arvauspeli.logics.Questions;
import java.util.Arrays;
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
        testQuestions.addQuestion("a", "b", "c", "d", "e", 2);
        testQuestions.addQuestion("a", "b", "c", "d", "e", 3);
        assertEquals(testQuestions.getEasyQuests().size(), 1);
        assertEquals(testQuestions.getMedQuests().size(), 1);
        assertEquals(testQuestions.getHardQuests().size(), 1);

    }

    @Test
    public void rollQuestions() {
        testQuestions.addQuestion("a1", "b1", "c1", "d1", "b1", 1);
        testQuestions.addQuestion("a1", "b1", "c1", "d1", "b1", 1);

        assertEquals(testQuestions.rollQuest(1).getA(), "b1");

        testQuestions.addQuestion("a2", "b2", "c2", "d2", "b2", 2);
        testQuestions.addQuestion("a2", "b2", "c2", "d2", "b2", 2);

        assertEquals(testQuestions.rollQuest(2).getA(), "b2");

        testQuestions.addQuestion("a3", "b3", "c3", "d3", "b3", 3);
        testQuestions.addQuestion("a3", "b3", "c3", "d3", "b3", 3);

        assertEquals(testQuestions.rollQuest(3).getA(), "b3");

    }

    @Test
    public void getsAndSets() {
        assertEquals(testQuestion.getA(), "a");
        assertEquals(testQuestion.getB(), "b");
        assertEquals(testQuestion.getC(), "c");
        assertEquals(testQuestion.getOikea(), "oikea");
        assertEquals(testQuestion.getQuest(), "main");
    }

}
