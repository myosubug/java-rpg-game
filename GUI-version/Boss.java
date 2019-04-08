import java.util.ArrayList;

public class Boss extends Player{
  //extra variables to control boss' abilities
  private String name;
  private ArrayList<Item> bossInventory = new ArrayList<Item>();
  private String introMessage;
  private String attackMessage1;
  private String attackMessage2;
  private String deathMessage;
  //CONSTRUCTORS

  public Boss(){
    this.name = "Ash";
    this.setHP(100);
    this.setAttack(12);
    Item superPotion = new Item("Super Potion", 20, 1);
    Item superBerry = new Item("Super Berry", 2, 3);
    bossInventory.add(superPotion);
    bossInventory.add(superBerry);
  }

  public String getAttackMessage1(){
    return this.attackMessage1;
  }

  public String getAttackMessage2(){
    return this.attackMessage2;
  }

  @Override
  public String getName(){
    return this.name;
  }

  @Override
  public String toString(){
		return this.name + "\nHP: " + this.getHP();
	}
}
