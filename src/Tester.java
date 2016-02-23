import java.awt.*;
import java.util.Scanner;

/**
 * Created by Chris on 2/18/2016.
 */
public class Tester {
    public static void main(String[] args){
        //Tests board to ensure random assignment of mines:
        Scanner scan = new Scanner(System.in);
        Board testBoard = new Board(12, 20);
        testBoard.setNumbers();
        testBoard.getTile(5, 0).setPiece(new Queen(true, 5, 0));
        testBoard.getTile(5, 0).setHasPiece(true);
        System.out.println(testBoard);
        System.out.println("Input x");
        int x2 = scan.nextInt();
        System.out.println("Input y");
        int y2 = scan.nextInt();
        System.out.println(testBoard.getTile(5, 0).getPiece().move(testBoard.getBoard(), x2, y2));
        testBoard.setNumbers();
        System.out.println(testBoard);
    }
}