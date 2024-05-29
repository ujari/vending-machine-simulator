package internal_data;

import javax.swing.*;

public class ReturnChange {

    MachineMoney machineMoney;
    User user;

    public ReturnChange(MachineMoney machineMoney,User user)
    {
        this.machineMoney = machineMoney;
        this.user = user;
    }

    public void change(int change) {
        if(change<=0)
        {
            JOptionPane.showMessageDialog(null, "반환할 금액이 없습니다.");

            return;
        }
        while (change > 0) {
            int index = 0;
            switch (chargeIndex(change)) {
                case 0:
                    index=compareMoney(change,0);
                    break;
                case 1:
                    index=compareMoney(change, 1);
                    break;
                case 2:
                    index=compareMoney(change, 2);
                    break;
                case 3:
                    index=compareMoney(change, 3);
                    break;
                case 4:
                    index=compareMoney(change, 4);
                    break;

            }

            switch (index) {
                case 0:
                    if (machineMoney.oneThousandWon > 0) {
                        machineMoney.oneThousandWon--;
                        user.increaseOneThousandWon(1);
                        change -= 1000;
                    }
                    break;
                case 1:
                    if(machineMoney.fiveHundredWon>0)
                    {
                        machineMoney.fiveHundredWon--;

                        user.increaseFiveHundredWon(1);
                        change-=500;
                    }
                    break;
                case 2:
                    if(machineMoney.oneHundredWon>0)
                    {
                        machineMoney.oneHundredWon--;
                        user.increaseOneHundredWon(1);
                        change-=100;
                    }
                    break;
                case 3:
                    if(machineMoney.fiftyWon>0)
                    {
                        machineMoney.fiftyWon--;
                        user.increaseFiftyWon(1);
                        change-=50;
                    }
                    break;
                case 4:
                    if(machineMoney.tenWon>0) {
                        machineMoney.tenWon--;

                        user.increaseTenWon(1);
                        change -= 10;
                    }
                    break;
            }

        }
    }

    public int compareMoney(int charge,int index)
    {
        //machineMoney에서 가장 많은 지폐를 반환
        int max[] = {machineMoney.oneThousandWon, machineMoney.fiveHundredWon, machineMoney.oneHundredWon, machineMoney.fiftyWon, machineMoney.tenWon};
        int maxIndex = index;

        if(index!=4) {
            for (int i = index; i < 5; i++) {
                if (max[maxIndex] <= max[i]) {
                    maxIndex=i;
                }
            }
        }
        else
        {
            maxIndex=4;
        }
        return maxIndex;

    }

    public int chargeIndex(int charge)
    {
        if(charge>=1000)
        {
            return 0;
        }
        else if(charge>=500)
        {
            return 1;
        }
        else if(charge>=100)
        {
            return 2;
        }
        else if(charge>=50)
        {
            return 3;
        }
        else
        {
            return 4;
        }
    }
}
