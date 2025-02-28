package main;


import entity.*;
import game_utils.TextUtils;

public class Floor {
    private Monster monster;
    private String floorDesc;
    
    public Floor(Monster monster, String floorDesc) {
        this.monster = monster;
        this.floorDesc = floorDesc;
    }

    public Monster getMonster() {return monster;}

    public String getFloorDesc() {return floorDesc;}

    public void displayFloorDesc() {
        TextUtils.SlowPrintln(floorDesc);
    }
}
