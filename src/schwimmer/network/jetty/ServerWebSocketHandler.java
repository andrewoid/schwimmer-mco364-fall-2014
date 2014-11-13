package schwimmer.network.jetty;

import org.eclipse.jetty.websocket.server.WebSocketHandler;
import org.eclipse.jetty.websocket.servlet.WebSocketServletFactory;

public class ServerWebSocketHandler extends WebSocketHandler {

	@Override
	public void configure(WebSocketServletFactory factory) {
		factory.register(EchoWebSocket.class);
	}

}
