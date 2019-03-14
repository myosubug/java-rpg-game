import java.util.ArrayList;

public class Collision {

    //declaring member variables for Collision class
    private boolean monsterFound = false;
    private int itemIndex;
    private int monsterIndex;
    
   
    /**
     * this method checks if the current tile (where player is located) has monster.
     * it compares x and y (in pixels) of player and monster arraylist
     * it returns monsterFound boolean variable, if found, true or if not found, false.
     * @param pikachu this is the current player character, pikachu
     * @param monsterLocation this is an arraylist that has list of monsters and its location as in Creature type
     * @return monsterFound it returns whether if monster is found on player's current location 
     */
    public boolean isMonsterFound(Player pikachu, ArrayList<Creature> monsterLocation){
        for(Creature monster : monsterLocation){
            if (pikachu.getX() == monster.getX() && pikachu.getY() == monster.getY()){
                monsterFound = true;
                monsterIndex = monsterLocation.indexOf(monster);
                break;
            }
            else
                monsterFound = false;
        }
    return monsterFound;
    }

    //getters and setters for member variables
    public int getItemIndex(){
        return this.itemIndex;
    }

    public int getMonsterIndex(){
        return this.monsterIndex;
    }

    public boolean getMonsterFound(){
        return this.monsterFound;
    }

    
}
