public class Map{
	private List[][] mapGrid;		//this will be the 2d array for any specific map screen
	private List[][] overWorldCoords;	//this is the ordered pair that tells where a map screen should sit among other map screens


	//CONSTRUCTORS
	public Map(ArrayList mapGrid, ArrayList overWorldCoords){
		this.mapGrid = mapGrid;
		this.overWorldCoords = overWorldCoords;
	}

	public Map(){
		this.mapGrid = createEmptyMap();
	}


	//METHODS
	/**Note, all maps are 8x8*/

	public createEmptyMap(){			//creates an 8x8 map with no enemies, items, or obstacles
		String gameBoard[][] = new String[8][8];
		for(int i = 0; i < gameBoard.length; i++){
			for(int j = 0; j < gameBoard[i].length; j++){
				gameBoard[i][j] = "-";
			}
		}
		return gameBoard;
	}
}