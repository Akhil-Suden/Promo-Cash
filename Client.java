import java.net.*;
import java.io.*;
import java.util.Scanner;


class Client{
public static void main(String args[])throws Exception{
Socket s=new Socket("localhost",3333);
DataOutputStream dout=new DataOutputStream(s.getOutputStream());

Scanner input = new Scanner(System.in);
System.out.print("Enter User name: ");
String name = input.next();
dout.writeUTF(name);
dout.flush();
System.out.print("Enter Amount to spend: ");
int amt = input.nextInt();
dout.writeInt(amt);
dout.flush();


s.close();
}}

