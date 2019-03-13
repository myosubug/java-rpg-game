import java.util.Random;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.Scene;
import javafx.event.EventHandler;

public class Interaction {
    /**
     * Declaring member variables, as the battle in this game only takes two creatures,
     * this class is extended from Creature class to properly access the intances of Creature.
     */
    Player player;
    Creature monster;
 


    //Constructor
    Interaction(Player player, Creature monster){
        this.player = player;
        this.monster = monster;
  
    }

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
                System.out.println(this.monster.getHP());
            }
            else{
                this.player.setHP(-this.monster.getAttack());
                System.out.println(this.player.getHP());
            }
        }
        if (this.player.getHP() <= 0){
            output.setText("===========YOU HAVE LOST THE BATTLE!===========");
        } else{
            this.player.levelUp();
            output.setText("You have won the battle!\n"+player.toString()+"\n");
            this.monster.setHP(25);
        }
        
        
        
    }

    





 



    
 
}
