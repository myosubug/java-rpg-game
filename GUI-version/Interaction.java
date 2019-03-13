import java.util.Random;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.Scene;
import javafx.event.EventHandler;

public class Interaction {
    /**
     * Declaring member variables, as the battle in this game only takes two creatures,
     * this class is extended from Creature class to properly access the intances of Creature.
     */
    Player player;
    Creature monster;
 


    //Constructor
    Interaction(Player player, Creature monster){
        this.player = player;
        this.monster = monster;
  
    }

    public Player getPlayer() {
        return this.player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Creature getMonster() {
        return this.monster;
    }

    public void setMonster(Creature monster) {
        this.monster = monster;
    }

    /*
    public void addActionKeyEvent(Scene scene, Label output){
        scene.setOnKeyPressed(
        new EventHandler<KeyEvent>()
        {
        public void handle(KeyEvent e)
            {
            switch(e.getCode()){
                    case J:
                        output.setText("j pressed");
                        break;
                    case D:
                        output.setText("k pressed");
                        break;
                    }
            }
        });
    

    }


    */

    





 



    
 
}
