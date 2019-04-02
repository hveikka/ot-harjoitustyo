package arvauspeli;

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
    public void getQuestions() {
        assertEquals(testQuestions.getQuests().size(), 4);

    }

    @Test
    public void getABCright() {
        assertEquals(testQuestion.getA(), "a");
        assertEquals(testQuestion.getB(), "b");
        assertEquals(testQuestion.getC(), "c");
        assertEquals(testQuestion.getOikea(), "oikea");
        assertEquals(testQuestion.getQuest(), "main");

    }

    @Test
    public void addingQuestions() {
        testQuestions.addQuestion("a", "b", "c", "d", "e");
        assertEquals(testQuestions.getQuests().size(), 5);

    }

    @Test
    public void rollingQuestions() {
        Questions rollQuestions = new Questions();
        rollQuestions.addQuestion("a", "b", "c", "d", "e");
        assertEquals(rollQuestions.rollQuest(), rollQuestions.getQuests());

    }

}
