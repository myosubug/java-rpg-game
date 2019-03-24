import java.util.jar.*;
import java.io.*;

class Item implements Serializable{

	//Declaring member variable
	private String name;
	private int hPIncrease;
	private int attackIncrease;
	private int xCoord;
	private int yCoord;


	//CONSTRUCTOR
	Item(String name, int hPIncrease, int attackIncrease, int x, int y){
		this.name = name;
		this.hPIncrease = hPIncrease;
		this.attackIncrease = attackIncrease;
		this.xCoord = x;
		this.yCoord = y;
	}

	//getter and setters for the member variable
	public String getName(){
		return this.name;
	}

	public String toString(){
		return this.name;
	}

	public int getX(){
		return this.xCoord;
	}

	public int getY(){
		return this.yCoord;
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
