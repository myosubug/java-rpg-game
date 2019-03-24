import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Menu;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.event.ActionEvent;
import java.util.ArrayList;
import java.io.*;

public class GUIApp extends Application implements Serializable{

    //setting up instance variables, everything except pikachux, y will have no significant changes
    //pikachu x,y will be implmented through sprite class again
    private static AnchorPane root;
    private static VBox root2;
    private static AnchorPane root3;
    private static Scene introScene;
    private static Scene gameScene;
    private static Scene battleScene;
    private static Canvas canvas;
    private static GraphicsContext gc;
    private static Label output;
    private static int updated = 1;
    private static Image gameBackground;
    private static boolean eastOrWest;
    private Player pikachu = new Player();
    private ArrayList<Map> gameMapList = new ArrayList<Map>();
    private Map gameMap;
    private Collision collisionCheck = new Collision();
    private Interaction interactionHandler = new Interaction();


    @Override
    public void start(Stage primaryStage) throws Exception{

        //setting up main layout and stage
        initilization(primaryStage);

        //connecting button and keys to event handler
        addMovementKeyEvent(primaryStage, gameScene);

        new AnimationTimer(){
            @Override
            public void handle(long now) {
                gc.clearRect(0, 0, 640, 640);
                gc.drawImage(gameBackground, 0, 0, 640, 640);
                gc.drawImage(pikachu.getPikachuImage(), pikachu.getX(), pikachu.getY());
                if(pikachu.getCurrentGameLevel() == 2 && updated == 1){
                    gameBackground = new Image("file:img/map2.png");
                    gameMap = gameMapList.get(1);
                    updated = 2;
                    if (pikachu.getIsGameLoaded() == false)
                        pikachu.setX(0);
                } else if(pikachu.getCurrentGameLevel() == 1 && updated == 2){
                    gameBackground = new Image("file:img/map1.png");
                    gameMap = gameMapList.get(0);
                    updated = 1;
                    if(pikachu.getIsGameLoaded() == false)
                        pikachu.setX(608);
                }
            }
        }.start();

    primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    // ======================= setting up the layout of status window here =======================

    /**
     * this is the event class for the menu
     * if save button is clicked then it prints out "save button clicked" in console
     * else if load button is clicked then it prints out "load button clicked" in console
     * we need to find a way to save it and load properly through these two events
     * @return
     */

    private EventHandler<ActionEvent> saveAndLoad(){
        return new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
                MenuItem saveOrLoad = (MenuItem) event.getSource();
                String menuButton = saveOrLoad.getText();
                if ("save".equalsIgnoreCase(menuButton)){
                    pikachu.savePlayer();
                    gameMap.saveMap();
                    output.setText("Save completed!");

                } else if ("load".equalsIgnoreCase(menuButton)){
                    pikachu = pikachu.loadPlayer();
                    gameMap = gameMap.loadMap();
                    pikachu.setIsGameLoaded(true);
                    output.setText("Your previous game is loaded!");
                }
            }
        };
    }

    public void initilization(Stage primary){

        //adding menu and save and load funcions
        gameMapList.add(new Map(20, "mapData/map1.txt"));
        gameMapList.add(new Map(20, "mapData/map2.txt"));

        gameMap = gameMapList.get(0);

        primary.setTitle("Liberate Pikachu!");
        MenuBar mainMenu = new MenuBar();
        Menu file = new Menu("File");
        MenuItem save = new MenuItem("Save");
        MenuItem load = new MenuItem("Load");
        EventHandler<ActionEvent> saveAndLoadAction = saveAndLoad();

        save.setOnAction(saveAndLoadAction);
        load.setOnAction(saveAndLoadAction);

        file.getItems().add(save);
        file.getItems().add(load);
        mainMenu.getMenus().add(file);


        root = new AnchorPane();
        introScene = new Scene(root, 640, 830);
        Button start = new Button("Start a new game");
        Button loading = new Button("Load a saved game");
        Button exit = new Button("Exit");
        start.setOnAction(e -> primary.setScene(gameScene));
        loading.setOnAction(e -> {
            primary.setScene(gameScene);
            pikachu = pikachu.loadPlayer();
            gameMap = gameMap.loadMap();
            pikachu.setIsGameLoaded(true);
        });
        exit.setOnAction(e -> System.exit(0));
        start.setMinWidth(150);
        start.setMinHeight(50);
        loading.setMinWidth(150);
        loading.setMinHeight(50);
        exit.setMinWidth(150);
        exit.setMinHeight(50);
        start.setLayoutX(250);
        start.setLayoutY(540);
        loading.setLayoutX(250);
        loading.setLayoutY(600);
        exit.setLayoutX(250);
        exit.setLayoutY(660);
        root.setStyle("-fx-background-image: url(file:img/intro.png);");
        root.getChildren().add(start);
        root.getChildren().add(loading);
        root.getChildren().add(exit);


        primary.setScene(introScene);


        root2 = new VBox(mainMenu);
        gameScene = new Scene(root2, 640, 830);
        pikachu.setX(0);
        pikachu.setY(96);
        canvas = new Canvas(640, 640);
        pikachu.setPikachuImage("file:img/front.gif");
        gameBackground = new Image("file:img/map1.png");
        gc = canvas.getGraphicsContext2D();
        gc.drawImage(pikachu.getPikachuImage(), pikachu.getX(), pikachu.getY());
        root2.getChildren().add(canvas);

        //setting up a borderpane to place status message section as label object
        output = new Label("Use WASD to move around. To see inventory, Use B.\n"+"To use items, use Z,X,C to use one of 3 items in order.");
        output.setMinWidth(640);
        output.setMaxHeight(150);
        output.setStyle("-fx-border-color: black;");

         //setting up buttons up/down/left/right and two action buttons
        root2.getChildren().add(output);

        root3 = new AnchorPane();
        battleScene = new Scene(root3, 640, 830);
        Button endBattle = new Button("Run away");
        Button startBattle = new Button("Battle!");
        endBattle.setOnAction(e -> primary.setScene(gameScene));
        endBattle.setLayoutX(320);
        endBattle.setLayoutY(320);
        startBattle.setLayoutX(320);
        startBattle.setLayoutY(400);
        root3.getChildren().add(endBattle);
        root3.getChildren().add(startBattle);

    }

    public void addMovementKeyEvent(Stage primary, Scene scene){
        scene.setOnKeyPressed(
        new EventHandler<KeyEvent>()
        {
        @Override
        public void handle(KeyEvent e)
            {
                output.setText("Use WASD to move around. To see inventory, Use B.\n"+"To use items, use Z,X,C to use one of 3 items in order.");
            switch(e.getCode()){

                    case W:
                        eastOrWest = false;
                        pikachu.playerMovement(pikachu, pikachu.getX(), pikachu.getY() - 32, "file:img/back.gif", primary, collisionCheck, gameMap, battleScene, output, eastOrWest, interactionHandler);
                        break;
                    case D:
                        eastOrWest = true;
                        pikachu.playerMovement(pikachu, pikachu.getX() + 32, pikachu.getY(), "file:img/right.gif", primary, collisionCheck, gameMap, battleScene, output, eastOrWest, interactionHandler);
                        break;
                    case S:
                        eastOrWest = false;
                        pikachu.playerMovement(pikachu, pikachu.getX(), pikachu.getY() + 32, "file:img/front.gif", primary, collisionCheck, gameMap, battleScene, output, eastOrWest, interactionHandler);
                        break;
                    case A:
                        eastOrWest = true;
                        pikachu.playerMovement(pikachu, pikachu.getX() - 32, pikachu.getY(), "file:img/left.gif", primary, collisionCheck, gameMap, battleScene, output, eastOrWest, interactionHandler);
                        break;
                    case Z:
                        pikachu.itemSelect(pikachu, 0, output);
                        break;
                    case X:
                        pikachu.itemSelect(pikachu, 1, output);
                        break;
                    case C:
                        pikachu.itemSelect(pikachu, 2, output);
                        break;
                    case B:
                        output.setText("Current items in bag:\n" +pikachu.displayInventory());
                        break;
                    default:
                        output.setText("Please press correct keys to operate.");
                        break;
                    }
                }
        });
    }
}
