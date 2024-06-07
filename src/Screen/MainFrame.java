package Screen;

import internal_data.MachineMoney;
import internal_data.User;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    User user;
    MachineScreen machineScreen;

    // 사용자가 자판기를 사용하는 메인 화면을 생성
    public MainFrame(User user, UserInfo userInfo, MachineMoney machineMoney, MachineInfo machineInfo, Information information)
    {
        this.user = user;
        this.machineScreen = new MachineScreen(user, userInfo,machineMoney, machineInfo,information);
        // 오른쪽 화면을 생성
        RightScreen rightScreen = new RightScreen(user,userInfo,machineMoney, machineInfo, information, machineScreen);

        this.setLayout(new GridLayout(0,2));
        this.setTitle("자판기");
        this.setResizable(false);

        // 왼쪽 화면과 오른쪽 화면을 추가
        this.add(machineScreen.getMachineScreen());
        this.add(rightScreen.getPanel());
        // 화면 설정
        this.setLocation(500,200);
        this.setSize(700,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

}

