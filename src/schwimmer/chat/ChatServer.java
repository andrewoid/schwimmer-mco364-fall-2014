package schwimmer.chat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatServer extends ChatBox implements ActionListener {

	private ServerSocket server;

	public ChatServer() throws UnknownHostException, IOException {
		super("Chat Server");
		
		server = new ServerSocket(7337);

		new Thread() {
			public void run() {
				try {
					Socket socket = server.accept();
					setSocket(socket);
					new ReadThread(ChatServer.this, socket).start();
				}
				catch(IOException e) {
					e.printStackTrace();
				}
			}
		}.start();

	}
	
	public static void main( String args[] ) throws UnknownHostException, IOException {
		ChatServer server = new ChatServer();
		server.setVisible(true);
	}
	
}
