import java.util.ArrayList;

public class Inventory{
  private ArrayList<Item> itemList;

  //constructors
  public Inventory(ArrayList<Item> startingItems){
    this.itemList = startingItems;
  }

  public Inventory(){
    this.itemList = new ArrayList<Item>();
  }


  //methods
  public ArrayList<Item> getItemList(){
    return this.itemList;
  }

  public Item addItem(Item newItem){
    this.itemList.add(newItem);
  }

  /**
  removes an item from the inventory, either because it has been used or because player drops it
  @param toDrop the item to be removed
  */
  public void dropItem(String toDrop){
    for (int i = 0; i <= this.itemList.length; i++){
      //if the name of the item in the list is the same as the name of the item to be removed,
      //it is taken out of the list and loop is broken
      if (itemList[i].getName() == toDrop){
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
          result += order + ": " + itemList[i].getName() + " \n";
          order++;
      }
      return result;
  }

}
