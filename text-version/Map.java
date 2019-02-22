public class Map{
	private String[][] mapGrid;		//this will be the 2d array for any specific map screen
	private Item HP, battleFruit;
	private Player pikachu;
	private Creature metapod, weedle, rattata;

	//CONSTRUCTORS
	//Sean has merged createEmptyMap() method to this constructor as it is useless to do it 2 steps while we can do it once
	//at constructor 
	Map(){
		this.mapGrid = new String[8][8];
		for(int i = 0; i < this.mapGrid.length; i++){
			for(int j = 0; j < this.mapGrid[i].length; j++){
				mapGrid[i][j] = " - ";
			}
		}

		this.HP = new Item("HP Potion");
		this.battleFruit = new Item("Battle Fruit");
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
	/**Note, all maps are 8x8*/
	public void setMap(String name, int x, int y){
		this.mapGrid[x][y] = name;
	}


	public String[][] getMap(){ 	//NOTE: NEEDS TO BE ENCAPSULATED, SHOULD RETURN A COPY OF mapGrid
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

	public void printMap(){
		String [][] m = this.getMap();
		for(int i = 0; i < m.length; i++){
			System.out.println();
			System.out.println();
			for(int j = 0; j < m[0].length; j++){
				System.out.print(m[i][j]);
			}
		}
		System.out.println();
	}

	//main method working, printMap() function is located in Map.java now

	public static void main(String[] args) {
		Map test = new Map();
		test.printMap();
	
			
	}
}
