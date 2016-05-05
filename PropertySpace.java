import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.*;
import java.io.*;
public class PropertySpace extends Space implements ActionListener
{
    int pos;
    JLabel propertyName;
    static String[] propertyList = {"","600's Bathroom","100's Bathroom","","300's Bathroom","Little Theater","Cafeteria","","Snack Shack",
            "Commons","Counseling","Library","Campus Ministry","Quad","","200's Building",
            "Burns Pavilion","Alumni Gym","Graham Theater","Football Field","Robotics Lab","Quad", "Faculty Lounge","Front Office",
            "Athletics Office","","Andre House","Chech's Room"};
    static int[] priceList = {0,60,60,0,100,100,120,0,140,
            140,160,180,180,200,0,220,
            220,240,260,260,280,300,300,320,
            340,0,350,400};
    JLabel cost;
    JLabel owner;
    JPanel infoPanel;
    JFrame infoFrame;
    String ownerName;
    JButton buy;
    JButton info;
    JPanel topColor;
    JPanel bottom;
    JPanel buyPanel;
    JFrame buyFrame;
    Cornerspace[]cornerList;
    String propertyTitle;
    int rent;
    public PropertySpace(Color c, int p)
    {
        this.setLayout(new GridLayout(5,1));
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        topColor = new JPanel();
        topColor.setBackground(c);
        propertyName = new JLabel(propertyTitle);
        cost = new JLabel();
        owner = new JLabel("Owner: " + ownerName);
        bottom = new JPanel();
        buy = new JButton("Buy");
        buy.addActionListener(this);
        info = new JButton("Info");
        info.addActionListener(this);
        bottom.setLayout(new GridLayout(1,2));
        bottom.add(buy);
        bottom.add(info);
        pos = p;
        this.add(topColor);
        propertyName.setText(propertyList[p]);
        this.add(propertyName);
        cost.setText("$" + priceList[p]);
        this.add(cost);
        this.add(owner);
        this.add(bottom);

    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource()==buy)
        {
            buyPanel = new JPanel();
            buyPanel.setLayout(new GridLayout(4,1));
            buyPanel.add(topColor);
            buyPanel.add(propertyName);
            buyPanel.add(cost);
            JLabel confirm = new JLabel("Are you sure you want to buy this property?");
            buyPanel.add(confirm);
            buyFrame = new JFrame();
            buyFrame.setSize(500,444);
            buyFrame.add(buyPanel);
            buyFrame.setVisible(true);
        }
        else if (e.getSource()==info)
        {
            infoPanel = new JPanel();
            infoPanel.setLayout(new GridLayout(3,1));
            infoPanel.add(topColor);
            infoPanel.add(propertyName);

            JLabel rentLabel = new JLabel("Rent: $" + priceList[pos]/8);
            infoPanel.add(rentLabel);
            infoFrame = new JFrame();
            infoFrame.setSize(500,444);
            infoFrame.add(buyPanel);
            infoFrame.setVisible(true);
        }
    }
}

