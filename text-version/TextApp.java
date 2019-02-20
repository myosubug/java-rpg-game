import java.util.Scanner;

public class TextApp extends Map{

	//Variables

	private Map currentMap;


	//Constructors

	/*NOTE: instead of putting these things in the text app, I think maybe they could go in the map object?
		SO a particular map would have a health potion and a rattata and another map would have a battle fruit and a weedle
		This way we don't have to hard code the locations of each thing within the actual app

		Sean: that's good idea, I will try to move everything to Map calss and let TextApp.java to just load currentMap!
	
			I have extended textapp.java with Map.java so that we can access all the thing we put on the map.
		*/

	TextApp(){
		this.currentMap = new Map();
	}

	//Methods

	public Map getCurrentMap(){		//NEEDS TO BE ENCAPSULATED
		return this.currentMap;
	}

	public void printToConsole(){
		String[][] temp = currentMap.getMap();
		for(int i = 0; i < temp.length; i++){
			System.out.println();
			for(int j = 0; j < temp[i].length; j++){

				if ((i == super.getPikachu().getX()) && (j == super.getPikachu().getY()))		//Prints P for Pikachu in char. location
					System.out.print(" P ");
				else 								//Otherwise prints map data
					System.out.print(temp[i][j]);		
			}
		}

		System.out.println();
	}



	//Main Method
	public static void main(String[] args){
		String mapObject;
		String[][] tempMap;
		TextApp test = new TextApp();
		Scanner keyboard = new Scanner(System.in);
		Boolean game = true;

		//Intro for now
		System.out.println("You are Pikachu. You have been held hostage for TOO LONG!");
		System.out.println("You must gain your freedom!");
		System.out.println();

		test.printToConsole();
		System.out.println();
		//updated movement 
		System.out.println("You can go: Left(4) Right(6) Up(8) Down(2)");
		System.out.println("Press 0 to quit the game");


		//MAIN GAME LOOP
		while (game == true){

			//Takes user input for movement
			int input = keyboard.nextInt();
			if ((input == 2) || (input == 4) || (input == 6) || (input == 8)){
				test.getPikachu().move(input);
				test.printToConsole();
				System.out.println("You can go: Left(4) Right(6) Up(8) Down(2)");
				System.out.println("Press 0 to quit the game");
			}

			else if (input == 0) 		//quits if user presses 0
				game = false;
			
			// have added instructions for inputs rather than 2,4,6,8
			else {
				System.out.println("Please enter correct input for the movement,\nyou can go: Left(4) Right(6) Up(8) Down(2).");
			}

			
			tempMap = test.getCurrentMap().getMap();
			mapObject = tempMap[test.getPikachu().getX()][test.getPikachu().getY()];
			double itemRate = Math.random();
			
			if (mapObject == " I "){
				System.out.println("Found an item!, let's keep this in my bag! \nCurrent list of the items in the inventory: ");
				
				if (itemRate > 0.50)
					test.getPikachu().addItemToInventory(test.getHP());
				else
					test.getPikachu().addItemToInventory(test.getBattleFruit());
				
				test.getPikachu().displayInventory();
				System.out.println();
				System.out.println("You can go: Left(4) Right(6) Up(8) Down(2)");
				continue;
			
			} else if (mapObject == " M "){
				System.out.println("Monster is near! \n What do you want to do? : Fight(7) or Run away(9)");
				int input2 = keyboard.nextInt();
				do{
					if (input2 == 7){
						System.out.println("Preparing battle...");
						//now we need fight interaction here
						break;
					} else if (input2 == 9){
						System.out.println("You are safe now! \nYou can go: Left(4) Right(6) Up(8) Down(2)");
						break;
					} else{
						System.out.println("Please enter correct input for the movement,\nyou can : Fight(7) or Run away(9)");
					}
				} while(input2 == 7 || input2 == 9);

			} else {
				continue;
			}
			
		}
		
	}
}
