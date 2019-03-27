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
        testQuestion = new Question("1", "2", "3", "4", "5");
    }

@Test
    public void getQuestions() {
        assertEquals(testQuestions.getQuests().size(), 4);
        
    }
    @Test
    public void getAnswer() {
        assertEquals(testQuestion.getOikea(), "5");
        
    }



}
