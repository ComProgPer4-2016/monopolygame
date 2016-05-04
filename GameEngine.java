import java.util.*;
public class GameEngine
{
    Board board;
    ArrayList<Player> pList = new ArrayList<Player>();
    Dice dice;
    int losers;
    int t = 0;
    public GameEngine()
    {
        dice = new Dice();
        board = new Board();
        losers = 0;
        pList.add(new Player("Player 1"));
        pList.add(new Player("Player 2"));
        pList.add(new Player("Player 3"));
        pList.add(new Player("Player 4"));
    }
    public void playGame()
    {
        board.displayBoard();        
        while (losers<3)
        {
            Player player = pList.get(t);
            boolean lost = playTurn(player);
            //if (lost) losers++; pList.remove(t);
            //t++;
            if (t==4-losers) t=0;
        }
    }
    boolean playTurn(Player player)
    {
        return false;
    }
}
