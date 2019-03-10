import java.util.Scanner;
import java.util.Random;

public class Interaction {
    /**
     * Declaring member variables, as the battle in this game only takes two creatures,
     * this class is extended from Creature class to properly access the intances of Creature.
     */
    Player player;
    Creature monster;
    String outputMessage;

    //Constructor
    Interaction(Player player, Creature monster){
        this.player = player;
        this.monster = monster;
        outputMessage = "Battle started with "+this.monster.getName();

    }

    /**
     * this method takes no parameter and returns nothing.
     * However, it prepares a battle between the player and a monster by taking user input for each different situation
     */
    public String battle(boolean userInput) {
        
       
        //this while block infinitely loops until either the player's hp or a monster's hp is not 0
        while(this.player.getHP() > 0 && this.monster.getHP() > 0){
            System.out.println();
            System.out.println("You can attack (j) or you can use item (k)");
            String input = keyboard.nextLine();
            String inputCap = input.toUpperCase();

            //if the player wants to fight
            if (inputCap.equals("J")){
                double monsterAttackChance = Math.random();
                this.monster.setHP(this.monster.getHP() - this.player.getAttack());
                System.out.println("You have successfully attacked the "+this.monster.getName()+"!");
                System.out.println();
                System.out.println(this.monster.toString());

                //the monster also have chance to attack the player back by 50%
                if(monsterAttackChance > 0.50){
                    System.out.println();
                    System.out.println();
                    System.out.println("The monster has attacked you back!");
                    System.out.println();
                    this.player.setHP(this.player.getHP() - this.monster.getAttack());
                    System.out.println();
                    System.out.println(this.player.toString());
                }

                //lets you know if monster doesn't hit
                else if(monsterAttackChance <= 0.50){
                    System.out.println();
                    System.out.println();
                    System.out.println("The monster missed you!");
                    System.out.println();
                    System.out.println();
                    System.out.println(this.player.toString());
                }
            }
            //else if player wants to use item to recover HP or increase attack damage
            else if (inputCap.equals("K")){
                System.out.println("You can use 1 item from your inventory! \n please select an item by number (1, 2, 3 ...) ");
                this.player.displayInventory();
                int input2 = keyboard.nextInt();
                Item item = this.player.getInventory().get(input2-1);
                String itemName = item.toString();

                if (item.getHPIncrease() > 0){
                  this.player.setHP(this.player.getHP() + item.getHPIncrease());
                  System.out.println("Your HP went up by " + item.getHPIncrease());
                }

                if (item.getAttackIncrease() > 0){
                  this.player.setAttack(this.player.getAttack() + item.getAttackIncrease());
                  System.out.println("Your attack went up by " + item.getAttackIncrease());
                }

                continue;

            }
            //if user input is incorrect and it will prompt to ask the user again to enter correct inputs
            else {
                System.out.println("You must type either 'J' or 'K'");
            }
        }


          //after the battle, the monster randomly recovers its hp up to 15
          Random rand = new Random();
          int randomRecovery =  rand.nextInt(15);
          this.monster.setHP(randomRecovery);

        //after the fight, if the player's hp is 0 or less, game ends as the player has been defeated
        if (this.player.getHP() <= 0){
            System.out.println("You have lost the battle, please restart the game");
            System.exit(0);

            return "lose";
        }

        //if the player survives and won the battle, player's level increases by 1
        else{
            System.out.println("You have won the battle! \n your level increased!");
            System.out.println();
            this.player.levelUp();
            System.out.println();
            System.out.println(this.player.toString());
            System.out.println();

            return "win";
        }
    }
}
