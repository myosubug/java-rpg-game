import java.util.Scanner;

public class TextApp{

	//Variables

	private Map currentMap;
	private Item HP, battleFruit;
	private Player pikachu;
	private Creature metapod, weedle, rattata;

	//Constructors

	/*NOTE: instead of putting these things in the text app, I think maybe they could go in the map object?
		SO a particular map would have a health potion and a rattata and another map would have a battle fruit and a weedle
		This way we don't have to hard code the locations of each thing within the actual app
	*/

	TextApp(){
		this.currentMap = new Map();
		this.HP = new Item("HP Potion", "H",0 ,4);
		this.battleFruit = new Item("Battle Fruit", "A", 5, 5);
		this.pikachu = new Player();
		this.metapod = new Creature("Metapod", 15, 1, 2, 2, 4);
		this.weedle = new Creature("Weedle", 10, 1, 3, 6, 6);
		this.rattata = new Creature("Rattata", 12, 1, 2, 7, 2);
	}

	//Methods

	public void updateMap(){
		this.currentMap.setMap("  "+HP.getName(), HP.getX(), HP.getY());
		this.currentMap.setMap("  "+battleFruit.getName(), battleFruit.getX(), battleFruit.getY());
		this.currentMap.setMap("  "+pikachu.getName(), pikachu.getX(), pikachu.getY());
		this.currentMap.setMap("  "+metapod.getName(), metapod.getX(), metapod.getY());
		this.currentMap.setMap("  "+weedle.getName(), weedle.getX(), weedle.getY());
		this.currentMap.setMap("  "+rattata.getName(), rattata.getX(), rattata.getY()); 

	}

	public Map getCurrentMap(){		//NEEDS TO BE ENCAPSULATED
		return this.currentMap;
	}

	public void printToConsole(){
		String[][] temp = currentMap.getMap();
		for(int i = 0; i < temp.length; i++){
			System.out.println();
			for(int j = 0; j < temp[i].length; j++){

				if ((i == pikachu.getX()) && (j == pikachu.getY()))		//Prints P for Pikachu in char. location
					System.out.print(" P ");
				else 								//Otherwise prints map data
					System.out.print(temp[i][j]);		
			}
		}

		System.out.println();
	}



	//Main Method
	public static void main(String[] args){
		
		TextApp test = new TextApp();
		Scanner keyboard = new Scanner(System.in);

		//Intro for now
		test.printToConsole();
		System.out.println("You are Pikachu. You can go: Up(8)/Down(2)/Left(4)/Right(6)");

		//Takes user input for movement
		int input = keyboard.nextInt();
		if ((input == 2) || (input == 4) || (input == 6) || (input == 8)){
			test.pikachu.move(input);
			test.printToConsole();
		}
		
	}
}