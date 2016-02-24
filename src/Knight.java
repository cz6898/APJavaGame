/**
 * Created by Chris on 2/23/2016.
 */
public class Knight extends Piece{
    public Knight(boolean c, int X, int Y){
        super(c, X, Y);
    }
    public String getName(){
        return "Knight";
    }
    public boolean move(Tile[][] t, int x2, int y2){
        if((Math.abs(x2 - x) == 2 && Math.abs(y2 - y) == 1) || (Math.abs(x2 - x) == 1 && Math.abs(y2 - y) == 2)){
            transfer(t, x2, y2);
            if(t[x2][y2].getMine())
                t[x2][y2].detonateMine();
            return true;
        }
        return false;
    }
}