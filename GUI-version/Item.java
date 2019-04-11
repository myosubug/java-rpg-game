import java.io.*;

public class Item implements Serializable{

	//Declaring member variable
	private String name;
	private int hPIncrease;
	private int attackIncrease;

	//CONSTRUCTOR
	Item(String name, int hPIncrease, int attackIncrease){
		this.name = name;
		if(hPIncrease <= 0)
			;
		else
			this.hPIncrease = hPIncrease;
		if(attackIncrease <= 0)
			;
		else
			this.attackIncrease = attackIncrease;
	}

	//getter and setters for the member variable
	public String getName(){
		return this.name;
	}

	public String toString(){
		return this.name;
	}

	public int getAttackIncrease(){
		return this.attackIncrease;
	}

	public int getHPIncrease(){
		return this.hPIncrease;
	}

    /**
	 * this method is for pikachu to use items
	 * @return hPincrease or attackIncrease
	 * 		   if it's HP potion, it returns the amount number that HP potion can heal
	 * 		   else, it returns the amount of number that battle fruit increases the attack damage
	 */
	public int useItem(){
		if (this.getName().equals("HP potion"))
			 return hPIncrease;
		else
			return attackIncrease;
	}

}
