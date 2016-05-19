import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.io.*;
public class Board implements ActionListener
{
    JFrame mainFrame;
    JPanel mainPanel;
    JPanel topPanel;
    JPanel rightPanel;
    JPanel bottomPanel;
    JLabel dLabel;
    JPanel leftPanel;
    JPanel centerPanel;
    Space[] spaceList;
    JButton endTurn;
    File f1;
    JPanel monopolyContain;
    Dice d;
    Color[] colorList;
    JButton dice;
    ArrayList<Player> pList;
    int pNum;
    boolean endTurnB;
    Player p;
    int index;

    public Board(ArrayList<Player> p)
    {
        mainFrame = new JFrame("Monopoly");
        //mainFrame.setSize(1050,1050);
        Dimension dd = Toolkit.getDefaultToolkit().getScreenSize();
        mainFrame.setBounds(0,0,dd.width,dd.height);
        mainFrame.setSize(dd);
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(0,0));
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
        dLabel = new JLabel();
        d = new Dice();
        pList = p;
        index = 0;
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
                spaceList[i] = new CardSpace("Community Chest", new ImageIcon("Images/ComChest.jpg"));
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
                spaceList[i].setPreferredSize(spaceList[i].getPreferredSize());
                spaceList[i].validate();
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
        leftPanel.setLayout(new GridLayout(5,1));
        leftPanel.setBorder(BorderFactory.createLineBorder(Color.black));

        for(int i = 26; i>=22; i--)
        {
            if(i>=25&&i<=26)
            {
                spaceList[i] = new PropertySpace(colorList[7],i);
                leftPanel.add(spaceList[i]);
            }
            //             else if(i==25)
            //             {
            //                 //spaceList[i] = new CardSpace("Chance", new ImageIcon("Images/chance.jpg"));
            //                 //leftPanel.add(spaceList[i]);
            //             }
            else if(i>=22&&i<=24)
            {
                spaceList[i] = new PropertySpace(colorList[6],i);
                leftPanel.add(spaceList[i]);
            }

        }
        topPanel.setPreferredSize(new Dimension(200,160));

        bottomPanel.setPreferredSize(new Dimension(200,130));

        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(rightPanel, BorderLayout.EAST);
        mainPanel.add(bottomPanel,BorderLayout.SOUTH);
        mainPanel.add(leftPanel,BorderLayout.WEST);
        monopolyContain = new JPanel();
        monopolyContain.setLayout(new BorderLayout());
        Cornerspace main = new Cornerspace(new ImageIcon("Images/monopolymain copy.png"), true);
        ImageIcon iCD = new ImageIcon("Images/dice.png");
        dice = new JButton(iCD);
        dice.setSize(iCD.getIconWidth()+4, iCD.getIconHeight()+1);
        endTurn = new JButton();  

        monopolyContain.add(main, BorderLayout.CENTER); 
        monopolyContain.add(endTurn,BorderLayout.EAST);
        monopolyContain.add(dLabel,BorderLayout.WEST);
        monopolyContain.add(dice, BorderLayout.SOUTH);
        mainPanel.add(monopolyContain, BorderLayout.CENTER);
        mainFrame.add(mainPanel);
        mainFrame.setVisible(true);
        main.setPos(false);
        dice.addActionListener(this);
        endTurn.addActionListener(this);
        for (int i = 0; i<pList.size(); i++)//put everyone on Go space
        {
            this.add(pList.get(i),i+1, 0);
        }
        for (int i = 1; i<=2; i++)
        {
            spaceList[i].getYesButton().addActionListener(this);
        }
        for (int i = 4; i<=6; i++)
        {
            spaceList[i].getYesButton().addActionListener(this);
        }
        for (int i = 8; i<=13; i++)
        {
            spaceList[i].getYesButton().addActionListener(this);
        }
        for (int i = 15; i<=20; i++)
        {
            spaceList[i].getYesButton().addActionListener(this);
        }
        for (int i = 22; i<=26; i++)
        {
            spaceList[i].getYesButton().addActionListener(this);
        }
        
    }

    public void add(Player p, int playerRef, int pos)
    {
        Space space = spaceList[pos];
        JPanel spot = space.getPlayerSpot(playerRef);
        spot.add(p.getImgLabel());
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==dice)
        {
            endTurn.setText("End " + p.getName() + "'s turn");
            int rollResult = d.roll();//roll dice and get result

            dLabel.setText(p.getName()+ d.getStr());//set dLabel to announce roll result

            move(p, rollResult);//move player

        }
        if(e.getSource()==endTurn)
        {
            index++;
            if (index>3) index = 0;//needs to adjust for number of players
            playTurn(pList.get(index));

        }
        if(e.getSource()==(spaceList[p.getPos()].getYesButton()))
        {
            p.withdraw(spaceList[p.getPos()].getCost(p.getPos()));
            spaceList[p.getPos()].setOwner(p);
            mainFrame.repaint();
            mainFrame.setVisible(true);
            System.out.println("asfayhsdggasdfgasdhfgad");
            //buyFrame.dispatchEvent(new WindowEvent(buyFrame, WindowEvent.WINDOW_CLOSING));
        }

        mainFrame.repaint();
    }

    public void drawBoard()
    {

        mainFrame.add(mainPanel);
        mainFrame.setVisible(true);

    }

    public void playTurn(Player player)//this changes who the active player is
    {
        p = player;
    }

    public JButton getEndTurn()
    {
        return endTurn;
    }

    public void move(Player p, int roll)//moves player
    {
        Space current = spaceList[p.getPos()];//"current" is the player's current space
        current.remove(p);//remove the player from the space
        int newSpaceInt = p.getPos() + roll; //new position of player after roll
        if (newSpaceInt>27) newSpaceInt-=27;//adjusting for cycling
        p.setPos(newSpaceInt);//update the pos var of the player
        this.add(p,p.getRef(), newSpaceInt);//add the player to the board at the proper space
    }
}