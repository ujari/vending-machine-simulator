package Screen;

import in.Beverage;
import in.MachineMoney;
import in.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MachineScreen extends JPanel {
    Beverage[] beverages = new Beverage[6];
    User user;
    MachineMoney machineMoney;
    UserInfo userInfo;
    MachineInfo machineInfo;
    Information information;
    public  MachineScreen(User user, UserInfo userInfo, MachineMoney machineMoney, MachineInfo machineInfo, Information information) {
        super();
        this.user = user;
        this.machineMoney = machineMoney;
        this.userInfo = userInfo;
        this.machineInfo = machineInfo;
        this.information = information;

        this.setSize(350, 600);
        JLabel lb1 = new JLabel();
        lb1.setBounds(0,0,350,600);
        ImageIcon icon = new ImageIcon("imgs/main.jpg");
        this.setLayout(null);
        lb1.setIcon(icon);
        Beverage[] beverages = InitBeverage();
        BeverageName(beverages);
        SelectButton();
        ReturnButton();
        this.add(lb1);
    }

  public void SelectButton()
  {
    JButton btn[]=new JButton[6];
    int x=33;
    for (int i = 0; i < 4; i++) {
        btn[i]=new JButton();
        btn[i].setBounds(x,132,55,16);
        x+=72;
    }
    btn[4]=new JButton();
    btn[5]=new JButton();
    btn[4].setBounds(34, 252, 55, 16);
    btn[5].setBounds(104, 252, 55, 16);



    for (int i= 0; i <6 ; i++) {
     this.add(btn[i]);
    }
    }

    public void BeverageName(Beverage[] beverage)
    {
        JLabel label[]=new JLabel[6];
        int x=28;
        for(int i=0;i<4;i++)
        {
            label[i]=new JLabel(beverage[i].name);
            label[i].setBounds(x,114,50,15);
            label[i].setBackground(Color.red); // 배경색을 파란색으로 변경
            label[i].setForeground(Color.black);
            label[i].setHorizontalAlignment(SwingConstants.CENTER);
            x+=76;

        }
        label[4]=new JLabel(beverage[4].name);
        label[5]=new JLabel(beverage[5].name);
        label[4].setBounds(39, 234, 50, 15);
        label[5].setBounds(109, 234, 50, 15);
        label[4].setBackground(Color.red); // 배경색을 파란색으로 변경
        label[5].setBackground(Color.red); // 배경색을 파란색으로 변경
        label[4].setForeground(Color.black);
        label[5].setForeground(Color.black);

        for (int i= 0; i <6 ; i++) {
            label[i].setFont(new Font("Serif", Font.BOLD, 9));
            this.add(label[i]);
        }
    }


    public Beverage[] InitBeverage()
    {
        Beverage[] beverages = new Beverage[6];
        beverages[0]=new Beverage("물",450,10,1);
        beverages[1]=new Beverage("커피",500,10,2);
        beverages[2]=new Beverage("이온음료",550,10,3);
        beverages[3]=new Beverage("고급커피",700,10,4);
        beverages[4]=new Beverage("탄산음료",750,10,5);
        beverages[5]=new Beverage("특화음료",800,10,6);

        return beverages;
    }

public void ReturnButton()
{
    JButton btn = new JButton();
    btn.setBounds(245, 315, 35, 30);
    btn.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            user.increaseOneThousandWon(machineMoney.tempOneThousandWon);
            user.increaseFiveHundredWon(machineMoney.tempFiveHundredWon);
            user.increaseOneHundredWon(machineMoney.tempOneHundredWon);
            user.increaseFiftyWon(machineMoney.tempFiftyWon);
            user.increaseTenWon(machineMoney.tempTenWon);
            machineMoney.decreaseOneThousandWon(machineMoney.tempOneThousandWon);
            machineMoney.decreaseFiveHundredWon(machineMoney.tempFiveHundredWon);
            machineMoney.decreaseOneHundredWon(machineMoney.tempOneHundredWon);
            machineMoney.decreaseFiftyWon(machineMoney.tempFiftyWon);
            machineMoney.decreaseTenWon(machineMoney.tempTenWon);
            machineMoney.resetTempMoney();
            userInfo.displayUserMoney(); // Existing line
            machineInfo.displayMachineMoney(); // Add this line
        }
    });
    btn.setOpaque(false);
    btn.setContentAreaFilled(false);
    btn.setBorderPainted(false);
    this.add(btn);
}
    public JPanel getMachineScreen()
    {
        return this;
    }
}
