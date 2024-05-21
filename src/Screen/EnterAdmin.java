package Screen;

import javax.swing.*;
import java.awt.*;

public class EnterAdmin extends JPanel{
    public EnterAdmin()
    {
        super();
        JButton button=new JButton("관리자모드 진입");
        button.setPreferredSize(new Dimension(350, 30));
        this.add(button);
        button.addActionListener(e -> {
            new AdminMode.AuthorityAuthentication();
        });
    }

    public JPanel getEnterAdmin() {
        return this;
    }
}