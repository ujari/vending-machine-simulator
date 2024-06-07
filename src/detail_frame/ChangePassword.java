package detail_frame;

import AdminMode.AdminModeScreen;
import AdminMode.AuthorityAuthentication;
import Screen.EnterAdmin;

import javax.swing.*;
import java.awt.*;

public class ChangePassword extends JFrame {
    public ChangePassword(EnterAdmin enterAdmin) {
        //비밀번호 변경 창 생성
        this.setTitle("비밀번호 변경");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocation(500, 200);
        this.setSize(300, 400);
        this.setLayout(new BorderLayout());
        topBar();//상단바
        Change(enterAdmin);//비밀번호 변경
        this.setVisible(true);
    }
    
    //상단바
    void topBar() {
        JPanel topBar = new JPanel();
        //비밀번호 변경 창임을 알려주는 레이블
        topBar.setPreferredSize(new Dimension(500, 50));
        JLabel label = new JLabel("비밀번호 변경");
        label.setFont(new Font("Serif", Font.BOLD, 30));
        topBar.setBackground(Color.white);
        this.add(topBar, BorderLayout.NORTH);
        topBar.add(label);
    }

    //비밀번호 변경
    void Change(EnterAdmin au)
    {
        JPanel Change = new JPanel();
        Change.setLayout(new GridLayout(0, 1, 0, 10));

        //현재 비밀번호 입력
        JLabel label1 = new JLabel("현재 비밀번호를 입력하세요");
        label1.setFont(new Font("Serif", Font.BOLD, 20));
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        Change.add(label1);
        
        //현재 비밀번호를 입력받는 패스워드 필드
        JPasswordField passwordField1 = new JPasswordField();
        passwordField1.setHorizontalAlignment(SwingConstants.CENTER);
        Change.add(passwordField1);
        
        //변경할 비밀번호 입력
        JLabel label2 = new JLabel("변경할 비밀번호를 입력하세요");
        label2.setFont(new Font("Serif", Font.BOLD, 20));
        label2.setHorizontalAlignment(SwingConstants.CENTER);
        Change.add(label2);
        
        //변경할 비밀번호를 입력받는 패스워드 필드
        JPasswordField passwordField2 = new JPasswordField();
        passwordField2.setHorizontalAlignment(SwingConstants.CENTER);
        Change.add(passwordField2);
        
        //확인 버튼
        JButton button = new JButton("확인");
        button.setPreferredSize(new Dimension(350, 30));

        //버튼이 엔터키로 입력될 경우
        passwordField2.addActionListener(e -> {
            if (String.valueOf(passwordField1.getPassword()).equals(au.getPassword()) && Judge(String.valueOf(passwordField2.getPassword()))) {
                //현재 비밀번호를 정확히 입력하고, 변경 비밀번호가 조건에 부합한다면
                au.setPassword(String.valueOf(passwordField2.getPassword()));//비밀번호 변경
                JOptionPane.showMessageDialog(null, "비밀번호가 변경되었습니다.");
                this.dispose();
            } else {
                //현재 비밀번호가 틀리거나, 비밀번호가 조건에 맞지 않는 경우
                JOptionPane.showMessageDialog(null, "비밀번호가 틀렸습니다.");
            }
        });


        //버튼을 누를 경우
        button.addActionListener(e -> {
            if (String.valueOf(passwordField1.getPassword()).equals(au.getPassword()) && Judge(String.valueOf(passwordField2.getPassword()))) {
                //현재 비밀번호를 정확히 입력하고, 변경 비밀번호가 조건에 부합한다면
                au.setPassword(String.valueOf(passwordField2.getPassword()));//비밀번호 변경
                JOptionPane.showMessageDialog(null, "비밀번호가 변경되었습니다.");
                this.dispose();
            } else {
                //현재 비밀번호가 틀리거나, 비밀번호가 조건에 맞지 않는 경우
                JOptionPane.showMessageDialog(null, "비밀번호가 틀렸습니다.");
            }
        });

        Change.add(button);
        this.add(Change);
    }

    //비밀번호 변경 조건 확인 함수
    boolean Judge( String will)
    {
        boolean result = false;

        //8자리 이상이고 특수기호가 포함되어 있으면 result를 true로 변경
        if(will.length()>=8)//길이 판단
        {
            for(int i=0;i<will.length();i++)
            {
                //특수기호 판단
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


