package main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Monster;

public class Dungeon {

    private List<Floor> floors;         //Actual floors themselves
    private List<String> floorDescs;    //Descriptions of our floors
    private List<Monster> monsters;
    private int FLOOR_IDX = 0;          //Start floor at 0
    private Floor currentFloor;         

    //Empty for now
    public Dungeon(){}

    private void generateFloorDescs() {
        //For now, we will make a static list of descs that correspond to 
        // static floors
        floorDescs = new ArrayList<String>();

        //Goblin room
        floorDescs.add("a cavernous looking room. The air is heavy, kind of like the cave you grew up in. \n Kind of.");

        //Zombie room
        floorDescs.add("a crypt (but the dungeon type). It smells like the great body pit of Gilgarth.");

        //Fat rat room
        floorDescs.add(  "a room filled with many great basins of water. They might be nice to bathe in, if it weren't for the fact " +
                         "that those vats are filled with lots of rats. Angry rats.");

        //Witch room
        floorDescs.add(  "a very witchy looking room. There's a comically large cauldron that smells of burnt socks and toad." +
                         "There's even a flying broom. Classic witch room.");

        //Skeleton King room
        floorDescs.add("a reagal throne room. At the end of the long, great hall sits a great pile of bones stacked neatly " + 
                        "into a zigguraut with a great skeletal throne at its peak.");
    }

    //Creates Monster list for our dungeon
    private void createMonsterList() {
        monsters = new ArrayList<>();  //does this map to function or higher.
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            monsters = objectMapper.readValue(new File("src\\entity\\monsters.json"), 
                objectMapper.getTypeFactory().constructCollectionType(List.class, Monster.class));
        } catch (IOException e) {
            e.printStackTrace();  //not sure if this is needed
        }
    }

    public void generateDungeon() {
        //Generate floor descriptions
        generateFloorDescs();

        //Populate our monster list
        createMonsterList();

        //Loop through our two lists (monsters and floors) and generate a floor
        // based off of that
        floors = new ArrayList<>();
        for (int i = 0; i < monsters.size();i++){
            floors.add(new Floor(monsters.get(i),floorDescs.get(i)));
        }

        //Set current floor to the first floor
        currentFloor = floors.get(FLOOR_IDX);
    }

    //Enter the next floor, display the intro 
    public void nextFloor() {
        //Check to see if last floor(?)

        //Switch next floor in list to current floor
        FLOOR_IDX += 1;
        currentFloor = floors.get(FLOOR_IDX);

        //Display next floor desc
        currentFloor.displayFloorDesc();
    }

    //Return the current floors monster
    public Monster getMonster() {
        return currentFloor.getMonster();  //Feels redundant, potentially
    }

    public List<Floor> getFloorList() {
        return floors;
    }
}
