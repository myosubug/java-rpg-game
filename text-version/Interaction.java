import java.util.Scanner;

public class Interaction extends Creature{
    Player player;
    Creature monster;

    Interaction(Player player, Creature monster){
        //We already gave the player running away option on the higher level 
        //so I don't think this is necessary
        //System.out.println("Run away (r)");
        this.player = player;
        this.monster = monster;
        System.out.println("Battle started with "+this.monster.getName());

    }
    
    public void battle() {
        Scanner keyboard = new Scanner(System.in);
        while(this.player.getHP() > 0 && this.monster.getHP() > 0){
            System.out.println();
            System.out.println("You can attack (j) or you can use item (k)");
            String input = keyboard.nextLine();
            String inputCap = input.toUpperCase();
           
            if (inputCap.equals("J")){
                double monsterAttackChance = Math.random();
                this.monster.setHP(this.monster.getHP() - this.player.getAttack());
                System.out.println("You have successfully attacked the "+this.monster.getName()+"!");
                System.out.println();
                System.out.println(this.monster.toString());
               
                if(monsterAttackChance > 0.50){
                    System.out.println();
                    System.out.println();
                    System.out.println("The monster have attacked you back!");
                    System.out.println();
                    this.player.setHP(this.player.getHP() - this.monster.getAttack());
                    System.out.println();
                    System.out.println(this.player.toString());
                }
            } 
            //Made else into else if K
            else if (inputCap.equals("K")){
                System.out.println("You can use 1 item from your inventory! \n please select an item by number (1, 2, 3 ...) ");
                this.player.displayInventory();
                int input2 = keyboard.nextInt();
                Item item = this.player.getInventory().get(input2-1);
                String itemName = item.toString();

                if (itemName.equals("HP Potion")){
                    this.player.setHP(this.player.getHP() + 10);
                    System.out.println("Your HP has increased by 10");
                    input = keyboard.nextLine();
                    inputCap = input.toUpperCase();
                    continue;
                } 
                
                else if (itemName.equals("Battle Fruit")){
                    this.player.setAttack(this.player.getAttack() + 1);
                    System.out.println("Your attack has increased by 1");
                    input = keyboard.nextLine();
                    inputCap = input.toUpperCase();
                    continue;
                }

                continue;
                

            }
            else {
                System.out.println("You must type either 'J' or 'K');
            }
        }

        if (this.player.getHP() <= 0){
            System.out.println("You have lost the battle, please restart the game");
            System.exit(0);
        }

        else{
            System.out.println("You have won the battle! \n your level increased!");
            System.out.println();
            this.player.levelUp();
            System.out.println();
            System.out.println(this.player.toString());
            System.out.println();
        }
        
        
        /**
         * if (pad.equals("j")) {
            pikachu.getAttack();
            System.out.println("you have dealt " + pikachu.getAttack());
            //creature hp = creature hp - pikachu dmg
            Creature.creature(hitPoints) = creature(hitPoints) - pikachu.getAttack();
            // creature then attacks pikachu
            //a bug is when the creature is dead, it still attacks pikachu
            //also the fight does not end if either party hp goes to 0
            pikachu(hitPoints - creature.getAttack());


        }
        //Item button
        else if (pad.equals("k")) {
            System.out.println("What kind of item do you want to use?");
            // scans the current inventory
            System.out.println(Player.Inventory);

            //If you used an item
            if (pad.equals = "a") {
                pikachu(hitPoints) = pikachu(hitPoints + 1);
                //Removing item from TestApp array
                test.getPikachu().removeItem(test.getBattleFruit());
            }

            else if (pad.equals("l")) {
                System.out.println("You have chosen not to use an item");
            }
        }
        */
    }
}