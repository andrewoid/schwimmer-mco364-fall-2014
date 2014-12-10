package schwimmer.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JTextArea;

import schwimmer.multichat.ReadThread;

public class ChatClient extends ChatBox {

	private Socket socket;

	public ChatClient() throws UnknownHostException, IOException {
		super("Chat Client");

		socket = new Socket("192.168.117.107",3773);
		setSocket(socket);
		
		new ReadThread(this, socket).start();
	}

	public static void main( String args[] ) throws UnknownHostException, IOException {
		ChatClient client = new ChatClient();
		client.setVisible(true);
	}

}
