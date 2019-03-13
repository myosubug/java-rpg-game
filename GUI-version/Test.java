import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.concurrent.ThreadLocalRandom;

public class Test{
  private char[][] mapData = new char[20][20];
	private String mapFileName = "map1.txt";

  public static char[][] readMapFile(String fileName) throws FileNotFoundException{
    try{
      int lineWidth = 20;

      File mapFile = new File(fileName);
      Scanner scanner = new Scanner(mapFile);
      char[][] results = new char[20][20];

      //while there are lines remaining in the file
      while (scanner.hasNextLine()){
        //gets each individual character from text file and adds it as a list element
        for (int i = 0; i < lineWidth; i++){
          for (int j = 0; j < lineWidth; j++){
            if (scanner.hasNext())
              results[i][j] = scanner.next().charAt(0);

            else{
              continue;
            }
          }
        }
      }

      scanner.close();
      return results;
    }

    catch (FileNotFoundException ex) {
      System.out.println("Unable to open " + fileName);
      return null;
    }
  }

  public static void main(String[] args) {
    char[][] testMapData = new char[20][20];
    try{
      testMapData = readMapFile("map1.txt");
    }

    //if it's unable to load file, will create a map with no obstacles instead
    catch(FileNotFoundException ex){
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
