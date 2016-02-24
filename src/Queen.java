/**
 * Created by Chairman Zhao on 2/22/2016.
 */
public class Queen extends Piece{
    public Queen(boolean c, int X, int Y, Board b){
        super(c, X, Y, b);
    }
    public String getName(){
        return "Queen";
    }
    public boolean move(int x2, int y2){
        if(!movementChecks(t, x2, y2))
            return false;
        //boolean rVal = false;
        if(Diagonal.move(this, t, x2, y2))
            return true;
        if(Straight.move(this, t, x2, y2))
            return true;
        return false;
    }
}
