package Screen;

import internal_data.MachineMoney;

import javax.swing.*;
import java.awt.*;

public class EnterAdmin extends JPanel{
    public String password="1234567!!";
    public EnterAdmin(MachineScreen machineScreen, PayChoice payChoice, MachineMoney machineMoney, UserInfo userInfo, MachineInfo machineInfo)
    {
        super();
        this.setBackground(Color.WHITE);
        JButton button=new JButton("관리자모드 진입");
        button.setPreferredSize(new Dimension(350, 30));
        this.add(button);
        button.addActionListener(e -> {
            new AdminMode.AuthorityAuthentication(machineScreen,payChoice,this,machineMoney,userInfo,machineInfo);
        });
    }

    public JPanel getEnterAdmin() {
        return this;
    }

    public String setPassword(String password) {
        return this.password = password;
    }

    public String getPassword() {
        return this.password;
    }
}