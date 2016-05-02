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
        colorList = new Color[8];
        colorList[0] = new Color(99,74,18);
        colorList[1] = new Color(119,223,237);
        colorList[2] = new Color(252,63,192);
        colorList[3] = new Color(252,156,0);
        colorList[4] = Color.red;
        colorList[5] = Color.yellow;
        colorList[6] = Color.green;
        colorList[7] = Color.blue;

 
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
                spaceList[i]=new Cornerspace(new ImageIcon("Images/freeparking.jpg"));

            }
            else if (i==7)
            {
                spaceList[i]=new Cornerspace(new ImageIcon("Images/freeparking.jpg"));

            }
            else
            {
                spaceList[i] = new PropertySpace(colorList[i/4]);
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
                spaceList[i] = new PropertySpace(colorList[2]);
                rightPanel.add(spaceList[i]);
            }
            else if(i>=11&&i<=13)
            {
                spaceList[i] = new PropertySpace(colorList[3]);
                rightPanel.add(spaceList[i]);
            }
            
        }

        bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(1,8));
        bottomPanel.setBorder(BorderFactory.createLineBorder(Color.black));

        for(int i = 21; i>=14; i--)
        {
            if (i==21)
            {
                spaceList[i]=new Cornerspace(new ImageIcon("Images/freeparking.jpg"));
            }
            else if (i==14)
            {
                spaceList[i]=new Cornerspace(new ImageIcon("Images/freeparking.jpg"));

            }
            
            if(i>=18&&i<=20)
            {
                spaceList[i] = new PropertySpace(colorList[4]);
                bottomPanel.add(spaceList[i]);
            }
            else if(i>=15&&i<=17)
            {
                spaceList[i] = new PropertySpace(colorList[5]);
                bottomPanel.add(spaceList[i]);
            }

            bottomPanel.add(spaceList[i]);
        }

        leftPanel = new JPanel();
        leftPanel.setLayout(new GridLayout(6,1));
        leftPanel.setBorder(BorderFactory.createLineBorder(Color.black));

        for(int i = 27; i>=22; i--)
        {
            if(i>=24&&i<=26)
            {
                spaceList[i] = new PropertySpace(colorList[6]);
                leftPanel.add(spaceList[i]);
            }
            else if(i>=22&&i<=24)//fix this shit
            {
                spaceList[i] = new PropertySpace(colorList[7]);
                leftPanel.add(spaceList[i]);
            }
           

        }

        for (int i =0;i<28;i++)
        {
            //spaceList[i].setName( FINISH THIS ABBAS
        }

        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(rightPanel, BorderLayout.EAST);
        mainPanel.add(bottomPanel,BorderLayout.SOUTH);
        mainPanel.add(leftPanel,BorderLayout.WEST);
        this.drawBoard();
    }

    public void drawBoard()
    {
        mainFrame.add(mainPanel);
        mainFrame.setVisible(true);
    }
}