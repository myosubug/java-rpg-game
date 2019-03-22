import java.util.ArrayList;
import java.io.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.control.Label;

class Player extends Creature implements Serializable{
    //declaring member variable, the player will use array list as a item bag
    private ArrayList<Item> inventory = new ArrayList<Item>();
    private int currentGameLevel = 1;
    private Image pikachuImage;
    private boolean isGameLoaded = false;

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

    public int getCurrentGameLevel(){
        return currentGameLevel;
    }

    public void setCurrentGameLevel(int level){
        this.currentGameLevel = level;
    }

    public void setPikachuImage(String FileLcation){
        this.pikachuImage = new Image(FileLcation);
    }

    public Image getPikachuImage(){
        return this.pikachuImage;
    }

    public boolean getIsGameLoaded(){
        return this.isGameLoaded;
    }

    public void setIsGameLoaded(boolean a){
        this.isGameLoaded = a;
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
        r = "Current status of "+super.getName() +"\n HP: "+super.getHP()+"\n Level: "+super.getLevel()+"\n Attack Damage: "+super.getAttack();
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



    public void playerMovement(Player pikachu, int pikachuX, int pikachuY, String imgLocation, Stage primaryStage, Collision collisionCheck, Map gameMap, Scene battleScene, Label output, boolean eastOrWest, Interaction interactionHandler){
        boolean objectCheck = collisionCheck.objectCollisionCheck(pikachuX, pikachuY, gameMap.getMapData());
        boolean secondMapUpdateCheck = collisionCheck.secondMapUpdateCheck(pikachuX, pikachuY, gameMap.getMapData());
        boolean firstMapUpdateCheck = collisionCheck.firstMapUpdateCheck(pikachuX, pikachuY, gameMap.getMapData());
        if(pikachuX >= 0 && pikachuX <= 608 && pikachuY >= 0 && pikachuY <= 608 && objectCheck == false){
            setPikachuImage(imgLocation);
            pikachu.setX(pikachuX);
            pikachu.setY(pikachuY);
            interactionHandler.itemInteractionHandler(pikachu, gameMap, output);
            interactionHandler.monsterInteractionHandler(primaryStage, battleScene);
            if(secondMapUpdateCheck == true && eastOrWest){
                pikachu.setCurrentGameLevel(2);
            } else if (firstMapUpdateCheck == true && eastOrWest){
                pikachu.setCurrentGameLevel(1);
            }
        }
        else
            output.setText("Use WASD to move around. To see inventory, Use B.\n"+"To use items, use Z,X,C to use one of 3 items in order.");
        pikachu.setIsGameLoaded(false);
    }


    public void itemSelect(Player pikachu, int invenNum, Label output){
        try{
		if(pikachu.getInventory().get(invenNum).getName().equals("HP Potion"))
            pikachu.setHP(pikachu.getInventory().get(invenNum).getHPIncrease());
        else if (pikachu.getInventory().get(invenNum).getName().equals("Battle Fruit"))
            pikachu.setAttack(pikachu.getInventory().get(invenNum).useItem());
        output.setText("Used "+pikachu.getInventory().get(invenNum).getName()+"\n"+pikachu.toString());
        pikachu.getInventory().remove(invenNum);
        } catch (Exception e){
            System.out.println("tried to access an empty inventory to delete item or to use non-existing item.");
            output.setText("tried to access an empty inventory to delete item or to use non-existing item.");
        }
    }
}
