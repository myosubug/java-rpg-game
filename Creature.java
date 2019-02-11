public class Creature{
	protected String name;
	protected int hitPoints;
	protected int level;
	protected int attackDamage;

//hello world

	//CONSTRUCTORS

	public Creature(String name, int hitPoints, int level, int attackDamage){
		this.name = name;
		this.hitPoints = hitPoints;
		this.level = level;
		this.attackDamage = attackDamage;
	}

	public Creature(String name){
		this(name, 10, 1, 1);
	}

	public Creature(){
		this("Pikachu", 10, 1, 1);
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

	public void move(){
		int newXcoord = 0;
		int newYcoord = 0;
		return newXcoord, newYcoord;
	}
}
