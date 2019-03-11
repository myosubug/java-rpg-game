import java.util.ArrayList;

public class Inventory{
  private ArrayList<Item> itemList;

  //constructors
  public Inventory(){
    this.itemList = new ArrayList<Item>();
  }

  //methods
  public ArrayList<Item> getItemList(){
    return this.itemList;
  }

  public void addItem(Item newItem){
    this.itemList.add(newItem);
  }

  /**
  removes an item from the inventory, either because it has been used or because player drops it
  @param toDrop the item to be removed
  */
  public void dropItem(String toDrop){
    for (int i = 0; i <= this.itemList.size(); i++){
      //if the name of the item in the list is the same as the name of the item to be removed,
      //it is taken out of the list and loop is broken
      if (itemList.get(i).getName() == toDrop){
        itemList.remove(i);
        break;
      }

      //if not, keeps scanning
      else
        continue;
    }
  }


  /**
  @return the items in the inventory in order
  */
  public String displayInventory(){
      int order = 1;
      String result = "";
      for(Item i : this.getItemList()){
          result += order+": "+i.toString()+" ";
          order++;
      }
      return result;
  }
}
