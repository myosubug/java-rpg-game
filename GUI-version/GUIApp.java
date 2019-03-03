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


import java.util.ArrayList;
import java.util.Random;

import com.sun.javafx.geom.Rectangle;


public class GUIApp extends Application {


    static GraphicsContext gc;
    //static ArrayList <String> userInput = new ArrayList<String>();
    static int pikachuX = 0;
    static int pikachuY = 0;



    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{

        //setting up main layout and stage
        primaryStage.setTitle("Liberate Pikachu!");
        VBox root = new VBox();
        Scene theScene = new Scene(root, 400, 580);
        primaryStage.setScene(theScene);

        //setting up canvas, which will be our game display area
        final Canvas canvas = new Canvas(400,400);
        root.getChildren().add(canvas);



        //importing pikachu sprite image from local directory and add it to canvas
        gc = canvas.getGraphicsContext2D();
        Image pikachuImage = new Image("file:img/pikachu.gif");
        gc.drawImage(pikachuImage, pikachuX, pikachuY);


       //setting up a borderpane to place status message section as label object
       BorderPane root2 = new BorderPane();
       Label output = new Label("\nUse arrow keys or WASD to move around. \nAction buttons will be used to make choices in game.\n");
       Label filler = new Label("");
       filler.minHeight(50);
       filler.minWidth(100);
       output.setMinWidth(400);
       output.setMaxHeight(100);
       output.setStyle("-fx-border-color: black;");
       root2.setTop(output);


       //setting up buttons up/down/left/right and two action buttons
       GridPane moveButtons = new GridPane();
       Button btnLeft = new Button("L");
       Button btnRight = new Button("R");
       Button btnUp = new Button("U");
       Button btnDown = new Button("D");

       btnLeft.setMaxWidth(Double.MAX_VALUE);
       btnRight.setMaxWidth(Double.MAX_VALUE);
       btnUp.setMaxWidth(Double.MAX_VALUE);
       btnDown.setMaxWidth(Double.MAX_VALUE);

       moveButtons.add(btnUp, 1, 0);
       moveButtons.add(btnLeft, 0, 1);
       moveButtons.add(btnRight,2, 1);
       moveButtons.add(btnDown,1, 2);


       //action button layout setting up
       GridPane actionButtons = new GridPane();
       Button btnA = new Button("J");
       Button btnB = new Button("K");

       btnA.setMinWidth(60);
       btnB.setMinWidth(60);

       actionButtons.add(btnA, 0, 1);
       actionButtons.add(btnB, 2, 1);


    //adding button events, two action buttons' action will be added below of this tooo
    //the first 4 of these are button actions
    btnUp.setOnAction((e) -> {
        if(pikachuY - 40 >= 0 && pikachuY - 40 <= 400)
            pikachuY -= 40;
        else
            ;
    });

    btnRight.setOnAction((e) -> {
        if(pikachuX + 40 >= 0 && pikachuX +40 <= 360)
            pikachuX += 40;
        else
            ;
    });

    btnDown.setOnAction((e) -> {
        if(pikachuY +40 >= 0 && pikachuY +40 <= +360)
            pikachuY += 40;
        else
            ;
    });

    btnLeft.setOnAction((e) -> {
        if(pikachuX -40 >= 0 && pikachuX - 40 <= 400)
            pikachuX -= 40;
        else
            ;
    });

    //these 4 are for keyboard action that is pressed as w/a/s/d
    theScene.setOnKeyPressed(
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


    new AnimationTimer(){

        @Override
        public void handle(long now) {
            gc.clearRect(0, 0, 400, 400);
            gc.drawImage(pikachuImage, pikachuX, pikachuY);
        }
    }.start();



    root2.setLeft(moveButtons);
    root2.setCenter(filler);
    root2.setRight(actionButtons);
    root.getChildren().add(root2);

    primaryStage.show();

    // ============== setting up the interface up to here ==============================
    }



    /**
     * THESE ARE EXTRA CODES THAT MIGHT BE USEFUL LATER TO I SAVED THEM UNDER HERE
     *
     *
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


                public static void render(){
                    gc.clearRect(0, 0, 400, 400);

                    if(userInput.contains("W")){
                        gc.drawImage(image, pikachuX, pikachuY + 40);
                    }
                }
    */



}
