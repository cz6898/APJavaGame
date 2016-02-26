/**
 * Created by Chris on 2/23/2016.
 */
public class Knight extends Piece{
    public Knight(boolean c, int X, int Y, Board b){
        super(c, X, Y, b);
    }
    public String getName(){
        return "Knight";
    }
    public boolean move(int x2, int y2){
        if(!movementChecks(x2, y2)){
            return false;
        }
        if((Math.abs(x2 - x) == 2 && Math.abs(y2 - y) == 1) || (Math.abs(x2 - x) == 1 && Math.abs(y2 - y) == 2)){
            transfer(x2, y2);
            if(UserPanel.board.getTile(x2, y2).getMine())
                UserPanel.board.getTile(x2, y2).detonateMine();
            return true;
        }
        return false;
    }
}
