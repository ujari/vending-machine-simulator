package internal_data;

public class MachineMoney {
    public int oneThousandWon;
    public int fiveHundredWon;
    public int oneHundredWon;
    public int fiftyWon;
    public int tenWon;
    public int tempOneThousandWon;
    public int tempFiveHundredWon;
    public int tempOneHundredWon;
    public int tempFiftyWon;
    public int tempTenWon;
    public int TempTotalMoney;
    public boolean check;//음료를 구매한 상태인지 확인


    public MachineMoney() {
        this.oneThousandWon =10;
        this.fiveHundredWon = 10;
        this.oneHundredWon =10;
        this.fiftyWon = 10;
        this.tenWon = 10;
        this.check = false;
    }

    public void increaseOneThousandWon(int n)
    {
        for (int i = 0; i < n; i++) {
            this.oneThousandWon++;
        }

    }

    public void increaseFiveHundredWon(int n) {
        for (int i = 0; i < n; i++) {

            this.fiveHundredWon++;

        }
    }

    public void increaseOneHundredWon(int n) {
        for (int i = 0; i < n; i++) {
            this.oneHundredWon++;
        }
    }

    public void increaseFiftyWon(int n) {
        for (int i = 0; i < n; i++) {
            this.fiftyWon++;
        }
    }

    public void increaseTenWon(int n) {
        for (int i = 0; i < n; i++) {
            this.tenWon++;
        }
    }

    public void increaseTempOneThousandWon(int n) {
        for (int i = 0; i < n; i++) {
            this.tempOneThousandWon++;
        }
    }

    public void increaseTempFiveHundredWon(int n) {
        for (int i = 0; i < n; i++) {
            this.tempFiveHundredWon++;
        }
    }

    public void increaseTempOneHundredWon(int n) {
        for (int i = 0; i < n; i++) {
            this.tempOneHundredWon++;
        }
    }

    public void increaseTempFiftyWon(int n) {
        for (int i = 0; i < n; i++) {
            this.tempFiftyWon++;
        }
    }

    public void increaseTempTenWon(int n) {
        for (int i = 0; i < n; i++) {
            this.tempTenWon++;
        }
    }

    public void decreaseOneThousandWon(int n) {
        for (int i = 0; i < n; i++) {
            if (this.oneThousandWon > 0) {
                this.oneThousandWon--;
            }
        }
    }

    public void decreaseFiveHundredWon(int n) {
        for (int i = 0; i < n; i++) {
            if (this.fiveHundredWon > 0) {
                this.fiveHundredWon--;
            }
        }
    }

    public void decreaseOneHundredWon(int n) {
        for (int i = 0; i < n; i++) {
            if (this.oneHundredWon > 0) {
                this.oneHundredWon--;
            }
        }
    }

    public void decreaseFiftyWon(int n) {
        for (int i = 0; i < n; i++) {
            if (this.fiftyWon > 0) {
                this.fiftyWon--;
            }
        }
    }

    public void decreaseTenWon(int n) {
        for (int i = 0; i < n; i++) {
            if (this.tenWon > 0) {
                this.tenWon--;
            }
        }
    }


    public void resetTempMoney() {
        this.tempOneThousandWon = 0;
        this.tempFiveHundredWon = 0;
        this.tempOneHundredWon = 0;
        this.tempFiftyWon = 0;
        this.tempTenWon = 0;
    }



    public void decreaseTotalTempMoney(int price) {

        TempTotalMoney -=price;
    }

    public void increaseTotalTempMoney(int price) {
        TempTotalMoney += price;
    }

    public int CollectMoneyShow() {
        return (oneThousandWon-10)*1000+ (fiveHundredWon-10)*500 + (oneHundredWon-10)*100 + (fiftyWon-10)*50 + (tenWon-10)*10;
    }


    public void resetMoney() {
        this.oneThousandWon = 10;
        this.fiveHundredWon = 10;
        this.oneHundredWon = 10;
        this.fiftyWon = 10;
        this.tenWon = 10;
    }
}
