import java.net.*;
import java.io.*;
import java.util.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.time.Duration;
import request.*;

//final VAL=Duration.ofSeconds(10);  //validity of coupon


public class Server {
    public static void main(String args[]) throws Exception {
    /*    User A = new User();
        User B=new User();
        HashMap<String,User> map=new HashMap<String,User>();
        map.put("A",A);
        map.put("B",B);*/

        ServerSocket ss = new ServerSocket(4445);
        while (true) {
        Socket s = ss.accept();
        System.out.println("Connection Established");
  			ServerThread st = new ServerThread(s);
  			st.start();}
        }}

class ServerThread extends Thread {
    	String line = null;
      BufferedReader is = null;
      PrintWriter os = null;
      Socket s = null;
      Credit c = null;

      public ServerThread(Socket s) {
        		this.s = s;
        	}

      public void run() {
        int closeServer = 1;
        try{ InputStream o = s.getInputStream();
             ObjectInput s1 = new ObjectInputStream(o);
             String str= (String) s1.readObject();
             while(closeServer != 0) {
             c = (Credit) s1.readObject();
             System.out.println(str);
             System.out.println(c.name+" "+c.amt);

             Scanner input = new Scanner(System.in);
             DataOutputStream dout = new DataOutputStream(s.getOutputStream());

             System.out.println("Close the admin? (y/n)");
             String yn = input.next();
             if (yn.equals("y") || yn.equals("Y")) {
                 closeServer = 0;
                 s1.close();
                 dout.writeInt(0);
             }
             else
               dout.writeInt(1);
           }}
        catch (Exception e) {
           System.out.println(e.getMessage());
           System.out.println("Error ");
           System.exit(1);  }
     }
   }


/*
        DataInputStream din = new DataInputStream(s.getInputStream());
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());

        int closeServer = 1;
        while(closeServer != 0) {
            String name = (String) din.readUTF();

            int amt = (int) din.readInt();
            String addingCoupon = map.get(name).addCoupon(amt);
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
}*/
