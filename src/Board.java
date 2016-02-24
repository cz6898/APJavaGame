/**
 * Created by Chris on 2/18/2016.
 */
public class Board{
    private Tile[][] board;
    public final int WIDTH = 10;
    private int length, numMines;
    public Board(int l, int n){
        length = l;
        board = new Tile[WIDTH][length];
        int mineTile = WIDTH * (length - 4);//number of tiles that can potentially have a mine
        numMines = n;
        int minesLeft = numMines;
        if(numMines > (int)(0.8 * (double)mineTile)){
            minesLeft = (int)(0.8 * (double)mineTile);
        }
        for(int w = 0; w < WIDTH; w++){
            for(int len = 0; len < 2; len++)
                board[w][len] = new Tile(w, len);
            for(int len = 2; len < length - 2; len++){
                if(minesLeft == mineTile) {
                    board[w][len] = new Tile(true, w, len);
                    minesLeft--;
                }
                else if(minesLeft == 0)
                    board[w][len] = new Tile(false, w, len);
                else if(Math.random() < (double)(minesLeft)/(double)mineTile) {

                    board[w][len] = new Tile(true, w, len);
                    minesLeft--;
                }
                else
                    board[w][len] = new Tile(false, w, len);
                mineTile--;
            }
            for(int len = length - 2; len < length; len++)
                board[w][len] = new Tile(w, len);
        }
    }
    public Tile getTile(int x, int y){
        try {
            return board[x][y];
        }
        catch(ArrayIndexOutOfBoundsException e){
            return null;
        }
    }
    public int getLength(){
        return length;
    }
    public void setNumbers(){
        for(int x = 0; x < WIDTH; x++){
            for(int y = 0; y < length; y++){
                int temp = 0;
                for(int i = -1; i <= 1; i++){
                    for(int j = -1; j <= 1; j++){
                        try{
                            if(board[x + i][y + j].getMine() && !(i == 0 && j == 0))
                                temp++;
                        }
                        catch(ArrayIndexOutOfBoundsException e){

                        }
                    }
                }
                board[x][y].setBorderMines(temp);
            }
        }
    }
    public String toString(){
        String rVal = "";
        for(int l = 0; l < length; l++){
            for(int w = 0; w < WIDTH; w++){
                if(board[w][l].getDiscovered()) {
                    if (board[w][l].getMine()) {
                        rVal += "  ";
                    } else if (board[w][l].getHasPiece()) {
                        rVal += board[w][l].getPiece().getName().charAt(0) + " ";
                    } else {
                        rVal += board[w][l].getBorderMines() + " ";
                    }
                }
                else{
                    rVal += "  ";
                }
            }
            rVal += "\n";
        }
        rVal += "\n\n";
        for(int l = 0; l < length; l++){
            for(int w = 0; w < WIDTH; w++){
                if (board[w][l].getMine()) {
                    rVal += "x ";
                }
                else {
                    rVal += board[w][l].getBorderMines() + " ";
                }
            }
            rVal += "\n";
        }
        return rVal;
    }
    public void discover(){
        for(int row = 0; row < WIDTH; row++){
            for(int col = 0; col < length; col++){
                if(board[row][col].getDiscovered() && board[row][col].getBorderMines() == 0 && !board[row][col].getMine()){
                    discoverArea(row, col);
                }
            }
        }
    }
    private void discoverArea(int row, int col){
        for(int i = -1; i <= 1; i++){
            for(int j = -1; j <= 1; j++){
                try{
                    if (!board[row + i][col + j].getDiscovered()) {
                        board[row + i][col + j].setDiscovered(true);
                        if(board[row + i][col + j].getBorderMines() == 0){
                            discoverArea(row + i, col + j);
                        }
                    }
                }
                catch(ArrayIndexOutOfBoundsException e){

                }
            }
        }

    }
    public Tile[][] getBoard(){
        return board;
    }
}