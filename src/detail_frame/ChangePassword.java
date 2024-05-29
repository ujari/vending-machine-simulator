package detail_frame;

import AdminMode.AdminModeScreen;
import AdminMode.AuthorityAuthentication;
import Screen.EnterAdmin;

import javax.swing.*;
import java.awt.*;

public class ChangePassword extends JFrame {
    public ChangePassword(EnterAdmin enterAdmin) {
        this.setTitle("비밀번호 변경");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocation(500, 200);
        this.setSize(300, 400);
        this.setLayout(new BorderLayout());
        topBar();
        Change(enterAdmin);
        this.setVisible(true);
    }

    void topBar() {
        JPanel topBar = new JPanel();
        topBar.setPreferredSize(new Dimension(500, 50));
        JLabel label = new JLabel("비밀번호 변경");
        label.setFont(new Font("Serif", Font.BOLD, 30));
        topBar.add(label);
        topBar.setBackground(Color.white);
        this.add(topBar, BorderLayout.NORTH);
    }

    void Change(EnterAdmin au)
    {
        JPanel Change = new JPanel();
        Change.setLayout(new GridLayout(0, 1, 0, 10));

        JLabel label1 = new JLabel("현재 비밀번호를 입력하세요");
        label1.setFont(new Font("Serif", Font.BOLD, 20));
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        Change.add(label1);
        JPasswordField passwordField1 = new JPasswordField();
        passwordField1.setHorizontalAlignment(SwingConstants.CENTER);
        Change.add(passwordField1);
        JLabel label2 = new JLabel("변경할 비밀번호를 입력하세요");
        label2.setFont(new Font("Serif", Font.BOLD, 20));
        label2.setHorizontalAlignment(SwingConstants.CENTER);
        Change.add(label2);
        JPasswordField passwordField2 = new JPasswordField();
        passwordField2.setHorizontalAlignment(SwingConstants.CENTER);
        Change.add(passwordField2);
        JButton button = new JButton("확인");
        button.setPreferredSize(new Dimension(350, 30));

        button.addActionListener(e -> {
            //엔터키도 입력가능
            if (String.valueOf(passwordField1.getPassword()).equals(au.getPassword()) && Judge(String.valueOf(passwordField2.getPassword()))) {
                au.setPassword(String.valueOf(passwordField2.getPassword()));
                JOptionPane.showMessageDialog(null, "비밀번호가 변경되었습니다.");
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "비밀번호가 틀렸습니다.");
            }
        });
        Change.add(button);
        this.add(Change);
    }

  boolean Judge( String will)
{
    boolean result = false;

    //8자리 이상이고 특수기호가 포함되어 있으면 result를 true로 변경
    if(will.length()>=8)
    {
        for(int i=0;i<will.length();i++)
        {
            if(will.charAt(i)=='!'||will.charAt(i)=='@'||will.charAt(i)=='#'||will.charAt(i)=='$'||will.charAt(i)=='%'||will.charAt(i)=='^'||will.charAt(i)=='&'||will.charAt(i)=='*')
            {
                result=true;
                break;
            }
        }
    }
    else
    {
        result=false;
    }



    return result;
}


}


