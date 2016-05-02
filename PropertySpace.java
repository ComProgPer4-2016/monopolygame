import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.*;
import java.io.*;
public class PropertySpace extends Space
{
    double price;
    JLabel propertyName;
    String propertyTitle;
    JLabel cost;
    JLabel owner;
    String ownerName;
    JButton buy;
    JButton info;
    JPanel topColor;
    JPanel bottom;
    Cornerspace[]cornerList;
    public PropertySpace(Color c)
    {
       this.setLayout(new GridLayout(5,1));
       this.setBorder(BorderFactory.createLineBorder(Color.black));
       topColor = new JPanel();
       topColor.setBackground(c);
       propertyName = new JLabel(propertyTitle);
       cost = new JLabel("$" + price);
       owner = new JLabel("Owner: " + ownerName);
       bottom = new JPanel();
       buy = new JButton("Buy");
       info = new JButton("Info");
       bottom.setLayout(new GridLayout(1,2));
       bottom.add(buy);
       bottom.add(info);
   
       
       
       this.add(topColor);
       this.add(propertyName);
       this.add(cost);
       this.add(owner);
       this.add(bottom);
            
       
    }
    
    public void setName(String n)
    {
        propertyTitle = n;
    }
    
   
   
}

