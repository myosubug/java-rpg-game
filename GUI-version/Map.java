import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Map{

	/**
	 * Declaring member variables
	*/
	private ArrayList<Item> itemList= new ArrayList<Item>();
	private ArrayList<Creature> monsterList = new ArrayList<Creature>();
	private Item HP, battleFruit;   //items that will be randomly appearing on the map
	private Creature metapod, weedle, rattata; //different kinds of monsters on the map

	//CONSTRUCTOR
	public Map(){
	// adding items and monsters that we are going to place on the map to each array of monster and item
	this.HP = new Item("HP Potion", 10, 0, 32, 32);
	this.battleFruit = new Item("Battle Fruit", 0, 1, 64, 32);
	this.metapod = new Creature("Metapod", 20, 1, 7, 0, 0);
	this.weedle = new Creature("Weedle", 21, 1, 6, 96, 96);
	this.rattata = new Creature("Rattata", 24, 1, 8, 608, 608);

	itemList.add(HP);
	itemList.add(battleFruit);
	monsterList.add(metapod);
	monsterList.add(weedle);
	monsterList.add(rattata);

	}

    /**
	 * getters and setters for member variables
	 */

	public ArrayList<Item> getItemList() {
		return this.itemList;
	}


	public ArrayList<Creature> getMonsterList() {
		return this.monsterList;
	}

	/**
	 * this method picks a random item from itemList, which is an array List
	 * @return it returns a randomly picked item from itemList
	 */
	public Item getRandomItem(){
		int index = ThreadLocalRandom.current().nextInt(this.itemList.size());
	    return itemList.get(index);
	}

}
