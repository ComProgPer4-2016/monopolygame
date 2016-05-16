import javax.swing.*;
public class Player
{
    String name;
    int balance;
    int reference;
    boolean turn;
    ImageIcon icon;
    int pos;
    int ref;
    public Player(String n, int r)
    {
        name = n;
        balance = 1500;
        icon = new ImageIcon("Images/car2.jpg");
        pos = 0;
        ref = r;
    }
    
    public int getRef()
    {
        return reference;
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
    

    
}
