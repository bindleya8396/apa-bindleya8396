import java.io.*;
import java.net.*;
import java.util.*;

public class DateServer {
	public static void main(String[] arg) throws IOException {
		try (var listener = new ServerSocket(59090)) {
			System.out.println("The date server is running...");
			while (true) {
				try (var socket = listener.accept()) {
					var out = new PrintWriter(socket.getOutputStream(), true);
					out.println(new Date().toString());
				} catch(Exception e) {}
			}
		} catch(Exception e) {}
	}
}