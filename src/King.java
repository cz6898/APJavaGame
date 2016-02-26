/**
 * Created by Chris on 2/23/2016.
 */
public class King extends Piece{
    public King(boolean c, int X, int Y, Board b){
        super(c, X, Y, b);
    }
    public String getName(){
        return "King";
    }
    public boolean move(int x2, int y2){
        if(!movementChecks(x2, y2))
            return false;
        //boolean rVal = false;
        if(Math.abs(x2 - x) <= 1 && Math.abs(y2 - y) <= 1) {
            if(Diagonal.move(this, x2, y2))
                return true;
            if(Straight.move(this, x2, y2))
                return true;
        }
        return false;
    }
}
