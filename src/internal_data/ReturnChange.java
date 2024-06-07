package internal_data;

import javax.swing.*;

public class ReturnChange {

    MachineMoney machineMoney;
    User user;

    //반환할 돈을 받아오는 생성자
    public ReturnChange(MachineMoney machineMoney,User user)
    {
        this.machineMoney = machineMoney;
        this.user = user;
    }

    //반환할 돈을 반환
    public void change(int change) {
        if(change<=0)//반환할 금액이 없을 경우
        {
            JOptionPane.showMessageDialog(null, "반환할 금액이 없습니다.");

            return;
        }

        //반환할 금액이 있을 경우
        while (change > 0) {//반환할 금액이 0이 될 때까지

            int index = 0;
            switch (chargeIndex(change)) {//반환할 금액이 어떤 지폐로 반환될지 결정
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

            //반환할 금액에서 지폐를 빼고 사용자에게 지폐를 주는 코드
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


    //반환할 금액이 어떤 지폐로 반환될지 결정
    public int compareMoney(int charge,int index)
    {
        //machineMoney에서 가장 많은 지폐를 반환
        int max[] = {machineMoney.oneThousandWon, machineMoney.fiveHundredWon, machineMoney.oneHundredWon, machineMoney.fiftyWon, machineMoney.tenWon};
        int maxIndex = index;

        //index가 4일 경우 10원을 반환
        if(index!=4) {
            for (int i = index; i < 5; i++) {
                if (max[maxIndex] <= max[i]) {//maxIndex에 가장 많은 지폐의 인덱스를 저장
                    maxIndex=i;//maxIndex에 가장 많은 지폐의 인덱스를 저장
                }
            }
        }
        else
        {
            maxIndex=4;
        }
        return maxIndex;

    }

    //반환할 금액에 대한 인덱스 번호를 반환
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
