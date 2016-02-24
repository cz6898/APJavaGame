/**
 * Created by Chris on 2/18/2016.
 */
public interface JavaArcade {
    public void startGame();
    public void endGame();
    public void pauseGame();
    public String getGameName();
    public int getHighScore();
    public String getInstructions();
    public String getCredits();
}