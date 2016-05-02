import java.util.Random;

public class Dice
{
    private int first;
    private int second;
    private Random gen;
    public Dice()
    {
        gen = new Random();
    }
    public double roll()
    {
        first = gen.nextInt(5)+1;
        second = gen.nextInt(5)+1;
        return first+second;
    }
    public boolean Doubles()
    {
        if (first==second) return true;
        else return false;
    }
}
