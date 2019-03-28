import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.ItemListener;
import java.io.*;

public class Test implements Serializable{
  private char[][] mapData = new char[20][20];
	private String mapFileName = "map1.txt";

  //methods
  public static char[][] readMapFile(String fileName) throws FileNotFoundException{
    try{
      int lineWidth = 20;

      File mapFile = new File(fileName);
      Scanner scanner = new Scanner(mapFile);
      char[][] results = new char[20][20];

      for (int row = 0; scanner.hasNextLine() && row < 20; row++) {
        results[row] = scanner.nextLine().toCharArray();
      }

      scanner.close();
      return results;
    }

    catch (FileNotFoundException ex) {
      System.out.println("Unable to open " + fileName);
      return null;
    }
  }

  //testing save functionality
  /*public void serializeMap() throws IOException{
    try{
      FileOutputStream fileOut = new FileOutputStream("/temp/testMap.ser");
      ObjectOutputStream mapOut = new ObjectOutputStream(fileOut);
      mapOut.writeObject(this);
      mapOut.close();
      fileOut.close();
    }

    catch(IOException i){
      i.printStackTrace();
    }
  }*/

  //main method
  public static void main(String[] args) {
    char[][] testMapData = new char[20][20];
    try{
      testMapData = readMapFile("mapData/map1.txt");

      //testing save functionality
      try{
        FileOutputStream fileOut = new FileOutputStream("./temp/testMap.ser");
        ObjectOutputStream mapOut = new ObjectOutputStream(fileOut);
        mapOut.writeObject(testMapData);
        mapOut.close();
        fileOut.close();
      }

      catch(IOException i){
        i.printStackTrace();
      }

    }

    //if it's unable to load file, will create a map with no obstacles instead
    catch(FileNotFoundException ex){
      System.out.println("Could not load file, blank map created instead.");
      for (int i = 0; i < 20; i++){
        for (int j = 0; j < 20; j++){
          String dash = "-";
  				char blankSymbol = dash.charAt(0);
          testMapData[i][j] = blankSymbol;
        }
      }
    }

    for (int i = 0; i < 20; i++){
      System.out.println("");
      for (int j = 0; j < 20; j++){
        System.out.print(testMapData[i][j]);
      }
    }

  }
}
