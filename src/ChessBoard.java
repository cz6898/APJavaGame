import javax.swing.*;
import java.awt.*;

/**
 * Created by Chairman Zhao on 2/24/2016.
 */
public class ChessBoard extends JPanel{
    private TileButton[][] buttons;
    private Board board;
    private Tile[] selected;
    private int count;
    public ChessBoard(Board b){
        this.setLayout(new GridLayout(b.WIDTH, b.getLength()));
        buttons = new TileButton[b.WIDTH][b.getLength()];
        selected = new Tile[2];
        for(int row = 0; row < b.WIDTH; row++){
            for(int col = 0; col < b.getLength(); col++){
                buttons[row][col] = new TileButton(board.getTile(row, col), this);
                this.add(buttons[row][col]);
            }
        }
        count = 0;
    }
    public void redrawChessBoard(){
        for(int row = 0; row < board.WIDTH; row++){
            for(int col = 0; col < board.getLength(); col++){
                if(board.getTile(row, col).getHasPiece()){
                    buttons[row][col].setText(board.getTile(row, col).getPiece().getName().substring(0, 2));
                }
            }
        }
    }
    public void setSelected(Tile t){
        selected[count] = t;
    }
    public Tile getSelected(int i){
        if(i <= 0)
            return selected[0];
        else
            return selected[1];
    }
    public int getCount(){
        return count;
    }
    public void setCount(int i){
        if(i <= 0)
            count = 0;
        else
            count = 1;
    }
}
