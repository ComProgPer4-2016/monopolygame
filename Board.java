import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.io.*;
public class Board
{
    JFrame mainFrame;
    JPanel mainPanel;
    JPanel topPanel;
    JPanel rightPanel;
    JPanel bottomPanel;
    JPanel leftPanel;
    Space[] spaceList;
    File f1;
    Color[] colorList;

    public Board()
    {
        mainFrame = new JFrame("Monopoly");
        mainFrame.setSize(1000,1000);
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        spaceList = new Space[28];
        colorList = new Color[9];
        colorList[0] = new Color(99,74,18);
        colorList[1] = new Color(119,223,237);
        colorList[2] = new Color(252,63,192);
        colorList[3] = new Color(252,156,0);
        colorList[4] = Color.red;
        colorList[5] = Color.yellow;
        colorList[6] = Color.green;
        colorList[7] = Color.blue;
        colorList[8] = Color.black;

 
    }

    public void displayBoard()
    {
        topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(1,8));
        topPanel.setBorder(BorderFactory.createLineBorder(Color.black));

        for(int i = 0; i<=7; i++)
        {
            if (i==0)
            {
                spaceList[i]=new Cornerspace(new ImageIcon("Images/Go.jpg"), false);

            }
            else if (i==7)
            {
                spaceList[i]=new Cornerspace(new ImageIcon("Images/jail.jpg"), false);

            }
           
            else if(i==3)
            {
                spaceList[i] = new PropertySpace(colorList[8], i);
            }
            else if(i>=1&&i<=2)
            {
                spaceList[i] = new PropertySpace(colorList[0], i);
            }
            else if(i>=4&&i<=6)
            {
                spaceList[i] = new PropertySpace(colorList[1],i);
            }

            topPanel.add(spaceList[i]);
        }
        rightPanel = new JPanel();
        rightPanel.setLayout(new GridLayout(6,1));
        rightPanel.setBorder(BorderFactory.createLineBorder(Color.black));

        for(int i = 8; i<=13; i++)
        {

            if(i>=8&&i<=10)
            {
                spaceList[i] = new PropertySpace(colorList[2],i);
            }
            else if(i>=11&&i<=13)
            {
                spaceList[i] = new PropertySpace(colorList[3],i);
                
            }
            rightPanel.add(spaceList[i]);
        }

        bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(1,8));
        bottomPanel.setBorder(BorderFactory.createLineBorder(Color.black));

        for(int i = 21; i>=14; i--)
        {
            if (i==21)
            {
                spaceList[i]=new Cornerspace(new ImageIcon("Images/gtj.jpg"), false);
            }
            else if (i==14)
            {
                spaceList[i]=new Cornerspace(new ImageIcon("Images/freeparking.jpg"), false);

            }
            
            if(i>=18&&i<=20)
            {
                spaceList[i] = new PropertySpace(colorList[5],i);
                
            }
            else if(i>=15&&i<=17)
            {
                spaceList[i] = new PropertySpace(colorList[4],i);
            }

            bottomPanel.add(spaceList[i]);
        }

        leftPanel = new JPanel();
        leftPanel.setLayout(new GridLayout(6,1));
        leftPanel.setBorder(BorderFactory.createLineBorder(Color.black));

        for(int i = 28; i>=22; i--)
        {
            if(i>=26&&i<=27)
            {
                spaceList[i] = new PropertySpace(colorList[7],i);
                leftPanel.add(spaceList[i]);
            }
            else if(i==25)
            {
                spaceList[i] = new PropertySpace(colorList[8],i);
                leftPanel.add(spaceList[i]);
            }
            else if(i>=22&&i<=24)
            {
                spaceList[i] = new PropertySpace(colorList[6],i);
                leftPanel.add(spaceList[i]);
            }
           
            
        }


        
        
        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(rightPanel, BorderLayout.EAST);
        mainPanel.add(bottomPanel,BorderLayout.SOUTH);
        mainPanel.add(leftPanel,BorderLayout.WEST);
        JPanel monopolyContain = new JPanel();
        monopolyContain.setLayout(new BorderLayout());
        Cornerspace main = new Cornerspace(new ImageIcon("Images/monopolymain copy.png"), true);
        monopolyContain.add(main, BorderLayout.CENTER);        
        mainPanel.add(monopolyContain, BorderLayout.CENTER);
        this.drawBoard();
        main.setPos(false);
    }

    public void drawBoard()
    {
        mainFrame.add(mainPanel);
        mainFrame.setVisible(true);
    }
}