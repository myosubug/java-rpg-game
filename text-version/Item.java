import java.util.jar.*;

class Item{

	//Declaring member variable
	private String name;

	//CONSTRUCTOR
	Item(String name){
		this.name = name;
	}

	//getter and setters for the member variable
	public String getName(){
		return this.name;
	}

	public String toString(){
		return this.name; 
	}

}
