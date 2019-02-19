public class Map{
	private String[][] mapGrid;		//this will be the 2d array for any specific map screen
	private String[][] overWorldCoords;	//this is the ordered pair that tells where a map screen should sit among other map screens


	//CONSTRUCTORS
	public Map(String[][] mapGrid, String[][] overWorldCoords){
		this.mapGrid = mapGrid;
		this.overWorldCoords = overWorldCoords;
	}

	public Map(){
		this.mapGrid = createEmptyMap();
	}

	//METHODS
	/**Note, all maps are 8x8*/

	public String[][] getMap(){ 	//NOTE: NEEDS TO BE ENCAPSULATED, SHOULD RETURN A COPY OF mapGrid
		return this.mapGrid;
	}

	public String[][] createEmptyMap(){			//creates an 8x8 map with no enemies, items, or obstacles
		String gameBoard[][] = new String[8][8];
		for(int i = 0; i < gameBoard.length; i++){
			for(int j = 0; j < gameBoard[i].length; j++){
				gameBoard[i][j] = " * ";
			}
		}
		return gameBoard;
	}

	public static void main(String[] args) {
		Map m = new Map();
		String[][] d;
		d = m.getMap();
		for(int i = 0; i < d.length; i++){
			System.out.println();
			for(int j = 0; j < d[0].length; j++){
				System.out.print(d[i][j]);
			}
		}
		System.out.println();
			
	}
}