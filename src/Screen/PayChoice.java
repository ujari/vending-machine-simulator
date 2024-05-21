package Screen;

import in.MachineMoney;
import in.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PayChoice extends JPanel {
    private User user;
    private MachineMoney machineMoney;
    private UserInfo userInfo;
    private MachineInfo machineInfo;

    public PayChoice(User user, UserInfo userInfo, MachineMoney machineMoney, MachineInfo machineInfo)
    {
        super();
        this.user = user;
        this.machineMoney = machineMoney;
        this.setPreferredSize(new Dimension(350, 300));
        this.userInfo = userInfo;
        this.machineInfo = machineInfo;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        PayButton();
    }

    public void PayButton()
    {
        JButton PayBtn[]=new JButton[5];
        int[] moneyValues = {1000, 500, 100, 50, 10};

        for(int i=0 ;i<5;i++) {
            PayBtn[i]=new JButton(String.valueOf(moneyValues[i]));
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
                            break;
                        case 500:
                            user.decreaseFiveHundredWon(1);
                            machineMoney.increaseFiveHundredWon(1);
                            machineMoney.increaseTempFiveHundredWon(1);
                            break;
                        case 100:
                            user.decreaseOneHundredWon(1);
                            machineMoney.increaseOneHundredWon(1);
                            machineMoney.increaseTempOneHundredWon(1);
                            break;
                        case 50:
                            user.decreaseFiftyWon(1);
                            machineMoney.increaseFiftyWon(1);
                            machineMoney.increaseTempFiftyWon(1);
                            break;
                        case 10:
                            user.decreaseTenWon(1);
                            machineMoney.increaseTenWon(1);
                            machineMoney.increaseTempTenWon(1);
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



                }
            });
            this.add(PayBtn[i]);
        }
        JButton ResetBtn = new JButton("소지한 금액 초기화");
        ResetBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                user.resetMoney();
                userInfo.displayUserMoney();
                for (int i = 0; i < 5; i++) {
                    PayBtn[i].setEnabled(true);
                }
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

    JPanel getPayChoice()
    {
        return this;
    }
}