import javax.swing.*;
import java.awt.*;

/**
 * Created by Chairman Zhao on 2/12/2016.
 */
public class Tile{
    private boolean discovered, hasMine;
    private int borderMines;
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
}