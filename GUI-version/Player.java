import java.util.ArrayList;
import java.io.*;

class Player extends Creature implements Serializable{

    private ArrayList<Item> inventory = new ArrayList<Item>();
    private int currentGameLevel = 1;


    Player() {
        super("Pikachu", 30, 1, 5);
    }

    public void addItemToInventory (Item newItem) {
        this.inventory.add(newItem);
    }

    //getter for array list
    public ArrayList<Item> getInventory() {
        return this.inventory;
    }

    public int getCurrentGameLevel(){
        return currentGameLevel;
    }

    public void setCurrentGameLevel(int level){
        this.currentGameLevel = level;
    }


    /**
     * this method returns nothing and takes no parameter.
     * it displays each item that is in the current inventory.
     */
    public String displayInventory(){
        String result = "";
        for(Item i : this.getInventory()){
            result += "* "+i.toString()+"\n";
        }
        return result +"\n To use items, use Z,X,C to use one of 3 items in order.";
    }

    //this toString() method overrides toString() method from Creature when it is called on player's class instance
    public String toString(){
        String r;
        r = super.getName() +"\n HP: "+super.getHP()+"\n Level: "+super.getLevel()+"\n Attack Damage: "+super.getAttack();
        return r;
    }

    /**
    * this method saves a player object to temp folder when game is saved
    */
    public void savePlayer(){
      try{
        //saves bytestream to temp folder
        FileOutputStream fileOut = new FileOutputStream("./temp/" + this.getName() + ".ser");
        ObjectOutputStream playerOut = new ObjectOutputStream(fileOut);
        playerOut.writeObject(this);
        playerOut.close();
        fileOut.close();
      }

      catch(IOException i){
        i.printStackTrace();
      }
    }

    /**
    * loads a player object from save state
    */
    public Player loadPlayer(){
      Player outputPlayer = new Player();

      try{
        FileInputStream fileIn = new FileInputStream("./temp/pikachu.ser");
        ObjectInputStream playerIn = new ObjectInputStream(fileIn);

        outputPlayer = (Player) playerIn.readObject();
        playerIn.close();
        fileIn.close();

        return outputPlayer;
      }

      catch(IOException i){
        i.printStackTrace();
        return null;
      }

      catch(ClassNotFoundException c){
        System.out.println("Player not found.");
        c.printStackTrace();
        return null;
      }
    }
}
