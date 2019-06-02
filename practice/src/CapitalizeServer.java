import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.Executors;

public class CapitalizeServer {
	public static void main(String[] args) throws Exception {
		try (var listener = new ServerSocket(59898)) {
			System.out.println("The capitalization server is running...");
			var pool = Executors.newFixedThreadPool(5);
			while (true) {
				pool.execute(new Capitalizer(listener.accept()));
			}
		}
	}
	
	private static class Capitalizer implements Runnable {
		private Socket socket;
		
		Capitalizer(Socket socket) {
			this.socket = socket;
		}
		
		@Override
		public void run() {
			System.out.println("Connected: " + socket);
			try {
				var in = new Scanner(socket.getInputStream());
				var out = new PrintWriter(socket.getOutputStream(), true);
				while (in.hasNextLine()) {
					out.println(in.nextLine().toUpperCase());
				}
			} catch (Exception e) {
				System.out.println("Error: " + socket);
			} finally {
				try {
					socket.close();
				} catch (IOException e) {}
				System.out.println("Closed: " + socket);
			}
		}
	}
}