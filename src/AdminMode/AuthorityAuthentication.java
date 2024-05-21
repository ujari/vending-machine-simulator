package AdminMode;

import javax.swing.*;
import java.awt.*;

public class AuthorityAuthentication extends JFrame {
    public AuthorityAuthentication() {
        super();
        this.setLayout(new GridLayout(0, 1));
        JLabel label = new JLabel("비밀번호를 입력하세요");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(label);
        JPasswordField passwordField = new JPasswordField();
        passwordField.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(passwordField);
        JButton button = new JButton("확인");
        button.setPreferredSize(new Dimension(350, 30));
        //비밀 번호가 맞으면 adminModeScreen을 생성
        button.addActionListener(e -> {
            //엔터키도 입력가능

            if (String.valueOf(passwordField.getPassword()).equals("1234")) {
                new AdminModeScreen();
                //프레임종료
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "비밀번호가 틀렸습니다.");
            }
        });
        this.add(button);
        this.setSize(400, 200);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

}
