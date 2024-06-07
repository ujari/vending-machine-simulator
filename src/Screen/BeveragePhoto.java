package Screen;

import javax.swing.*;
import java.awt.*;

public class BeveragePhoto extends JLabel {
    String ad;
    //음료 사진 생성
    public BeveragePhoto(String add)
    {
        super();
        this.ad = add;
        ImageIcon icon = new ImageIcon(add);
        Image image = icon.getImage();
        Image newimg = image.getScaledInstance(60, 60,  java.awt.Image.SCALE_SMOOTH); //음료 사진의 크기를 지정
        icon = new ImageIcon(newimg);
        setIcon(icon);
        this.setSize(70,70);
    }

}