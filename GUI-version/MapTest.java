import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.image.Image;

public class MapTest extends Application{

  //Variables
  static GraphicsContext graphics;
  private int xCoord;
  private int yCoord;

  //Main method
  public static void main(String[] args) {
      launch(args);
  }

  /**This method reads information from the map and prints an image at the correct pixel location for each element
    * eg element [0][0] should sit at 0,0
    * element [0][1] should sit at 0, 40 and so on
  */
  public void MapToCanvas(Map workingMap, Image blank, Image filled){
    //these are set to the pixel location of the square
    int xCoord;
    int yCoord;
    String[][] temp = workingMap.getMap();

    for(int i = 0; i < temp.length; i++){
      yCoord = i*40;

      for(int j = 0; j < temp[i].length; j++){
        xCoord = j*40;

        //places a green or grey square depending on if the spot is empty in the map
        if(temp[i][j] == " - "){
          graphics.drawImage(blank, xCoord, yCoord);
        }

        else{
          graphics.drawImage(filled, xCoord, yCoord);
        }
      }
    }



  }




  //Start method
  @Override
  public void start(Stage primaryStage) throws Exception{

    //importing images from local directory
    Image bgGreen = new Image("file:img/green.png");
    Image bgGrey = new Image("file:img/grey.png");

    //setting up main layout and stage
    primaryStage.setTitle("Liberate Pikachu!");
    VBox root = new VBox();
    Scene theScene = new Scene(root, 400, 400);
    primaryStage.setScene(theScene);

    //setting up canvas, which will be the game display area
    final Canvas canvas = new Canvas(400,400);
    root.getChildren().add(canvas);
    graphics = canvas.getGraphicsContext2D();

    //fetches 2d array from Map class
    Map currentMap = new Map();

    //prints that array as tiles on the background
    this.MapToCanvas(currentMap, bgGreen, bgGrey);

    primaryStage.show();

  }

}
