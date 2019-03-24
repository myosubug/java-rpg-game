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


    public void battle(Player pikachu, Creature monster, Label battleOutput){      
        double fightRate = Math.random();
        if(fightRate < 0.80){
            monster.setHP(-pikachu.getAttack());
            battleOutput.setText("Your attack was succesful!");
        }
        else{
            pikachu.setHP(-monster.getAttack());
            battleOutput.setText(monster.getName()+" attacked you back!");
        }

        if (pikachu.getHP() <= 0){
            battleOutput.setText("===============================================\n===========YOU HAVE LOST THE BATTLE!===========\n===========PLEASE RE-START THE GAME============\n===============================================");
        } else if(monster.getHP() <= 0){
            pikachu.levelUp();
            battleOutput.setText("You have won the battle with "+ monster.getName()+"!!\nTo go back to game map, press Q");
        }
    }
}