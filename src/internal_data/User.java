package internal_data;

public class User {
    private int oneThousandWon;
    private int fiveHundredWon;
    private int oneHundredWon;
    private int fiftyWon;
    private int tenWon;
    public int TotalMoney;

    public User() {
        this.oneThousandWon =100;
        this.fiveHundredWon = 100;
        this.oneHundredWon = 100;
        this.fiftyWon = 100;
        this.tenWon = 100;

    }

    public void resetMoney() {
        this.oneThousandWon = oneThousandWon;
        this.fiveHundredWon = 100;
        this.oneHundredWon = 100;
        this.fiftyWon = 100;
        this.tenWon = 100;
    }


    ///////////////////////////돈 감소 함수///////////////////////////
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

    ///////////////////////////돈 증가 함수///////////////////////////
    public void increaseOneThousandWon(int n) {
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


    ////////////////돈 반환 함수/////////////////////
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

    public int getTotalMoney() {
        this.TotalMoney = this.oneThousandWon * 1000 + this.fiveHundredWon * 500 + this.oneHundredWon * 100 + this.fiftyWon * 50 + this.tenWon * 10;
        return this.TotalMoney;
    }

}