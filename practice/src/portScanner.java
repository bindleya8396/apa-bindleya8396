import java.net.*;

public class portScanner {
	public static void main(String arg[]) {
		Socket s;
		
		for(int i = 1; i < 65536; i++) {
			
			try {
				s = new Socket(arg[0],i);
				System.out.println("Port Open: " + i);
			} catch(Exception e) {}
		}
	}
}