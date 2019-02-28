import java.util.jar.*;

class Item{

	//Declaring member variable
	private String name;
	private int hPIncrease;
	private int attackIncrease;

	//CONSTRUCTOR
	Item(String name, int hPIncrease, int attackIncrease){
		this.name = name;
		this.hPIncrease = hPIncrease;
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

	public void useItem(){

		if (hPIncrease > 0)
			 System.out.println("Your HP has increased by " + hPIncrease);

		if (attackIncrease > 0)
			System.out.println("Your attack went up by " + attackIncrease);

	}



}
