import java.util.ArrayList;

public class Boss extends Creature{
  //extra variables to control boss' abilities
  private Inventory bossInventory;

  private String introMessage;
  private String attackMessage1;
  private String attackMessage2;
  private String deathMessage;


  //CONSTRUCTORS
  public Boss(Inventory bossItems, String bossIntroMessage, String attackMessage1, String attackMessage2, String bossDeathMessage){
    this.bossInventory = bossItems;
    this.introMessage = bossIntroMessage;
    this.attackMessage1 = attackMessage1;
    this.attackMessage2 = attackMessage2;
    this.deathMessage = bossDeathMessage;
  }

  public Boss(){
    super("Boss", 100, 10, 10, 0, 0);
    this.bossInventory = new Inventory();
    Item superPotion = new Item("Super Potion", 20, 1, this.getX(), this.getY());
    bossInventory.addItem(superPotion);

    Item superBerry = new Item("Super Berry", 2, 3, this.getX(), this.getY());
    this.bossInventory.addItem(superBerry);

  }


}
