
package arvauspeli;


public class Question {
    
    private String oikea;
    private String main;
    private String q1;
    private String q2;
    private String q3;

    
    
    
    public Question(String main, String a, String b, String c, String oikea){
        this.q1 = a;
        this.q2 = b;
        this.q3 = c;

        this.main = main;
        
        this.oikea = oikea;
    }
    public String getOikea(){
        return this.oikea;
    }
    public String getQuest(){
        return this.main;
    }
    public String getA(){
        return this.q1;
    }
    public String getB(){
        return this.q2;
    }
    public String getC(){
        return this.q3;
    }

    
    
    
    
}