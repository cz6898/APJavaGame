import javax.swing.*;
import java.awt.GridLayout;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 * Created by Chris on 2/23/2016.
 */
public class UserPanel extends JPanel implements JavaArcade{
    private Team white, black;
    private Board board;
    private javax.swing.Timer blitzTimer;
    public UserPanel(){
        board = new Board(16, 40);
        white = new Team(true, board);
        black = new Team(false, board);
        this.setLayout(new GridLayout());
    }
    public String getGameName(){
        return "ChesSweeper";
    }
    public String getInstructions(){
        return "";
    }
    public String getCredits(){
        return "Made by Olinah Hassan and Chris\n" +
                "Based on the games Chess, which likely originated c. 280-550 in East India and modernized c. 1475 in Italy and Spain\n" +
                "and Minesweeper, based on Jerimac Ratliff's Cube";
    }
    public void startGame(){

    }
    public void endGame(){

    }
    public void pauseGame(){

    }
    public int getHighScore(){
        return 0;
    }

}

