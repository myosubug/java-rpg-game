public class Map{
	private String[][] mapGrid;		//this will be the 2d array for any specific map screen


	//CONSTRUCTORS
	//Sean has merged createEmptyMap() method to this constructor as it is useless to do it 2 steps while we can do it once
	//at constructor 
	Map(){
		this.mapGrid = new String[8][8];
		for(int i = 0; i < this.mapGrid.length; i++){
			for(int j = 0; j < this.mapGrid[i].length; j++){
				mapGrid[i][j] = "  [*****]  ";
			}
		}
	}

	//METHODS
	/**Note, all maps are 8x8*/
	public void setMap(String name, int x, int y){
		this.mapGrid[x][y] = name;
	}


	public String[][] getMap(){ 	//NOTE: NEEDS TO BE ENCAPSULATED, SHOULD RETURN A COPY OF mapGrid
		return this.mapGrid;
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