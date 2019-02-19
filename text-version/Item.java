import java.util.jar.*;

class Item{
	private String name;
	private String type;
	private int xCoord;
	private int yCoord;

	//CONSTRUCTORS

	Item(String name, String type, int x, int y){
		this.name = name;
		this.type = type;
		this.xCoord = x;
		this.yCoord = y;
	}

	public String getName(){
		return this.name;
	}

	public int getX(){
		return this.xCoord;
	}

	public int getY(){
		return this.yCoord;
	}

	public String toString(){
		return "Item Name : "+ this.name; 
	}

	//deleted anything is not necessary for now, checked constructor/object and toString() method works
	public static void main(String[] args) {

		Item test = new Item("HP potion", "healing", 0, 0);
		System.out.println(test.toString());
		
		
		
	}

}