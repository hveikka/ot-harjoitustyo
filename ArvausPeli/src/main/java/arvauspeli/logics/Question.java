package arvauspeli.logics;

/**
 * Luokka kysymyksiä varten.
 */
public class Question {

    private String oikea;
    private String main;
    private String q1;
    private String q2;
    private String q3;

    public Question(String main, String a, String b, String c, String oikea) {
        this.q1 = a;
        this.q2 = b;
        this.q3 = c;

        this.main = main;

        this.oikea = oikea;
    }

    /**
     *
     * @return
     */
    public String getOikea() {
        return this.oikea;
    }

    /**
     *
     * @return
     */
    public String getQuest() {
        return this.main;
    }

    /**
     *
     * @return
     */
    public String getA() {
        return this.q1;
    }

    /**
     *
     * @return
     */
    public String getB() {
        return this.q2;
    }

    /**
     *
     * @return
     */
    public String getC() {
        return this.q3;
    }

}
