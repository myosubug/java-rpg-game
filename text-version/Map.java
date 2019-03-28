public class Map{

	/**
	 * Declaring member variables, the 2d array map and object that needs to be on the map.
	 */
	private String[][] mapGrid;		//this will be the 2d array for any specific map screen
	private Item HP, battleFruit;   //items that will be randomly appearing on the map
	private Player pikachu;	        //the player character
	private Creature metapod, weedle, rattata; //different kinds of monsters on the map

	//CONSTRUCTORS
	/**
	 * Note: all maps are 8x8
	 * this constructor not only does create 2d array and filled each array with " - " so that it represents default cell
	 * but also member variables are delcared to be instances by using their own constructors.
	 * Initial potision of the objects are also set on this constructor.
	 */
	Map(){
		this.mapGrid = new String[8][8];
		for(int i = 0; i < this.mapGrid.length; i++){
			for(int j = 0; j < this.mapGrid[i].length; j++){
				mapGrid[i][j] = " - ";
			}
		}

		this.HP = new Item("HP Potion", 10, 0);
		this.battleFruit = new Item("Battle Fruit", 0, 1);
		this.pikachu = new Player();
		this.metapod = new Creature("Metapod", 20, 1, 7);
		this.weedle = new Creature("Weedle", 21, 1, 6);
		this.rattata = new Creature("Rattata", 24, 1, 5);

		this.setMap(" I ", 0, 4);
		this.setMap(" I ", 5, 5);
		this.setMap(" M ", 2, 4);
		this.setMap(" M ", 6, 6);
		this.setMap(" M ", 7, 2);
	}

	Map(Map m){
		this();
	}

	//METHODS
	/**
	 * getters and setters for Map and member variables
	 */
	public void setMap(String name, int x, int y){
		this.mapGrid[x][y] = name;
	}


	public String[][] getMap(){
		return this.mapGrid;
	}

	public Player getPikachu(){
		return this.pikachu;
	}

	public Creature getMetapod(){
		return this.metapod;
	}

	public Creature getWeedle(){
		return this.weedle;
	}

	public Creature getRattata(){
		return this.rattata;
	}

	public Item getHP(){
		return this.HP;
	}

	public Item getBattleFruit(){
		return this.battleFruit;
	}

}
