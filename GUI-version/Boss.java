import java.util.ArrayList;

public class Boss extends Player{
  //extra variables to control boss' abilities
  private String name;
  private ArrayList<Item> bossInventory = new ArrayList<Item>();

  
  //CONSTRUCTORS
  public Boss(){
    super(100, 25, 12);
    this.name = "Ash";
    Item superPotion = new Item("Super Potion", 20, 1);
    Item superBerry = new Item("Super Berry", 2, 3);
    bossInventory.add(superPotion);
    bossInventory.add(superBerry);
  }

  /**
   * this method overrides getname method from Player class
   */
  @Override
  public String getName(){
    return this.name;
  }

  /**
   * this method overrides toString method from Player class
   */
  @Override
  public String toString(){
		return this.name + "\nHP: " + this.getHP();
	}
}
