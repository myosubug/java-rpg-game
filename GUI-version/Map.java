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
	private ArrayList<char[]> mapData = new ArrayList<char[]>();
	private String mapFileLocation;
	private int mapLineWidth;

	private Item HP, battleFruit;   //items that will be randomly appearing on the map
	private Creature metapod, weedle, rattata; //different kinds of monsters on the map

	//CONSTRUCTORS

	public Map(int mapLineWidth, String mapToRead){
		this.mapLineWidth = mapLineWidth;

		//will try to load map data from text file
		try{
			this.mapData = readMapFile(mapToRead);
		}
		//if it's unable to load file, will create a map with no obstacles instead
		catch(FileNotFoundException ex){
			char[] blankLine = new char[mapLineWidth];
			for (int i = 0; i < mapLineWidth; i++){
				String dash = "-";
				char blankSymbol = dash.charAt(0);
				blankLine[i] = blankSymbol;
			}

			for (int i = 0; i < mapLineWidth; i++){
				this.mapData.add(blankLine);
			}
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

	public static ArrayList<char[]> readMapFile(String fileName) throws FileNotFoundException{

		try{
			int lineWidth = 20;

			File mapFile = new File(fileName);
			Scanner scanner = new Scanner(mapFile);
			ArrayList<char[]> results = new ArrayList<char[]>();

			//while there are lines remaining in the file
			while (scanner.hasNextLine()){
				//creates a list for characters in this row
				char[] currentRow = new char[lineWidth];

				//gets each individual character from text file and adds it as a list element
				for (int i = 0; i < lineWidth; i++){
					currentRow[i] = scanner.next().charAt(0);
				}

				//adds the 1d list to the 2d array of map data results
				results.add(currentRow);
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
