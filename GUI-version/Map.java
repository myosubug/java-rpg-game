import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.concurrent.ThreadLocalRandom;

public class Map{

	/**
	 * Declaring member variables, the 2d array map and object that needs to be on the map.
	*/
	private ArrayList<Item> itemList= new ArrayList<Item>();
	private ArrayList<Creature> monsterList = new ArrayList<Creature>();
	private ArrayList<Item> itemLocation= new ArrayList<Item>();
	private ArrayList<Creature> monsterLocation = new ArrayList<Creature>();
	private char[][] mapData = new char[20][20];
	private String mapFileLocation;
	private int mapLineWidth;

	private Item HP, battleFruit;   //items that will be randomly appearing on the map
	private Creature metapod, weedle, rattata; //different kinds of monsters on the map

	//CONSTRUCTORS

	public Map(int mapLineWidth, String mapToRead){

		//will try to load map data from text file
		try{
			this.mapData = readMapFile(mapToRead, mapLineWidth);
		}
		//if it's unable to load file, will create a map with no obstacles instead
		catch(FileNotFoundException ex){
			System.out.print("Cannot read text file");
			this.mapData = null;
		}

		this.HP = new Item("HP Potion", 10, 0, 32, 32);
		this.battleFruit = new Item("Battle Fruit", 0, 1, 64, 32);
		this.metapod = new Creature("Metapod", 20, 1, 7, 224, 160);
		this.weedle = new Creature("Weedle", 21, 1, 6, 320, 320);
		this.rattata = new Creature("Rattata", 24, 1, 8, 608, 608);

		itemList.add(HP);
		itemList.add(battleFruit);
		monsterList.add(metapod);
		monsterList.add(weedle);
		monsterList.add(rattata);
	}


	public Map(){


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


	//METHODS
	/**
	 * getters and setters for Map and member variables
	 */

	public ArrayList<Item> getItemList() {
		return this.itemList;
	}


	public ArrayList<Creature> getMonsterList() {
		return this.monsterList;
	}


	public String getMapFileLocation(){
		return this.mapFileLocation;
	}


	public Item getRandomItem(){
		int index = ThreadLocalRandom.current().nextInt(this.itemList.size());
	    return itemList.get(index);
	}


	/**
	method reads a text file to get map data
	*/

	public static char[][] readMapFile(String fileName, int lengthOfSide) throws FileNotFoundException{
		char[][] mapData = new char[lengthOfSide][lengthOfSide];
		try{
			int lineWidth = 20;
			File mapFile = new File(fileName);
			Scanner scanner = new Scanner(mapFile);
			char[][] results = new char[20][20];

			for (int row = 0; scanner.hasNextLine() && row < lengthOfSide; row++) {
				results[row] = scanner.nextLine().toCharArray();
			}

			scanner.close();
			return results;
		}

		catch (FileNotFoundException ex) {
			System.out.println("Unable to open " + fileName);
			return null;
		}
	}










}
