package review.emp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TransactionTest")
public class TransactionTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TransactionTest() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(request.getServletContext().getRealPath("/"));
		// 1. 파라미터 받기
		request.setCharacterEncoding("utf-8");
		AccountDTO dto = new AccountDTO();
		// 2. 로직 처리
		Connection conn = ConnectionManager.getConnnection();
		try {
			conn.setAutoCommit(false);
			dto.setId("kim");
			dto.setMoney(-100);
			AccountDAO.getInstance().withdraw(conn, dto);
			dto.setId("hong");
			dto.setMoney(+100);
			AccountDAO.getInstance().withdraw(conn, dto);

			conn.commit();

		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

		} finally {
			ConnectionManager.close(conn);

		}
		// 3. 결과를 저장

		// 4. 뷰페이지 포워드
		response.setContentType("text/html; charset=utf-8");
		response.getWriter().append("<table>").append("<tr><td>실행결과</td></tr>").append("<tr><td>출금완료되었습니다</td></tr>")
				.append("</table>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
