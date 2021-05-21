import java.net.*;
import java.io.*;
import java.util.Queue;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.time.Duration;

/*HashMap<String,User> map=new HashMap<String,Queue>();*/

//final VAL=Duration.ofSeconds(10);  //validity of coupon


public class Server {
    public static void main(String args[]) throws Exception {
        User A = new User();
        User B=new User();
        map.put("A",A);
        map.put("B",B);

        ServerSocket ss = new ServerSocket(3333);
        Socket s = ss.accept();
        DataInputStream din = new DataInputStream(s.getInputStream());
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());

        int closeServer = 1;
        while(closeServer != 0) {
            String name = (String) din.readUTF();
            int amt = (int) din.readInt();
            String addingCoupon = A.addCoupon(amt);
            System.out.println("UserName " + name+" credited with amount "+amt+" succesfully.");
            dout.writeUTF(addingCoupon);
            dout.flush();

            Scanner input = new Scanner(System.in);

            System.out.println("Close the admin? (y/n)");
            String yn = input.next();
            if (yn.equals("y") || yn.equals("Y")) {
                closeServer = 0;
                dout.writeInt(0);
            }
            else
              dout.writeInt(1);
        }


        din.close();
        s.close();
        ss.close();
    }
}
