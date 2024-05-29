package Screen;


import internal_data.MachineMoney;
import internal_data.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PayChoice extends JPanel {
    private User user;
    private MachineMoney machineMoney;
    private UserInfo userInfo;
    private MachineInfo machineInfo;
    private MachineScreen machineScreen;
    public JButton PayBtn[]=new JButton[5];
    public PayChoice(User user, UserInfo userInfo, MachineMoney machineMoney, MachineInfo machineInfo,MachineScreen machineScreen)
    {
        super();
        this.user = user;
        this.machineMoney = machineMoney;
        this.machineScreen = machineScreen;
        this.setPreferredSize(new Dimension(350, 300));
        this.userInfo = userInfo;
        this.machineInfo = machineInfo;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        PayButton(false);
        this.setBackground(Color.WHITE);

    }

    public void PayButton(boolean admin)
    {
        removeAll();
        int[] moneyValues = {1000, 500, 100, 50, 10};
        for(int i=0;i<5;i++){
        PayBtn[i]=new JButton(String.valueOf(moneyValues[i]));
        }




        for (int j = 0; j < 5; j++) {
            if(machineMoney.TempTotalMoney+moneyValues[j]>7000)
            {
                PayBtn[j].setEnabled(false);
            }
            else
            {
                PayBtn[j].setEnabled(true);
            }
        }

        for(int i=0 ;i<5;i++) {
            PayBtn[i].setMaximumSize(new Dimension(Integer.MAX_VALUE, PayBtn[i].getPreferredSize().height));

            int finalI = i;
            PayBtn[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    // Decrease the user's money according to the button pressed
                    switch (moneyValues[finalI]) {
                        case 1000:
                            user.decreaseOneThousandWon(1);
                            machineMoney.increaseOneThousandWon(1);
                            machineMoney.increaseTempOneThousandWon(1);
                            machineMoney.increaseTempMoney(1000);
                            break;
                        case 500:
                            user.decreaseFiveHundredWon(1);
                            machineMoney.increaseFiveHundredWon(1);
                            machineMoney.increaseTempFiveHundredWon(1);
                            machineMoney.increaseTempMoney(500);
                            break;
                        case 100:
                            user.decreaseOneHundredWon(1);
                            machineMoney.increaseOneHundredWon(1);
                            machineMoney.increaseTempOneHundredWon(1);
                            machineMoney.increaseTempMoney(100);
                            break;
                        case 50:
                            user.decreaseFiftyWon(1);
                            machineMoney.increaseFiftyWon(1);
                            machineMoney.increaseTempFiftyWon(1);
                            machineMoney.increaseTempMoney(50);
                            break;
                        case 10:
                            user.decreaseTenWon(1);
                            machineMoney.increaseTenWon(1);
                            machineMoney.increaseTempTenWon(1);
                            machineMoney.increaseTempMoney(10);
                            break;
                    }
                    // Update the user's money display
                    userInfo.displayUserMoney(); // Existing line
                    machineInfo.displayMachineMoney(); // Add this line

                    // Disable the button if the user's money of this denomination is 0
                    if (user.getOneThousandWon() == 0 && moneyValues[finalI] == 1000 ||
                            user.getFiveHundredWon() == 0 && moneyValues[finalI] == 500 ||
                            user.getOneHundredWon() == 0 && moneyValues[finalI] == 100 ||
                            user.getFiftyWon() == 0 && moneyValues[finalI] == 50 ||
                            user.getTenWon() == 0 && moneyValues[finalI] == 10) {
                        PayBtn[finalI].setEnabled(false);
                    }

                    if(machineMoney.tempOneThousandWon>=5)
                    {
                        PayBtn[0].setEnabled(false);
                    }
                    else
                    {
                        PayBtn[0].setEnabled(true);
                    }
                    for (int j = 1; j < 5; j++) {
                        if(machineMoney.TempTotalMoney+moneyValues[j]>7000)
                        {
                            PayBtn[j].setEnabled(false);
                        }
                        else
                        {
                            PayBtn[j].setEnabled(true);
                        }
                    }
                    machineScreen.SelectButton(false);


                }
            });
            if(admin)
            {
                for(int j=0;j<5;j++)
                {
                    PayBtn[j].setEnabled(false);
                }
                return;
            }
            this.add(PayBtn[i]);
        }
        JButton ResetBtn = new JButton("소지한 금액 초기화");
        ResetBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                user.resetMoney();
                userInfo.displayUserMoney();
                PayButton(false);
            }
        });
        ResetBtn.setMaximumSize(new Dimension(Integer.MAX_VALUE, ResetBtn.getPreferredSize().height));
        this.add(ResetBtn);

    }



    public JLabel buttonName()
    {
        JLabel label = new JLabel("<html>---------------------------------------<br/>클릭하여 지불할 금액을 선택<br/><html/>");
        label.setFont(new Font("Dialog", Font.PLAIN,20));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);

        return label;
    }

    public void buttonPause()
    {
        for(int i=0;i<5;i++)
        {
            PayBtn[i].setEnabled(false);
        }
    }


    JPanel getPayChoice()
    {
        return this;
    }
}