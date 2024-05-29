package detail_frame;

import Screen.MachineScreen;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class ItemManagement extends JFrame {
    MachineScreen machineScreen;

    public ItemManagement(MachineScreen machineScreen) {
        this.machineScreen = machineScreen;
        this.setTitle("판매 물품 관리");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocation(500, 200);
        this.setSize(500, 300);
        this.setLayout(new BorderLayout());
        topBar();
        changeItem();
        this.setVisible(true);
    }

    void topBar() {
        JPanel topBar = new JPanel();
        topBar.setPreferredSize(new Dimension(800, 50));
        JLabel label = new JLabel("판매 물품 관리");
        label.setFont(new Font("Serif", Font.BOLD, 30));
        topBar.add(label);
        topBar.setBackground(Color.white);
        this.add(topBar, BorderLayout.NORTH);
    }




    public void changeItem() {
       JPanel changeItem = new JPanel();
        changeItem.setLayout(new FlowLayout());
         JLabel label1 = new JLabel("물품 이름 변경");
            label1.setFont(new Font("Serif", Font.BOLD, 20));
            label1.setHorizontalAlignment(SwingConstants.CENTER);
            label1.setForeground(Color.red);
            changeItem.add(label1);
            //몇번째 물품인지 선택
            JLabel label2 = new JLabel("물품 선택");
            label2.setFont(new Font("Serif", Font.BOLD, 20));
            label2.setHorizontalAlignment(SwingConstants.CENTER);
            changeItem.add(label2);
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
            //필드박스에 예시
            changeItem.add(textField1);
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


            JLabel label3 = new JLabel("물품 가격 변경");
            label3.setFont(new Font("Serif", Font.BOLD, 20));
            label3.setHorizontalAlignment(SwingConstants.CENTER);
            label3.setForeground(Color.red);
            changeItem.add(label3);
            //몇번째 물품인지 선택
            JLabel label4 = new JLabel("물품 선택");
            label4.setFont(new Font("Serif", Font.BOLD, 20));
            label4.setHorizontalAlignment(SwingConstants.CENTER);
            changeItem.add(label4);
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
            //필드박스에 예
            textField2.setHorizontalAlignment(SwingConstants.CENTER);
            changeItem.add(textField2);
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

            JLabel label5 = new JLabel("물품 수량 변경");
            label5.setFont(new Font("Serif", Font.BOLD, 20));
            label5.setHorizontalAlignment(SwingConstants.CENTER);
            label5.setForeground(Color.red);
            changeItem.add(label5);
            //몇번째 물품인지 선택
            JLabel label6 = new JLabel("물품 선택");
            label6.setFont(new Font("Serif", Font.BOLD, 20));
            label6.setHorizontalAlignment(SwingConstants.CENTER);
            changeItem.add(label6);
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
            changeItem.add(textField3);
            JButton button3 = new JButton("변경");
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

                machineScreen.setBeveragesStock(Integer.parseInt((String) Objects.requireNonNull(comboBox3.getSelectedItem()))-1, Integer.parseInt(textField3.getText()));
                JOptionPane.showMessageDialog(null, "변경이 완료되었습니다.");

            });

            this.add(changeItem, BorderLayout.CENTER);


    }

}
