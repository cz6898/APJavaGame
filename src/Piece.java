/**
 * Created by Chris on 2/18/2016.
 */
public abstract class Piece {
    protected boolean color, alive;//White = true, Black = false
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
    public abstract boolean move(Tile[][] tiles, int x2, int y2);
    protected boolean checkStraight(Tile[][] t, int x2, int y2){
        if(x2 - x != 0){
            for(int i = 0; i < Math.abs(x - x2); i++){
                if(x2 - x > 0 && t[x + i][y].getMine()){
                    transfer(t, x + i, y);
                    t[x + i][y].detonateMine();
                    return false;
                }
                else if(x2 - x < 0 && t[x - i][y].getMine()){
                    transfer(t, x - i, y);
                    t[x - i][y].detonateMine();
                    return false;
                }
            }
        }
        if(y2 - y != 0){
            for(int i = 0; i < Math.abs(y - y2); i++){
                if(y2 - y > 0 && t[x][y + i].getMine()){
                    transfer(t, x, y + i);
                    t[x][y + i].detonateMine();
                    return false;
                }
                else if(y2 - y < 0 && t[x][y - i].getMine()){
                    transfer(t, x, y - i);
                    t[x][y - i].detonateMine();
                    return false;
                }
            }
        }
        transfer(t, x2, y2);
        if(t[x2][y2].getMine()){
            t[x2][y2].detonateMine();
            return false;
        }
        return true;
    }
    protected boolean checkDiagonal(Tile[][] t, int x2, int y2){
        for(int i = 0; i < Math.abs(x - x2); i++){
            int xCoord, yCoord;
            if(x - x2 > 0)
                xCoord = x + i;
            else
                xCoord = x - i;
            if(y - y2 > 0)
                yCoord = y + i;
            else
                yCoord = y - i;
            if(t[xCoord][yCoord].getMine()){
                transfer(t, xCoord, yCoord);
                t[xCoord][yCoord].detonateMine();
                return false;
            }
        }
        transfer(t, x2, y2);
        if(t[x2][y2].getMine()){
            t[x2][y2].detonateMine();
            return false;
        }
        return true;
    }
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
}