import java.util.Random;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;

public class Interaction {
    /**
     * Declaring member variables, as the battle in this game only takes two creatures,
     * this class is extended from Creature class to properly access the intances of Creature.
     */
    private Player player;
    private Creature monster;


    //Constructor

    public Player getPlayer() {
        return this.player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Creature getMonster() {
        return this.monster;
    }

    public void setMonster(Creature monster) {
        this.monster = monster;
    }


    public void battle(Label output){      
        while(this.player.getHP() > 0 && this.monster.getHP() > 0){
            double fightRate = Math.random();
            if(fightRate < 0.80){
                this.monster.setHP(-this.player.getAttack());
            }
            else{
                this.player.setHP(-this.monster.getAttack());
            }
        }
        if (this.player.getHP() <= 0){
            output.setText("===========YOU HAVE LOST THE BATTLE!===========\n===========PLEASE RE-START THE GAME===========");
        } else{
            this.player.levelUp();
            output.setText("You have won the battle with "+ this.monster.getName() +"\n"+player.toString()+"\n");
            this.monster.setHP(25);
        }
    }



    public void itemInteractionHandler(Player pikachu, Map gameMap, Label output){

        double randomRate = Math.random();
        if (randomRate <= 0.04 && pikachu.getInventory().size() < 3){
            pikachu.addItemToInventory(gameMap.getRandomItem());
            output.setText("Item has been found!\nItem has been added to your inventory!\n"+pikachu.displayInventory());
        }

    }

    public void monsterInteractionHandler(Stage primary, Scene battleScene){
        double randomRate = Math.random();
        if (randomRate <= 0.04){
            primary.setScene(battleScene);
        }
    }

    





 



    
 
}
