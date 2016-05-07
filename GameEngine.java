import java.util.*;
import javax.swing.JOptionPane; //imports JOptionPane class so it can be used in code
public class GameEngine
{
    Board board;
    ArrayList<Player> pList = new ArrayList<Player>();
    ArrayList<String> nameList = new ArrayList<String>();
    Dice dice;
    int losers;
    int turn;
    public GameEngine()
    {
        dice = new Dice();
        board = new Board();
        losers = 0;
        String pN = JOptionPane.showInputDialog(null, "How many players?\nMaximum of 4." ); //invokes static method showInputDialog with implicit parameter JOptionPane,
        //and explicit paramter of "null, Player 1, enter a word", stores user input to newly constructed memory location with return type of String
        if (pN ==null)
            {
               System.exit(0);
            }
        int playerNumber = Integer.parseInt(pN);
        turn = playerNumber;
        for (int i=1;i<playerNumber+1;i++)
        {
            String name = JOptionPane.showInputDialog(null, "Player " + i + " enter your name." );
            nameList.add(name);
            if (name ==null)
            {
               System.exit(0);
            }
            
        }

    }

    public void playGame()
    {
        board.displayBoard();        
        //         while (losers<3)
        //         {
        //             Player player = pList.get(t);
        //             boolean lost = playTurn(player);
        //             //if (lost) losers++; pList.remove(t);
        //             //t++;
        //             if (t==4-losers) t=0;
        //         }
    }

    public void nextTurn(Player player)
    {
        player.setTurn();
    }
}
