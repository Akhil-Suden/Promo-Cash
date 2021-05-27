import java.net.*;
import java.io.*;
import java.util.Scanner;

class Admin{
  public static void main(String args[]) throws Exception{
      try {
          Socket s1 = new Socket("localhost", 4445);
          int closeAdmin = 1;
          while (closeAdmin != 0) {

              OutputStream o = s1.getOutputStream();
              ObjectOutput s = new ObjectOutputStream(o);

              InputStream inputStream = s1.getInputStream();
              ObjectInput oi = new ObjectInputStream(inputStream);


              Scanner input = new Scanner(System.in);
              System.out.print("Enter User name: ");
              String name = input.next();
              System.out.print("Enter Amount to credit: ");
              int amt = input.nextInt();
              s.writeObject(new Request("Credit", name, amt));


              System.out.println((String) oi.readObject());


              DataOutputStream dout = new DataOutputStream(s1.getOutputStream());

              System.out.println("Close the admin? (y/n)");
              String yn = input.next();
              if (yn.equals("y") || yn.equals("Y")) {
                  closeAdmin = 0;
                  dout.writeInt(0);
                  s1.close();
                  s.flush();
                  s.close();
              }
             else
                  dout.writeInt(1);
          }
      }
          catch(Exception e){
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
