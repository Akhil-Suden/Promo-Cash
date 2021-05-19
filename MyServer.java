import java.net.*;
import java.io.*;
import java.util.Queue;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.time.Duration;

final VAL=Duration.ofSeconds(10);

struct coupon{
  int amt;
  LocalDateTime born;    //time at which coupon was created
  int valid;    //it is fixed validity period
}
class MyServer{
public static void main(String args[])throws Exception{
Queue<coupon> account[] = new Queue[2];   //array of queue, each queue element for different user
HashMap<String,Queue> map=new HashMap<String,Queue>();
for(int i = 0; i <= 1; i++)
  bank[i] = new LinkedList<coupon>();
map.put("A",account[0]);
map.put("B",account[1]);
//map.get("name").offer(coupon(amt,LocalDateTime.now(),VAL));

ServerSocket ss=new ServerSocket(3333);
Socket s=ss.accept();

}

s.close();
ss.close();
}}
