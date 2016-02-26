/**
 * Created by Chris on 2/23/2016.
 */
public interface Straight{
    public static boolean move(Piece p, int x2, int y2) {
        int x = p.getX();
        int y = p.getY();
        if (x2 - x == 0 || y2 - y == 0) {
            if (x2 - x != 0) {
                for (int i = 1; i < Math.abs(x - x2); i++){
                    int xCoord;
                    if(x2 - x > 0)
                        xCoord = x + i;
                    else
                        xCoord = x - i;
                    if(UserPanel.board.getTile(xCoord, y).getMine()) {
                        p.transfer(xCoord, y);
                        UserPanel.board.getTile(xCoord, y).detonateMine();
                        return true;
                    }
                    if(UserPanel.board.getTile(xCoord, y).getHasPiece()){
                        return false;
                    }
                }
            }
            if (y2 - y != 0) {
                for (int i = 1; i < Math.abs(y - y2); i++) {
                    int yCoord;
                    if(x2 - x > 0)
                        yCoord = y + i;
                    else
                        yCoord = y - i;
                    if(UserPanel.board.getTile(x, yCoord).getMine()) {
                        p.transfer(x, yCoord);
                        UserPanel.board.getTile(x, yCoord).detonateMine();
                        return true;
                    }
                    if(UserPanel.board.getTile(x, yCoord).getHasPiece()){
                        return false;
                    }
                }
            }
            p.transfer(x2, y2);
            if(UserPanel.board.getTile(x2, y2).getMine()){
                UserPanel.board.getTile(x2, y2).detonateMine();
            }
            return true;
        }
        return false;
    }
}