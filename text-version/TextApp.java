public class TextApp{

	//Variables
	private Map currentMap;
	private Item HP, battleFruit;
	private Player pikachu;
	private Creature metapod, weedle, rattata;

	//Constructors
	TextApp(){
		this.currentMap = new Map();
		this.HP = new Item("HP Potion", "Healing",0 ,4);
		this.battleFruit = new Item("Battle Fruit", "Attack Bonus", 5, 5);
		this.pikachu = new Player();
		this.metapod = new Creature("Metapod", 15, 1, 2, 2, 4);
		this.weedle = new Creature("Weedle", 10, 1, 3, 6, 6);
		this.rattata = new Creature("Rattata", 12, 1, 2, 7, 2);
	}

	//Methods

	public void updateMap(){
		this.currentMap.setMap(HP.getName(), HP.getX(), HP.getY());
		this.currentMap.setMap(battleFruit.getName(), battleFruit.getX(), battleFruit.getY());
		this.currentMap.setMap(pikachu.getName(), pikachu.getX(), pikachu.getY());
		this.currentMap.setMap(metapod.getName(), metapod.getX(), metapod.getY());
		this.currentMap.setMap(weedle.getName(), weedle.getX(), weedle.getY());
		this.currentMap.setMap(rattata.getName(), rattata.getX(), rattata.getY());
	}

	public Map getCurrentMap(){
		return this.currentMap;
	}


	//Main Method
	public static void main(String[] args){
		
		TextApp test = new TextApp();
		test.updateMap();
		test.getCurrentMap().printMap();
		
	}
}