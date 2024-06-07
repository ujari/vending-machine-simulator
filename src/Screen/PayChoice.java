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
    
    // 사용자가 지불할 금액을 선택하는 화면을 생성
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

    // 지불 버튼을 생성하는 메소드
    public void PayButton(boolean admin)
    {
        removeAll();
        // 지불 버튼을 생성
        int[] moneyValues = {1000, 500, 100, 50, 10};
        for(int i=0;i<5;i++){
        PayBtn[i]=new JButton(String.valueOf(moneyValues[i]));
        }
        
        
        for(int i=0 ;i<5;i++) {
            PayBtn[i].setMaximumSize(new Dimension(Integer.MAX_VALUE, PayBtn[i].getPreferredSize().height));

            int finalI = i;
            PayBtn[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    
                    // 사용자가 선택한 금액을 지불하고, 사용자의 돈을 감소시키고, 자판기의 돈을 증가시킴
                    switch (moneyValues[finalI]) {
                        case 1000:
                            // 사용자의 돈을 감소시키고, 자판기의 돈을 증가시킴
                            user.decreaseOneThousandWon(1);
                            machineMoney.increaseOneThousandWon(1);
                            machineMoney.increaseTempOneThousandWon(1);
                            machineMoney.increaseTotalTempMoney(1000);
                            break;
                        case 500:
                            // 사용자의 돈을 감소시키고, 자판기의 돈을 증가시킴
                            user.decreaseFiveHundredWon(1);
                            machineMoney.increaseFiveHundredWon(1);
                            machineMoney.increaseTempFiveHundredWon(1);
                            machineMoney.increaseTotalTempMoney(500);
                            break;
                        case 100:
                            // 사용자의 돈을 감소시키고, 자판기의 돈을 증가시킴
                            user.decreaseOneHundredWon(1);
                            machineMoney.increaseOneHundredWon(1);
                            machineMoney.increaseTempOneHundredWon(1);
                            machineMoney.increaseTotalTempMoney(100);
                            break;
                        case 50:
                            // 사용자의 돈을 감소시키고, 자판기의 돈을 증가시킴
                            user.decreaseFiftyWon(1);
                            machineMoney.increaseFiftyWon(1);
                            machineMoney.increaseTempFiftyWon(1);
                            machineMoney.increaseTotalTempMoney(50);
                            break;
                        case 10:
                            // 사용자의 돈을 감소시키고, 자판기의 돈을 증가시킴
                            user.decreaseTenWon(1);
                            machineMoney.increaseTenWon(1);
                            machineMoney.increaseTempTenWon(1);
                            machineMoney.increaseTotalTempMoney(10);
                            break;
                    }
                    // 사용자의 돈과 자판기의 돈을 화면에 표시
                    userInfo.displayUserMoney(); 
                    machineInfo.displayMachineMoney();

                    // 사용자가 소지한 금액이 0원이 되면 해당 금액의 버튼 비활성화
                    if (user.getOneThousandWon() == 0 && moneyValues[finalI] == 1000 ||
                            user.getFiveHundredWon() == 0 && moneyValues[finalI] == 500 ||
                            user.getOneHundredWon() == 0 && moneyValues[finalI] == 100 ||
                            user.getFiftyWon() == 0 && moneyValues[finalI] == 50 ||
                            user.getTenWon() == 0 && moneyValues[finalI] == 10) {
                        PayBtn[finalI].setEnabled(false);
                    }

                    // 7000원 이상일 시 버튼 비활성화
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

                    //1000원 입력이 5000원 이상일 시 버튼 비활성화
                    if(machineMoney.TempTotalMoney+moneyValues[0]>5000)
                    {
                        PayBtn[0].setEnabled(false);

                    }
                    else {
                        machineScreen.SelectButton(false);
                    }

                }
            });

            // 버튼을 누르지 않는 경우에도 7000원 이상일 시 버튼 비활성화
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

            // 버튼을 누르지 않는 경우에도 5000원 이상일 시 버튼 비활성화
            if(machineMoney.TempTotalMoney+moneyValues[0]>5000)
            {
                PayBtn[0].setEnabled(false);

            }
            else {
                machineScreen.SelectButton(false);
            }

            //관리자 모드에 진입 된 상태인 경우 비활성화
            if(admin)
            {
                for(int j=0;j<5;j++)
                {
                    PayBtn[j].setEnabled(false);
                }
                return;
            }
            // 버튼을 추가
            this.add(PayBtn[i]);
        }
        
        // 소지한 금액을 초기화하는 버튼을 생성
        JButton ResetBtn = new JButton("소지한 금액 초기화");
        ResetBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                user.resetMoney();
                userInfo.displayUserMoney();
                PayButton(false);
            }
        });
        // 버튼을 추가
        ResetBtn.setMaximumSize(new Dimension(Integer.MAX_VALUE, ResetBtn.getPreferredSize().height));
        this.add(ResetBtn);

    }
    
    // 안내 문구를 생성하는 메소드
    public JLabel buttonName()
    {
        JLabel label = new JLabel("<html>---------------------------------------<br/>클릭하여 지불할 금액을 선택<br/><html/>");
        label.setFont(new Font("Dialog", Font.PLAIN,20));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);

        return label;
    }

    // 지불 버튼을 반환하는 메소드
    JPanel getPayChoice()
    {
        return this;
    }
}