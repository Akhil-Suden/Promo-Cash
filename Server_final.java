import java.io.*;
import java.net.*;

public class Server_final {
	public static void main(String args[]) throws Exception {
		ServerSocket ss2 = null;
		Socket s = null;
		System.out.println("Server Listening......");
		ss2 = new ServerSocket(4445);
		while (true) {
			s = ss2.accept();
			System.out.println("connection Established");
			ServerThread st = new ServerThread(s);
			st.start();
		}
	}
}
class ServerThread extends Thread {
	String line = null;
	BufferedReader is = null;
	PrintWriter os = null;
	Socket s = null;

	public ServerThread(Socket s) {
		this.s = s;
	}

	public void run() {
		try {
			is = new BufferedReader(new InputStreamReader(s.getInputStream()));
			os = new PrintWriter(s.getOutputStream());

		} catch (IOException e) {
			System.out.println("IO error in server thread");
		}

		try {
			line = is.readLine();
			while (line.compareTo("QUIT") != 0) {

				os.println(line);
				os.flush();
				System.out.println("Response to Client  :  " + line);
				line = is.readLine();
			}
		} catch (IOException e) {

			line = this.getName(); // reused String line for getting thread name
			System.out.println("IO Error/ Client " + line + " terminated abruptly");
		} catch (NullPointerException e) {
			line = this.getName(); // reused String line for getting thread name
			System.out.println("Client " + line + " Closed");
		}

		finally {
			try {
				System.out.println("Connection Closing..");
				if (is != null) {
					is.close();
					System.out.println(" Socket Input Stream Closed");
				}

				if (os != null) {
					os.close();
					System.out.println("Socket Out Closed");
				}
				if (s != null) {
					s.close();
					System.out.println("Socket Closed");
				}

			} catch (IOException ie) {
				System.out.println("Socket Close Error");
			}
		} // end finally
	}
}