import javax.swing.*;
    import java.io.File;
public class Player
{
    String name;
    JLabel imgLabel;
    int balance;
    boolean turn;
    ImageIcon icon;
    int pos;
    int ref;
    public Player(String n, int r, File f)
    {
        name = n;
        imgLabel = new JLabel();
        balance = 1500;
        //icon = new ImageIcon(f.getPath());
        icon = new ImageIcon("Images/rishab.jpg");

        pos = 0;
        ref = r;
        imgLabel.setIcon(icon);
    }
    
    public void withdraw(int x)
    {
        balance-=x;
        System.out.println("works");
    }
    
    public int getRef()
    {
        return ref;
    }
    
    public int getPos()
    {
        return pos;
    }
    
    public void setPos(int p)
    {
        pos = p;
    }
    
    public ImageIcon getIcon()
    {
        return icon;
    }

    public void payRentTo(Player other, int rent)
    {
        balance -= rent;
        other.addToBalance(rent);
    }

    public void addToBalance(int value)
    {
        balance += value;
    }

    public void takeFromBalance(int value)
    {
        balance -= value;
    }
    
    public void setTurn()
    {
        turn = true;
    }
    
    public void nextTurn()
    {
        turn=false;
    }
    
    public String getName()
    {
        return name;
    }
    
    public JLabel getImgLabel()
    {
        return imgLabel;
    }
    
}
