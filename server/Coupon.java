package server;

import java.time.LocalDateTime;
import java.util.Queue;

public class Coupon {
    int amt;
    LocalDateTime born;

    Coupon(int amt,LocalDateTime born){
        this.amt = amt;
        this.born= born;
    }

    @Override
    public String toString() {
        return "(" + amt + ", " + born + ")";
    }
}
