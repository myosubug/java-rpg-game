import java.io.*;

public class Creature implements Serializable{

	//Declaring member variables
	private String name;
	private int hitPoints;
	private int level;
	private int attackDamage;
	private int xCoord;
	private int yCoord;

	//CONSTRUCTORS

	Creature(String name, int hitPoints, int level, int attackDamage, int x, int y){
		this.name = name;
		this.hitPoints = hitPoints;
		this.level = level;
		this.attackDamage = attackDamage;
		this.xCoord = x;
		this.yCoord = y;
	}


	Creature(String name, int hitPoints, int level, int attackDamage){
		this.name = name;
		this.hitPoints = hitPoints;
		this.level = level;
		this.attackDamage = attackDamage;
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
		this.xCoord = x;
	}

	public void setY(int y){
		this.yCoord = y;
	}

	public void setName(String name){
		this.name = name;
	}

	/**
	 * This methods updates current HP of all creature classes (including player and monsters) 
	 * if hp is updated (healed) more than what is supposed to be, this condition sets the upper limit.
	 * else, it just adds the amound of hp (parameter) to current hp of the creature
	 * @param hp this is the hp that needs to be added (or subtracted if negative value comes in) to current hp of a creature
	 */
	public void setHP(int hp){
		int upperLimit = 30 + (this.getLevel() - 1) * 3;
		if (this.hitPoints + hp > upperLimit)
			this.hitPoints = upperLimit;
		else
			this.hitPoints += hp;
	}
	/**
	 * this method updates current attack damage of all creatures.
	 * @param ad this is the attack damage that needs to be added (or subtracted if negative value comes in) 
	 * 			 to current attack damage of a creature
	 */
	public void setAttack(int ad){
		this.attackDamage += ad;
	}
	public void setLocation(int x, int y){
		this.xCoord = x;
		this.yCoord = y;
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
	@Override
	public String toString(){
		return "Name: " + this.getName() + " HP: " + this.getHP();
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
