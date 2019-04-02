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
    public void addingQuestions() {
        testQuestions.addQuestion("a", "b", "c", "d", "e");
        assertEquals(testQuestions.getQuests().size(), 1);

    }

    @Test
    public void rollingQuestions() {
        Questions rollQuestions = new Questions();
        rollQuestions.addQuestion("a", "b", "c", "d", "e");
        assertEquals(rollQuestions.rollQuest().getA(), "b");

    }

}
