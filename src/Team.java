/**
 * Created by Chris on 2/23/2016.
 */
public class Team {
    private Piece[] pieces;
    private boolean color;
    public Team(boolean c){
        pieces = new Piece[20];
        int zone = 0;
        if(!c)
            zone = UserPanel.board.getLength() - 1;
        for(int i = 0; i < 10; i++){
            if(c){
                pieces[i] = new Pawn(c, i, 1, UserPanel.board);
            }
            else{
                pieces[i] = new Pawn(c, i, zone - 1, UserPanel.board);
            }
        }
        pieces[10] = new Engineer(c, 0, zone, UserPanel.board);
        pieces[11] = new Rook(c, 1, zone, UserPanel.board);
        pieces[12] = new Knight(c, 2, zone, UserPanel.board);
        pieces[13] = new Bishop(c, 3, zone, UserPanel.board);
        pieces[14] = new Queen(c, 4, zone, UserPanel.board);
        pieces[15] = new King(c, 5, zone, UserPanel.board);
        pieces[16] = new Bishop(c, 6, zone, UserPanel.board);
        pieces[17] = new Knight(c, 7, zone, UserPanel.board);
        pieces[18] = new Rook(c, 8, zone, UserPanel.board);
        pieces[19] = new Engineer(c, 9, zone, UserPanel.board);
    }
    public void printPieces(){
        for(int i = 0; i < 10; i++){
            System.out.print(pieces[i].getName() + " ");
        }
        System.out.println();
        for(int i = 10; i < 20; i++){
            System.out.print(pieces[i].getName() + " ");
        }
    }
}
