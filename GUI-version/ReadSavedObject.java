import java.io.*;
import java.util.Scanner;

public class ReadSavedObject implements Serializable{

  public static void main(String[] args){
    System.out.println("Type the name of the map you would like to load:");
    Scanner keyboard = new Scanner(System.in);
    String mapName = "./temp/" + keyboard.nextLine() + ".ser";

    char[][] testMap = new char[20][20];

    try{
      FileInputStream fileIn = new FileInputStream(mapName);
      ObjectInputStream mapIn = new ObjectInputStream(fileIn);

      testMap = (char[][]) mapIn.readObject();
      mapIn.close();
      fileIn.close();
    }

    catch(IOException i){
      i.printStackTrace();
      return;
    }

    catch(ClassNotFoundException c){
      System.out.println("Test Map class not found");
      c.printStackTrace();
      return;
    }

    for (int i = 0; i < 20; i++){
      System.out.println("");
      for (int j = 0; j < 20; j++){
        System.out.print(testMap[i][j]);
      }
    }

  }

}
