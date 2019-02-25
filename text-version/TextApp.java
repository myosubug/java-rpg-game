import java.util.Scanner;
import javax.lang.model.util.ElementScanner6;
import java.util.Random;

public class TextApp extends Map{

	//Declaring member variable

	private Map currentMap;


	//Constructors
	TextApp(){
		this.currentMap = new Map(); //creates a new map when the game is launched.
	}

	//Methods
	//getters for the current map of this game.
	public Map getCurrentMap(){		
		return this.currentMap;
	}

	/**
	 * prints the current status of the map
	 * while monster and item's positions are static, player still can move around the map.
	 * so it shows the player's location on the map.
	 */
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
		Random rand = new Random();     //variable for generating random numbers
		String mapObject;				//variable for detecting map objects: "I" for items, "M" for monsters
		String[][] tempMap;				//temporary copy of current map
		TextApp test = new TextApp();   //test object for this game.
		Scanner keyboard = new Scanner(System.in); //variable for taking user input
		Boolean game = true;            //if this boolean value becomes false, the game ends

		//Game Intro
		System.out.println();
		System.out.println();
		System.out.println("=========================================================");
		System.out.println("You are Pikachu. You have been held hostage for TOO LONG!");
		System.out.println("You must gain your freedom!");
		System.out.println("=========================================================");
		System.out.println();

		test.printToConsole();
		System.out.println();
		System.out.println("Use WASD to move");           //instruction for basic game operation.
		System.out.println("Press 0 to quit the game");
		System.out.println();


		//Main game loop, this game will be terminated only if game value is false.
		while (game == true){

			//End game condition : if the player reaches level 5, this will end the loop.
			if(test.getPikachu().getLevel() == 5){
				System.out.println("You have reached level 5 and you have become strong enough to challenge Ash for now!");
				game = false;
				System.exit(0);
				System.out.println();
			}
	


			//Takes user input for movement
			String input = keyboard.nextLine();
			String inputCap = input.toUpperCase();
			if ((inputCap.equals("W")) || (inputCap.equals("A")) || (inputCap.equals("D")) || (inputCap.equals("S"))){
				test.getPikachu().move(inputCap);
				test.printToConsole();
				System.out.println("Use WASD to move");
				System.out.println("Press 0 to quit the game");
				System.out.println();
			}

			//quits if user presses 0
			else if (input.equals("0")){ 		
				System.out.println("Bye!");
				game = false;
				System.exit(0);
			}

			//if user input is wrong, it will prompts the user again for correct input.
			else {
				System.out.println("Please enter correct input for the movement,\nyou can go: Left(a) Right(d) Up(w) Down(s).");
			}


			/**
			 * interaction starts when player meets something else rather than " - " on the map.
			 */
			tempMap = test.getCurrentMap().getMap(); 								 //getting copy of the current map
			mapObject = tempMap[test.getPikachu().getX()][test.getPikachu().getY()]; //saving comparison string for interaction
			double itemRate = Math.random();										 //this will generate random chances of getting random items.

			//if the player is loacted at " I " on the map, the player gets a random item.
			if (mapObject == " I "){
				System.out.println("Found an item! Let's keep this in my bag! \n\nCurrent list of the items in the inventory: ");

				//this random change will give a random item to player, HP potion or Battle Fruit
				if (itemRate > 0.50)
					test.getPikachu().addItemToInventory(test.getHP());
				else
					test.getPikachu().addItemToInventory(test.getBattleFruit());

				//once the player obtains an item, it will display updated inventory.
				test.getPikachu().displayInventory();
				System.out.println();

				//then prompt user to enter another input for movement.
				System.out.println("You can go: Left(a) Right(d) Up(w) Down(s)");
				System.out.println();
				continue;

			}

			//if the player is loacted at " M " on the map, the player get to choose fight or run from a monster.
			else if (mapObject == " M "){
				System.out.println("Monster is near! \nWhat do you want to do? : Fight(f) or Run away(r)");
					String input2 = keyboard.nextLine();
					String inputCap2 = input2.toUpperCase();

					//if player choose to fight, a random monster from wild will be selected.
					if (inputCap2.equals("F")){
						System.out.println("Preparing battle...");
						System.out.println();
						//now we need fight interaction here
						int randomMonster =  rand.nextInt(3);
						Creature m = new Creature();
						if (randomMonster == 0)
							m = test.getMetapod();
						else if (randomMonster == 1)
							m = test.getRattata();
						else
							m = test.getWeedle();

						//once the monster is selected, the actual battle interaction begins.
						Interaction fight = new Interaction(test.getPikachu(), m);
						fight.battle();

						//after the battle, the current map is shown to the player and ask user input for new movement.
						test.printToConsole();
						System.out.println();
						System.out.println("Use WASD to move");
						System.out.println("Press 0 to quit the game");
						System.out.println();
					}

					//if player choose to run, the current map is shown to the player and ask user input for new movement.
					else if (inputCap2.equals("R")){
						System.out.println("Success!");
						System.out.println();
						test.printToConsole();
						System.out.println();
						System.out.println("You can go: Left(a) Right(d) Up(w) Down(s)");
						System.out.println("Press 0 to quit the game");
						System.out.println();
					}

					//this is a termination condition if the player just wants to quit the game.
					else if (input2.equals("0")){
						System.exit(0);
					}

					//if the player didn't enter correct input, it will prompt the player again to enter correct input.
					else{
						System.out.println("Please enter correct input for the movement,\nyou can Fight(f) or Run away(r)");
						System.out.println();
						continue;
					}

					continue;
			}
		}
		//closing keyboad scanner
		keyboard.close();
	}
}
