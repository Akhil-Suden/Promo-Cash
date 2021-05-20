package server;
import java.net.*;
import java.io.*;
import java.util.Queue;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.time.Duration;

/*HashMap<String,User> map=new HashMap<String,Queue>();

//final VAL=Duration.ofSeconds(10);  //validity of coupon

struct coupon{
  int amt;
  LocalDateTime born;    //time at which coupon was created
}

class User{
  int bal;   //balance
  Queue<coupon> account;

  User(){
    bal=100;
    Queue<coupon> account=new LinkedList<coupon>();
  }

  void addcoupon(int amt1){
    this.account.offer(coupon(amt,LocalDateTime.now()));
    System.Out.println("Amount added succesfully.");
  }

  void usecoupon(int amt1){
    if(this.bal<amt1){
      System.Out.println("Insufficient balance to make the transaction.");
    }
    else if(this.account.peek.amt>amt1){
       this.account.peek.amt-=amt1;
       bal-=amt1;
      System.Out.print("Amount deducted succesfully");
    }
    else{
      int ded=this.account.account.poll.amt;
      bal-=ded;
      this.account.usecoupon(amt1-ded);
      System.Out.print("Amount deducted succesfully");
        }
    }
  }  */

public class Server {
    public static void main(String args[]) throws Exception {
        User userA = new User();
/*User B=new User();
map.put("A",A);
map.put("B",B); */

        ServerSocket ss = new ServerSocket(3333);
        Socket s = ss.accept();
        DataInputStream din = new DataInputStream(s.getInputStream());
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());

        int closeServer = 1;
        while(closeServer != 0) {
            String name = (String) din.readUTF();
            System.out.println("message= " + name);
            int amt = (int) din.readInt();
            System.out.println("message= " + amt);
            String addingCoupon = userA.addCoupon(amt);
            dout.writeUTF(addingCoupon);
            dout.flush();

            Scanner input = new Scanner(System.in);


            System.out.println("Close the admin? (y/n)");
            String yn = input.next();
            if (yn.equals("y") || yn.equals("Y")) {
                closeServer = 0;
            }
        }


        din.close();
        s.close();
        ss.close();
    }
}
