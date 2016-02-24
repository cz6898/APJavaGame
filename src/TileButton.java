import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Chairman Zhao on 2/24/2016.
 */
public class TileButton extends JButton implements ActionListener {
    private JButton button;
    private Tile tile;
    private ChessBoard chess;
    public TileButton(Tile t, ChessBoard c){
        tile = t;
        button = new JButton();
        ChessBoard chess = c;
        button.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e){
        chess.setSelected(tile);
        if(chess.getCount() == 0)
            chess.setCount(1);
        else{
            chess.getSelected(0).getPiece().move(chess.getSelected(1).getX(), chess.getSelected(1).getY());
        }
    }
}
