import java.awt.event.*;
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
    JPanel confirmContainer;
    Cornerspace[]cornerList;
    String propertyTitle;
    JButton yes;
    JButton cancel;
    JButton closeInfo;
    int rent;
    Player user;
    public PropertySpace(Color c, int p)
    {
        this.setLayout(new GridLayout(5,1));
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        topColor = new JPanel();
        topColor.setBackground(c);
        
        propertyName = new JLabel(propertyTitle, JLabel.CENTER);
        
        cost = new JLabel("", JLabel.CENTER);
        //cost.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
        owner = new JLabel("Owner: " + ownerName, JLabel.CENTER);
        //owner.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
        
        bottom = new JPanel();
        buy = new JButton("Buy");
        
        confirmContainer = new JPanel();
        confirmContainer.setLayout(new GridLayout(1,2));
        yes = new JButton("Yes");
        yes.addActionListener(this);
        cancel = new JButton("Cancel");
        cancel.addActionListener(this);
        confirmContainer.add(yes);
        confirmContainer.add(cancel);

        closeInfo = new JButton("Close Window");
        closeInfo.addActionListener(this);

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
            buyPanel.setLayout(new GridLayout(5,1));
            buyPanel.add(topColor);
            buyPanel.add(propertyName);
            buyPanel.add(cost);
            JLabel confirm = new JLabel("Are you sure you want to buy this property?", JLabel.CENTER);
            confirm.setFont(new Font("Lucida Grande", Font.BOLD, 15));
            buyPanel.add(confirm);
            buyPanel.add(confirmContainer);
            buyFrame = new JFrame();
            buyFrame.setSize(400,500);
            buyFrame.add(buyPanel);
            buyFrame.setVisible(true);
        }
        else if (e.getSource()==info)
        {
            infoPanel = new JPanel();
            infoPanel.setLayout(new GridLayout(4,1));
            infoPanel.add(topColor);
            infoPanel.add(propertyName);
            JLabel rentLabel = new JLabel("Rent: $" + priceList[pos]/8, JLabel.CENTER);
            rentLabel.setFont(new Font("Lucida Grande", Font.BOLD, 15));
            infoPanel.add(rentLabel);
            infoPanel.add(closeInfo);

            infoFrame = new JFrame();
            infoFrame.setSize(500,444);
            infoFrame.add(infoPanel);
            infoFrame.setVisible(true);
        }
        else if (e.getSource()==yes)
        {
            //invoke buy transanction
            
        }
        else if (e.getSource()==cancel)
        {
            buyFrame.dispatchEvent(new WindowEvent(buyFrame, WindowEvent.WINDOW_CLOSING));
        }
        else if (e.getSource()==closeInfo)
        {
            infoFrame.dispatchEvent(new WindowEvent(infoFrame, WindowEvent.WINDOW_CLOSING));
        }
    }
}
