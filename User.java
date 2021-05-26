import java.util.Deque;
import java.util.LinkedList;

public class User {
    int bal =0;     //balance
    Deque<Coupon> account =new LinkedList<>();

    boolean addCoupon(int amt){
        bal= bal + amt;
        Coupon c = new Coupon(amt);
        account.add(c);
        return true;
    }

    boolean useCoupon(int amt){
        if(this.bal<amt){
           return false;
    //        System.out.println("Insufficient balance to make the transaction.");
        }
        else if(this.account.peek().getAmt()>amt){
            account.peek().setAmt(account.peek().getAmt()-amt);
            bal-=amt;
            return true;
      //      System.out.println(d.name +" debited with amount= " + d.amt);
      //      System.out.println(c.name+"'s balance = "+map.get(name).bal);
        }
        else{
            int deduct=this.account.poll().getAmt();
            bal-=deduct;
            useCoupon(amt-deduct);
            return true;
        }
    }


}
