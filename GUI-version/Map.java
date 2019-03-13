import java.util.ArrayList;

public class Map{

	/**
	 * Declaring member variables, the 2d array map and object that needs to be on the map.
	 */
	private ArrayList<Item> itemLocation= new ArrayList<Item>();
	private ArrayList<Creature> monsterLocation = new ArrayList<Creature>();
	private String mapFileLocation;

	private Item HP, battleFruit;   //items that will be randomly appearing on the map
	private Creature metapod, weedle, rattata; //different kinds of monsters on the map



	//CONSTRUCTORS
	Map() {


	this.HP = new Item("HP Potion", 10, 0, 32, 32);
	this.battleFruit = new Item("Battle Fruit", 0, 1, 64, 32);
	this.metapod = new Creature("Metapod", 20, 1, 7, 0, 0);
	this.weedle = new Creature("Weedle", 21, 1, 6, 96, 96);
	this.rattata = new Creature("Rattata", 24, 1, 8, 608, 608);

	itemLocation.add(HP);
	itemLocation.add(battleFruit);
	monsterLocation.add(metapod);
	monsterLocation.add(weedle);
	monsterLocation.add(rattata);

	}

	//METHODS
	/**
	 * getters and setters for Map and member variables
	 */

	public ArrayList<Item> getItemLocation() {
		return this.itemLocation;
	}


	public ArrayList<Creature> getMonsterLocation() {
		return this.monsterLocation;
	}


	public String getMapFileLocation(){
		return this.mapFileLocation;
	}



}
