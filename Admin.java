import java.net.*;
import java.io.*;
import java.util.Scanner;

class Admin{
    public static void main(String[] args)throws Exception{
        Socket s=new Socket("localhost",3333);
        DataOutputStream dout=new DataOutputStream(s.getOutputStream());

        Scanner input = new Scanner(System.in);
        System.out.print("Enter User name: ");
        String name = input.next();
        dout.writeUTF(name);
        dout.flush();
        System.out.print("Enter Amount to credit: ");
        int amt = input.nextInt();
        dout.writeInt(amt);
        dout.flush();

        dout.close();
        s.close();
    }
}

