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

	Creature(int hitPoints, int level, int attackDamage){
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

	// X or Y value of creature class can't be lower than 0 or higher than 608.
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

	public void setMonsterImage(String fileLocation){
		this.monsterImage = new Image(fileLocation);
	}

	public Image getMonsterImage(){
		return this.monsterImage;
	}


	/**
	 * this method sets up hp for all creature class
	 * there is an upper limit based on its creature's level
	 * ex) level 1 = 30 hp
	 * 	   level 2 = 33 hp
	 * also hp can't be lower than 0.
	 * @param hp this is the hp amount that needs to be added or
	 *           subtracted from current hp.
	 */
	public void setHP(int hp){
		int upperLimit = 30 + (this.getLevel() - 1) * 3;
		if (this.hitPoints + hp > upperLimit)
			this.hitPoints = upperLimit;
		else if(this.hitPoints + hp < 0)
			this.hitPoints = 0;
		else
			this.hitPoints += hp;
	}

	/**
	 * this method updates attack damage for all creature class.
	 * @param ad this is the additional attack damage and can't be lower or equal to 0
	 */
	public void setAttack(int ad){
		if(ad < 0)
			;
		else
			this.attackDamage += ad;
	}

	// X or Y value of creature class can't be lower than 0 or higher than 608.
	public void setLocation(int x, int y){
		if(x < 0 || x > 608 || y < 0 || y > 608)
			;
		else{
			this.xCoord = x;
			this.yCoord = y;
		}
	}

	/**
	 * this method updates player's level, hp and attackdamage when player levels up after battle.
	 */
	public void levelUp(){
		this.level += 1;
		this.hitPoints += 3;
		this.attackDamage += 1;
	}

	/**
	 * this toString() prints out the creature's name and current HP
	 * it overides default toString() method.
	 */
	public String toString(){
		return this.getName() + "\nHP: " + this.getHP();
	}

}
