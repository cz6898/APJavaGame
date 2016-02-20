/**
 * Created by Chris on 2/18/2016.
 */
public class Tester {
    public static void main(String[] args){
         //Tests board to ensure random assignment of mines:
        Board testBoard = new Board(20, 40);
        testBoard.setNumbers();
        System.out.println(testBoard);
    }
}
