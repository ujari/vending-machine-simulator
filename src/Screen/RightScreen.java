package Screen;

import internal_data.MachineMoney;
import internal_data.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class RightScreen extends JPanel {
    User user;
    MachineMoney machineMoney;
    UserInfo userInfo;
    MachineInfo machineInfo;
    Information information;

    public RightScreen(User user,UserInfo userInfo,MachineMoney machineMoney, MachineInfo machineInfo, Information information, MachineScreen machineScreen)
    {
        super();
        this.setBackground(Color.WHITE);
        this.user = user;
        this.machineMoney = machineMoney;
        this.userInfo = userInfo;
        this.machineInfo = machineInfo;
        this.information = information;

        PayChoice payChoice=new PayChoice(user, userInfo,machineMoney, machineInfo,machineScreen);
        machineScreen.setPayChoice(payChoice);
        EnterAdmin enterAdmin = new EnterAdmin(machineScreen,payChoice,machineMoney,userInfo,machineInfo);

        enterAdmin.setMaximumSize(enterAdmin.getPreferredSize());

        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int remainingHeight = getHeight() - enterAdmin.getPreferredSize().height;
                int height = remainingHeight / 2;
                userInfo.setMaximumSize(new Dimension(Integer.MAX_VALUE, height));
                payChoice.setMaximumSize(new Dimension(Integer.MAX_VALUE, height));
            }
        });

        this.add(enterAdmin.getEnterAdmin());
        this.add(information.getPanel());
        this.add(payChoice.buttonName());
        this.add(payChoice.getPayChoice());
        this.revalidate();
        this.repaint();
    }

    public JPanel getPanel()
    {
        return this;
    }
    }

