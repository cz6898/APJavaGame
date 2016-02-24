/**
 * Created by Chairman Zhao on 2/22/2016.
 */
public class Queen extends Piece implements Diagonal, Straight{
    public Queen(boolean c, int X, int Y){
        super(c, X, Y);
    }
    public String getName(){
        return "Queen";
    }
    public boolean move(Tile[][] t, int x2, int y2){
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
