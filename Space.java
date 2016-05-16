import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.*;
import java.io.*;
public class Space extends JPanel
{
    String n;
    JPanel spaceP;//this is essentially the Space itself
    JPanel northP = new JPanel();
    JPanel playersP;
    JPanel player1spot = new JPanel();//panel that holds player icon
    JPanel player2spot = new JPanel();
    JPanel player3spot = new JPanel();
    JPanel player4spot = new JPanel();
    public Space()
    {
        spaceP = new JPanel();
        spaceP.setLayout(new BorderLayout(0,0));

        playersP = new JPanel();
        playersP.setLayout(new GridLayout(1,4,0,0));
        playersP.add(player1spot);
        playersP.add(player2spot);
        playersP.add(player3spot);
        playersP.add(player4spot);

        spaceP.add(playersP, BorderLayout.SOUTH);
        

    }
    
    public void remove(Player p)
    {
        int ref = p.getRef();
        if (ref==1) player1spot.removeAll();//removes all components in a panel
        if (ref==2) player2spot.removeAll();
        if (ref==3) player3spot.removeAll();
        else player4spot.removeAll();
    }
    
    public JPanel getPlayerSpot(int ref)
    {
        if (ref==1) return player1spot;
        if (ref==2) return player2spot;
        if (ref==3) return player3spot;
        else return player4spot;
    }

    public void setName(String n)
    {

    }

}
