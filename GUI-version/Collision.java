import java.util.ArrayList;

public class Collision {

    /**
     * This method checks if pikachu can't move to the next tile or not by checking mapData which is 2d char array
     * that is imported in Map class. If there is an object that Pikachu can't pass, then it will return true,
     * else it will return false.
     * @param pikachuX this argument holds pikachu's x position for next tile
     * @param pikachuY this argument holds pikachu's y position for next tile
     * @param mapData this argument holds 2d char array that is imported in Map class
     * @return it will return true if there is a blocking object ahead, false if there is no object is blocking
     */
    public boolean objectCollisionCheck (int pikachuX, int pikachuY, char[][] mapData){
        if(pikachuX > 608 || pikachuY > 608 || pikachuX < 0 || pikachuY < 0)
            return true;
            
        int pikachuXDivided = pikachuX / 32;
        int pikachuYDivided = pikachuY / 32;
        try{
        if (mapData[pikachuYDivided][pikachuXDivided] == 'x')
            return true;
        else
            return false;
        }catch(Exception e){
            System.out.println("Object Collision checking ...");
            return false;
        }
    }

    /**
     * this method checks if pikachu has met with boss monster by checking mapData which is in 2d char array.
     * @param pikachuX this argument holds pikachu's x position for next tile
     * @param pikachuY this argument holds pikachu's y position for next tile
     * @param mapData this argument holds 2d char array that is imported in Map class
     * @return it wiill return true if pikachu's in same position as boss monster or return false if not.
     */
    public boolean bossCollisionCheck (int pikachuX, int pikachuY, char[][] mapData){
        if(pikachuX > 608 || pikachuY > 608 || pikachuX < 0 || pikachuY < 0)
            return false;

        int pikachuXDivided = pikachuX / 32;
        int pikachuYDivided = pikachuY / 32;
        try{
        if (mapData[pikachuYDivided][pikachuXDivided] == '*')
            return true;
        else
            return false;
        } catch(Exception e){
            System.out.println("Object Collision checking ...");
            return false;
        }
    }

    /**
     * this method checks if pikachu enters second map of the game by checking mapData which is in 2d char array.
     * @param pikachuX this argument holds pikachu's x position for next tile
     * @param pikachuY this argument holds pikachu's y position for next tile
     * @param mapData his argument holds 2d char array that is imported in Map class
     * @return it will return true if pikachu's entering second map or false if pikachu is still in other map.
     */
    public boolean secondMapUpdateCheck(int pikachuX, int pikachuY, char[][] mapData){
        if(pikachuX > 608 || pikachuY > 608 || pikachuX < 0 || pikachuY < 0)
            return false;
        
        int pikachuXDivided = pikachuX / 32;
        int pikachuYDivided = pikachuY / 32;
        try{
        if (mapData[pikachuYDivided][pikachuXDivided] == '#')
            return true;
        else
            return false;
        } catch(Exception e){
            System.out.println("Object Collision checking ...");
            return false;
        }
    }

    /**
     * this method checks if pikachu enters first map of the game by checking mapData which is in 2d char array.
     * @param pikachuX this argument holds pikachu's x position for next tile
     * @param pikachuY this argument holds pikachu's y position for next tile
     * @param mapData his argument holds 2d char array that is imported in Map class
     * @return it will return true if pikachu's entering first map or false if pikachu is still in other map.
     */
    public boolean firstMapUpdateCheck(int pikachuX, int pikachuY, char[][] mapData){
        if(pikachuX > 608 || pikachuY > 608 || pikachuX < 0 || pikachuY < 0)
            return false;

        int pikachuXDivided = pikachuX / 32;
        int pikachuYDivided = pikachuY / 32;
        try{
        if (mapData[pikachuYDivided][pikachuXDivided] == '@')
            return true;
        else
            return false;
        } catch(Exception e){
            System.out.println("Object Collision checking ...");
            return false;
        }
    }

    /**
     * this method checks if pikachu enters third map of the game by checking mapData which is in 2d char array.
     * @param pikachuX this argument holds pikachu's x position for next tile
     * @param pikachuY this argument holds pikachu's y position for next tile
     * @param mapData his argument holds 2d char array that is imported in Map class
     * @return it will return true if pikachu's entering third map or false if pikachu is still in other map.
     */
    public boolean thirdMapUpdateCheck(int pikachuX, int pikachuY, char[][] mapData){
        if(pikachuX > 608 || pikachuY > 608 || pikachuX < 0 || pikachuY < 0)
            return false;

        int pikachuXDivided = pikachuX / 32;
        int pikachuYDivided = pikachuY / 32;
        try{
        if (mapData[pikachuYDivided][pikachuXDivided] == '%')
            return true;
        else
            return false;
        } catch(Exception e){
            System.out.println("Object Collision checking ...");
            return false;
        }
    }
    
}
