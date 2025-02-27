package main;
/*************************************************************************
 *  Combat Loop Class
 *   - In charge of running the combat interactions. 
 * 
 * 
 * 
 *************************************************************************/

import entity.*;
import game_utils.*;
import java.util.Scanner;

public class CombatLoop {
    private Player player;  //Can we do this or does this make a new player?
    private Monster monster;

    //Loop inside constructor?
    public CombatLoop(Player player, Monster monster) { //do we need to pass in player?  (for now we will, and only use 1 monster)
        this.player = player;
        this.monster = monster;
    }  

    public Boolean Start() {
        Scanner scanner = new Scanner(System.in); //This is for reading input from players (do we need do this every loop?)
        //Clear screen before we start
        TextUtils.clearScreen();

        //Start loop, condition is that both monster and player are alive
        while (player.IsAlive() && monster.IsAlive()) {

            //Player goes first for the time being
            displayCombatActions();
            int playerChoice = scanner.nextInt();

            switch (playerChoice) {  //Might shove this into player class later for better readability here
                case 1: //Attack
                    //For now, will display here, but should probably move into player or somewhere else
                    TextUtils.SlowPrintln("You take a swing at the " + monster.getName() + ".");  //how would we get monster name?
                    TextUtils.Pause(100);
                    monster.TakeDamage(player.Attack());
                    TextUtils.SlowPrintln("You Hit! You deal " + player.Attack() + " dmg to the " + monster.getName() + ".");
                    break;

                case 2: //Block 
                    //Probably a temp solution, if we include AC and such, this will probably be depracated
                    player.Block();
                    break;

                case 3: //Do a funny dance
                    player.DoFunnyDance();
                    TextUtils.SlowPrintln(" in front of the " + monster.getName() + ".");
                    TextUtils.SlowPrintln("While impressed, the " + monster.getName() + " does not budge otherwise.");
                    break;

                case 4: //Heal
                    player.Heal();
                    TextUtils.SlowPrintln("You pull out a potion and chug it down in one gulp!");
                    TextUtils.SlowPrintln("(The " + monster.getName() + " is disturbed.)");
                    TextUtils.SlowPrintln("Your health is now back to full.");
                    break;
            
                default: //Use this to deal with unexpected inputs
                    break;
            }

            //Break out of loop if monster is dead
            if (!monster.IsAlive()) {
                break;  //Should break out of while loop
            }

            //For now, monster will just attack
            TextUtils.SlowPrintln("The " + monster.getName() + " tries to attack you!");
            if (player.IsBlocking()) {
                TextUtils.SlowPrintln("But you deflect its attack with your shield!");
            }
            else {
                player.TakeDamage(monster.Attack());
                TextUtils.SlowPrintln("Ouch! You take "+ monster.Attack() + " pts of damage!");
            }
            TextUtils.Pause(100);
        }
        scanner.close();
        //After combat, check to see if player is still alive
        if (!player.IsAlive()) {  //if not, return false
            return false;
        }
        else {                    //if they are, return true
            return true;
        }
    }

    private void displayCombatActions() {
        System.out.println("===============================================================");
        System.out.println("Actions: ");
        System.out.println("===============================================================");
        System.out.println(" 1. Attack                           2. Block                  ");
        System.out.println(" 3. Do a funny dance                 4. Heal                   ");
        System.out.println("");
        TextUtils.Pause(1000);
        TextUtils.SlowPrint("What would you like to do? ");
    }
}
