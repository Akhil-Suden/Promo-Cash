import java.net.*;
import java.io.*;
import java.util.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.time.Duration;

//final VAL=Duration.ofSeconds(10);  //validity of coupon

public class Server {
    public static void main(String args[]) throws Exception {
    /*    User A = new User();
        User B=new User();
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
          byte closeServer = 1;
          while(closeServer != 0) {
              try {
                  InputStream o = s.getInputStream();
                  ObjectInput s1 = new ObjectInputStream(o);

                  OutputStream outputStream = s.getOutputStream();
                  ObjectOutput oo = new ObjectOutputStream(outputStream);

                  r = (Request) s1.readObject();
                  System.out.println("Request recieved : "+ r.requestType+" amount= "+r.amt+" for "+r.name);
                  String output= new String();
                  if(r.requestType.equals("Credit")) {
                      // System.out.println(str);
                      if (!map.containsKey(r.name)) {
                          map.put(r.name, new User());
                      }
                      map.get(r.name).addCoupon(r.amt);
                      output = r.requestType + " Successfull." + "\n" + r.name + "'s balance = " + map.get(r.name).bal;
                      System.out.println("Result : "+ r.requestType+" Succesfull \n"+r.name+"'s balance="+map.get(r.name).bal);

                  }


                  else if(r.requestType.equals("Debit")){
                      if (!map.containsKey(r.name)) {
                          output = "User doesn't exist. Contact Admin";
                          System.out.println("Result: User doesn't exist.");
                      }
                      else{
                      if(map.get(r.name).useCoupon(r.amt)){
                          output = r.requestType + " Successfull." + "\n" + r.name + "'s balance = " + map.get(r.name).bal;
                          System.out.println("Result : "+ r.requestType+" Succesfull \n"+r.name+"'s balance="+map.get(r.name).bal);

                      }
                      else
                        { output = "Insufficient balance to make the transaction." + "\n" + r.name+"'s balance = "+map.get(r.name).bal;
                          System.out.println("Result: Debit Failed due to Insufficient Balance\n" + r.name+"'s balance = "+map.get(r.name).bal);}
                     }

                  }

                  oo.writeObject(output);

                  DataInputStream din = new DataInputStream(s.getInputStream());
                  closeServer=din.readByte();
                  if (closeServer==0) {
                      s1.close();
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
