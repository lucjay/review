package common;

import javax.servlet.http.HttpSession;
import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;

public class ServletConfig extends ServerEndpointConfig.Configurator {

	@Override
	public void modifyHandshake(ServerEndpointConfig sec, HandshakeRequest request, HandshakeResponse response) {

		// httpsession정보저장
		HttpSession session = (HttpSession) request.getHttpSession();
		sec.getUserProperties().put("userid", session.getAttribute("userid"));
	}

}