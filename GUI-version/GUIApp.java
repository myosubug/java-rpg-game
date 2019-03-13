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
    private static Image pikachuImage;
    private static Image gamebackground;
    private static int monsterIndex;
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

        root = new VBox();
        theScene = new Scene(root, 640, 800);

        canvas = new Canvas(640, 640);
        pikachuImage = new Image("file:img/front.gif");
        gamebackground = new Image("file:img/map.png");
        gc = canvas.getGraphicsContext2D();
        gc.drawImage(pikachuImage, pikachu.getX(), pikachu.getY());


        root.getChildren().add(canvas);

        //setting up a borderpane to place status message section as label object
        output = new Label("Use WASD to move around. To see inventory, Use B.\n"+"To use items, use Z,X,C to use one of 3 items in order from 1 to 3.");
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
                            collisionCheck.isMonsterFound(pikachu, firstMap.getMonsterList());
                            if(collisionCheck.getMonsterFound() == true){
                                monsterIndex = collisionCheck.getMonsterIndex();
                                output.setText("You have encountered with "+firstMap.getMonsterList().get(monsterIndex).getName()+"\nWill you fight or run? (If yes, press J, or to run away press L)");
                            }
                            else
                                output.setText("Use WASD to move around. To see inventory, Use B.\n"+"To use items, use Z,X,C to use one of 3 items in order from 1 to 3.");
                        }
                        else
                            output.setText("Use WASD to move around. To see inventory, Use B.\n"+"To use items, use Z,X,C to use one of 3 items in order from 1 to 3.");
                        break;
                    case D:
                        if(pikachu.getX() + 32 >= 0 && pikachu.getX() + 32 <= 608){
                            pikachuImage = new Image("file:img/right.gif");
                            pikachu.setX(pikachu.getX() + 32);
                            itemInteractionHandler();
                            collisionCheck.isMonsterFound(pikachu, firstMap.getMonsterList());
                            if(collisionCheck.getMonsterFound() == true){
                                monsterIndex = collisionCheck.getMonsterIndex();
                                output.setText("You have encountered with "+firstMap.getMonsterList().get(monsterIndex).getName()+"\nWill you fight or run? (If yes, press J, or to run away press L)");
                            }
                            else
                                output.setText("Use WASD to move around. To see inventory, Use B.\n"+"To use items, use Z,X,C to use one of 3 items in order from 1 to 3.");
                        }
                        else
                            output.setText("Use WASD to move around.");
                        break;
                    case S:
                        if(pikachu.getY() + 32 >= 0 && pikachu.getY() + 32 <= +608){
                            pikachuImage = new Image("file:img/front.gif");
                            pikachu.setY(pikachu.getY() + 32);
                            itemInteractionHandler();
                            collisionCheck.isMonsterFound(pikachu, firstMap.getMonsterList());
                            if(collisionCheck.getMonsterFound() == true){
                                monsterIndex = collisionCheck.getMonsterIndex();
                                output.setText("You have encountered with "+firstMap.getMonsterList().get(monsterIndex).getName()+"\nWill you fight or run? (If yes, press J, or to run away press L)");
                            }
                            else
                                output.setText("Use WASD to move around. To see inventory, Use B.\n"+"To use items, use Z,X,C to use one of 3 items in order from 1 to 3.");
                        }
                        else
                            output.setText("Use WASD to move around.");
                        break;
                    case A:
                        if(pikachu.getX() - 32 >= 0 && pikachu.getX() - 32 <= 608){
                            pikachuImage = new Image("file:img/left.gif");
                            pikachu.setX(pikachu.getX() - 32);
                            itemInteractionHandler();
                            collisionCheck.isMonsterFound(pikachu, firstMap.getMonsterList());
                            if(collisionCheck.getMonsterFound() == true){
                                monsterIndex = collisionCheck.getMonsterIndex();
                                output.setText("You have encountered with "+firstMap.getMonsterList().get(monsterIndex).getName()+"\nWill you fight or run? (If yes, press J, or to run away press L)");
                            }
                            else
                                output.setText("Use WASD to move around. To see inventory, Use B.\n"+"To use items, use Z,X,C to use one of 3 items in order from 1 to 3.");
                        } 
                        else
                            output.setText("Use WASD to move around.");
                        break;
                    case J:
                        monsterInteractionHandler();
                        break;
                    case L:
                        output.setText("Use WASD to get out of battle");
                        break;
                    case Z:
                        if(pikachu.getInventory().get(0).getName().equals("HP Potion"))
                            pikachu.setHP(pikachu.getInventory().get(0).useItem());
                        else if (pikachu.getInventory().get(0).getName().equals("Battle Fruit"))
                            pikachu.setAttack(pikachu.getInventory().get(0).useItem());
                        output.setText("Used "+pikachu.getInventory().get(0).getName()+"\n"+pikachu.toString());
                        pikachu.getInventory().remove(0);
                        break;
                    case X:
                        if(pikachu.getInventory().get(1).getName().equals("HP Potion"))
                            pikachu.setHP(pikachu.getInventory().get(1).useItem());
                        else if (pikachu.getInventory().get(1).getName().equals("Battle Fruit"))
                            pikachu.setAttack(pikachu.getInventory().get(1).useItem());
                        output.setText("Used "+pikachu.getInventory().get(1).getName()+"\n"+pikachu.toString());
                        pikachu.getInventory().remove(1);
                        break;
                    case C:
                        if(pikachu.getInventory().get(2).getName().equals("HP Potion"))
                            pikachu.setHP(pikachu.getInventory().get(2).useItem());
                        else if (pikachu.getInventory().get(2).getName().equals("Battle Fruit"))
                            pikachu.setAttack(pikachu.getInventory().get(2).useItem());
                        output.setText("Used "+pikachu.getInventory().get(2).getName()+"\n"+pikachu.toString());
                        pikachu.getInventory().remove(2);
                        break;
                    case B:
                        output.setText("Current items in bag:\n" +pikachu.displayInventory());
                        
                        
                        
                }
            }
        });

    }


    public void itemInteractionHandler(){

        double randomRate = Math.random();
        if (randomRate <= 0.02 && pikachu.getInventory().size() < 3){
            pikachu.addItemToInventory(firstMap.getRandomItem());
            output.setText("Item has been found!\nItem has been added to your inventory!\n"+pikachu.displayInventory());
        }

    }

    
    public void monsterInteractionHandler(){
            Creature monster = firstMap.getMonsterList().get(monsterIndex);
            interaction = new Interaction(pikachu, monster);
            interaction.battle(output);
     }
     

    public static void main(String[] args) {
        launch(args);
    }


}
