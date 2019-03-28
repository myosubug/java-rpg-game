import java.util.Random;
import javafx.scene.control.Label;

public class Interaction {

    /**
      * this method controls battle between player and a monster and prints out status to a label
      * @param pikachu player class, pikachu is passed to this argument
      * @param monster any creature class but other than player class is passed to here.
      * @param battleOutput this is label that is in battle scene.
      * @return true is battle is finished and false if battle is not finished.
      */
    public boolean battle(Player pikachu, Creature monster, Label battleOutput){      
        double fightRate = Math.random();
        //by 59% of chance, monster attacks back player every time player tries to attack the monster
        if(fightRate < 0.60){
            monster.setHP(-pikachu.getAttack());
            battleOutput.setText("Your attack was succesful!");
        }
        else{
            pikachu.setHP(-monster.getAttack());
            battleOutput.setText(monster.getName()+" attacked you back!");
        }

        //if either of monster or player's hp become 0, the battle is over.
        if (pikachu.getHP() <= 0){
            battleOutput.setText("============================================================\n===========YOU HAVE LOST THE BATTLE!==========================\n===========PLEASE GO BACK TO GAME MAP BY PRESS Q===============\n============================================================");
            pikachu.setHP(1);
            return true;
        } else if(monster.getHP() <= 0){
            pikachu.levelUp();
            battleOutput.setText("You have won the battle with "+ monster.getName()+"!!\nTo go back to game map, press Q");
            return true;
        } else {
            return false;
        }
    }
}