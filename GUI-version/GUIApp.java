import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.input.KeyEvent;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.event.ActionEvent;
import java.util.ArrayList;





public class GUIApp extends Application {

    //setting up instance variables, everything except pikachux, y will have no significant changes
    //pikachu x,y will be implmented through sprite class again
    private static VBox root;
    private static Scene theScene;
    private static Canvas canvas;
    private static GraphicsContext gc;
    private static Label output;
    private static int gameStage = 1;
    private static Image pikachuImage;
    private static Image gamebackground;
    private Player pikachu = new Player();
    private Map firstMap = new Map(20, ".\\map1.txt");
    private Collision collisionCheck = new Collision();
    private Interaction interaction;





    @Override
    public void start(Stage primaryStage) throws Exception{


        //setting up main layout and stage
        initilization();
        primaryStage.setTitle("Liberate Pikachu!");
        primaryStage.setScene(theScene);

        //connecting button and keys to event handler
        addMovementKeyEvent(theScene);

        new AnimationTimer(){
            @Override
            public void handle(long now) {
                gc.clearRect(0, 0, 640, 640);
                gc.drawImage(gamebackground, 0, 0, 640, 640);
                gc.drawImage(pikachuImage, pikachu.getX(), pikachu.getY());
            }
        }.start();


    primaryStage.show();
    }

    // ======================= setting up the layout of status window here =======================
    public void initilization(){


        pikachu.setX(0);
        pikachu.setY(0);


        root = new VBox();
        theScene = new Scene(root, 640, 800);

        canvas = new Canvas(640, 640);
        pikachuImage = new Image("file:img/pikachu.gif");
        gamebackground = new Image("file:img/map.png");
        gc = canvas.getGraphicsContext2D();
        gc.drawImage(pikachuImage, pikachu.getX(), pikachu.getY());


        root.getChildren().add(canvas);

        //setting up a borderpane to place status message section as label object
        output = new Label("\nUse WASD to move around. Press J for yes, K for no.\n");
        output.setMinWidth(640);
        output.setMinHeight(160);
        output.setStyle("-fx-border-color: black;");

         //setting up buttons up/down/left/right and two action buttons
        root.getChildren().add(output);


    }

    // ======================= setting up button and key events here =======================

    //NOTE: should be moved to an EventHandler class
    public void addMovementKeyEvent(Scene scene){
        scene.setOnKeyPressed(
        new EventHandler<KeyEvent>()
        {
        @Override
        public void handle(KeyEvent e)
            {
            switch(e.getCode()){
                    case W:
                        if(pikachu.getY() - 32 >= 0 && pikachu.getY() - 32 <= 608){
                            pikachuImage = new Image("file:img/back.gif");
                            pikachu.setY(pikachu.getY() - 32);
                            itemInteractionHandler();
                        }
                        else
                            output.setText("Use WASD to move around.");
                        break;
                    case D:
                        if(pikachu.getX() + 32 >= 0 && pikachu.getX() + 32 <= 608){
                            pikachuImage = new Image("file:img/right.gif");
                            pikachu.setX(pikachu.getX() + 32);
                            itemInteractionHandler();
                        }
                        else
                            output.setText("Use WASD to move around.");
                        break;
                    case S:
                        if(pikachu.getY() + 32 >= 0 && pikachu.getY() + 32 <= +608){
                            pikachuImage = new Image("file:img/front.gif");
                            pikachu.setY(pikachu.getY() + 32);
                            itemInteractionHandler();
                        }
                        else
                            output.setText("Use WASD to move around.");
                        break;
                    case A:
                        if(pikachu.getX() - 32 >= 0 && pikachu.getX() - 32 <= 608){
                            pikachuImage = new Image("file:img/left.gif");
                            pikachu.setX(pikachu.getX() - 32);
                            itemInteractionHandler();
                        }
                        else
                            output.setText("Use WASD to move around.");
                        break;
                    case J:
                        output.setText("getting into b");
                        scene.setOnKeyPressed(
                            new EventHandler<KeyEvent>(){
                                @Override
                                public void handle(KeyEvent e2){
                                    switch(e2.getCode()){
                                        case M:
                                            output.setText("please work");
                                            break;
                                        case N:
                                            output.setText("please work it");
                                            break;
                                    }
                                }
                            });
                        break;

                    case K:
                        output.setText("testing branched options");
                        break;
                }
            }
        });

    }


   //NOTE: this should be moved to Collision class
   /*
   public String collisionCheck(ArrayList<Item> itemLocation, ArrayList<Creature> monsterLocation){
        if (collisionCheck.isItemFound(pikachu, itemLocation))
            return "item";
        else if (collisionCheck.isMonsterFound(pikachu, monsterLocation))
            return "monster";
        else
            return "nothing";
    }
    */

    //NOTE: this should be moved to an EventHandler class
    public void itemInteractionHandler(){

        double randomRate = Math.random();
        if (randomRate < 0.02){
            pikachu.addItemToInventory(firstMap.getRandomItem());
            output.setText("Item has been found!\nItem has been added to your inventory!\n"+pikachu.displayInventory());
        }

    }

    /*
    public void monsterInteractionHandler(){
        int monsterIndex = collisionCheck.getMonsterIndex();
        Creature monster = firstMap.getMonsterLocation().get(monsterIndex);
        interaction = new Interaction(pikachu, monster);
        output.setText("You have encountered a " + monster.getName() + "!\nWill you fight or run? (To fight, press J. To run away press K)");
        //interaction.addActionKeyEvent(theScene, output);
     }
     */

    public static void main(String[] args) {
        launch(args);
    }


}
