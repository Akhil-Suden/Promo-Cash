import java.net.*;
import java.io.*;
import java.util.Scanner;
import request.*;

class Admin{
  public static void main(String args[]) throws Exception{
      Socket s1=null;
      s1=new Socket("localhost", 4445);
  try{
      OutputStream o = s1.getOutputStream();
      ObjectOutput s = new ObjectOutputStream(o);
      s.writeObject("Credit");
      int closeAdmin = 1;
      while(closeAdmin != 0){
          Scanner input = new Scanner(System.in);
          System.out.print("Enter User name: ");
          String name = input.next();
          System.out.print("Enter Amount to credit: ");
          int amt = input.nextInt();
          s.writeObject(new Credit(name,amt));

          DataInputStream din = new DataInputStream(s1.getInputStream());
          closeAdmin=din.readInt();

      }
      s.flush();
      s.close();
    }
      catch (Exception e) {
          System.out.println(e.getMessage());
          System.out.println("Error ");

          System.exit(1);
      }
  }
}




/*    public static void main(String[] args)throws Exception{
        Socket s=new Socket("localhost",3333);
        DataOutputStream dout=new DataOutputStream(s.getOutputStream());
        DataInputStream din = new DataInputStream(s.getInputStream());

        int closeAdmin = 1;
        while(closeAdmin != 0){
            Scanner input = new Scanner(System.in);
            System.out.print("Enter User name: ");
            String name = input.next();
            dout.writeUTF(name);
            dout.flush();
            System.out.print("Enter Amount to credit: ");
            int amt = input.nextInt();
            dout.writeInt(amt);
            dout.flush();
            String addingCoupon = (String) din.readUTF();
            System.out.println(addingCoupon);
            closeAdmin=din.readInt();

        }



        dout.close();
        s.close();
    }
}
 */
