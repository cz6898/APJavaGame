/**
 * Created by Chris on 2/18/2016.
 */
public abstract class Piece {
    protected boolean color, alive;//White = true, Black = false
    public Piece(boolean c){
        color = c;
        alive = true;
    }
    public abstract String getName();
    public boolean getColor(){
        return color;
    }
    public abstract void move();
}