package Screen;

import in.MachineMoney;
import in.User;

import javax.swing.*;
import java.awt.*;

public class Information extends JPanel {
    public Information(User user, UserInfo userInfo, MachineMoney machineMoney, MachineInfo machineInfo)
    {
        super();
        this.setLayout(new GridLayout(0,2));


        // Create a PayChoice instance and pass the UserInformationScreen and MachineInformationScreen instances
        PayChoice payChoice = new PayChoice(user, userInfo, machineMoney, machineInfo);

        this.revalidate(); // Re-layout the components
        this.repaint(); // Refresh the display

        this.add(machineInfo.getMachineInformationScreen());
        this.add(userInfo.getUserInformationScreen());
        // Add the PayChoice instance to the panel
    }

    public JPanel getPanel()
    {
        return this;
    }
}