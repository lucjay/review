package common;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

import com.google.gson.Gson;

public class MessageDecoder implements Decoder.Text<MessageVO> {
	@Override
	public void init(EndpointConfig ec) {
	}

	@Override
	public void destroy() {
	}

	@Override
	public MessageVO decode(String string) throws DecodeException {
		Gson gson = new Gson();
		MessageVO message = gson.fromJson(string, MessageVO.class);
		return message;

	}

	@Override
	public boolean willDecode(String string) {
		// Determine if the message can be converted into either a
		// MessageA object or a MessageB object...
		return true;
	}
}