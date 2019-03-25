import java.util.Random;
import javafx.scene.control.Label;

public class Interaction {

    public void battle(Player pikachu, Creature monster, Label battleOutput){      
        double fightRate = Math.random();
        if(fightRate < 0.60){
            monster.setHP(-pikachu.getAttack());
            battleOutput.setText("Your attack was succesful!");
        }
        else{
            pikachu.setHP(-monster.getAttack());
            battleOutput.setText(monster.getName()+" attacked you back!");
        }

        if (pikachu.getHP() <= 0){
            battleOutput.setText("===============================================\n===========YOU HAVE LOST THE BATTLE!=============\n===========PLEASE RE-START THE GAME=============\n===============================================");
        } else if(monster.getHP() <= 0){
            pikachu.levelUp();
            battleOutput.setText("You have won the battle with "+ monster.getName()+"!!\nTo go back to game map, press Q");
        }
    }
}