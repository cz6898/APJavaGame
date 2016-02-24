/**
 * Created by Chris on 2/23/2016.
 */
public class Bishop extends Piece{
    public Bishop(boolean c, int X, int Y, Board b){
        super(c, X, Y, b);
    }
    public String getName(){
        return "Bishop";
    }
    public boolean move(int x2, int y2){
        if(!movementChecks(t, x2, y2))
            return false;
        return Diagonal.move(this, t, x2, y2);
    }
}
