 import java.util.Random;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.io.*;
public class Dice
{
    private int first;
    JLabel dRoll;
    private int second;
    private Random gen;
    String str1;
    String str2;
    public Dice()
    {
        gen = new Random();
    }

    public  int roll()
    {
        first = gen.nextInt(6)+1;
        second = gen.nextInt(6)+1;
        str1 = Integer.toString(first);
        str2 = Integer.toString(second);
        dRoll = new JLabel(str1+str2);        
        return first+second;
    }
    
    public String getStr()
    {
        return   " rolled a: "+ str1+ " and a " + str2;
    }
    
    public boolean Doubles()
    {
        if (first==second) return true;
        else return false;
    }
}
