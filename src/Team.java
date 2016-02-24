/**
 * Created by Chris on 2/23/2016.
 */
public class Team {
    private Piece[] pieces;
    private boolean color;
    public Team(boolean c, Board b){
        pieces = new Piece[20];
        int zone = 0;
        if(!c)
            zone = b.getLength() - 1;
        for(int i = 0; i < 10; i++){
            if(c){
                pieces[i] = new Pawn(c, i, 1);
            }
            else{
                pieces[i] = new Pawn(c, i, zone - 1);
            }
        }
        pieces[10] = new Engineer(c, 0, zone);
        pieces[11] = new Rook(c, 1, zone);
        pieces[12] = new Knight(c, 2, zone);
        pieces[13] = new Bishop(c, 3, zone);
        pieces[14] = new Queen(c, 2, zone);
        pieces[15] = new King(c, 2, zone);
        pieces[16] = new Bishop(c, 2, zone);
        pieces[17] = new Knight(c, 2, zone);
        pieces[18] = new Rook(c, 2, zone);
        pieces[19] = new Engineer(c, 2, zone);
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
