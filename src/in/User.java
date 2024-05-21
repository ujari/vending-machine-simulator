package in;

import javax.swing.plaf.PanelUI;

public class User {
    private int oneThousandWon;
    private int fiveHundredWon;
    private int oneHundredWon;
    private int fiftyWon;
    private int tenWon;

    public User(int oneThousandWon, int fiveHundredWon, int oneHundredWon, int fiftyWon, int tenWon) {
        this.oneThousandWon = oneThousandWon;
        this.fiveHundredWon = fiveHundredWon;
        this.oneHundredWon = oneHundredWon;
        this.fiftyWon = fiftyWon;
        this.tenWon = tenWon;
    }

    public void resetMoney() {
        this.oneThousandWon = 10;
        this.fiveHundredWon = 10;
        this.oneHundredWon = 10;
        this.fiftyWon = 10;
        this.tenWon = 10;
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
    //증가 함수 제작예정
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