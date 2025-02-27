package main;

import entity.Player;
import game_utils.TextUtils;
import java.util.Scanner;

/*************************************************************************
 *  Exploration Loop Class
 *   - In charge of running the exploration phase of the game. 
 *  
 * 
 * 
 * 
 *************************************************************************/

public class ExplorationLoop {
    private Player player;

    public ExplorationLoop(Player player) {
        this.player = player;
    }

    public void start() {
        Boolean stillExploring = true;
        Scanner scanner = new Scanner(System.in);
        
        //Run through loop while player is still exploring
        while (stillExploring) {
            displayCalmActions();
            int playerChoice = scanner.nextInt();
            switch (playerChoice) {
                case 1: //Move to next floor
                    stillExploring = false;
                    break;

                case 2: //Rest
                    player.Rest();
                    TextUtils.SlowPrintln("You decide to take a small break to heal your wounds.");
                    break;

                case 3: //Do a funny dance
                    player.DoFunnyDance();
                    TextUtils.SlowPrintln(" after your victory.");
                    TextUtils.SlowPrintln("It looks really good. Too bad no one was here to see it...");
                    break;

                case 4: //Leave the dungeon
                    //Need to figure out the logic of this
                    break;
            
                default: //need to implement 
                    break;
            }
        }
        scanner.close();
    }

    private void displayCalmActions() {   //might want to move this to Exploration class
        System.out.println("===============================================================");
        System.out.println("Actions: ");
        System.out.println("===============================================================");
        System.out.println(" 1. Move to next floor               2. Rest                   ");
        System.out.println(" 3. Do a funny dance                 4. Leave                  ");
        System.out.println("");
        TextUtils.Pause(1000);
        TextUtils.SlowPrint("What would you like to do? ");
    }
}
