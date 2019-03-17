import java.util.ArrayList;

public class Collision {

    public boolean objectCollisionCheck (int pikachuX, int pikachuY, char[][] mapData){
        int pikachuXDivided = pikachuX / 32;
        int pikachuYDivided = pikachuY / 32;
        if (mapData[pikachuYDivided][pikachuXDivided] == 'x')
            return true;
        else
            return false;
    }

    public boolean miniBossCollisionCheck (int pikachuX, int pikachuY, char[][] mapData){
        pikachuX /= 32;
        pikachuY /= 32;
        if (mapData[pikachuX][pikachuY] == '*')
            return true;
        else
            return false;
    }
    
}
