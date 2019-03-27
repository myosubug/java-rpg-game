import java.io.*;

import javafx.scene.image.Image;

public class Creature implements Serializable{

	//Declaring member variables
	private String name;
	private int hitPoints;
	private int level;
	private int attackDamage;
	private int xCoord;
	private int yCoord;
	private Image monsterImage;

	//CONSTRUCTORS

	Creature(String name, int hitPoints, int level, int attackDamage, String imgLocation){
		this.name = name;
		if(hitPoints <= 0)
			this.hitPoints = 1;
		else
			this.hitPoints = hitPoints;
		if(level <= 0)
			this.level = 1;
		else
			this.level = level;
		if(attackDamage <= 0)
			this.attackDamage = 1;
		else
			this.attackDamage = attackDamage;
		this.monsterImage = new Image(imgLocation);

	}


	Creature(String name, int hitPoints, int level, int attackDamage){
		this.name = name;
		if(hitPoints <= 0)
			this.hitPoints = 1;
		else
			this.hitPoints = hitPoints;
		if(level <= 0)
			this.level = 1;
		else
			this.level = level;
		if(attackDamage <= 0)
			this.attackDamage = 1;
		else
			this.attackDamage = attackDamage;
	}

	Creature(){
		this("default", 10, 1, 1);
	}

	//METHODS
	//Getters and setters for member variables
	public String getName(){
		return name;
	}

	public int getHP(){
		return hitPoints;
	}

	public int getLevel(){
		return level;
	}

	public int getAttack(){
		return attackDamage;
	}

	public int getX(){
		return this.xCoord;
	}

	public int getY(){
		return this.yCoord;
	}

	public void setX(int x){
		if(x < 0 || x > 608)
			;
		else
			this.xCoord = x;
	}

	public void setY(int y){
		if(y < 0 || y > 608)
			;
		else
			this.yCoord = y;
	}

	public void setName(String name){
		this.name = name;
	}

	public Image getMonsterImage(){
		return this.monsterImage;
	}


	public void setHP(int hp){
		int upperLimit = 30 + (this.getLevel() - 1) * 3;
		if (this.hitPoints + hp > upperLimit)
			this.hitPoints = upperLimit;
		else if(this.hitPoints + hp < 0)
			this.hitPoints = 0;
		else
			this.hitPoints += hp;
	}

	public void setAttack(int ad){
		if(ad < 0)
			;
		else
			this.attackDamage += ad;
	}

	public void setLocation(int x, int y){
		if(x < 0 || x > 608 || y < 0 || y > 608)
			;
		else{
			this.xCoord = x;
			this.yCoord = y;
		}
	}

	public void levelUp(){
		this.level += 1;
		this.hitPoints += 3;
		this.attackDamage += 1;
	}

	public String toString(){
		return this.getName() + "\nHP: " + this.getHP();
	}

	/**
	* this method saves a creature object to temp folder when game is saved
	*/
	public void saveCreature(){
		try{
			//saves bytestream to temp folder
			FileOutputStream fileOut = new FileOutputStream("./temp/" + this.getName() + ".ser");
			ObjectOutputStream creatureOut = new ObjectOutputStream(fileOut);
			creatureOut.writeObject(this);
			creatureOut.close();
			fileOut.close();
		}

		catch(IOException i){
			i.printStackTrace();
		}
	}

	/**
	* loads a creature object from save state
	*/
	public Creature loadCreature(String creatureName){
		Creature outputCreature = new Creature();

		try{
			FileInputStream fileIn = new FileInputStream("./temp/" + creatureName + ".ser");
			ObjectInputStream creatureIn = new ObjectInputStream(fileIn);

			outputCreature = (Creature) creatureIn.readObject();
			creatureIn.close();
			fileIn.close();

			return outputCreature;
		}

		catch(IOException i){
			i.printStackTrace();
			return null;
		}

		catch(ClassNotFoundException c){
			System.out.println("Creature not found.");
			c.printStackTrace();
			return null;
		}
	}




}
