import java.net.*;
import java.io.*;

public class server {
		public static void main(String arg[]) {	
			try {
				ServerSocket server = new ServerSocket(3000);
				Socket s = server.accept();
			
			
				System.out.println("Connected");
				
				DataOutputStream dos = new DataOutputStream(s.getOutputStream());
				dos.writeUTF("Welcome to Socket");
			} catch(Exception e) {}
		}
}