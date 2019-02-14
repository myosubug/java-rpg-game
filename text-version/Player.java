import java.util.ArrayList;

public class Player extends Creature{
    private ArrayList<Item> inventory = new ArrayList<Item>();
    private int ycoord;
    private int xcoord;
    private int pad;


    public Player(ArrayList<Item> inventory, int ycoord, int xcoord, int pad) {
        super(); // Should call Creature(), which is Pikachu, 10, 1, 1
        this.inventory = inventory;
        this.ycoord = ycoord;
        this.xcoord = xcoord;
        this.pad = pad;
    }

    // Stores the item from the map into the player inventory
    public ArrayList<Item> inventory() {
        ArrayList<Item> playerInventory = new ArrayList<Item>();
        playerInventory.add(getItem());
        return playerInventory;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<Item> inventory) {
        this.inventory = inventory;
    }

    // I don't think this code is necessary, but just in case if we want to change the stats based on level, this code might do.

    public void levelUp(hitPoints, level, attackDamage){
        int i = 1;
        if (i < level){
            this.hitPoints += 3;
            this.attackDamage += 1;
            i += 1;
        }
    }


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
