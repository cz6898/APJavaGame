/**
 * Created by Chris on 2/23/2016.
 */
public class Pawn extends Piece implements Straight, Diagonal{
    public Pawn(boolean c, int X, int Y){
        super(c, X, Y);
    }
    public String getName(){
        return "Pawn";
    }
    public boolean move(Tile[][] t, int x2, int y2){
        if(!movementChecks(t, x2, y2))
            return false;
        //boolean rVal = false;
        if((color && x2 - x != 1) || (!color && x2 - x != -1))
            return false;
        if(Math.abs(y2 - y) <= 1){
            if (Diagonal.move(this, t, x2, y2))
                return true;
            if (Straight.move(this, t, x2, y2))
                return true;
        }
        return false;
    }
}
