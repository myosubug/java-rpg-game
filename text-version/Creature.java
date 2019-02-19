class Creature{
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

	Creature(){
		this("default", 10, 1, 1, 0, 0);
	}

	//METHODS

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

	public void setName(String name){
		this.name = name;
	}

	public void setHP(int hp){
		this.hitPoints = hp;
	}

	public void setAttack(int ad){
		this.attackDamage = ad;
	}
	public void setLocation(int x, int y){
		this.xCoord = x;
		this.yCoord = y;
	}

	public void levelUp(){
		this.level += 1;
		this.hitPoints += 3;
		this.attackDamage += 1;
	}

	public String toString(){
		return "Name: " + this.getName() + " HP: " + this.getHP();
	}


	//tested with main, it works and I (Sean) have brought level system to creature and let player class override levelup method so that it can give
	//specific stats later 
	public static void main (String [] args){
	Creature c1 = new Creature();
	System.out.println(c1.toString());
	}

}	

