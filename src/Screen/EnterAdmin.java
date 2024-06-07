package Screen;

import internal_data.MachineMoney;

import javax.swing.*;
import java.awt.*;

public class EnterAdmin extends JPanel{
    public String password="1234567!!";//기본 비밀번호

    //관리자모드 진입 버튼 생성
    public EnterAdmin(MachineScreen machineScreen, PayChoice payChoice, MachineMoney machineMoney, UserInfo userInfo, MachineInfo machineInfo)
    {
        super();
        this.setBackground(Color.WHITE);
        JButton button=new JButton("관리자모드 진입");
        button.setPreferredSize(new Dimension(350, 30));
        this.add(button);
        //버튼을 누를 경우
        button.addActionListener(e -> {
            //비밀번호 입력 창 생성
            new AdminMode.AuthorityAuthentication(machineScreen,payChoice,this,machineMoney,userInfo,machineInfo);
        });
    }


    //비밀번호 변경
    public String setPassword(String password) {
        return this.password = password;
    }

    //비밀번호 반환
    public String getPassword() {
        return this.password;
    }

    public JPanel getEnterAdmin() {
        return this;
    }
}