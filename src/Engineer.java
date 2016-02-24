/**
 * Created by Chris on 2/23/2016.
 */
public class Engineer extends Piece implements Diagonal, Straight{
    public Engineer(boolean c, int X, int Y){
        super(c, X, Y);
        eng = true;
    }
    public String getName(){
        return "Siege Engineer";
    }
    public boolean move(Tile[][] t, int x2, int y2){
        if(!movementChecks(t, x2, y2)){
            return false;
        }
        if(Math.abs(x2 - x) <= 3 && Math.abs(y2 - y) <= 3){
            if(Straight.move(this, t, x2, y2)){
                return true;
            }
            if(Diagonal.move(this, t, x2, y2)){
                return true;
            }
        }
        return false;
    }
}
