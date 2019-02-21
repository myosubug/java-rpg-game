import java.util.ArrayList;

class Player extends Creature{
    private ArrayList<Item> inventory = new ArrayList<Item>();

    Player() {
        super("Pikachu", 30, 1, 5, 0, 0);
        this.inventory = inventory;
    }

    // Stores the item from the map into the player inventory
    public void addItemToInventory (Item newItem) {
        this.inventory.add(newItem);
    }

    public ArrayList<Item> getInventory() {
        return this.inventory;
    }

    public void displayInventory(){
        for(Item i : this.getInventory()){
            System.out.println(i.toString());
        }
    }

     // Movement of the player

    //Can we add functionality for WASD or arrow keys instead of just num pad? -Emily
    public void move(String pad){
        if ((pad.equals("W")) && ((super.getX() - 1) >= 0)){
            super.setLocation(super.getX()-1, super.getY());
            // when you type W you move up
        }
        else if ((pad.equals("A")) && ((super.getY() - 1) >= 0)){
            super.setLocation(super.getX(), super.getY()-1);
            // when you type 4 you move left
        }
        else if ((pad.equals("S")) && ((super.getX() + 1) <= 8)){
            super.setLocation(super.getX()+1, super.getY());
            // when you type 2 you move down
        }
        else if ((pad.equals("D")) && ((super.getX() + 1) <= 8)){
            super.setLocation(super.getX(), super.getY()+1);
            // when you type 6 you move right
        }
        else {
            System.out.println("You have to choose from Up(W)/Down(S)/Left(A)/Right(D)");
        }
    }

    public String toString(){
        String r;
        r = "Current status of "+super.getName() +"\n HP: "+super.getHP()+"\n Level: "+super.getLevel()+"\n Attack Damage: "+super.getAttack()+" \n Location (x, y): ("+super.getX()+", "+super.getY()+")";
        return r;
    }
    public static void main(String[] args) {
        Player pikachu = new Player();
        System.out.println(pikachu.toString());
    }
}
