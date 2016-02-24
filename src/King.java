/**
 * Created by Chris on 2/23/2016.
 */
public class King extends Piece implements Straight, Diagonal{
    public King(boolean c, int X, int Y){
        super(c, X, Y);
    }
    public String getName(){
        return "King";
    }
    public boolean move(Tile[][] t, int x2, int y2){
        if(!movementChecks(t, x2, y2))
            return false;
        //boolean rVal = false;
        if(Math.abs(x2 - x) <= 1 && Math.abs(y2 - y) <= 1) {
            if(Diagonal.move(this, t, x2, y2))
                return true;
            if(Straight.move(this, t, x2, y2))
                return true;
        }
        return false;
    }
}
