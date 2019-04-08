import java.util.Random;
import javafx.scene.control.Label;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Arrays;

public class Interaction {

  public int bossTurn(Boss boss, Label battleOutput){
    //displays initial boss message before the attack
    int randomMessage = ThreadLocalRandom.current().nextInt(1, 3);

    if (randomMessage == 1){
      battleOutput.setText(boss.getAttackMessage1());
    }
    else{
      battleOutput.setText(boss.getAttackMessage2());
    }

    //decides whether boss will attack or use an item
    double itemOrAttack = Math.random();

    //if its HP is below 5, it will use its potion
    if (boss.getHP() <= 5){
      Item superPotion = new Item("Super Potion", 20, 1);
      if (Arrays.asList(boss.getInventory()).contains(superPotion)){
        battleOutput.setText(boss.getName() + " used a Super Potion and regained 20 HP!");
        return 0;
      }

      //if boss doesn't have super potion, attacks instead
      else{
        itemOrAttack = 0.1;
      }
    }


    //30% chance of using its super berry
    if (itemOrAttack > 0.7){
      Item superBerry = new Item("Super Berry", 2, 3);
      if (Arrays.asList(boss.getInventory()).contains(superBerry)){
        battleOutput.setText(boss.getName() + " used a Super Berry and its attack went up!");
        return 0;
      }

      //if the boss's inventory doesn't contain a super berry, it attacks instead
      else{
        itemOrAttack = 0.1;
      }
    }

    //70% chance of attacking
    if (itemOrAttack <= 0.7){
      double monsterAttack = Math.random();

      if (boss.getAttack() > monsterAttack){
        int damagePoints = -(int)(monsterAttack * boss.getAttack());
        battleOutput.setText("The " + boss.getName() + " did " + damagePoints + " of damage to you!");
        return damagePoints;
      }

      else {
        battleOutput.setText("The " + boss.getName() + " tried to attack, but it missed!");
        return 0;
      }
    }


    return 0;

  }


  public int monstersTurn(Creature monster, Label battleOutput){
    double monsterAttack = Math.random();

    if (monster.getAttackStrength() > monsterAttack){
      int damagePoints = -(int)(monsterAttack * monster.getAttack());
      battleOutput.setText("The " + monster.getName() + " did " + damagePoints + " of damage to you!");
      return damagePoints;
    }

    else {
      battleOutput.setText("The " + monster.getName() + " tried to attack, but it missed!");
      return 0;
    }
  }

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
            battleOutput.setText("Your attack was succesful! \nYou did " + pikachu.getAttack() + " damage! \nTo fight, press J or to run away, press Q.");
        }
        else{
            //pikachu.setHP(-monster.getAttack());
            battleOutput.setText("You tried to hit, but you missed! \nTo fight, press J or to run away, press Q.");
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
