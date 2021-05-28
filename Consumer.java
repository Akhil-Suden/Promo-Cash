import java.net.*;
import java.io.*;
import java.util.Scanner;


class Consumer{
    public static void main(String args[])throws Exception{
        try {
            Socket s1 = new Socket("localhost", 4445);
            byte closeClient = 1;
            while (closeClient != 0) {
                OutputStream o = s1.getOutputStream();
                ObjectOutput s = new ObjectOutputStream(o);

                InputStream inputStream = s1.getInputStream();
                ObjectInput oi = new ObjectInputStream(inputStream);

                Scanner input = new Scanner(System.in);
                System.out.print("Enter User name: ");
                String name = input.next();
                System.out.print("Enter Amount to debit: ");
                int amt = input.nextInt();
                while(amt<=0){
                System.out.printf("\nAmount should be greater than 0 ");
                System.out.print("\nEnter Amount to debit: ");
                amt = input.nextInt();  }

                s.writeObject(new Request("Debit", name, amt));
                System.out.println((String) oi.readObject());

                DataOutputStream dout = new DataOutputStream(s1.getOutputStream());

                System.out.println("Press Q to exit OR any key to continue.");
                String yn = input.next();
                if (yn.equals("Q") || yn.equals("q")) {
                    closeClient = 0;
                    dout.writeByte(0);
                    s1.close();
                    s.flush();
                    s.close();
                }
                else
                dout.writeByte(1);
            }
        } catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println("Error ");

            System.exit(1);
        }
    }
}
