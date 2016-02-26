/**
 * Created by Chris on 2/23/2016.
 */
public class Engineer extends Piece{
    public Engineer(boolean c, int X, int Y, Board b){
        super(c, X, Y, b);
        eng = true;
    }
    public String getName(){
        return "Siege Engineer";
    }
    public boolean move(int x2, int y2){
        if(!movementChecks(x2, y2)){
            return false;
        }
        if(Math.abs(x2 - x) <= 3 && Math.abs(y2 - y) <= 3){
            if(Straight.move(this, x2, y2)){
                return true;
            }
            if(Diagonal.move(this, x2, y2)){
                return true;
            }
        }
        return false;
    }
}
