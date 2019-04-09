
package arvauspeli.notUi;

import arvauspeli.logics.User;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class UserTest {
    
    User user;
    
    
    
    @Before
    public void setUp() {
        user = new User();
        User.setUser("test");
        User.setScore(9);
    }
    @Test
    public void getsAndSets(){
        assertEquals(User.getName(), "test");
        assertEquals(User.getScore(), 9);

    }
    
}
