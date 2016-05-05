import java.awt.image.*;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.File;
import java.awt.*;
import javax.swing.JComponent;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
public class Cornerspace extends Space
{
    BufferedImage img;//declaring instance field variable img as a BufferedImage
    ImageIcon i;
    boolean pos;
    public Cornerspace(ImageIcon n, boolean b)
    {
        i=n;
        JLabel image = new JLabel();
        image.setIcon(n);
        this.add(image);
        pos = b;

        /*img = null;//try catch statement to create imageIcon from a file
        try {
        img = ImageIO.read(n);//initializing img to the BufferedImage returned by invoking static accessor method read with explicit
        //parameter of type File invoked on the class ImageIO
        } catch (IOException ee) {//prevents crashing
        } */
    }

    public void paintComponent(Graphics g)//example of overriding the paintComponent method in the JComponent superclass
    {
        if(pos)
        {
            g.drawImage(img, 500-94, 500-94, null);
        }
        else
        {
            int xx = 1000-94;//initializing int x and assigning it to the int that is the result of the int
            //returned by accessor method getWidth invoked on this instance of the class subtracted from the int that resulted from the
            //accesor method getWidth invoked on the img with
            int yy = 0;//initializing int x and assigning it to the int that is the result of the int
            //returned by accessor method getWidth invoked on this instance of the class subtracted from the int that resulted from the
            //accesor method getWidth invoked on the img with
            g.drawImage(img, xx, yy, null);//invoking mutator method drawImage on the object referenced by g with explicit parameters of type
            //bufferedImages, int, int, null
        }
    }

    public void setPos(boolean i)
    {
        pos = i;
    }

}
