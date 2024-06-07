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

        //비밀번호 입력은 안내하는 레이블
        JLabel label = new JLabel("비밀번호를 입력하세요");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(label);

        //비밀번호를 입력받는 패스워드 필드
        JPasswordField passwordField = new JPasswordField();
        passwordField.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(passwordField);

        //비밀번호 입력을 완료하는 버튼
        JButton button = new JButton("확인");
        button.setPreferredSize(new Dimension(350, 30));

        //버튼을 누를 경우
        button.addActionListener(e -> {
        if (String.valueOf(passwordField.getPassword()).equals(enterAdmin.getPassword())) {
            //비밀번호가 맞을 경우 AdminModeScreen을 생성하고 현재 창을 닫음
            new AdminModeScreen(this, machineScreen, payChoice, enterAdmin, machineMoney, userInfo, machineInfo);
            //자판기가 동작하지 않도록 설정
            payChoice.PayButton(true);
            machineScreen.SelectButton(true);
            this.dispose();
        }
        else
        {
            //비밀번호가 틀릴 경우 경고창을 띄움
            JOptionPane.showMessageDialog(null, "비밀번호가 틀렸습니다.");
        }
        });

        //버튼이 엔터키로 입력될 경우
        passwordField.addActionListener(e -> {
        if (String.valueOf(passwordField.getPassword()).equals(enterAdmin.getPassword())) {
            //비밀번호가 맞을 경우 AdminModeScreen을 생성하고 현재 창을 닫음
            new AdminModeScreen(this, machineScreen, payChoice, enterAdmin, machineMoney, userInfo, machineInfo);
            //자판기가 동작하지 않도록 설정
            payChoice.PayButton(true);
            machineScreen.SelectButton(true);
            
            this.dispose();
        }
        else
        {
            //비밀번호가 틀릴 경우 경고창을 띄움
            JOptionPane.showMessageDialog(null, "비밀번호가 틀렸습니다.");
        }
        });
        this.add(button);

        //창의 크기와 위치 설정
        this.setSize(400, 200);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }



}
