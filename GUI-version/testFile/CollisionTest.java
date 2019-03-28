import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;

public class CollisionTest {
    char[][] testMap = new char[5][5];
    
    /**
     * this is to test object collision check method.
     * if wrong intput has been entered, it should return true for players can't move
     */
    @Test
    public void object_collision_method(){
        Collision c = new Collision();

        assertEquals("checking boundaries for wrong input, should return true", true, c.objectCollisionCheck(700, 32, testMap));
       
    }

    /**
     * this is to test first map collision check method.
     * if wrong intput has been entered, it should return false for players can't move
     */
    @Test
    public void first_mapcheck_method(){
        Collision c = new Collision();

        assertEquals("checking boundaries for wrong input, should return false", false, c.firstMapUpdateCheck(700, -232, testMap));
       
    }

    /**
     * this is to test second map collision check method.
     * if wrong intput has been entered, it should return false for players can't move
     */
    @Test
    public void second_mapcheck_method(){
        Collision c = new Collision();

        assertEquals("checking boundaries for wrong input, should return false", false, c.secondMapUpdateCheck(700, -32, testMap));
       
    }
}
