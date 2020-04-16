package common;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EventNoticeServlet")
public class EventNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EventNoticeServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Broadsoket socket = new Broadsoket();
		MessageVO vo = new MessageVO();
		vo.setCmd("event");
		vo.setMsg("4월 총선");
		socket.eventNoticeMessage(vo);

	}

}
