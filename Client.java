import java.net.*;
import java.io.*;

class Client{
public static void main(String args[])throws Exception{
Socket s=new Socket("localhost",3333);


Scanner input = new Scanner(System.in);
System.out.print("Enter User name: ");
String name = input.next();
System.out.print("Enter Amount to spend: ");
String amt = input.next();


s.close();
}}
