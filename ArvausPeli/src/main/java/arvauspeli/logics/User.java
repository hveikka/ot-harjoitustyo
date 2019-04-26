package arvauspeli.logics;

/**
 * Käyttäjä luokka palauttaa käyttäjän nimeä ja pisteitä.
 */
public class User {

    static String name;
    static int score;

    /**
     *
     * @return
     */
    public static String getName() {
        return name;
    }

    /**
     *
     * @return
     */
    public static int getScore() {
        return score;
    }

    /**
     *
     * @param x
     */
    public static void setScore(int x) {
        score = x;
    }

    /**
     *
     * @param y
     */
    public static void setUser(String y) {
        name = y;
    }
}
