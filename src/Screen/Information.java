package Screen;

import internal_data.MachineMoney;
import internal_data.User;

import javax.swing.*;
import java.awt.*;

public class Information extends JPanel {
    //사용자 정보, 기기 정보, 기기 돈 정보, 기기 정보를 받아오는 생성자
    public Information(User user, UserInfo userInfo, MachineMoney machineMoney, MachineInfo machineInfo)
    {
        super();
        this.setLayout(new GridLayout(0,2));
        this.revalidate();
        this.repaint();

        //사용자 정보, 기기 돈 정보를 ADD
        this.add(machineInfo.getMachineInformationScreen());
        this.add(userInfo.getUserInformationScreen());
    }

    public JPanel getPanel()
    {
        return this;
    }
}