import java.util.ArrayList;

public class Collision {

    private boolean itemFound = false;
    private boolean monsterFound = false;
    private int itemIndex;
    private int monsterIndex;

    public boolean isItemFound(Player pikachu, ArrayList<Item> itemLocation){
        for(Item item : itemLocation){
            if (pikachu.getX() == item.getX() && pikachu.getY() == item.getY()){
                itemFound = true;
                itemIndex = itemLocation.indexOf(item);
                break;
            }
            else
                itemFound = false;
        }
        return itemFound;

    }

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
