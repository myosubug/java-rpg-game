import java.util.ArrayList;

public class Boss extends Player{
  //extra variables to control boss' abilities
  private String name;
  private Inventory bossInventory;
  private String introMessage;
  private String attackMessage1;
  private String attackMessage2;
  private String deathMessage;


  //CONSTRUCTORS
  public Boss(String bossName, Inventory bossItems, String bossIntroMessage, String attackMessage1, String attackMessage2, String bossDeathMessage){
    this.name = name;
    this.setHP(100);
    this.setAttack(10);
    this.bossInventory = bossItems;
    this.introMessage = bossIntroMessage;
    this.attackMessage1 = attackMessage1;
    this.attackMessage2 = attackMessage2;
    this.deathMessage = bossDeathMessage;
  }

  public Boss(){
    this.name = name;
    this.setHP(100);
    this.setAttack(10);
    this.bossInventory = new Inventory();
    Item superPotion = new Item("Super Potion", 20, 1);
    bossInventory.addItem(superPotion);

    Item superBerry = new Item("Super Berry", 2, 3);
    this.bossInventory.addItem(superBerry);

  }

  public String getAttackMessage1(){
    return this.attackMessage1;
  }

  public String getAttackMessage2(){
    return this.attackMessage2;
  }

}
