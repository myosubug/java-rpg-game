import java.util.ArrayList;

public class Collision {

    public boolean objectCollisionCheck (int pikachuX, int pikachuY, char[][] mapData){
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

    public boolean miniBossCollisionCheck (int pikachuX, int pikachuY, char[][] mapData){
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


    public boolean secondMapUpdateCheck(int pikachuX, int pikachuY, char[][] mapData){
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

    public boolean firstMapUpdateCheck(int pikachuX, int pikachuY, char[][] mapData){
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
    
}
