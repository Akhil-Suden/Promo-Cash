package server;

import java.time.LocalDateTime;

public class Coupon {
    private int amt;
    private LocalDateTime born;

    Coupon(int amt){
        this.amt = amt;
        this.born= LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "(" + amt + ", " + born + ")";
    }

    public int getAmt() {
        return amt;
    }

    public void setAmt(int amt) {
        this.amt = amt;
    }

    public LocalDateTime getBorn() {
        return born;
    }

    public void setBorn(LocalDateTime born) {
        this.born = born;
    }
}
