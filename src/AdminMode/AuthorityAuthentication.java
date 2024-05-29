package AdminMode;

import Screen.*;
import internal_data.MachineMoney;

import javax.swing.*;
import java.awt.*;

public  class  AuthorityAuthentication extends JFrame {
    PayChoice payChoice;
    MachineScreen machineScreen;
    EnterAdmin enterAdmin;
    MachineMoney machineMoney;
    public AuthorityAuthentication(MachineScreen machineScreen, PayChoice payChoice, EnterAdmin enterAdmin, MachineMoney machineMoney, UserInfo userInfo, MachineInfo machineInfo) {
        super();
        this.machineMoney = machineMoney;
        this.machineScreen = machineScreen;
        this.payChoice = payChoice;
        this.enterAdmin = enterAdmin;
        this.setLayout(new GridLayout(0, 1));
        JLabel label = new JLabel("비밀번호를 입력하세요");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(label);
        JPasswordField passwordField = new JPasswordField();
        passwordField.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(passwordField);
        JButton button = new JButton("확인");
        button.setPreferredSize(new Dimension(350, 30));
        //비밀 번호가 맞으면 adminModeScreen 생성
        //엔터키로도 입력하능하게

        button.addActionListener(e -> {
            //엔터키도 입력가능

            if (String.valueOf(passwordField.getPassword()).equals(enterAdmin.getPassword())) {
                new AdminModeScreen(this, machineScreen,payChoice,enterAdmin,machineMoney,userInfo,machineInfo);
                payChoice.PayButton(true);
                machineScreen.SelectButton(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "비밀번호가 틀렸습니다.");
            }
        });
        this.add(button);
        this.setSize(400, 200);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }



}
