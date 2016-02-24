/**
 * Created by Chris on 2/23/2016.
 */
public class Pawn extends Piece{
    public Pawn(boolean c, int X, int Y, Board b){
        super(c, X, Y, b);
    }
    public String getName(){
        return "Pawn";
    }
    public boolean move(int x2, int y2){
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
