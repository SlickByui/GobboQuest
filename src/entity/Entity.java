package entity;
/*************************************************************************
 *  Entity Abstract Class
 *   - Base template class for creatures and the player
 * 
 * 
 *************************************************************************/

public abstract class Entity {
    //Basic entity attributes
    protected int maxHP;                  //dont let program change this ever
    protected int currentHP;
    protected int DMG;
    protected Boolean isAlive;

    //Is a constructor necessary for this or just leave up to child?
    public Entity(int maxHP, int DMG){
        this.isAlive = true;  //default true for all things (idk why it wouldn't be)
        this.maxHP = maxHP;
        this.currentHP = maxHP;
        this.DMG = DMG;
    }

    //General methods
    public int getHP(){
        return currentHP;
    }

    public void TakeDamage(int damage) {
        currentHP -= damage;

        //Check to see if entity is still alive
        if (currentHP <= 0){
            isAlive = false;
        }
    }

    public int Attack() {
        return DMG;
    }

    public Boolean IsAlive() {
        return isAlive;
    }
}
