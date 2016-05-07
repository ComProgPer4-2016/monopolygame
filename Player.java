
public class Player
{
    String name;
    int balance;
    boolean turn;
    public Player(String n)
    {
        name = n;
        balance = 1500;
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
    
    
}
