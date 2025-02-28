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
    public Player player;
    //private GameLoop gameLoop = new GameLoop();
    public Dungeon dungeon;
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
        player = new Player(20, 4);   //Create our player
        dungeon = new Dungeon();                //Create our new dungeon
        dungeon.generateDungeon();
    }

    public void displayIntro(){
        String intro = "You find yourself wandering through the woods, when suddenly you happen upon a dungeon.\n" + 
        "Feeling rather devious, the little rascal of a Goblin that you are, you decide to do a dungeon delve.";
        TextUtils.SlowPrint(intro);
        return;
    }

    public void runGameLoop() {
        
    }

    public void displayOutro() {
        return;
    }
}