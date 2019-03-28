import static org.junit.Assert.*;
import org.junit.Test;

public class MapTest extends Map{
  char[][] testMap = new char[3][3];

  //tests the constructor with all valid inputs
  @Test
  public void test_Constructor_allValid(){
    Map m = new Map(3, "mapTestInput.txt");
  	assertArrayEquals("Created map with valid input", testMap, m.getMapData());
  }

  //tests the constructor when the number of elements per line passed as a parameter is different
  //than number of elements in the actual inputted text file
  @Test
  public void test_Constructor_mismatchedLineNumber(){
    Map m = new Map()
  }





}
