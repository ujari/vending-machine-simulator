package Screen;

import in.MachineMoney;
import in.User;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    User user;
    MachineScreen machineScreen;
    public MainFrame(User user, UserInfo userInfo, MachineMoney machineMoney, MachineInfo machineInfo, Information information)
    {  this.user = user;
        this.machineScreen = new MachineScreen(user, userInfo,machineMoney, machineInfo,information);
        RightScreen rightScreen = new RightScreen(user,userInfo,machineMoney, machineInfo, information);
        JFrame frame=new JFrame();
        frame.setLayout(new GridLayout(0,2));
        frame.setTitle("자판기");
        frame.setResizable(false);
        frame.add(machineScreen.getMachineScreen());
        frame.add(rightScreen.getPanel());
        frame.setLocation(500,200);
        frame.setSize(700,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

