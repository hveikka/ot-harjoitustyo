
package arvauspeli;


public class User {
    
    static String name;
    static int score;
    
    

    
    public static String getName(){
        return name;
    }
    public static int getScore(){
        return score;
    }
    public static void setScore(int x){
        score = x;
    }
    public static void setUser(String y){
        name = y;
    }
}
