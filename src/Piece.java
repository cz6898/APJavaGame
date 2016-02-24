/**
 * Created by Chris on 2/18/2016.
 */
public abstract class Piece{
    protected boolean color, alive, eng = false;//White = true, Black = false
    protected int x, y;
    public Piece(boolean c, int X, int Y){
        color = c;
        x = X;
        y = Y;
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
    public abstract boolean move(Tile[][] t, int x2, int y2);
    protected void transfer(Tile[][] t, int x2, int y2){
        t[x][y].setHasPiece(false);
        t[x][y].setPiece(null);
        t[x2][y2].setHasPiece(true);
        t[x2][y2].setPiece(t[x][y].getPiece());
        x = x2;
        y = y2;
    }
    public void kill(){
        alive = false;
    }
    protected boolean movementChecks(Tile[][] t, int x2, int y2){
        boolean withinBounds = (x2 < t.length && x2 >= 0 && y2 < t[0].length && y2 >= 0);
        if(!withinBounds){
            return false;
        }
        if(t[x2][y2].getHasPiece() && t[x2][y2].getPiece().getColor() == color){
            return false;
        }
        return true;
    }
    public boolean getEng(){
        return eng;
    }
}