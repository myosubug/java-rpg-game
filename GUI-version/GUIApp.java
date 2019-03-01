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


        primaryStage.setTitle("Liberate Pikachu!");
        VBox root = new VBox();
        Scene theScene = new Scene(root, 400, 580);
        primaryStage.setScene(theScene);
        
        
        

        
        final Canvas canvas = new Canvas(400,400);
        root.getChildren().add(canvas);

        

        /** 
         * this is good for when key press and release needs to change its status
        theScene.setOnKeyPressed(
            new EventHandler<KeyEvent>()
            {
                public void handle(KeyEvent e)
                {
                    String code = e.getCode().toString().toUpperCase();
                    if(!userInput.contains(code))
                        userInput.add(code);    
                }
            });
        
        theScene.setOnKeyReleased(
            new EventHandler<KeyEvent>()
            {
                public void handle(KeyEvent e){
                    String code = e.getCode().toString().toUpperCase();
                    userInput.remove(code);
                }
            });

        */

        gc = canvas.getGraphicsContext2D();
        
        
        Image image = new Image("file:img/text_pixel.jpg");
        gc.drawImage(image, pikachuX, pikachuY);
        //Sprite pikachu = new Sprite();
        
        //gc.drawImage(image, 0, 0);
            
        new AnimationTimer(){
        
            @Override
            public void handle(long now) {
                gc.clearRect(0, 0, 400, 400);
                gc.drawImage(image, pikachuX, pikachuY);
            }
        }.start();
    


        

        //setting up gridpane, root


       BorderPane root2 = new BorderPane();
       Label output = new Label("\nUse arrow keys or WASD to move around. \nAction buttons will be used to make choices in game.\n");
       Label filler = new Label("");
       filler.minHeight(50);
       filler.minWidth(100);
       output.setMinWidth(400);
       output.setMaxHeight(100);
       output.setStyle("-fx-border-color: black;");
       //output.setText("         this better work");
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
       
      


       primaryStage.show();


        // ============== setting up the interface up to here ==============================
        
    }

    /**
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