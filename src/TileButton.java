import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Chairman Zhao on 2/24/2016.
 */
public class TileButton extends JButton implements ActionListener {
    private Tile tile;
    public TileButton(Tile t){
        tile = t;
        this.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e){
        if(!UserPanel.chessBoard.getChosen()){
            if(tile.getHasPiece() && UserPanel.chessBoard.getUserPanel().getTurn() == tile.getPiece().getColor()){
                UserPanel.chessBoard.setSelected(tile);
            }
            UserPanel.chessBoard.setChosen(true);
        }
        else{
            UserPanel.chessBoard.setSuccessful(UserPanel.chessBoard.getSelected().getPiece().move(tile.getX(), tile.getY()));
            UserPanel.chessBoard.setChosen(false);
        }
    }
}
