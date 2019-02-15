import java.util.ArrayList;

public class Player extends Creature{
    private ArrayList<Item> inventory = new ArrayList<Item>();
    private int pad;
    private Location playerXcoord = Location.getXcoordinate();
    private Location playerYcoord = Location.getYcoordinate();



    public Player(ArrayList<Item> inventory, Location x, Location y, int pad) {
        super(); // Should call Creature(), which is Pikachu, 10, 1, 1
        this.inventory = inventory;
        this.playerXcoord = x;
        this.playerYcoord = y;
        this.pad = pad;
    }

    // Stores the item from the map into the player inventory
    public void ArrayList<Item> setInventory(Item newItem) {
        this.inventory.add(newItem);
    }

    public ArrayList<Item> getInventory() {
        return this.inventory;
    }

    public void setInventory(ArrayList<Item> inventory) {
        this.inventory = inventory;
    }

    // I don't think this code is necessary, but just in case if we want to change the stats based on level, this code might do.
    /*
    public void levelUp(hitPoints, level, attackDamage){
        int i = 1;
        if (i < level){
            this.hitPoints += 3;
            this.attackDamage += 1;
            i += 1;
        }
    }
    */


    // Movement of the player
    public void move(int pad){
        if (pad == 8){
            this.ycoord -= ycoord;
            // when you type 8 you move up
        }
        else if (pad == 4){
            this.xcoord -= xcoord;
            // when you type 4 you move left
        }
        else if (pad == 2){
            this.ycoord += ycoord;
            // when you type 2 you move down
        }
        else if (pad == 6){
            this.xcoord += xcoord;
            // when you type 6 you move right
        }
        else {
            System.out.println("You have to make a direction");
        }
    }


}
