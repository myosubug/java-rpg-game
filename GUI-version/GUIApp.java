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
    private Player pikachu = new Player();
    private Map gameMap = new Map(20, "mapData/map1.txt");
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
        pikachu.setX(0);
        pikachu.setY(96);
        canvas = new Canvas(640, 640);
        pikachuImage = new Image("file:img/front.gif");
        gamebackground = new Image("file:img/map.png");
        gc = canvas.getGraphicsContext2D();
        gc.drawImage(pikachuImage, pikachu.getX(), pikachu.getY());


        root.getChildren().add(canvas);

        //setting up a borderpane to place status message section as label object
        output = new Label("Use WASD to move around. To see inventory, Use B.\n"+"To use items, use Z,X,C to use one of 3 items in order.");
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
                        pikachuMovement(pikachu.getX(), pikachu.getY() - 32, "file:img/back.gif");
                        break;
                    case D:
                        pikachuMovement(pikachu.getX() + 32, pikachu.getY(), "file:img/right.gif");
                        break;
                    case S:
                        pikachuMovement(pikachu.getX(), pikachu.getY() + 32, "file:img/front.gif");
                        break;
                    case A:
                        pikachuMovement(pikachu.getX() - 32, pikachu.getY(), "file:img/left.gif");
                        break;
                    case J:
                        randomMonsterBattle();
                        break;
                    case L:
                        output.setText("Use WASD to get out of battle");
                        break;
                    case Z:
                        itemSelect(0);
                        break;
                    case X:
                        itemSelect(1);
                        break;
                    case C:
                        itemSelect(2);
                        break;
                    case B:
                        output.setText("Current items in bag:\n" +pikachu.displayInventory());
                        break;
                    default:
                        output.setText("Please press correct keys to operate.");
                }
            }
        });
    }

    public void pikachuMovement(int pikachuX, int pikachuY, String imgLocation){
        boolean objectCheck = collisionCheck.objectCollisionCheck(pikachuX, pikachuY, gameMap.getMapData());
        if(pikachuX >= 0 && pikachuX <= 608 && pikachuY >= 0 && pikachuY <= 608 && objectCheck == false){
            pikachuImage = new Image(imgLocation);
            pikachu.setX(pikachuX);
            pikachu.setY(pikachuY);
            itemInteractionHandler();
            monsterInteractionHandler();
        }
        else
            output.setText("Use WASD to move around. To see inventory, Use B.\n"+"To use items, use Z,X,C to use one of 3 items in order.");
    }


    public void itemInteractionHandler(){

        double randomRate = Math.random();
        if (randomRate <= 0.04 && pikachu.getInventory().size() < 3){
            pikachu.addItemToInventory(gameMap.getRandomItem());
            output.setText("Item has been found!\nItem has been added to your inventory!\n"+pikachu.displayInventory());
        }

    }


    public void monsterInteractionHandler(){
            double randomRate = Math.random();
            if (randomRate <= 0.04)
                output.setText("You have encountered a monster! Press J to fight, or press L to run away.");
    }

    public void randomMonsterBattle(){
            interaction = new Interaction(pikachu, gameMap.getRandomMonster());
            interaction.battle(output);
    }

     public void itemSelect(int invenNum){
        try{
		if(pikachu.getInventory().get(invenNum).getName().equals("HP Potion"))
            pikachu.setHP(pikachu.getInventory().get(invenNum).getHPIncrease());
        else if (pikachu.getInventory().get(invenNum).getName().equals("Battle Fruit"))
            pikachu.setAttack(pikachu.getInventory().get(invenNum).useItem());
        output.setText("Used "+pikachu.getInventory().get(invenNum).getName()+"\n"+pikachu.toString());
        pikachu.getInventory().remove(invenNum);
        } catch (Exception e){
            System.out.println("tried to access an empty inventory to delete item or to use non-existing item.");
            output.setText("tried to access an empty inventory to delete item or to use non-existing item.");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }


}
