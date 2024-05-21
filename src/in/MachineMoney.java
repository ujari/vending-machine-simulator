package in;

public class MachineMoney {
    private int oneThousandWon;
    private int fiveHundredWon;
    private int oneHundredWon;
    private int fiftyWon;
    private int tenWon;
    public int tempOneThousandWon;
    public int tempFiveHundredWon;
    public int tempOneHundredWon;
    public int tempFiftyWon;
    public int tempTenWon;

    public MachineMoney() {
        this.oneThousandWon =10;
        this.fiveHundredWon = 10;
        this.oneHundredWon =10;
        this.fiftyWon = 10;
        this.tenWon = 10;

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



    public int tempTotalMoney() {
       int total = (tempOneThousandWon * 1000) + (tempFiveHundredWon * 500) + (tempOneHundredWon * 100) + (tempFiftyWon * 50) + (tempTenWon * 10);
       return total;
    }


    public int getOneThousandWon() {
        return oneThousandWon;
    }

    public int getFiveHundredWon() {
        return fiveHundredWon;
    }

    public int getOneHundredWon() {
        return oneHundredWon;
    }

    public int getFiftyWon() {
        return fiftyWon;
    }

    public int getTenWon() {
        return tenWon;
    }

}
