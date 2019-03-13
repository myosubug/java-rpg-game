class Creature{
	
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
		this.xCoord = x;
	}

	public void setY(int y){
		this.yCoord = y;
	}

	public void setName(String name){
		this.name = name;
	}


	//if hp is updated (healed) more than what is supposed to be, this condition sets the upper limit.
	public void setHP(int hp){
		int upperLimit = 30 + (this.getLevel() - 1) * 3;
		if (this.hitPoints + hp > upperLimit)
			this.hitPoints = upperLimit;
		else
			this.hitPoints += hp;
	}

	public void setAttack(int ad){
		this.attackDamage += ad;
	}
	public void setLocation(int x, int y){
		this.xCoord = x;
		this.yCoord = y;
	}

	/**
	 * this method updates player's level, hp and attackdamage when player levels up after battle.
	 * returns nothing and takes no parameter.
	 */
	public void levelUp(){
		this.level += 1;
		this.hitPoints += 3;
		this.attackDamage += 1;
	}

	/**
	 * this toString() prints out the creature's name and current HP
	 */
	public String toString(){
		return "Name: " + this.getName() + " HP: " + this.getHP();
	}

}
