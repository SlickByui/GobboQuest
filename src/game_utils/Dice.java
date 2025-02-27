//Define pack <?>
package game_utils;
/*************************************************************************
 *  Dice Class
 *   - Collection of dice rolling functions 
 * 
 * 
 *************************************************************************/

//Import libraries
import java.util.Random;

public class Dice {
    private static Random rand = new Random(); //Need to be inside constructor?

    public static int RollD2(){
        return rand.nextInt(2) + 1;
    }

    public static int RollD4(){
        return rand.nextInt(4) + 1;
    }

    public static int RollD6(){
        return rand.nextInt(6) + 1;
    }

    public static int RollD8(){
        return rand.nextInt(8) + 1;
    }

    public static int RollD10(){
        return rand.nextInt(10) + 1;
    }
    
    public static int RollD12(){
        return rand.nextInt(12) + 1;
    }

    public static int RollD20(){
        return rand.nextInt(20) + 1;
    }
}
