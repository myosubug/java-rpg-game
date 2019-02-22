import java.util.jar.*;

class Item{
	private String name;

	//CONSTRUCTORS

	Item(String name){
		this.name = name;
	}

	public String getName(){
		return this.name;
	}

	public String toString(){
		return this.name; 
	}

	//deleted anything is not necessary for now, checked constructor/object and toString() method works
}
