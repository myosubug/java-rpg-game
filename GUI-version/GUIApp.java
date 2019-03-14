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

    /**
     * these are member variables that are used in this class
     */
    private static VBox root;
    private static Scene theScene;
    private static Canvas canvas;
    private static GraphicsContext gc;
    private static Label output;
    private static Image pikachuImage;
    private static Image gamebackground;
    private static int monsterIndex;
    private Player pikachu = new Player();
    private Map firstMap = new Map();
    private Collision collisionCheck = new Collision();
    private Interaction interaction;





    @Override
    public void start(Stage primaryStage) throws Exception{


        //setting up main layout and stage
        initilization();
        primaryStage.setTitle("Liberate Pikachu!");
        primaryStage.setScene(theScene);


        //connecting keys to event handler
        addMovementKeyEvent(theScene);

        //animation starts
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

    /**
     * this method initalizes layout of JavaFX on this application
     * including layout style, size of each different children nodes
     * initial messages for output (label)
     * also initially sets the player character location as 0, 0
     */
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

    /**
     * This method take cares of all the keyboard event in this game
     * it takes the current Scene as a parameter and based on the key pressed, 
     * it's taking care of different actions
     * WASD - these are movement keys that updates pikachu's current location also checks for
     *        item interaction or monster interaction.
     *        these key event make sure that Pikachu doesn't go over the boundaries of canvas
     * J - this is the key to start battle with the monster where pikachu currently is at
     * L - this is the key for escape from battle
     * ZXC - these are keys for using items. Can choose 1st, 2nd, and 3rd item in order
     * B - this is the key to check pikachu's current inventory. 
     * @param scene this is the current Scene variable in this JavaFx application
     */
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
                            pikachu.setHP(pikachu.getInventory().get(0).getHPIncrease());
                        else if (pikachu.getInventory().get(0).getName().equals("Battle Fruit"))
                            pikachu.setAttack(pikachu.getInventory().get(0).useItem());
                        output.setText("Used "+pikachu.getInventory().get(0).getName()+"\n"+pikachu.toString());
                        pikachu.getInventory().remove(0);
                        break;
                    case X:
                        if(pikachu.getInventory().get(1).getName().equals("HP Potion"))
                            pikachu.setHP(pikachu.getInventory().get(1).getHPIncrease());
                        else if (pikachu.getInventory().get(1).getName().equals("Battle Fruit"))
                            pikachu.setAttack(pikachu.getInventory().get(1).useItem());
                        output.setText("Used "+pikachu.getInventory().get(1).getName()+"\n"+pikachu.toString());
                        pikachu.getInventory().remove(1);
                        break;
                    case C:
                        if(pikachu.getInventory().get(2).getName().equals("HP Potion"))
                            pikachu.setHP(pikachu.getInventory().get(2).getHPIncrease());
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

    /**
     * this methods gives a player (pikachu) an random item by random chance.
     * everytime pikahu makes a movement, this method is called and by 4% chance, 
     * pikachu can get a random item and it's added to pikachu's current inventory, which is an arraylist
     * pikachu only can have 3 items at max, and more item will be disregarded.
     */
    public void itemInteractionHandler(){
        double randomRate = Math.random();
        if (randomRate <= 0.04 && pikachu.getInventory().size() < 3){
            pikachu.addItemToInventory(firstMap.getRandomItem());
            output.setText("Item has been found!\nItem has been added to your inventory!\n"+pikachu.displayInventory());
        }

    }

    /**
     * this methods handles a monster battle event if player is at a tile where monster is.
     * this method creates instance of Interaction class and takes player and the monster that player have met as parameter
     * also prints out the result of the battle as output in Label of the JavaFX application
     */
    public void monsterInteractionHandler(){
            Creature monster = firstMap.getMonsterList().get(monsterIndex);
            interaction = new Interaction(pikachu, monster);
            interaction.battle(output);
     }


    public static void main(String[] args) {
        launch(args);
    }


}
