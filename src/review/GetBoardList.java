package review;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GetBoardList.do")
public class GetBoardList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "board/boardList.tiles";
		// String path = "member/login.jsp";
		// String path = "admin/member/login.tiles";
		request.getRequestDispatcher(path).forward(request, response);
	}

}
