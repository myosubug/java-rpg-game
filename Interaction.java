import java.util.Scanner;

public class Interaction{
    Scanner pad;
    private Player pikachu = new Player();
    private Creature creature = new Creature();
    // Maybe used to call the inventory gathered from text app
    private TextApp test = new TextApp();

    {
        pad = new Scanner(System.in);
        System.out.println("Attack(j)");
        System.out.println("Use Item(k)");
        System.out.println("Run away(l)");
    }
    //Attack button
    public void Interaction(String pad) {
        if (pad.equals("j")) {
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
        else if (pad.eqauls("k")) {
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
        //Run away button
        else if (pad.equals("l")) {
            System.out.println("You have ran away!");

        }
    }

}