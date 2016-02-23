/**
 * Created by Chairman Zhao on 2/22/2016.
 */
public class Queen extends Piece{
    public Queen(boolean c, int X, int Y){
        super(c, X, Y);
    }
    public String getName(){
        return "Queen";
    }
    public boolean move(Tile[][] t, int x2, int y2){
        boolean withinBounds = (x2 < t.length && x2 >= 0 && y2 < t[0].length && y2 >= 0);
        if(!withinBounds){
            return false;
        }
        else if(t[x2][y2].getHasPiece() && t[x2][y2].getPiece().getColor() == color){
            return false;
        }
        //boolean rVal = false;
        else if(Math.abs(x2 - x) == Math.abs(y2 - y)){
            transfer(t, x2, y2);
            return true;
        }
        else if(x2 - x == 0 && y2 - y != 0){
            if(!checkStraight(t, x2, y2)) {
                alive = false;
            }
            return true;
        }
        else if(x2 - x != 0 && y2 - y == 0){
            if(!checkStraight(t, x2, y2)){
                alive = false;
            }
            return true;
        }
        return false;
    }
}
