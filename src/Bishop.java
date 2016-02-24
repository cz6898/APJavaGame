/**
 * Created by Chris on 2/23/2016.
 */
public class Bishop extends Piece implements Diagonal{
    public Bishop(boolean c, int X, int Y){
        super(c, X, Y);
    }
    public String getName(){
        return "Bishop";
    }
    public boolean move(Tile[][] t, int x2, int y2){
        if(!movementChecks(t, x2, y2))
            return false;
        return Diagonal.move(this, t, x2, y2);
    }
}