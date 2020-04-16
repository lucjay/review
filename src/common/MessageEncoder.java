package common;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

public class MessageEncoder implements Encoder.Text<MessageVO> {
	   @Override
	   public void init(EndpointConfig ec) { }
	   @Override
	   public void destroy() { }
	   @Override
	   public String encode(MessageVO msg) throws EncodeException {
	      // Access msgA's properties and convert to JSON text...
		   
	      return "";//msgAJsonString;
	   }
	}
