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

    /*void useCoupon(int amt1){
        if(this.bal<amt1){
            System.Out.println("Insufficient balance to make the transaction.");
        }
        else if(this.account.peek.amt>amt1){
            this.account.peek.amt-=amt1;
            bal-=amt1;
            System.Out.print("Amount deducted successfully");
        }
        else{
            int ded=this.account.account.poll.amt;
            bal-=ded;
            this.account.usecoupon(amt1-ded);
            System.Out.print("Amount deducted successfully");
        }
    }*/
}
