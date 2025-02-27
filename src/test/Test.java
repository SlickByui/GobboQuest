package test;
import main.*;
import game_utils.*;

import java.util.List;

import entity.*;  //do we need these if we are importing main, or is it all imported through main?


//Test class and package used to test the various functions built thus far
public class Test {
    protected Player player;
    protected List<Monster> monsters;
    
    public static void main(String[] args) {
        //Runs through and tests all of our test functions
        Test test = new Test();
        test.TestDiceRoll();
        test.TestTextUtils();
        test.TestMonsterListCreation();
        test.TestCombatLoop();
    }

    //Blank constructor
    public Test() {}

    public void PrintNewline() {
        System.out.println("");
        System.out.println("==========================================");
    }

    public void TestDiceRoll() {
        PrintNewline();
        System.out.println("Testing Our Dice class by rolling D10: " + Dice.RollD10());
        return;
    }

    public void TestTextUtils() {
        PrintNewline();
        System.out.println("Testing out our slow print function");
        String testString = "This should slowly print to the screen";
        TextUtils.SlowPrintln(testString);
    }

    public void TestMonsterListCreation() {
        PrintNewline();
        System.out.println("Testing our monster list creation, reading from a json file: ");
        Game testGame = new Game();
        testGame.CreateMonsterList();
        for (Monster monster : testGame.monsters) {
            TextUtils.SlowPrintln(monster.toString());
        }
        monsters = testGame.monsters; //set our local monsters to test monsters
    }

    public void TestCombatLoop() {
        player = new Player(20, 5);
        CombatLoop combatLoop = new CombatLoop(player, monsters.get(0));
        boolean combat = combatLoop.Start();
        if (combat) {
            System.out.println("Player won");
        }
        else {
            System.out.println("Player Died");
        }
    }


}
