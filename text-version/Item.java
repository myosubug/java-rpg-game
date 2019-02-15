import java.util.jar.*;

public class Item{
	private String name;
	private String description;
	private int attackBonus;

	//CONSTRUCTORS

	public Item(String name, String description, int attackBonus){
		this.name = name;
		this.description = description;
		this.attackBonus = attackBonus;
	}

	public Item(String name){
		this(name, "It's a " + name + "!", 0);
	}

	public Item(){
		this("No Name", "No one knows what it is?", 0);
	}
	
	/*public String getName(){
		return this.name=name;
	}
	public void setName(String name){
		
	}*/
	
	
	
	public static void main(String[] args) {
		Item item = new Item();
		System.out.println(item);
		
		/*String name = new Name();
		System.out.println(name);*/
		
		
		
	}

}