package detail_frame;

import Screen.MachineScreen;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class ItemAndMoneyManagement extends JFrame {
    MachineScreen machineScreen;

    public ItemAndMoneyManagement(MachineScreen machineScreen) {
        //판매 물품 관리 창 생성
        this.machineScreen = machineScreen;
        this.setTitle("판매 물품 관리");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocation(500, 200);
        this.setSize(450, 600);
        //사이즈 변경 불가
        this.setResizable(false);
        this.setLayout(new BorderLayout());
        //상단바
        topBar();
        //물품 변경
        changeItem();
        this.setVisible(true);
    }

    //상단바
    void topBar() {
        JPanel topBar = new JPanel();
        topBar.setPreferredSize(new Dimension(800, 50));
        JLabel label = new JLabel("판매 물품 관리");
        label.setFont(new Font("Serif", Font.BOLD, 30));
        topBar.add(label);
        topBar.setBackground(Color.white);
        this.add(topBar, BorderLayout.NORTH);
    }

    //물품 변경
    public void changeItem() {
        JPanel changeItem = new JPanel();
        changeItem.setLayout(new FlowLayout());
        //////////////물품 이름 변경//////////////
        JLabel label1 = new JLabel("물품 이름 변경");
        label1.setFont(new Font("Serif", Font.BOLD, 20));
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        label1.setForeground(Color.red);
        changeItem.add(label1);
        //몇번째 물품인지 선택
        JLabel label2 = new JLabel("물품 선택 :");
        label2.setFont(new Font("Serif", Font.BOLD, 10));
        label2.setHorizontalAlignment(SwingConstants.CENTER);
        changeItem.add(label2);
        //콤보박스
        JComboBox<String> comboBox = new JComboBox<>();
        comboBox.addItem("1");
        comboBox.addItem("2");
        comboBox.addItem("3");
        comboBox.addItem("4");
        comboBox.addItem("5");
        comboBox.addItem("6");
        label2.setLabelFor(comboBox);
        changeItem.add(comboBox);

        //새로운 이름 입력
        JTextField textField1 = new JTextField(8);
        textField1.setHorizontalAlignment(SwingConstants.CENTER);
        //필드박스에
        textField1.setToolTipText("물품 이름 입력");
        changeItem.add(textField1);
        //변경 버튼
        JButton button1 = new JButton("변경");
        button1.setPreferredSize(new Dimension(350, 30));
        changeItem.add(button1);
        button1.addActionListener(e -> {
            //아무 입력도 없으면 입력 되지 않았다는 팝업
            if (textField1.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "입력되지 않았습니다.");
                return;
            }
            machineScreen.setBeveragesName(Integer.parseInt((String) Objects.requireNonNull(comboBox.getSelectedItem()))-1, textField1.getText());
            JOptionPane.showMessageDialog(null, "변경이 완료되었습니다.");
        });

        //////////////물품 이름 변경//////////////
        JLabel label3 = new JLabel("물품 가격 변경");
        label3.setFont(new Font("Serif", Font.BOLD, 20));
        label3.setHorizontalAlignment(SwingConstants.CENTER);
        label3.setForeground(Color.red);
        changeItem.add(label3);
        //몇번째 물품인지 선택
        JLabel label4 = new JLabel("물품 선택 :");
        label4.setFont(new Font("Serif", Font.BOLD, 10));
        label4.setHorizontalAlignment(SwingConstants.CENTER);
        changeItem.add(label4);
        //콤보박스
        JComboBox<String> comboBox2 = new JComboBox<>();
        comboBox2.addItem("1");
        comboBox2.addItem("2");
        comboBox2.addItem("3");
        comboBox2.addItem("4");
        comboBox2.addItem("5");
        comboBox2.addItem("6");
        label4.setLabelFor(comboBox2);
        changeItem.add(comboBox2);
        //새로운 가격 입력
        JTextField textField2 = new JTextField(8);
        textField2.setHorizontalAlignment(SwingConstants.CENTER);
        textField2.setToolTipText("물품 가격 입력");
        changeItem.add(textField2);
        //변경 버튼
        JButton button2 = new JButton("변경");
        button2.setPreferredSize(new Dimension(350, 30));
        changeItem.add(button2);
        button2.addActionListener(e -> {
            //아무 입력도 없으면 입력 되지 않았다는 팝업
            if (textField2.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "입력되지 않았습니다.");
                return;
            }
            //숫자가 아닐 시 다시 입력하라는 팝업
            try {
                Integer.parseInt(textField2.getText());
            } catch (NumberFormatException ex) {
                //숫자가 아닐 시 다시 입력하라는 팝업
                JOptionPane.showMessageDialog(null, "숫자를 입력해주세요.");
                return;
            }
            //0보다 작을경우
            if (Integer.parseInt(textField2.getText()) < 0) {
                JOptionPane.showMessageDialog(null, "0보다 작은 수는 입력할 수 없습니다.");
                return;
            }
            machineScreen.setBeveragesPrice(Integer.parseInt((String) Objects.requireNonNull(comboBox2.getSelectedItem()))-1, Integer.parseInt(textField2.getText()));
            JOptionPane.showMessageDialog(null, "변경이 완료되었습니다.");
        });

        //////////////물품 수량 변경//////////////
        JLabel label5 = new JLabel("물품 수량 변경");
        label5.setFont(new Font("Serif", Font.BOLD, 20));
        label5.setHorizontalAlignment(SwingConstants.CENTER);
        label5.setForeground(Color.red);
        changeItem.add(label5);
        //몇번째 물품인지 선택
        JLabel label6 = new JLabel("물품 선택 :");
        label6.setFont(new Font("Serif", Font.BOLD, 10));
        label6.setHorizontalAlignment(SwingConstants.CENTER);
        changeItem.add(label6);
        //콤보박스
        JComboBox<String> comboBox3 = new JComboBox<>();
        comboBox3.addItem("1");
        comboBox3.addItem("2");
        comboBox3.addItem("3");
        comboBox3.addItem("4");
        comboBox3.addItem("5");
        comboBox3.addItem("6");
        label6.setLabelFor(comboBox3);
        changeItem.add(comboBox3);
        //새로운 수량 입력
        JTextField textField3 = new JTextField(8);
        textField3.setHorizontalAlignment(SwingConstants.CENTER);
        textField3.setToolTipText("물품 수량 입력");
        changeItem.add(textField3);
        //물품 감소 버튼
        JButton button3 = new JButton("-");
        button3.setPreferredSize(new Dimension(350, 30));
        changeItem.add(button3);
        button3.addActionListener(e -> {
            //아무 입력도 없으면 입력 되지 않았다는 팝업
            if (textField3.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "입력되지 않았습니다.");
                return;
            }
            //숫자가 아닐 시 다시 입력하라는 팝업
            try {
                Integer.parseInt(textField3.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "숫자를 입력해주세요.");
                return;
            }
            //0보다 작을경우
            if (Integer.parseInt(textField3.getText()) < 0) {
                JOptionPane.showMessageDialog(null, "0보다 작은 수는 입력할 수 없습니다.");
                return;
            }
            machineScreen.setBeveragesStock(Integer.parseInt((String) Objects.requireNonNull(comboBox3.getSelectedItem()))-1, Integer.parseInt(textField3.getText()),'-');
            JOptionPane.showMessageDialog(null, "변경이 완료되었습니다.");
        });
        //물품 증가 버튼
        JButton button5 = new JButton("+");
        button5.setPreferredSize(new Dimension(350, 30));
        changeItem.add(button5);
        button5.addActionListener(e -> {
            //아무 입력도 없으면 입력 되지 않았다는 팝업
            if (textField3.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "입력되지 않았습니다.");
                return;
            }
            //숫자가 아닐 시 다시 입력하라는 팝업
            try {
                Integer.parseInt(textField3.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "숫자를 입력해주세요.");
                return;
            }
            //0보다 작을경우
            if (Integer.parseInt(textField3.getText()) < 0) {
                JOptionPane.showMessageDialog(null, "0보다 작은 수는 입력할 수 없습니다.");
                return;
            }
            machineScreen.setBeveragesStock(Integer.parseInt((String) Objects.requireNonNull(comboBox3.getSelectedItem()))-1, Integer.parseInt(textField3.getText()),'+');
            JOptionPane.showMessageDialog(null, "변경이 완료되었습니다.");
        });
        //////////////물품 사진 변경//////////////
        JLabel label7 = new JLabel("물품 사진 변경");
        label7.setFont(new Font("Serif", Font.BOLD, 20));
        label7.setHorizontalAlignment(SwingConstants.CENTER);
        label7.setForeground(Color.red);
        changeItem.add(label7);
        //몇번째 물품인지 선택
        JLabel label8 = new JLabel("물품 선택 :");
        label8.setFont(new Font("Serif", Font.BOLD, 10));
        label8.setHorizontalAlignment(SwingConstants.CENTER);
        changeItem.add(label8);
        //콤보박스
        JComboBox<String> comboBox4 = new JComboBox<>();
        comboBox4.addItem("1");
        comboBox4.addItem("2");
        comboBox4.addItem("3");
        comboBox4.addItem("4");
        comboBox4.addItem("5");
        comboBox4.addItem("6");
        label8.setLabelFor(comboBox4);
        changeItem.add(comboBox4);
        //새로운 사진 입력
        JTextField textField4 = new JTextField(30);
        textField4.setHorizontalAlignment(SwingConstants.CENTER);
        textField4.setToolTipText("물품 사진 주소 입력");
        changeItem.add(textField4);
        //변경 버튼
        JButton button4 = new JButton("변경");
        button4.setPreferredSize(new Dimension(350, 30));
        changeItem.add(button4);
        //변경 버튼 누를 시
        button4.addActionListener(e -> {
            //아무 입력도 없으면 입력 되지 않았다는 팝업
            if (textField4.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "입력되지 않았습니다.");
                return;
            }
            machineScreen.PhotoAd[Integer.parseInt((String) Objects.requireNonNull(comboBox4.getSelectedItem()))-1] = textField4.getText();
            JOptionPane.showMessageDialog(null, "변경이 완료되었습니다.");
        });

        /////////////소지금 변경//////////////
        JLabel label9 = new JLabel("화폐 변경");
        label9.setFont(new Font("Serif", Font.BOLD, 20));
        label9.setHorizontalAlignment(SwingConstants.CENTER);
        label9.setForeground(Color.red);
        changeItem.add(label9);
        //화폐 단위 선택
        JLabel label10 = new JLabel("화폐 단위 선택 :");
        label10.setFont(new Font("Serif", Font.BOLD, 10));
        label10.setHorizontalAlignment(SwingConstants.CENTER);
        changeItem.add(label10);
        textField4.setHorizontalAlignment(SwingConstants.CENTER);

        //화폐를 지정하는 드롭박스
        JComboBox<String> comboBox5 = new JComboBox<>();
        comboBox5.addItem("10");
        comboBox5.addItem("50");
        comboBox5.addItem("100");
        comboBox5.addItem("500");
        comboBox5.addItem("1000");
        changeItem.add(comboBox5);
        //몇 개를 증감할지 입력하는 필드
        JTextField textField6 = new JTextField(30);
        textField6.setHorizontalAlignment(SwingConstants.CENTER);
        textField6.setToolTipText("증감할 화폐 개수 입력");
        changeItem.add(textField6);

        //증감을 지정하는 드롭박스
        JComboBox<String> comboBox6 = new JComboBox<>();
        comboBox6.addItem("+");
        comboBox6.addItem("-");
        changeItem.add(comboBox6);


        //변경 버튼
        JButton button6 = new JButton("변경");
        button6.setPreferredSize(new Dimension(350, 30));
        changeItem.add(button6);
        //변경 버튼 누를 시
        button6.addActionListener(e -> {
            //아무 입력도 없으면 입력 되지 않았다는 팝업
            if ( textField6.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "입력되지 않았습니다.");
                return;
            }
            //숫자가 아닐 시 다시 입력하라는 팝업
            try {
                Integer.parseInt(textField6.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "숫자를 입력해주세요.");
                return;
            }
            //0보다 작을경우
            if (Integer.parseInt(textField6.getText()) < 0) {
                JOptionPane.showMessageDialog(null, "0보다 작은 수는 입력할 수 없습니다.");
                return;
            }
            //화폐를 변경
            switch (Integer.parseInt((String) Objects.requireNonNull(comboBox5.getSelectedItem())))
            {
                case 10:
                    if(comboBox6.getSelectedItem().equals("+"))
                    {
                        machineScreen.machineMoney.increaseTenWon(Integer.parseInt(textField6.getText()));
                    }
                    else
                    {
                        machineScreen.machineMoney.decreaseTenWon(Integer.parseInt(textField6.getText()));
                    }
                    break;
                case 50:
                    if(comboBox6.getSelectedItem().equals("+"))
                    {
                        machineScreen.machineMoney.increaseFiftyWon(Integer.parseInt(textField6.getText()));
                    }
                    else
                    {
                        machineScreen.machineMoney.decreaseFiftyWon(Integer.parseInt(textField6.getText()));
                    }
                    break;
                case 100:
                    if(comboBox6.getSelectedItem().equals("+"))
                    {
                        machineScreen.machineMoney.increaseOneHundredWon(Integer.parseInt(textField6.getText()));
                    }
                    else
                    {
                        machineScreen.machineMoney.decreaseOneHundredWon(Integer.parseInt(textField6.getText()));
                    }
                    break;
                case 500:
                    if(comboBox6.getSelectedItem().equals("+"))
                    {
                        machineScreen.machineMoney.increaseFiveHundredWon(Integer.parseInt(textField6.getText()));
                    }
                    else
                    {
                        machineScreen.machineMoney.decreaseFiveHundredWon(Integer.parseInt(textField6.getText()));
                    }
                    break;
                case 1000:
                    if(comboBox6.getSelectedItem().equals("+"))
                    {
                        machineScreen.machineMoney.increaseOneThousandWon(Integer.parseInt(textField6.getText()));
                    }
                    else
                    {
                        machineScreen.machineMoney.decreaseOneThousandWon(Integer.parseInt(textField6.getText()));
                    }
                    break;
            }
            JOptionPane.showMessageDialog(null, "변경이 완료되었습니다.");

        });

        this.add(changeItem, BorderLayout.CENTER);

    }

}
