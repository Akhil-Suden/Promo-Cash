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
        HashMap<String,User> map=new HashMap<String,User>();

        ServerSocket ss = new ServerSocket(4445);
        while (true) {
            Socket s = ss.accept();
            System.out.println("Connection Established");
            Thread st = new ServerThread(s,map);
            st.start();
        }
    }
}

class ServerThread extends Thread {
      String line = null;
      BufferedReader is = null;
      PrintWriter os = null;
      Socket s = null;
      Request r=null;
    HashMap<String,User> map=null;

      public ServerThread(Socket s,HashMap<String, User> map) {
        		this.s = s;
        		this.map = map;
        	}

      public void run() {
          int closeServer = 1;
          //User A = new User();
          //User B = new User();
          while(closeServer != 0) {
              try {
                  InputStream o = s.getInputStream();
                  ObjectInput s1 = new ObjectInputStream(o);

                  OutputStream outputStream = s.getOutputStream();
                  ObjectOutput oo = new ObjectOutputStream(outputStream);

                  r = (Request) s1.readObject();
                  String output= new String();
                  if(r.requestType.equals("Credit")) {

                      // System.out.println(str);
                      if (!map.containsKey(r.name)) {
                          map.put(r.name, new User());
                      }
                      map.get(r.name).addCoupon(r.amt);
                      output = r.name + " credited with amount= " + r.amt + "\n" + r.name + "'s balance = " + map.get(r.name).bal;

                  }


                  else if(r.requestType.equals("Debit")){

                 //  System.out.println(str);
                      if (!map.containsKey(r.name)) {
                          output = "User doesn't exist. Contact Admin";
                      }
                      else{
                      if(map.get(r.name).useCoupon(r.amt)){
                          output = r.name +" debited with amount= " + r.amt + "\n" + r.name+"'s balance = "+map.get(r.name).bal;
                      }
                      else
                          output = "Insufficient balance to make the transaction." + "\n" + r.name+"'s balance = "+map.get(r.name).bal;
                     }

                  }
                  oo.writeObject(output);
                  //System.out.println(A.addCoupon(c.amt));

                  DataInputStream din = new DataInputStream(s.getInputStream());
                  closeServer=din.readInt();
                  if (closeServer==0) {
                      s1.close();
                      break;
                  }

              }
              catch (Exception e) {
                  System.out.println(e.getMessage());
                  System.out.println("Error ");
                  System.exit(1);
              }
          }
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
