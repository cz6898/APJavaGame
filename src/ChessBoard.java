import javax.swing.*;
import java.awt.*;

/**
 * Created by Chairman Zhao on 2/24/2016.
 */
public class ChessBoard extends JPanel{
    private TileButton[][] buttons;
    private Tile selected;
    private boolean pieceChosen, successful;
    private UserPanel userPanel;
    public ChessBoard(UserPanel u){
        this.setLayout(new GridLayout(UserPanel.board.WIDTH, UserPanel.board.getLength()));
        buttons = new TileButton[UserPanel.board.WIDTH][UserPanel.board.getLength()];
        for(int row = 0; row < UserPanel.board.WIDTH; row++){
            for(int col = 0; col < UserPanel.board.getLength(); col++){
                buttons[row][col] = new TileButton(UserPanel.board.getTile(row, col));
                this.add(buttons[row][col]);
            }
        }
        pieceChosen = false;
        userPanel = u;
    }
    public void redrawChessBoard(){
        for(int row = 0; row < UserPanel.board.WIDTH; row++){
            for(int col = 0; col < UserPanel.board.getLength(); col++){
                if(UserPanel.board.getTile(row, col).getHasPiece()){
                    buttons[row][col].setText(UserPanel.board.getTile(row, col).getPiece().getName().substring(0, 2));
                }
                else{
                    buttons[row][col].setText(" ");
                }
            }
        }
    }
    public void setSelected(Tile t){
        selected = t;

    }
    public Tile getSelected(){
        return selected;
    }
    public void setChosen(boolean b){
        pieceChosen = b;
    }
    public boolean getChosen(){
        return pieceChosen;
    }
    public UserPanel getUserPanel(){
        return userPanel;
    }
    public void setSuccessful(boolean b){
        successful = b;
    }
    public boolean getSuccessful(){
        return successful;
    }
}
