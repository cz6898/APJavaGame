/**
 * Created by Chris on 2/23/2016.
 */
public interface Diagonal{
    public static boolean move(Piece p, Tile[][] t, int x2, int y2) {
        int x = p.getX();
        int y = p.getY();
        if (Math.abs(x2 - x) == Math.abs(y2 - y)) {
            for (int i = 0; i < Math.abs(x - x2); i++) {
                int xCoord, yCoord;
                if (x2 - x > 0)
                    xCoord = x + i;
                else
                    xCoord = x - i;
                if (y2 - y > 0)
                    yCoord = y + i;
                else
                    yCoord = y - i;
                if(t[xCoord][yCoord].getMine()) {
                    p.transfer(t, xCoord, yCoord);
                    t[xCoord][yCoord].detonateMine();
                    return true;
                }
                if(t[xCoord][yCoord].getHasPiece()) {
                    return false;
                }
            }
            p.transfer(t, x2, y2);
            if (t[x2][y2].getMine()) {
                t[x2][y2].detonateMine();
            }
            return true;
        }
        return false;
    }
}
