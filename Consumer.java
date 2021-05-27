import request.Credit;
import request.Debit;

import java.net.*;
import java.io.*;
import java.util.Scanner;


class Consumer{
    public static void main(String args[])throws Exception{
        try {
            Socket s1 = new Socket("localhost", 4445);
            int closeClient = 1;
            while (closeClient != 0) {
                OutputStream o = s1.getOutputStream();
                ObjectOutput s = new ObjectOutputStream(o);

                InputStream inputStream = s1.getInputStream();
                ObjectInput oi = new ObjectInputStream(inputStream);

                s.writeObject("Debit");

                Scanner input = new Scanner(System.in);
                System.out.print("Enter User name: ");
                String name = input.next();
                System.out.print("Enter Amount to debit: ");
                int amt = input.nextInt();
                s.writeObject(new Debit(name, amt));


                System.out.println((String) oi.readObject());


                DataOutputStream dout = new DataOutputStream(s1.getOutputStream());

                System.out.println("Close the client? (y/n)");
                String yn = input.next();
                if (yn.equals("y") || yn.equals("Y")) {
                    closeClient = 0;
                    dout.writeInt(0);
                    s1.close();
                    s.flush();
                    s.close();
                }
                else
                dout.writeInt(1);          
            }
        } catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println("Error ");

            System.exit(1);
        }
    }
}

    /*Socket s1=null;
        s1 =new Socket("localhost",4445);
                try {
                DataOutputStream dout = new DataOutputStream(s1.getOutputStream());

                Scanner input = new Scanner(System.in);
                System.out.print("Enter User name: ");
                String name = input.next();
                dout.writeUTF(name);
                dout.flush();
                System.out.print("Enter Amount to spend: ");
                int amt = input.nextInt();
                dout.writeInt(amt);
                dout.flush();
                }catch(Exception e){}

                s1.close();*/
