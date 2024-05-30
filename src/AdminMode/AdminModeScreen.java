package AdminMode;
import Screen.*;
import detail_frame.ChangePassword;
import detail_frame.ItemManagement;
import detail_frame.SalesCheck;
import detail_frame.collection;
import internal_data.MachineMoney;

import javax.swing.*;
import java.awt.*;

public class AdminModeScreen extends JFrame {
    AuthorityAuthentication authorityAuthentication;
    MachineScreen machineScreen;
    PayChoice payChoice;
    EnterAdmin enterAdmin;
    MachineMoney machineMoney;
    UserInfo userInfo;
    MachineInfo machineInfo;
    AdminModeScreen(AuthorityAuthentication authorityAuthentication, MachineScreen machineScreen, PayChoice payChoice, EnterAdmin enterAdmin, MachineMoney machineMoney, UserInfo userInfo, MachineInfo machineInfo) {
        this.authorityAuthentication = authorityAuthentication;
        this.machineScreen = machineScreen;
        this.payChoice = payChoice;
        this.enterAdmin = enterAdmin;
        this.machineMoney = machineMoney;
        this.userInfo = userInfo;
        this.machineInfo = machineInfo;
        this.setTitle("관리자 모드");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocation(500, 200);
        this.setSize(300, 400);
        this.setLayout(new BorderLayout());
        topBar();
        menuButton();
        this.setVisible(true);
    }

    void topBar() {
        JPanel topBar = new JPanel();
        topBar.setPreferredSize(new Dimension(500, 50));
        JLabel label = new JLabel("관리자 모드");
        label.setFont(new Font("Serif", Font.BOLD, 30));
        topBar.add(label);
        topBar.setBackground(Color.white);
        this.add(topBar, BorderLayout.NORTH);
    }

    void menuButton() {
        JPanel menuButton = new JPanel();
        menuButton.setLayout(new GridLayout(0, 1, 0, 10));

        String[] buttonLabels = {"비밀번호 변경", "매출 확인", "물품 관리", "수금", "관리자 모드 종료 및 변경 사항 적용"};
        JButton[] buttons = new JButton[buttonLabels.length];

        for (int i = 0; i < 4; i++) {
            buttons[i] = new JButton(buttonLabels[i]);
            menuButton.add(buttons[i]);
            buttons[i].setBackground(Color.GRAY);
            buttons[i].setFont(new Font("Serif", Font.BOLD, 20));
            buttons[i].setForeground(Color.white);
        }
        buttons[4] = new JButton(buttonLabels[4]);
        menuButton.add(buttons[4]);
        buttons[4].setBackground(Color.GRAY);
        buttons[4].setFont(new Font("Serif", Font.BOLD, 15));
        buttons[4].setForeground(Color.white);


        buttons[0].addActionListener(e -> {
            new ChangePassword(enterAdmin);
        });
        buttons[1].addActionListener(e -> {
            new SalesCheck();
        });
        buttons[2].addActionListener(e -> {
            new ItemManagement(machineScreen);
        });

        buttons[3].addActionListener(e -> {
            new collection(machineMoney);
        });
        buttons[4].addActionListener(e -> {
             payChoice.PayButton(false);
             machineInfo.displayMachineMoney();
             userInfo.displayUserMoney();
            machineScreen.MenuLabel(machineScreen.beverages);
            machineScreen.ReturnButton();
            machineScreen.SelectButton(false);
            machineScreen.BeverageName(machineScreen.beverages);
            machineScreen.PhotoScreen();

             this.dispose();
        });

        this.add(menuButton, BorderLayout.CENTER);
    }


}
