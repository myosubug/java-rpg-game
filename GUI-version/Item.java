import java.util.jar.*;
import java.io.*;

class Item implements Serializable{

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

	public int useItem(){
		if (this.getName().equals("HP potion"))
			 return hPIncrease;
		else
			return attackIncrease;
	}

}
