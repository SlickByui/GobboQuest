package test;
import main.*;
import game_utils.*;
//import java.util.List;
import entity.*;  //do we need these if we are importing main, or is it all imported through main?


//Test class and package used to test the various functions built thus far
public class Test {
    private Monster testMonster;
    private ExplorationLoop explorationLoop;
    private CombatLoop combatLoop;
    
    public static void main(String[] args) {
        //Runs through and tests all of our test functions
        Test test = new Test();
        test.TestDiceRoll();
        test.TestTextUtils();
        test.TestPlayerClass();
        test.TestDungeonClass();
        test.TestExplorationLoop();
        //test.TestCombatLoop();
    }

    //Blank constructor
    public Test() {
        Player.getInstance(20, 5);  //Initialize player class instance
    }

    public void PrintNewline() {
        System.out.println("");
        System.out.println("==========================================");
    }

    public void TestPlayerClass() {
        PrintNewline();
        //Test whether the Singleton class works with just a basic initialization
        System.out.println("Player Health: " + Player.getInstance().getHP());
        System.out.println("Player DMG: " + Player.getInstance().attack());
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

    public void TestDungeonClass() {
        PrintNewline();
        System.out.println("Testing our Dungeon.java class: ");
        Dungeon testDungeon = new Dungeon();
        testDungeon.generateDungeon();  //Generate our new dungeon
        testMonster = testDungeon.getMonster();

        //Check to see if our floors match our monsters
        for (Floor floor : testDungeon.getFloorList()) {
            System.out.println("Floor monster: " + floor.getMonster().getName() + " Desc: " + floor.getFloorDesc());
        }
    }

    public void TestCombatLoop() {  //System might be redundant, double check
        combatLoop = new CombatLoop();
        boolean combat = combatLoop.start(testMonster);
        if (combat) {
            System.out.println("Player won");
        }
        else {
            System.out.println("Player Died");
        }
    }

    public void TestExplorationLoop()
    {
        explorationLoop = new ExplorationLoop();
        explorationLoop.start();
    }
}
