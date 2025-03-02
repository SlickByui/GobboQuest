package test;
import main.*;
import game_utils.*;
//import java.util.List;
import entity.*;  //do we need these if we are importing main, or is it all imported through main?


//Test class and package used to test the various functions built thus far
public class Test {
    protected Player player;
    protected Monster testMonster;
    
    public static void main(String[] args) {
        //Runs through and tests all of our test functions
        Test test = new Test();
        test.TestDiceRoll();
        test.TestTextUtils();
        test.TestDungeonClass();
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

    public void TestCombatLoop() {
        player = Player.getInstance();
        CombatLoop combatLoop = new CombatLoop(player, testMonster);
        boolean combat = combatLoop.Start();
        if (combat) {
            System.out.println("Player won");
        }
        else {
            System.out.println("Player Died");
        }
    }
}
