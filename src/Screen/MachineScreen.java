package Screen;

import in.Beverage;
import in.MachineMoney;
import in.ReturnChange;
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
    JButton btn[]=new JButton[6];
    ReturnChange returnChange;

    public MachineScreen (User user, UserInfo userInfo, MachineMoney machineMoney, MachineInfo machineInfo, Information information) {
    super();
    this.user = user;
    this.machineMoney = machineMoney;
    this.userInfo = userInfo;
    this.machineInfo = machineInfo;
    this.information = information;
    this.returnChange = new ReturnChange(machineMoney,user);

    this.setSize(350, 600);
    ImageIcon icon = new ImageIcon("imgs/main.jpg");
    this.setLayout(null);
    beverages = InitBeverage(); // Initialize beverages before calling SelectButton
    BeverageName(beverages);
    JLabel[] beverageLabels = MenuLabel(beverages);
    for (JLabel label : beverageLabels) {
        this.add(label);
    }
    ReturnButton();
    SelectButton();
    // Move this line to the end

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        ImageIcon icon = new ImageIcon("imgs/main.jpg");
        g.drawImage(icon.getImage(), 0, 0, null);
    }

  public void SelectButton()
  {
      if(btn[0]!=null)
      {
          for(int i=0;i<6;i++) {
              remove(btn[i]);
          }
      }
      this.setLayout(null);
      int x=33;
      for (int i = 0; i < 4; i++) {
            btn[i]=new JButton();
            btn[i].setBounds(x,132,55,16);
            x+=72;

        // Check if the tempMachineMoney is greater than or equal to the price of the beverage
            if (machineMoney.TempTotalMoney >= beverages[i].price) {
                btn[i].setEnabled(true);
                btn[i].setBackground(Color.green);
            } else {
                btn[i].setEnabled(false);
                btn[i].setBackground(Color.red);
            }
      }
      btn[4]=new JButton();
      btn[5]=new JButton();
      btn[4].setBounds(34, 252, 55, 16);
      btn[5].setBounds(104, 252, 55, 16);


      if (machineMoney.TempTotalMoney >= beverages[4].price) {
        btn[4].setEnabled(true);
        btn[4].setBackground(Color.green);
      } else {
        btn[4].setEnabled(false);
        btn[4].setBackground(Color.red);
      }

      if (machineMoney.TempTotalMoney>= beverages[5].price) {
        btn[5].setEnabled(true);
        btn[5].setBackground(Color.green);
      } else {
        btn[5].setEnabled(false);
        btn[5].setBackground(Color.red);
      }
      for (int i = 0; i < 6; i++) {
          this.add(btn[i]);
      }

      for(int i=0;i<6;i++) {
          final int finalI = i;
          btn[i].addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                  machineMoney.check = true;
                  machineMoney.decreaseTempMoney(beverages[finalI].price);
                  machineInfo.displayMachineMoney();
                  userInfo.displayUserMoney();

                  // Update the enabled state of the buttons
                  for (int j = 0; j < 6; j++) {
                      if (machineMoney.TempTotalMoney >= beverages[j].price) {
                          btn[j].setEnabled(true);
                          btn[j].setBackground(Color.red);
                      } else {
                          btn[j].setEnabled(false);
                      }
                  }
                  SelectButton();

                  repaint();
              }
          });
      }
      this.revalidate();
      this.repaint();
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
            if (machineMoney.TempTotalMoney == 0) {
                JOptionPane.showMessageDialog(null, "반환할 금액이 없습니다.");
                return;
            }

            if(!machineMoney.check) {
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
                machineMoney.decreaseTempMoney(machineMoney.TempTotalMoney);
                machineMoney.resetTempMoney();
                userInfo.displayUserMoney(); // Existing line
                machineInfo.displayMachineMoney(); // Add this line
                SelectButton();
            }
            else {
                returnChange.change(machineMoney.TempTotalMoney);
                machineMoney.resetTempMoney();
                machineMoney.TempTotalMoney=0;
                userInfo.displayUserMoney();
                machineInfo.displayMachineMoney();
                SelectButton();

            }
        }
        });
        btn.setOpaque(false);
        btn.setContentAreaFilled(false);
        btn.setBorderPainted(false);
        this.add(btn);
    }

    public JLabel[] MenuLabel(Beverage[] beverages) {
        JLabel[] labels = new JLabel[beverages.length];
        int y = 315; // Initial y position
        int height = 20; // Height of each label

        for (int i = 0; i < beverages.length; i++) {
            String beverageInfo =  beverages[i].name+"       "  +
                              "Price: " + beverages[i].price + "원";
            labels[i] = new JLabel(beverageInfo);
            labels[i].setFont(new Font("Serif", Font.BOLD, 11));
            labels[i].setBounds(23, y, 500, height);
            y += height;
        }
            return labels;
    }

    public JPanel getMachineScreen()
    {
        return this;
    }
}
