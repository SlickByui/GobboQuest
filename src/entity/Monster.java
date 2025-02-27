package entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Monster extends Entity{
    
    protected int cr;    //challenge rating *Note: might not use for the time being
    protected String desc;
    protected String name;

    //Constructor that constructs from json file using jackson lib
    public Monster(@JsonProperty("name") String name, 
                   @JsonProperty("cr") int cr, 
                   @JsonProperty("maxHP") int maxHP, 
                   @JsonProperty("DMG") int DMG, 
                   @JsonProperty("desc") String desc) {
        super(maxHP, DMG);
        this.cr = cr;
        this.name = name;
        this.DMG = DMG;
        this.desc = desc;
    }
    

    //Specific methods to monsters
    public String getName() { return name; }
    public int getCr() { return cr; }
    public int getMaxHP() { return maxHP; }
    public int getDMG() { return DMG; }
    public String getDesc() { return desc; }

    @Override
    public String toString() {  //Currently just a debug string
        return "Monster{name='" + name + "', cr=" + cr + ", maxHP=" + maxHP + ", DMG=" + DMG + ", desc='" + desc + "'}";
    }
}
