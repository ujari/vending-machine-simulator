package Screen;

import internal_data.MachineMoney;

import javax.swing.*;
import java.awt.*;

public class MachineInfo extends JPanel {
    private MachineMoney machineMoney;

    //자판기 정보 생성
    public MachineInfo(MachineMoney machineMoney)
    {
        super();
        this.machineMoney = machineMoney;
        displayMachineMoney();
        this.setBackground(Color.WHITE);
    }

    //자판기 의 금액 정보를 화면에 출력
    public void displayMachineMoney() {
        this.removeAll(); // Remove the old label
        JLabel label = new JLabel();
        String moneyInfo = "<html>&nbsp&nbsp&nbsp자판기 보유 금액 <br/><br/>1000&nbsp&nbsp원&nbsp&nbsp: " + machineMoney.oneThousandWon+ "<br/>" +
                "500&nbsp&nbsp&nbsp&nbsp원&nbsp&nbsp: "+ machineMoney.fiveHundredWon + "<br/>" +
                "100&nbsp&nbsp&nbsp&nbsp원&nbsp&nbsp: " + machineMoney.oneHundredWon + "<br/>" +
                "50&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp원&nbsp&nbsp: " + machineMoney.fiftyWon + "<br/>" +
                "10&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp원&nbsp&nbsp: " + machineMoney.tenWon + "<br/><br/>"+"총 금액&nbsp&nbsp&nbsp&nbsp: "+totalMoney()+"<br/>투입한 금액&nbsp&nbsp&nbsp&nbsp: "+machineMoney.TempTotalMoney+"</html>";
        label.setText(moneyInfo);
        label.setFont(new Font("Dialog", Font.PLAIN, 15)); // Set the font size to 20
        this.add(label);
        this.revalidate();
        this.repaint();
    }

    //자판기의 총 금액을 반환
    public int totalMoney()
    {
        int totalMoney = machineMoney.oneThousandWon * 1000 + machineMoney.fiveHundredWon * 500 + machineMoney.oneHundredWon * 100 + machineMoney.fiftyWon * 50 + machineMoney.tenWon * 10;
        return totalMoney;
    }

    public JPanel getMachineInformationScreen()
    {
        return this;
    }
}

