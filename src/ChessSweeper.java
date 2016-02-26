import javax.swing.*;

/**
 * Created by Chairman Zhao on 2/25/2016.
 */
public class ChessSweeper {
    public static void main(String[] args){
        UserPanel panel = new UserPanel();
        JFrame frame = new JFrame("ChesSweeper");
        frame.setSize(600, 500);
        frame.setVisible(true);
        frame.add(panel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        panel.startGame();
    }
}
