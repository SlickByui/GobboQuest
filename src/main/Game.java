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
    public Player player;    //singleton class shoudl only allow one player
    //private GameLoop gameLoop = new GameLoop();
    public Dungeon dungeon;
    public Boolean stillPlaying;
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
        //Display first floor of dungeon manually
        dungeon.getCurrentFloor().displayFloorDesc();
        
    

        //Check to make sure the game is still running
        while (stillPlaying && player.IsAlive())
        {


        }
    }

    public void displayOutro() {
        return;
    }
}