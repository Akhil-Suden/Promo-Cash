package server;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.Queue;

public class User {
    int bal;   //balance
    Queue<Coupon> account;

    User(){
        bal=0;
        Queue<Coupon> account=new LinkedList<>();
    }

    void addCoupon(int amt1){
        bal+=amt1;
        account.add(new Coupon(amt1, LocalDateTime.now()));
        System.out.println("Amount added successfully." );
    }

    /*void usecoupon(int amt1){
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


