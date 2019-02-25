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
    public void displayInventory(){
        int order = 1;
        for(Item i : this.getInventory()){
            System.out.print(order+": ");
            System.out.println(i.toString());
            order++;
        }
    }

   /**
    * this method takes a String parameter as input (W,A,S,D) and moves accoding to its direction.
    * this doesn't return anything.
    * as the array starts from left top (0,0), up, down, left, right has been impletmented along with the direction. 
    * @param pad
    */
    public void move(String pad){
        if ((pad.equals("W")) && ((super.getX() - 1) >= 0)){
            super.setLocation(super.getX() - 1, super.getY());
            // when you type W you move up
        }
        else if ((pad.equals("A")) && ((super.getY() - 1) >= 0)){
            super.setLocation(super.getX(), super.getY() - 1);
            // when you type A you move left
        }
        else if ((pad.equals("S")) && ((super.getX() + 1) <= 7)){
            super.setLocation(super.getX() + 1, super.getY());
            // when you type S you move down
        }
        else if ((pad.equals("D")) && ((super.getY() + 1) <= 7)){
            super.setLocation(super.getX(), super.getY() + 1);
            // when you type D you move right
        }
        else {
            System.out.println("You have to choose from Up(W)/ Down(S)/ Left(A)/ Right(D)");
        }
    }

    //this toString() method overrides toString() method from Creature when it is called on player's class instance
    public String toString(){
        String r;
        r = "Current status of "+super.getName() +"\n HP: "+super.getHP()+"\n Level: "+super.getLevel()+"\n Attack Damage: "+super.getAttack();
        return r;
    }
}
