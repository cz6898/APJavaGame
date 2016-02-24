import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Chairman Zhao on 2/12/2016.
 */
public class Tile{
    private boolean discovered, hasMine, hasPiece;
    private int borderMines, xCoord, yCoord;
    private Piece piece;
    //private JButton button;
    public Tile(int x, int y){
        discovered = true;
        hasMine = false;
        xCoord = x;
        yCoord = y;
        //button = new JButton();
    }
    public Tile(boolean mine, int x, int y){
        hasMine = mine;
        discovered = false;
        xCoord = x;
        yCoord = y;
        //button = new JButton();
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
        if(!piece.getEng()) {
            hasMine = false;
            //piece.kill();
            piece = null;
            hasPiece = false;
        }
        else{
            hasMine = false;
        }
    }
    public void setDiscovered(boolean b){
        discovered = b;
    }
    public boolean getDiscovered(){
        return discovered;
    }
    public int getX(){
        return xCoord;
    }
    public int getY(){
        return yCoord;
    }
}