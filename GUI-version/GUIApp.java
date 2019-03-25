import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Menu;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.input.KeyEvent;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    private static boolean eastOrWest;
    private static Image pikachuImage;
    private static Image gameBackground;
    private static boolean isGameLoaded = false;
    private static StackPane battleImage;
    private static Label battleOutput;
    private static Label playerStatus;
    private static Label monsterStatus;
    private static ImageView playerImageView;
    private static ImageView monsterImageView;
    private Player pikachu = new Player();
    private Creature monster;
    private ArrayList<Map> gameMapList = new ArrayList<Map>();
    private Map gameMap;
    private Collision collisionCheck = new Collision(); 
    private Interaction interaction = new Interaction();
    


    @Override
    public void start(Stage primaryStage) throws Exception{

        //setting up main layout and stage
        initilization(primaryStage);

        //connecting button and keys to scenes
        addMovementKeyEvent(primaryStage, gameScene);
        addBattleKeyEvent(primaryStage, battleScene);


        new AnimationTimer(){
            @Override
            public void handle(long now) {
                gc.clearRect(0, 0, 640, 640);
                gc.drawImage(gameBackground, 0, 0, 640, 640);
                gc.drawImage(pikachuImage, pikachu.getX(), pikachu.getY());
                if(pikachu.getCurrentGameLevel() == 2 && updated == 1){
                    gameBackground = new Image("file:img/map2.png");
                    gameMap = gameMapList.get(1);
                    updated = 2;
                    if (isGameLoaded == false)
                        pikachu.setX(0);
                } else if(pikachu.getCurrentGameLevel() == 1 && updated == 2){
                    gameBackground = new Image("file:img/map1.png");
                    gameMap = gameMapList.get(0);
                    updated = 1;
                    if(isGameLoaded == false)
                        pikachu.setX(608);
                }
            }
        }.start();

    primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
        
    }

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
                    isGameLoaded = true;
                    output.setText("Your previous game is loaded!");
                }
            }
        };
    }

    public void initilization(Stage primary){

        //adding pre-loaded game maps to arraylist
        gameMapList.add(new Map(20, "mapData/map1.txt"));
        gameMapList.add(new Map(20, "mapData/map2.txt"));
        gameMap = gameMapList.get(0);
        


        //adding menu and save and load funcions
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


        //Intro scene layout setup 
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
            isGameLoaded = true;
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


        //game map scene layout and initliazations of variables
        root2 = new VBox(mainMenu);
        gameScene = new Scene(root2, 640, 830);
        pikachu.setX(0);
        pikachu.setY(96);
        canvas = new Canvas(640, 640);
        pikachuImage = new Image("file:img/front.gif");
        gameBackground = new Image("file:img/map1.png");
        gc = canvas.getGraphicsContext2D();
        gc.drawImage(pikachuImage, pikachu.getX(), pikachu.getY());
        root2.getChildren().add(canvas);
        output = new Label("Use WASD to move around. To see inventory, Use B.\n"+"To use items, use Z,X,C to use one of 3 items in order.");
        output.setMinWidth(640);
        output.setMaxHeight(150);
        output.setStyle("-fx-border-color: black;");
        root2.getChildren().add(output);

        //setting up battle scene and image and label layouts
        root3 = new AnchorPane();
        battleScene = new Scene(root3, 640, 830);
        monsterStatus = new Label();
        monsterStatus.setPrefSize(300, 120);
        monsterStatus.setLayoutX(14);
        monsterStatus.setLayoutY(14);
        monsterStatus.setText("hi im monster");
        monsterStatus.setStyle("-fx-border-color: red; -fx-border-width: 3px;");

        playerStatus = new Label();
        playerStatus.setPrefSize(300, 120);
        playerStatus.setLayoutX(326);
        playerStatus.setLayoutY(540);
        playerStatus.setText(pikachu.toString());
        playerStatus.setStyle("-fx-border-color: red; -fx-border-width: 3px;");

        battleOutput = new Label();
        battleOutput.setPrefSize(640, 150);
        battleOutput.setLayoutX(0);
        battleOutput.setLayoutY(680);
        battleOutput.setText("hi im battle output");
        battleOutput.setStyle("-fx-border-color: black; -fx-border-width: 3px;");

        battleImage = new StackPane();
        battleImage.setPrefSize(615, 370);
        battleImage.setLayoutY(150);
        battleImage.setLayoutX(14);

        playerImageView = new ImageView();
        monsterImageView = new ImageView();
        Image battlePikachu = new Image("file:img/battleBack.gif");
        playerImageView.setImage(battlePikachu);
        battleImage.setAlignment(playerImageView, Pos.BOTTOM_RIGHT);
        battleImage.setAlignment(monsterImageView, Pos.TOP_LEFT);
        battleImage.getChildren().addAll(playerImageView, monsterImageView);

        root3.getChildren().add(monsterStatus);
        root3.getChildren().add(playerStatus);
        root3.getChildren().add(battleImage);
        root3.getChildren().add(battleOutput);

    }

    public void addMovementKeyEvent(Stage primary, Scene scene){
        scene.setOnKeyPressed(
        new EventHandler<KeyEvent>()
        {
        @Override
        public void handle(KeyEvent e)
            {
            switch(e.getCode()){
                    case W:
                        eastOrWest = false;
                        pikachuMovement(pikachu.getX(), pikachu.getY() - 32, "file:img/back.gif", primary);
                        break;
                    case D:
                        eastOrWest = true;
                        pikachuMovement(pikachu.getX() + 32, pikachu.getY(), "file:img/right.gif", primary);
                        break;
                    case S:
                        eastOrWest = false;
                        pikachuMovement(pikachu.getX(), pikachu.getY() + 32, "file:img/front.gif", primary);
                        break;
                    case A:
                        eastOrWest = true;
                        pikachuMovement(pikachu.getX() - 32, pikachu.getY(), "file:img/left.gif", primary);
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
                    case Q:
                        primary.setScene(gameScene);
                        break;
                    default:
                        output.setText("Please press correct keys to operate.\nUse WASD to move around. To see inventory, Use B.\n"+"To use items, use Z,X,C to use one of 3 items in order.");
                    }
                }
        });
    }


    public void addBattleKeyEvent(Stage primary, Scene scene){
        scene.setOnKeyPressed(
        new EventHandler<KeyEvent>()
        {
        @Override
        public void handle(KeyEvent e)
            {
            switch(e.getCode()){
                    case J:
                        playerStatus.setText(pikachu.toString());
                        monsterStatus.setText(monster.toString());
                        interaction.battle(pikachu, monster, battleOutput);
                        playerStatus.setText(pikachu.toString());
                        monsterStatus.setText(monster.toString());
                        break;
                    case Z:
                        itemSelect(0);
                        playerStatus.setText(pikachu.toString());
                        break;
                    case X:
                        itemSelect(1);
                        playerStatus.setText(pikachu.toString());
                        break;
                    case C:
                        itemSelect(2);
                        playerStatus.setText(pikachu.toString());
                        break;
                    case B:
                        battleOutput.setText("Current items in bag:\n" +pikachu.displayInventory());
                        break;
                    case Q:
                        primary.setScene(gameScene);
                        monster.setHP(30);
                        break;
                    default:
                        battleOutput.setText("Please press correct keys to operate.\nTo attack, press J.\nTo use items, Press B and use Z,X,C to use one of 3 items in order.");
                    }
                }
        });
    }

    public void pikachuMovement(int pikachuX, int pikachuY, String imgLocation, Stage primaryStage){
        boolean objectCheck = collisionCheck.objectCollisionCheck(pikachuX, pikachuY, gameMap.getMapData());
        boolean secondMapUpdateCheck = collisionCheck.secondMapUpdateCheck(pikachuX, pikachuY, gameMap.getMapData());
        boolean firstMapUpdateCheck = collisionCheck.firstMapUpdateCheck(pikachuX, pikachuY, gameMap.getMapData());
        if(pikachuX >= 0 && pikachuX <= 608 && pikachuY >= 0 && pikachuY <= 608 && objectCheck == false){
            pikachuImage = new Image(imgLocation);
            pikachu.setX(pikachuX);
            pikachu.setY(pikachuY);
            itemInteractionHandler();
            monsterInteractionHandler(primaryStage);
            if(secondMapUpdateCheck == true && eastOrWest){
                pikachu.setCurrentGameLevel(2);
            } else if (firstMapUpdateCheck == true && eastOrWest){
                pikachu.setCurrentGameLevel(1);
            }
        }
        else
            output.setText("Use WASD to move around. To see inventory, Use B.\n"+"To use items, use Z,X,C to use one of 3 items in order.");
        isGameLoaded = false;
    }

    public void itemInteractionHandler(){

        double randomRate = Math.random();
        if (randomRate <= 0.04 && pikachu.getInventory().size() < 3){
            pikachu.addItemToInventory(gameMap.getRandomItem());
            output.setText("Item has been found!\nItem has been added to your inventory!\n"+pikachu.displayInventory());
        }

    }

    public void monsterInteractionHandler(Stage primary){
            double randomRate = Math.random();
            if (randomRate <= 0.04){
                primary.setScene(battleScene);
                monster = gameMap.getRandomMonster();
                battleOutput.setText("You have been encountered with "+ monster.getName() +" To fight, press J or to run away, press Q");
                monsterStatus.setText(monster.toString());
                monsterImageView.setImage(monster.getMonsterImage());
            }
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
}
