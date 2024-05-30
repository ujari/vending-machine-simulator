package Screen;

import javax.swing.*;
import java.awt.*;

public class BeveragePhoto extends JLabel {
    String ad;
    public BeveragePhoto(String add)
    {
        super();
        this.ad = add;
        ImageIcon icon = new ImageIcon(add);
        Image image = icon.getImage(); // transform it 
        Image newimg = image.getScaledInstance(60, 60,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        icon = new ImageIcon(newimg);  // transform it back
        setIcon(icon);
        this.setSize(70,70);
    }

    public void setAd(String ad)
    {
        this.ad = ad;
    }
}