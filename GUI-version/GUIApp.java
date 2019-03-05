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
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.geometry.Rectangle2D;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.util.Random;




public class GUIApp extends Application {

    //setting up instance variables, everything except pikachux, y will have no significant changes
    //pikachu x,y will be implmented through sprite class again
    static VBox root = new VBox();
    static Scene theScene = new Scene(root, 400, 580);
    static Canvas canvas = new Canvas(400,400);
    static GraphicsContext gc = canvas.getGraphicsContext2D();
    static BorderPane statusOutputAndButtons = new BorderPane();
    static Label output = new Label("\nUse arrow keys or WASD to move around. \nAction buttons will be used to make choices in game.\n");
    static GridPane moveButtons = new GridPane();
    static Button btnLeft = new Button("L");
    static Button btnRight = new Button("R");
    static Button btnUp = new Button("U");
    static Button btnDown = new Button("D");
    static GridPane actionButtons = new GridPane();
    static Button btnJ = new Button("J");
    static Button btnK = new Button("K");
    static int pikachuX = 0;
    static int pikachuY = 0;



    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{

        //setting up main layout and stage
        primaryStage.setTitle("Liberate Pikachu!");
        primaryStage.setScene(theScene);
        root.getChildren().add(canvas);
        root.getChildren().add(statusOutputAndButtons);
        settingUpStatusOutputAndButton();

        //connecting button and keys to event handler
        btnLeft.setOnAction(new ButtonMovementLeft());
        btnDown.setOnAction(new ButtonMovementDown());
        btnRight.setOnAction(new ButtonMovementRight());
        btnUp.setOnAction(new ButtonMovementUp());
        addKeyEvent(theScene);
      
        //adding sprite but there will be better ways to do this, still implementing
        Image pikachuImage = new Image("file:img/pikachu.gif");
        gc.drawImage(pikachuImage, pikachuX, pikachuY);

        //this is where our game logic will be rendered
        new AnimationTimer(){
            @Override
                public void handle(long now) {
                gc.clearRect(0, 0, 400, 400);
                gc.drawImage(pikachuImage, pikachuX, pikachuY);
                }
        }.start();


    primaryStage.show();
    }

    // ======================= setting up the layout of status window and buttons here ======================= 
    public static void settingUpStatusOutputAndButton(){

        //setting up a borderpane to place status message section as label object
        output.setMinWidth(400);
        output.setMaxHeight(100);
        output.setStyle("-fx-border-color: black;");

         //setting up buttons up/down/left/right and two action buttons
        statusOutputAndButtons.setTop(output);
        moveButtons = new GridPane();
        
        btnLeft.setMaxWidth(Double.MAX_VALUE);
        btnRight.setMaxWidth(Double.MAX_VALUE);
        btnUp.setMaxWidth(Double.MAX_VALUE);
        btnDown.setMaxWidth(Double.MAX_VALUE);
 
        moveButtons.add(btnUp, 1, 0);
        moveButtons.add(btnLeft, 0, 1);
        moveButtons.add(btnRight,2, 1);
        moveButtons.add(btnDown,1, 2);

        //action button layout setting up
        btnJ.setMinWidth(60);
        btnK.setMinWidth(60);
 
        actionButtons.add(btnJ, 0, 1);
        actionButtons.add(btnK, 2, 1);

        statusOutputAndButtons.setLeft(moveButtons);
        statusOutputAndButtons.setRight(actionButtons);
    } 

    // ======================= setting up button and key events here ======================= 
    public class ButtonMovementUp implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent ButtonMovementEventUp){
            if(pikachuY - 40 >= 0 && pikachuY - 40 <= 400)
                pikachuY -= 40;
            else
                ;
        }
    }

    public class ButtonMovementRight implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent ButtonMovementEventRight){
            if(pikachuX + 40 >= 0 && pikachuX +40 <= 360)
                pikachuX += 40;
            else
                ;
        }
    }

    public class ButtonMovementDown implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent ButtonMovementEventDown){
            if(pikachuY +40 >= 0 && pikachuY +40 <= +360)
                pikachuY += 40;
            else
                ;
        }
    }

    public class ButtonMovementLeft implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent ButtonMovementEventLeft){
            if(pikachuX -40 >= 0 && pikachuX - 40 <= 400)
                pikachuX -= 40;
            else
                ;
        }
    }

    public static void addKeyEvent(Scene scene){
        scene.setOnKeyPressed(
        new EventHandler<KeyEvent>()
        {
        public void handle(KeyEvent e)
            {
            switch(e.getCode()){
                    case W:
                        if(pikachuY - 40 >= 0 && pikachuY - 40 <= 400){
                            pikachuY -= 40;
                            btnUp.requestFocus();
                        }
                        else
                            ;
                        break;
                    case D:
                        if(pikachuX + 40 >= 0 && pikachuX +40 <= 360){
                            pikachuX += 40;
                            btnRight.requestFocus();
                        }
                        else
                            ;
                        break;
                    case S:
                        if(pikachuY +40 >= 0 && pikachuY +40 <= +360){
                            pikachuY += 40;
                            btnDown.requestFocus();
                        }
                        else
                            ;
                        break;
                    case A:
                        if(pikachuX -40 >= 0 && pikachuX - 40 <= 400){
                            pikachuX -= 40;
                            btnLeft.requestFocus();
                        }
                        else
                            ;
                        break;
                }
            }
        });

    }

}
