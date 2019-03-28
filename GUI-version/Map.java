import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.util.concurrent.ThreadLocalRandom;
import javafx.scene.image.Image;

public class Map implements Serializable{

	//declaring member variables
	private ArrayList<Item> itemList= new ArrayList<Item>();
	private ArrayList<Creature> monsterList = new ArrayList<Creature>();
	private char[][] mapData;
	private String mapFileLocation;

	//CONSTRUCTOR
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
		itemList.add(new Item("HP Potion", 10, 0));
		itemList.add(new Item("Battle Fruit", 0, 1));
		monsterList.add(new Creature("Metapod", 20, 1, 7, "file:img/metapod.png"));
		monsterList.add(new Creature("Rattata", 24, 1, 8, "file:img/rattata.gif"));
		monsterList.add(new Creature("Weedle", 22, 1, 9, "file:img/weedle.png"));
	}

	//getters and setter methods
	public ArrayList<Item> getItemList() {
		return this.itemList;
	}

	public ArrayList<Creature> getMonsterList() {
		return this.monsterList;
	}

	public String getMapFileLocation(){
		return this.mapFileLocation;
	}

	public char[][] getMapData(){
		return this.mapData;
	}


	/**
	 * this method randomly picks an item out of the two kinds from arraylist, itemList
	 * @return it returns randomly picked item from the arraylist.
	 */
	public Item getRandomItem(){
		int index = ThreadLocalRandom.current().nextInt(this.itemList.size());
	    return itemList.get(index);
	}

	/**
	 * this method randomly picks a monster out of three kinds from arraylist, monsterList
	 * @return it returns randomly picked monster from the arraylist.
	 */
	public Creature getRandomMonster(){
		int index = ThreadLocalRandom.current().nextInt(this.monsterList.size());
	    return monsterList.get(index);
	}




   /**
	* method reads a text file to get map data
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
		* Method is used to save the map state when player saves game.
		* Needed because of boss and miniboss locations
		* which are deleted from map after defeat.
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
		* Method loads a saved map
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
