import java.net.*;
import java.io.*;
import java.util.Scanner;

class Admin{
    public static void main(String[] args)throws Exception{
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

            System.out.println("Close the admin? (y/n)");
            String yn = input.next();
            if(yn.equals("y") || yn.equals("Y")){
                closeAdmin=0;
            }
        }



        dout.close();
        s.close();
    }
}

