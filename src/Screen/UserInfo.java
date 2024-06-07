package Screen;
import internal_data.User;
import javax.swing.*;
import java.awt.*;

public class UserInfo extends JPanel {
    private  User user;

    public UserInfo(User user)
    {
        super();
        this.setBackground(Color.WHITE);
        this.user = user;
        displayUserMoney();
    }


    // 사용자가 가진 돈을 화면에 표시하는 메소드
    public void displayUserMoney() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // 사용자가 가진 돈을 화면에 표시하는 레이블을 추가
                removeAll();
                JLabel label = new JLabel();
                String moneyInfo = "<html>&nbsp&nbsp&nbsp&nbsp&nbsp가진 돈 <br/><br/>1000&nbsp&nbsp원&nbsp&nbsp: " + user.getOneThousandWon() + "<br/>" +
                                   "500&nbsp&nbsp&nbsp&nbsp원&nbsp&nbsp: "+ user.getFiveHundredWon() + "<br/>" +
                                   "100&nbsp&nbsp&nbsp&nbsp원&nbsp&nbsp: " + user.getOneHundredWon() + "<br/>" +
                                   "50&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp원&nbsp&nbsp: " + user.getFiftyWon() + "<br/>" +
                                   "10&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp원&nbsp&nbsp: " + user.getTenWon() + "<br/><br/>"+"총 금액&nbsp&nbsp&nbsp&nbsp: "+user.getTotalMoney()+"</html>";
                label.setText(moneyInfo);
                label.setFont(new Font("Dialog", Font.PLAIN, 15)); // Set the font size to 20
                add(label);
                revalidate();
                repaint();
            }
        });
    }


        public JPanel getUserInformationScreen()
        {
            return this;
        }
}