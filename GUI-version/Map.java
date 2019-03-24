import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.ItemListener;
import java.io.*;
import java.util.concurrent.ThreadLocalRandom;

public class Map implements Serializable{

	/**
	 * Declaring member variables, the 2d array map and object that needs to be on the map.
	*/
	private ArrayList<Item> itemList= new ArrayList<Item>();
	private ArrayList<Creature> monsterList = new ArrayList<Creature>();
	private char[][] mapData;
	private String mapFileLocation;


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

		this.HP = new Item("HP Potion", 10, 0);
		this.battleFruit = new Item("Battle Fruit", 0, 1);
		this.metapod = new Creature("Metapod", 20, 1, 7, "file:img/metapod.png");
		this.weedle = new Creature("Weedle", 21, 1, 6);
		this.rattata = new Creature("Rattata", 24, 1, 8, "file:img/rattata.gif");

		itemList.add(HP);
		itemList.add(battleFruit);
		monsterList.add(metapod);
		//monsterList.add(weedle);
		monsterList.add(rattata);
	}


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

	public Creature getRandomMonster(){
		int index = ThreadLocalRandom.current().nextInt(this.monsterList.size());
	    return monsterList.get(index);
	}

	public char[][] getMapData(){
		return this.mapData;
	}

	public void printMap(){
		for (int i = 0; i < 20; i++){
			System.out.println("");
			for (int j = 0; j < 20; j++){
			  System.out.print(this.mapData[i][j]);
			}
		}
	}

	/**
	method reads a text file to get map data
	*/

	public char[][] readMapFile(String fileName, int lengthOfSide) throws FileNotFoundException{
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


		/**
		Method is used to save the map state when player saves game.
		Needed because of boss and miniboss locations
		which are deleted from map after defeat.
		*/
		public void saveMap(){
			if (this.mapData != null){
				try{
					//saves bytestream to temp folder
					FileOutputStream fileOut = new FileOutputStream("./temp/currentmap.ser");
					ObjectOutputStream mapOut = new ObjectOutputStream(fileOut);
					mapOut.writeObject(this);
					mapOut.close();
					fileOut.close();
				}

				catch(IOException i){
					i.printStackTrace();
				}
			}

			else
				System.out.println("No map data to save.");
		}

		/**
		Method loads a saved map
		*/
		public Map loadMap(){
			Map outputMap = new Map(20, "blankMap");

			try{
				FileInputStream fileIn = new FileInputStream("./temp/currentmap.ser");
	      ObjectInputStream mapIn = new ObjectInputStream(fileIn);

				outputMap = (Map) mapIn.readObject();
				mapIn.close();
				fileIn.close();
				return outputMap;
			}

			catch(IOException i){
				i.printStackTrace();
				return null;
			}

			catch(ClassNotFoundException c){
				System.out.println("No map found.");
				c.printStackTrace();
				return null;
			}
		}

	}
