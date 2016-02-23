import javax.swing.*;
import java.awt.*;

/**
 * Created by Chairman Zhao on 2/12/2016.
 */
public class Tile{
    private boolean discovered, hasMine, hasPiece;
    private int borderMines;
    private Piece piece;
    public Tile(){
        discovered = true;
        hasMine = false;
    }
    public Tile(boolean mine){
        hasMine = mine;
        discovered = false;
    }
    public boolean getMine(){
        return hasMine;
    }
    public void setBorderMines(int a){
        borderMines = a;
    }
    public int getBorderMines(){
        return borderMines;
    }
    public boolean getHasPiece(){
        return hasPiece;
    }
    public void setHasPiece(boolean b){
        hasPiece = b;
    }
    public Piece getPiece(){
        return piece;
    }
    public Piece setPiece(Piece p){
        Piece rVal = piece;
        piece = p;
        return rVal;
    }
    public void detonateMine(){
        hasMine = false;
        //piece.kill();
        piece = null;
        hasPiece = false;
    }
}