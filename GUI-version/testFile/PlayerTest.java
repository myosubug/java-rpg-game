import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;

public class PlayerTest {

    /**
     * this tests if the constructor for player creates its instance correctly
     */
    @Test
    public void test_constoructor(){
        Player p = new Player();
        assertEquals("Checking if player contstuctor create pikachu correctly", 5, p.getAttack(), 0.00001);
        assertEquals("Checking if player contstuctor create pikachu correctly", 30, p.getHP(), 0.00001);
        assertEquals("Checking if player contstuctor create pikachu correctly", 1, p.getLevel(), 0.00001);
    }

    /**
     * this tests if a desired item is correctly added to player's inventory arraylist.
     */
    @Test
    public void test_player_inventory(){
        Player p = new Player();

        p.addItemToInventory(new Item("testItem", 99, 44));
        assertEquals("Checking if player inventory adds item correctly", 99, p.getInventory().get(0).getHPIncrease(), 0.00001);
    }

    /**
     * this tests if setCurrentGamelevel() method blocks values for out of lower boundary
     */
    @Test
    public void test_set_current_game_level_negative(){
        Player p = new Player();

        p.setCurrentGameLevel(-4);
        assertEquals("Checking if player's current gamelevel works correctly in boundary", 1, p.getCurrentGameLevel(), 0.00001);
      
    }

    /**
     * this tests if setCurrentGamelevel() method blocks values for out of upper boundary
     */
    @Test
    public void test_set_current_game_level_upper_boundary(){
        Player p = new Player();

        p.setCurrentGameLevel(55);
        assertEquals("Checking if player's current gamelevel works correctly in boundary", 1, p.getCurrentGameLevel(), 0.00001);
    }
}