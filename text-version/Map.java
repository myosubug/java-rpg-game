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

		this.HP = new Item("HP", 0, 4);
		this.battleFruit = new Item("BF", 5, 5);
		this.pikachu = new Player();
		this.metapod = new Creature("Metapod", 15, 1, 2, 2, 4);
		this.weedle = new Creature("Weedle", 10, 1, 3, 6, 6);
		this.rattata = new Creature("Rattata", 12, 1, 2, 7, 2);

		this.setMap(HP.getName(), HP.getX(), HP.getY());
		this.setMap(battleFruit.getName(), battleFruit.getX(), battleFruit.getY());
		this.setMap(metapod.getName(), metapod.getX(), metapod.getY());
		this.setMap(weedle.getName(), weedle.getX(), weedle.getY());
		this.setMap(rattata.getName(), rattata.getX(), rattata.getY()); 
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