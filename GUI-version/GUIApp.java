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
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.event.EventHandler;

import java.util.ArrayList;
import java.util.Random;

import com.sun.javafx.geom.Rectangle;


public class GUIApp extends Application {


    static GraphicsContext gc;
    static ArrayList <String> userInput = new ArrayList<String>();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{

        VBox root = new VBox();

        final Canvas canvas = new Canvas(400,400);
        Rectangle rect = new Rectangle(0, 0, 40, 40);
        
        gc = canvas.getGraphicsContext2D();
        
        
        root.getChildren().add(canvas);

        //setting up gridpane, root


       BorderPane root2 = new BorderPane();
       TextArea output = new TextArea();
       output.setText("Use arrow keys or WASD to move around. \nAction buttons will be used to make choices in game.");
       Label filler = new Label("");
       output.setMinWidth(400);
       output.setMaxHeight(100);
       root2.setTop(output);

       GridPane moveButtons = new GridPane();
       Button btnLeft = new Button("←");
       Button btnRight = new Button("→");
       Button btnUp = new Button("↑");
       Button btnDown = new Button("↓");

       btnLeft.setMaxWidth(Double.MAX_VALUE);
       btnRight.setMaxWidth(Double.MAX_VALUE);
       btnUp.setMaxWidth(Double.MAX_VALUE);
       btnDown.setMaxWidth(Double.MAX_VALUE);

       moveButtons.add(btnUp, 1, 0);
       moveButtons.add(btnLeft, 0, 1);
       moveButtons.add(btnRight,2, 1);
       moveButtons.add(btnDown,1, 2);


       GridPane actionButtons = new GridPane();
       Button btnA = new Button("A");
       Button btnB = new Button("B");

       btnA.setMinWidth(60);
       btnB.setMinWidth(60);
 
       actionButtons.add(btnA, 0, 1);
       actionButtons.add(btnB, 2, 1);


       root2.setLeft(moveButtons);
       root2.setCenter(filler);
       root2.setRight(actionButtons);
       root.getChildren().add(root2);
       
        primaryStage.setTitle("Liberate Pikachu!");
        primaryStage.setScene(new Scene(root, 400, 600));
        primaryStage.show();


        // ============== setting up the interface up to here ==============================
        
    }

    public static void keyboardAction(){

        root.setOnKeyPressed(
            new EventHandler<KeyEvent>()
            {
                @Override
                public void handle(KeyEvent e)
                {
                    String key = e.getCode().toString().toUpperCase();
                    userInput.add(key);
                }
            });

            root.setOnKeyRelease(
                new EventHandler<KeyEvent>(){
                    @Override
                    public void handle(KeyEvent e)
                    {
                        userInput.remove(e.getCode().toString().toUpperCase());
                    }
            });

    }


    public static render(){
        gc.clearRect(0, 0, 400, 400);

        if(userInput.contains("W")){
            gc.
        }
    }


 
}