package Screen;

import internal_data.Beverage;
import internal_data.MachineMoney;
import internal_data.ReturnChange;
import internal_data.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;


public class MachineScreen extends JPanel {

    public PayChoice payChoice;
    public Beverage[] beverages = new Beverage[6];
    public JButton btn[]=new JButton[6];
    private int totalSales = 0;
    public String PhotoAd[]={"imgs/생수.PNG","imgs/커피.PNG","imgs/이온음료.PNG","imgs/고급커피.PNG","imgs/탄산음료.PNG","imgs/특화음료.PNG"};

    public MachineMoney machineMoney;
    UserInfo userInfo;
    User user;
    MachineInfo machineInfo;
    Information information;
    ReturnChange returnChange;
    BeveragePhoto beveragePhoto[];

    //자판기를 사용자에게 보여주는 객체를 생성
    public MachineScreen (User user, UserInfo userInfo, MachineMoney machineMoney, MachineInfo machineInfo, Information information) {

        super();
        this.user = user;
        this.machineMoney = machineMoney;
        this.userInfo = userInfo;
        this.machineInfo = machineInfo;
        this.information = information;
        this.returnChange = new ReturnChange(machineMoney,user);
        this.beveragePhoto=new BeveragePhoto[6];

        this.setSize(350, 600);
        ImageIcon icon = new ImageIcon("imgs/main.jpg");
        this.setLayout(null);

        //음료 초기화
        beverages = InitBeverage();
        //음료 라벨
        MenuLabel(beverages);
        ReturnButton();
        SelectButton(false);
        BeverageName(beverages);
        PhotoScreen();

    }

    // PayChoice 클래스의 인스턴스를 설정하는 메소드
    public void setPayChoice(PayChoice payChoice)
    {
        this.payChoice = payChoice;
    }

    //프레임의 사진을 자판기 형태로 지정
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        ImageIcon icon = new ImageIcon("imgs/main.jpg");
        g.drawImage(icon.getImage(), 0, 0, null);
    }

    //음료 선택 버튼
    public void SelectButton(boolean admin)
    {

        //음료 버튼을 초기화 하기위해 지움
        if(btn[0]!=null)
        {
            for(int i=0;i<6;i++) {
                remove(btn[i]);
            }
        }

        this.setLayout(null);
        int x=33;

        //////////사용자가 입력한 금액이나 음료의 제고가 충분하지 않은 경우 버튼 비활성화 //////////
        for (int i = 0; i < 4; i++) {
            btn[i]=new JButton();
            btn[i].setBounds(x,132,55,16);
            x+=72;

            if (machineMoney.TempTotalMoney >= beverages[i].price&&beverages[i].stock>0) {
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

        if (machineMoney.TempTotalMoney >= beverages[4].price&&beverages[4].stock>0) {
            btn[4].setEnabled(true);
            btn[4].setBackground(Color.green);
        } else {
            btn[4].setEnabled(false);
            btn[4].setBackground(Color.red);
        }

        if (machineMoney.TempTotalMoney>= beverages[5].price&&beverages[5].stock>0) {
            btn[5].setEnabled(true);
            btn[5].setBackground(Color.green);
        } else {
            btn[5].setEnabled(false);
            btn[5].setBackground(Color.red);
        }
        ////////////////////////////////////////////////////////////////////////////////

        //버튼 ADD
        for (int i = 0; i < 6; i++) {
            this.add(btn[i]);
        }

        ////////////////////버튼이 클릭 되었을 때 음료 반환과 소지금 관리
        for(int i=0;i<6;i++) {
            final int finalI = i;
            btn[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    machineMoney.check = true;//돈을 넣었을 때 check를 true로 변경
                    machineMoney.decreaseTotalTempMoney(beverages[finalI].price);//temp머니를 전부 자판기에게 증가
                    beverages[finalI].stock--;//해당 버튼의 음료 제고 감소
                    machineInfo.displayMachineMoney();//기기 돈 정보를 다시 보여줌
                    userInfo.displayUserMoney();//사용자 돈 정보를 다시 보여줌

                    //판매 내역 파일에 쓰기위해 정보를 저장
                    beverages[finalI].salesCount++;
                    totalSales += beverages[finalI].price;

                    //판매 내역 파일에 쓰기
                    try {
                        FileWriter fileWriter = new FileWriter("purchase_history.txt", true);
                        PrintWriter printWriter = new PrintWriter(fileWriter);
                        printWriter.println("-----------------------------");
                        printWriter.println("Purchased item: " + beverages[finalI].name);
                        printWriter.println("Price: " + beverages[finalI].price);
                        printWriter.println("Purchase time: " + LocalDateTime.now());
                        printWriter.println("-----------------------------");
                        printWriter.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }

                    //total 파일 만들어 작성
                    try {
                        FileWriter fileWriter = new FileWriter("total.txt");
                        PrintWriter printWriter = new PrintWriter(fileWriter);
                        printWriter.println("Total sales: " + totalSales);
                        for (Beverage beverage : beverages) {
                            printWriter.println("Sales count of " + beverage.name + ": " + beverage.salesCount);
                        }
                        printWriter.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }

                    //해당 물품을 구매하였다는 팝업창
                    JOptionPane.showMessageDialog(null, beverages[finalI].name + "을 구매하였습니다.");
                    SelectButton(false);
                    payChoice.PayButton(false);
                    repaint();
                }

            });

            //만약 관리자 모드가 설정 되어있다면 버튼 비활성화ㅣ
            if (admin) {
                for (int j = 0; j < 6; j++) {
                    btn[j].setEnabled(false);
                    btn[j].setBackground(Color.green);
                }

                return;
            }

        }
        this.revalidate();
        this.repaint();
    }

    //음료 이름 라벨
    public void BeverageName(Beverage[] beverage)
    {
        JLabel label[]=new JLabel[6];
        int x=28;
        ////////////////버튼 속성 설정///////////////
        for(int i=0;i<4;i++)
        {
            label[i]=new JLabel(beverage[i].name);//음료 이름
            label[i].setBounds(x,114,50,15);
            label[i].setBackground(Color.red); // 배경색을 파란색으로 변경
            label[i].setForeground(Color.black);
            label[i].setHorizontalAlignment(SwingConstants.CENTER);
            x+=76;

        }
        label[4]=new JLabel(beverage[4].name);//음료 이름
        label[5]=new JLabel(beverage[5].name);//음료 이름
        label[4].setBounds(39, 234, 50, 15);
        label[5].setBounds(109, 234, 50, 15);
        label[4].setBackground(Color.red); // 배경색을 파란색으로 변경
        label[5].setBackground(Color.red); // 배경색을 파란색으로 변경
        label[4].setForeground(Color.black);
        label[5].setForeground(Color.black);

        //라벨 ADD
        for (int i= 0; i <6 ; i++) {
            label[i].setFont(new Font("Serif", Font.BOLD, 9));
            this.add(label[i]);
        }
    }

    //음료 초기화
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


    //돈 반환 버튼
    public void ReturnButton()
    {
        JButton btn = new JButton();
        btn.setBounds(245, 315, 35, 30);

        //돈 반환 버튼을 눌렀을 때의 동작
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (machineMoney.TempTotalMoney == 0) {//돈을 넣지 않았을 때 반환 버튼을 누르면 반환할 금액이 없다는 팝업창
                    JOptionPane.showMessageDialog(null, "반환할 금액이 없습니다.");
                    return;
                }

                // machineMoney.check(음료를 구매하지 않은 상태)가 false일 때, 사용자의 돈을 증가시키고 기계의 돈을 감소시킨다.
                if(!machineMoney.check) {
                    /////////////////투입한 금액 그대로 반환////////////////
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
                    machineMoney.decreaseTotalTempMoney(machineMoney.TempTotalMoney);
                    /////////////////////////////////////////////////////////////////

                    // 사용자의 돈을 반환하고 기계의 돈을 초기화한다.
                    JOptionPane.showMessageDialog(null, machineMoney.TempTotalMoney + "원이 반환되었습니다.");
                    machineMoney.resetTempMoney();
                    //사용자 돈과 기기 돈 정보를 다시 보여줌
                    userInfo.displayUserMoney();
                    machineInfo.displayMachineMoney();
                    SelectButton(false);
                }
                else {
                    // machineMoney.check가 true일 때, 사용자의 돈을 반환하고 기계의 돈을 초기화한다.
                    returnChange.change(machineMoney.TempTotalMoney);
                    JOptionPane.showMessageDialog(null, machineMoney.TempTotalMoney + "원이 반환되었습니다.");
                    machineMoney.resetTempMoney();
                    machineMoney.TempTotalMoney=0;
                    //사용자 돈과 기기 돈 정보를 다시 보여줌
                    userInfo.displayUserMoney();
                    machineInfo.displayMachineMoney();
                    SelectButton(false);


                }
                payChoice.PayButton(false);
            }
        });
        //버튼 속성 설정
        btn.setOpaque(false);
        btn.setContentAreaFilled(false);
        btn.setBorderPainted(false);
        this.add(btn);
    }

    //음료에 대한 정보를 라벨로 출력
    public void MenuLabel(Beverage[] beverages) {
        removeAll();

        JLabel[] labels = new JLabel[beverages.length];
        int y = 315;
        int height = 20;

        //라벨이 음료의 이름 , 가격을 나타냄
        for (int i = 0; i < beverages.length; i++) {
            String beverageInfo =  beverages[i].name+"       "  +
                    "Price: " + beverages[i].price + "원";
            labels[i] = new JLabel(beverageInfo);
            labels[i].setFont(new Font("Serif", Font.BOLD, 11));
            labels[i].setBounds(23, y, 500, height);
            y += height;
            this.add(labels[i]);
        }

        this.revalidate();
        this.repaint();

    }


    //음료 사진을 출력
    public void PhotoScreen()
    {
        //음료 사진을 초기화 하기위해 지움
        if(beveragePhoto[0]!=null)
        {
            for(int i=0;i<6;i++) {
                remove(beveragePhoto[i]);
            }
        }

        ////////음료 사진 출력////////////
        for (int i=0;i<4;i++)
        {
            beveragePhoto[i]=new BeveragePhoto(PhotoAd[i]);
            beveragePhoto[i].setBounds(28+i*76, 40, 60, 60);
            this.add(beveragePhoto[i]);
        }
        for (int i=4;i<6;i++)
        {
            beveragePhoto[i]=new BeveragePhoto(PhotoAd[i]);
            beveragePhoto[i].setBounds(34+(i-4)*70, 160, 60, 60);
            this.add(beveragePhoto[i]);
        }
        //////////////////////////////////////////
    }


    public JPanel getMachineScreen()
    {
        return this;
    }

    ///////////////////음료의 이름, 가격, 재고설정////////////////////////
    public void setBeveragesName(int index, String name) {
        this.beverages[index].name = name;
    }

    public void setBeveragesPrice(int index, int money) {
        this.beverages[index].price = money;
    }

    public void setBeveragesStock(int index, int stock,char mode) {
        if(mode=='-')
            this.beverages[index].stock -= stock;
        else {
            this.beverages[index].stock += stock;
        }
    }

}
