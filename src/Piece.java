/**
 * Created by Chris on 2/18/2016.
 */
public abstract class Piece{
    protected boolean color, alive, eng = false;//White = true, Black = false
    protected int x, y, pointValue;
    //protected Board board;
    public Piece(boolean c, int X, int Y, Board b){
        color = c;
        x = X;
        y = Y;
        b.getTile(X, Y).setPiece(this);
        b.getTile(X, Y).setHasPiece(true);
        //board = b;
        alive = true;
    }
    public abstract String getName();
    public boolean getColor(){
        return color;
    }
    public void setX(int a){
        x = a;
    }
    public void setY(int b){
        y = b;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public abstract boolean move(int x2, int y2);
    protected void transfer(int x2, int y2){
        UserPanel.board.getTile(x, y).setHasPiece(false);
        UserPanel.board.getTile(x2, y2).setHasPiece(true);
        UserPanel.board.getTile(x2, y2).setPiece(UserPanel.board.getTile(x, y).getPiece());
        UserPanel.board.getTile(x, y).setPiece(null);
        x = x2;
        y = y2;
    }
    public void kill(){
        alive = false;
    }
    protected boolean movementChecks(int x2, int y2){
        boolean withinBounds = (x2 < UserPanel.board.WIDTH && x2 >= 0 && y2 < UserPanel.board.getLength() && y2 >= 0);
        if(!withinBounds){
            return false;
        }
        if(UserPanel.board.getTile(x2, y2).getHasPiece() && UserPanel.board.getTile(x2, y2).getPiece().getColor() == color){
            return false;
        }
        return true;
    }
    public boolean getEng(){
        return eng;
    }
}