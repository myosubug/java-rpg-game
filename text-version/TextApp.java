public class TextApp{

	//Variables
	private Map currentMap;

	//Constructors
	public TextApp(){
		Map currentMap = new Map();
	}

	//Methods

	//currently just prints the map to the screen, does not include character
	public void printToScreen(){

		String[][] mapToPrint;
		mapToPrint = currentMap.getMap();

		for(int i = 0; i < mapToPrint.length; i++){
			System.out.println();
			for(int j = 0; j < mapToPrint[0].length; j++){
				System.out.print(mapToPrint[i][j]);
			}
		}
		System.out.println();
	} 

	//Main Method
	public static void main(String[] args){
		
		
		TextApp test = new TextApp();

		
	}
}