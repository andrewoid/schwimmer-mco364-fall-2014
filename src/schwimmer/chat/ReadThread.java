package schwimmer.chat;

import java.awt.TextArea;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class ReadThread extends Thread {
	
	private Socket socket;
	private ChatBox box;

	public ReadThread(ChatBox box, Socket socket) {
		this.socket = socket;
		this.box = box;
	}

	public void run() {

		try {
			BufferedReader in = new BufferedReader(
					new InputStreamReader(
							socket.getInputStream()));

			while (true) {
				box.append(in.readLine());
			}

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
}
