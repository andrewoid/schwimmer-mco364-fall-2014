package schwimmer.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;


public class NetworkRequest {

	public static void main(String args[]) throws IOException {
		
		Socket socket = new Socket("www.amazon.com", 80);
		InputStream in = socket.getInputStream();
		OutputStream out = socket.getOutputStream();
		String request = "GET /index.html\n\n";
		out.write(request.getBytes());
		out.flush();
		BufferedReader reader = 
				new BufferedReader(new InputStreamReader(in));
		
		String line;
		while ( (line = reader.readLine()) != null ) {
			System.out.println(line);
		}
		
		
	}
	
	
}
