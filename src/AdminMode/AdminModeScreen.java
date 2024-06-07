package AdminMode;
import Screen.*;
import detail_frame.ChangePassword;
import detail_frame.ItemAndMoneyManagement;
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

        String[] buttonLabels = {"비밀번호 변경", "매출 확인", "잔고 및 물품 관리", "수금", "관리자 모드 종료 및 변경 사항 적용"};
        JButton[] buttons = new JButton[buttonLabels.length];

        //버튼 추가
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

        //버튼이 눌릴 시 동작 구현

        //비밀번호 변경
        buttons[0].addActionListener(e -> {
            new ChangePassword(enterAdmin);
        });

        //매출 확인
        buttons[1].addActionListener(e -> {
            new SalesCheck();
        });

        //잔고 및 물품 관리
        buttons[2].addActionListener(e -> {
            new ItemAndMoneyManagement(machineScreen);
        });

        //수금
        buttons[3].addActionListener(e -> {
            new collection(machineMoney);
        });

        //관리자 모드 종료 및 변경 사항 적용
        buttons[4].addActionListener(e -> {
             payChoice.PayButton(false);//payButton 초기화
             machineInfo.displayMachineMoney();//displayMachineMoney 초기화
             userInfo.displayUserMoney();//displayUserMoney 초기화
            machineScreen.MenuLabel(machineScreen.beverages);//MenuLabel 초기화
            machineScreen.ReturnButton();//ReturnButton 초기화
            machineScreen.SelectButton(false);//SelectButton 초기화
            machineScreen.BeverageName(machineScreen.beverages);//BeverageName 초기화
            machineScreen.PhotoScreen();//PhotoScreen 초기화

             this.dispose();//관리자 모드 종료
        });

        this.add(menuButton, BorderLayout.CENTER);
    }


}
