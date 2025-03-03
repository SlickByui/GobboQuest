package main;
/*************************************************************************
 *  Game Class
 *   - Primary game "engine" that drives the bulk of the program. 
 * 
 * 
 *************************************************************************/

import game_utils.TextUtils;
import entity.Player;

public class Game{
    public Player player;    //singleton class should only allow one player
    public Dungeon dungeon;
    public Boolean stillPlaying;
    public CombatLoop combatLoop;
    public ExplorationLoop explorationLoop;
    public static void main(String[] args) {
        new Game();
    }

    public Game()  //Kinda the main game class, might move to the gameloop maybe
    {              
        displayIntro();
        runGameLoop();
        displayOutro();
    }

    public void initialize() {
        //Game initialization
        player = Player.getInstance(20, 5);   //Create our player
        dungeon = new Dungeon();                        //Create our new dungeon
        dungeon.generateDungeon();
        combatLoop = new CombatLoop();                  //Initialize combat loop
        explorationLoop = new ExplorationLoop();
    }

    public void displayIntro(){
        String intro = "You find yourself wandering through the woods, when suddenly you happen upon a dungeon.\n" + 
        "Feeling rather devious, the little rascal of a Goblin that you are, you decide to do a dungeon delve.";
        TextUtils.SlowPrint(intro);
        return;
    }

    //Main game loop
    public void runGameLoop() 
    {
        //Check to make sure the game is still running
        while (stillPlaying && player.isAlive())    //player.isAlive may be redundant
        {
            //Display floor desc.
            dungeon.getCurrentFloor().displayFloorDesc();

            //start combat loop
            combatLoop.start(dungeon.getCurrentFloor().getMonster());
            if (!player.isAlive() || dungeon.isLastFloor()) {  //Check to see if the floor we entered was the last one
                break;
            }

            //Start the exploration loop
            explorationLoop.start();

            //Check to see if player has decided to leave the dungeon
            if (explorationLoop.leavingDungeon()) {
                break;  //Make sure to display that we have left
            }

            //Go to next floor of dungeon
            dungeon.nextFloor();
        }
    }

    public void displayGameOver(String monsterName)
    {
        TextUtils.SlowPrintln("The " + monsterName + " killed you!");
        TextUtils.SlowPrintln("Game Over!");
    }

    public void displayOutro() {
        return;
    }
}