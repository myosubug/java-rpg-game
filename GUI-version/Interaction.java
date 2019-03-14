import java.util.Random;
import javafx.scene.control.Label;

public class Interaction {
    /**
     * Declaring member variables, as the battle in this game only takes two creatures
     */
    Player player;
    Creature monster;
 


    //Constructor
    Interaction(Player player, Creature monster){
        this.player = player;
        this.monster = monster;
    }

    //getters and setters for member variables
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

    /**
     * this method starts a battle with Pikachu and the current monster that Pikachu has met on a tile
     * it takes Label object to print out message of the result of the battle
     * The battle is in while loop that ends when either of monster's hp or the player's hp become 0 or less
     * each creature's attack damage decreaes each other's hp by a chance
     * and send out the result on the label 
     * if player has lost it sends out message for restarting the game
     * else, player gets level-up event, then the defeated monster restroes its hp +25 to prepare next possible battle
     * @param output this is Label object that will show the result of battle in JavaFx application
     */
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
            output.setText("You have won the battle!\n"+player.toString()+"\n");
            this.monster.setHP(25);
        }  
    }

    





 



    
 
}
