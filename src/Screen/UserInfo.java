package Screen;
import in.User;
import javax.swing.*;
import java.awt.*;

public class UserInfo extends JPanel {
    private  User user;

    public UserInfo(User user)
    {
        super();
        this.user = user;
        displayUserMoney();
    }

public void displayUserMoney() {
    SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
            // Update UI components here
            removeAll(); // Remove the old label
            JLabel label = new JLabel();
            String moneyInfo = "<html>&nbsp&nbsp&nbsp&nbsp&nbsp가진 돈 <br/><br/>1000&nbsp&nbsp원&nbsp&nbsp: " + user.getOneThousandWon() + "<br/>" +
                               "500&nbsp&nbsp&nbsp&nbsp원&nbsp&nbsp: "+ user.getFiveHundredWon() + "<br/>" +
                               "100&nbsp&nbsp&nbsp&nbsp원&nbsp&nbsp: " + user.getOneHundredWon() + "<br/>" +
                               "50&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp원&nbsp&nbsp: " + user.getFiftyWon() + "<br/>" +
                               "10&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp원&nbsp&nbsp: " + user.getTenWon() + "<br/><br/>"+"총 금액&nbsp&nbsp&nbsp&nbsp: "+totalMoney()+"</html>";
            label.setText(moneyInfo);
            label.setFont(new Font("Dialog", Font.PLAIN, 15)); // Set the font size to 20
            add(label);
            revalidate(); // Re-layout the components
            repaint(); // Refresh the display
        }
    });
}

    public int totalMoney()
    {
        int totalMoney = user.getOneThousandWon() * 1000 + user.getFiveHundredWon() * 500 + user.getOneHundredWon() * 100 + user.getFiftyWon() * 50 + user.getTenWon() * 10;
        return totalMoney;
    }

    public JPanel getUserInformationScreen()
    {
        return this;
    }
}