import java.util.ArrayList;

class Player extends Creature{
    //declaring member variable, the player will use array list as a item bag
    private ArrayList<Item> inventory = new ArrayList<Item>();

    //Constructor, calls its super class, Creature to create the player's character, Pikachu.
    Player() {
        super("Pikachu", 30, 1, 5, 0, 0);
    }

    /**
     * this method returns nothing but adds an item (parameter) to inventory arraylist.
     * @param newItem
     */
    public void addItemToInventory (Item newItem) {
        this.inventory.add(newItem);
    }

    //getter for array list
    public ArrayList<Item> getInventory() {
        return this.inventory;
    }

    /**
     * this method returns nothing and takes no parameter.
     * it displays each item that is in the current inventory.
     */
    public String displayInventory(){
        int order = 1;
        String result = "";
        for(Item i : this.getInventory()){
            result += order+": "+i.toString()+"\n";
            order++;
        }
        return result;
    }

    //this toString() method overrides toString() method from Creature when it is called on player's class instance
    public String toString(){
        String r;
        r = "Current status of "+super.getName() +"\n HP: "+super.getHP()+"\n Level: "+super.getLevel()+"\n Attack Damage: "+super.getAttack();
        return r;
    }
}
