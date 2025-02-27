package game_utils;

public class TextUtils {

    static final int DELAY = 50;
    //Function wipes screen so we get a clean display
    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    } 

    //Function slowly prints txt onto the screen one char at a time
    public static void SlowPrint(String text) {  //interrupted exception makes this work fsr
        for (char character : text.toCharArray()) {
            System.out.print(character);
            try {
                Thread.sleep(DELAY);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }

    public static void SlowPrintln(String text) {  //interrupted exception makes this work fsr
        for (char character : text.toCharArray()) {
            System.out.print(character);
            try {
                Thread.sleep(DELAY);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
        System.out.println(); //newline char
    }

    public static void Pause(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) { // I know this is bad, but idk how to work with this otherwise
            Thread.currentThread().interrupt();
            return;
        }
    }

}
