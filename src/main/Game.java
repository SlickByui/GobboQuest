package main;
/*************************************************************************
 *  Game Class
 *   - Primary game "engine" that drives the bulk of the program. 
 * 
 * 
 *************************************************************************/

import game_utils.TextUtils;
import entity.Player;
import entity.Monster;

import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Game{
    public List<Monster> monsters;  //Not sure if need the new argument or can just implement the first half
    public Player player;
    public static void main(String[] args) {
        new Game();
        //See if we cant link our tests/ debug to this main instead
    }

    public Game()
    {
        player = new Player(20, 4);
    }
  
    //Maybe abstract this into own separate class or put this into Dungeon class
    public void CreateMonsterList() {

        //might be able to abstract this to work for any input class/ value? (Might be overkill)
        monsters = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            monsters = objectMapper.readValue(new File("src\\entity\\monsters.json"), 
                objectMapper.getTypeFactory().constructCollectionType(List.class, Monster.class));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void DisplayIntro(){
        String intro = "You find yourself wandering through the woods, when suddenly you happen upon a dungeon.";
        TextUtils.SlowPrint(intro);
        return;
    }

    public void DisplayOutro() {
        return;
    }
}