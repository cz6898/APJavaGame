/**
 * Created by Chris on 2/23/2016.
 */
public interface Diagonal{
    public static boolean move(Piece p, int x2, int y2) {
        int x = p.getX();
        int y = p.getY();
        if (Math.abs(x2 - x) == Math.abs(y2 - y)) {
            for (int i = 1; i < Math.abs(x2 - x); i++) {
                int xCoord, yCoord;
                if (x2 - x > 0)
                    xCoord = x + i;
                else
                    xCoord = x - i;
                if (y2 - y > 0)
                    yCoord = y + i;
                else
                    yCoord = y - i;
                if(UserPanel.board.getTile(xCoord, yCoord).getMine()) {
                    p.transfer(xCoord, yCoord);
                    UserPanel.board.getTile(xCoord, yCoord).detonateMine();
                    return true;
                }
                if(UserPanel.board.getTile(xCoord, yCoord).getHasPiece()) {
                    return false;
                }
            }
            p.transfer(x2, y2);
            if (UserPanel.board.getTile(x2, y2).getMine()) {
                UserPanel.board.getTile(x2, y2).detonateMine();
            }
            return true;
        }
        return false;
    }
}
