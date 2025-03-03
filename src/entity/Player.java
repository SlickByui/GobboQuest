package entity;
import game_utils.*;

public class Player extends Entity{    
    private static Player single_instance = null;
    private Boolean isBlocking;

    private Player(int maxHP, int DMG) {
        super(maxHP, DMG);
        isBlocking = false;
    }

    public static synchronized Player getInstance(int maxHP, int DMG)
    {
        if (single_instance == null)
            single_instance = new Player(maxHP, DMG);

        return single_instance;
    }

    //Used for time when we don't want to pass in vars (another way around this?)
    public static synchronized Player getInstance() 
    {
        return single_instance;
    }

    //Player specific methods
    public void rest() { //Resting currently sets your health back to max (if you aren't in combat)
        //need to add conditional for combat
        currentHP = maxHP;
    }

    //Function displays the actions the player can take during combat (static for now)
    public void heal() {
        //Currently just heals to full, can be used infinitely
        currentHP = maxHP;
    }

    public void block() {
        //Set block equal to true
        isBlocking = true;
        TextUtils.SlowPrintln("You raise your shield to block the enemies next attack!");  //Maybe put these in combatloop
    }

    public void unBlock() {
        //Set block equal to false
        isBlocking = false;
        TextUtils.SlowPrintln("You lower your shield preparing for your next move.");  //Would be funny if we tracked these 
    }

    public Boolean isBlocking() {
        return isBlocking;
    }

    public void doFunnyDance() {
        TextUtils.SlowPrint("You decide the best course of action is to break it down");
        return;
    }

}
