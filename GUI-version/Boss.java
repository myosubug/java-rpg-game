public class Boss extends Creature{
  //extra variables to control boss' abilities
  private Inventory bossInventory;

  private String introMessage;
  private ArrayList<String> attackMessages = new ArrayList<String>;
  private String deathMessage;

  //used to store stats and attack damage of a special attack
  private ArrayList<int> specialAttack1 = new ArrayList<int>;

  //CONSTRUCTORS
  public Boss(Inventory bossItems, String bossIntroMessage, ArrayList<String> inFightMessages, String bossDeathMessage, ArrayList<int> specialAttack ){
    this.bossInventory = bossItems;
    this.introMessage = bossIntroMessage;
    this.attackMessages = inFightMessages;
    this.deathMessage = bossDeathMessage;
    this.specialAttack1 = specialAttack;
  }

  public Boss(){
    super("Boss", 100, 10, 10, 0, 0)
    this.bossInventory = new Inventory(new Item("Super Potion", 20, 1, this.getX(), this.getY()), new Item("Super Berry", 2, 3, this.getX(), this.getY()) );


  }
}
