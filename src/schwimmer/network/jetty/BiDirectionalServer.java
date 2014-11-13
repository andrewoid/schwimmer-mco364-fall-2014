package schwimmer.network.jetty;

import org.eclipse.jetty.server.Server;

public class BiDirectionalServer {

	public static void main( String args[] ) throws Exception {
		Server server = new Server(8080);
		server.setHandler(new ServerWebSocketHandler());
		server.start();
		server.join();
	}
	
}
