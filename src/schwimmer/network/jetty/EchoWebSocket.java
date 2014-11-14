package schwimmer.network.jetty;

import java.io.IOException;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;

// http://www.eclipse.org/jetty/documentation/current/jetty-websocket-api-annotations.html
@WebSocket(maxTextMessageSize = 64 * 1024)
public class EchoWebSocket {
	
	private Session session;
	
	@OnWebSocketClose
	public void onClose(int statusCode, String reason) {

	}

	@OnWebSocketConnect
	public void onConnect(Session session) {
		this.session = session;
	}

	@OnWebSocketMessage
	public void onMessage(String msg) {
		try {
			session.getRemote().sendString(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
