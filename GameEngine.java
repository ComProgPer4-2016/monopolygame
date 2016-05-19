import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.applet.Applet;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane; //imports JOptionPane class so it can be used in code
public class GameEngine implements ActionListener
{
    Board board;
    ArrayList<Player> pList = new ArrayList<Player>();
    //ArrayList<Integer> intList = new ArrayList<Integer>();
    int losers;
    int index;
    int playerNumber;
    JFileChooser fC;
    boolean imageChosen = false;
    File file;
    public GameEngine()
    {

        fC = new JFileChooser();
        losers = 0;
        index = 0;
        String pN = JOptionPane.showInputDialog(null, "How many players?\nMaximum of 4." );
        //invokes static method showInputDialog with implicit parameter JOptionPane,
        //and explicit paramter of "null, Player 1, enter a word", stores user input to newly constructed memory location with return type of String
        playerNumber = Integer.parseInt(pN);
        fC.addActionListener(this);
        for (int i=1;i<playerNumber+1;i++)
        {
            String name = JOptionPane.showInputDialog(null, "Player " + i + " enter your name." );

            //chooseChar.setVisible(true); 
            /*while(!imageChosen)
            {
                int status = fC.showOpenDialog(null);

                if (status == fC.APPROVE_OPTION)
                {
                    file = fC.getSelectedFile();
                }
                imageChosen = true;
            }*/
            pList.add(new Player(name, i, file));
            if (name ==null)
            {
                System.exit(0);
            }
            imageChosen = false;
        }

        board = new Board(pList);
        board.displayBoard(); 

    }

    public void playGame()
    {
        index = 0;

        boolean win = false;
        board.playTurn(pList.get(index));

    }

    public void actionPerformed(ActionEvent e)
    {
        /*if(e.getSource()==board.getEndTurn())
        {
        index++;
        board.playTurn(pList.get(index));

        }*/
        
    }

    public void nextTurn(Player player)
    {
        player.nextTurn();
    }

    public void setIndex(int x)
    {
        index = x;
    }

}

