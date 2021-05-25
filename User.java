import java.util.Deque;
import java.util.LinkedList;

public class User {
    int bal =0;     //balance
    Deque<Coupon> account =new LinkedList<>();

    String addCoupon(int amt){
        bal= bal + amt;
        Coupon c = new Coupon(amt);
        account.add(c);
        return "Amount added successfully & total balance is : " + bal ;
    }

    void useCoupon(int amt){
        if(this.bal<amt){
            System.out.println("Insufficient balance to make the transaction.");
        }
        else if(this.account.peek().getAmt()>amt){
            account.peek().setAmt(account.peek().getAmt()-amt);
            bal-=amt;
            System.out.println("Amount deducted successfully  " + bal);
        }
        else{
            int deduct=this.account.poll().getAmt();
            bal-=deduct;
            useCoupon(amt-deduct);
            System.out.println("Amount deducted successfully  " + bal);
        }
    }
}
