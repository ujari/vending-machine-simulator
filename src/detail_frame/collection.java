package detail_frame;

import internal_data.MachineMoney;

import javax.swing.*;
import java.awt.*;

public class collection extends JFrame {
    MachineMoney machineMoney;
    public collection(MachineMoney machineMoney) {
        this.machineMoney = machineMoney;
        this.setTitle("수금");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocation(500, 200);
        this.setSize(300, 400);
        this.setLayout(new BorderLayout(50,50));
        topBar();
        Collection(machineMoney,machineMoney.CollectMoneyShow());
        this.setVisible(true);
    }

    void topBar() {
        JPanel topBar = new JPanel();
        topBar.setPreferredSize(new Dimension(500, 50));
        JLabel label = new JLabel("수금 가능한 돈 : "+ machineMoney.CollectMoneyShow());
        label.setFont(new Font("Serif", Font.BOLD, 25));
        label.setForeground(Color.white);
        topBar.add(label);
        topBar.setBackground(Color.GRAY);
        this.add(topBar, BorderLayout.NORTH);
    }

    void Collection(MachineMoney machineMoney,int money) {
        JButton button = new JButton("수금하기");
        button.setPreferredSize(new Dimension(350, 30));
        button.addActionListener(e -> {
            if(money==0)
            {
                JOptionPane.showMessageDialog(null, "수금할 돈이 없습니다.");
                return;
            }
            machineMoney.resetMoney();
            JOptionPane.showMessageDialog(null, money+"수금이 완료되었습니다.");
            this.dispose();
        });
        this.add(button,BorderLayout.CENTER);
    }



}
