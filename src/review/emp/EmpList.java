package review.emp;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Paging;

/**
 * Servlet implementation class EmpList
 */
@WebServlet("/EmpList.do")
public class EmpList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EmpSearchDTO sdto = new EmpSearchDTO();

		// 페이징처리
		Paging paging = new Paging();
		paging.setPageUnit(2);
		paging.setPageSize(5); // 한페이지에 보여줄 페이지 갯수 디폴트는 10
		// 현재 페이지번호
		String page = request.getParameter("page");
		int p = 1;
		if (page != null)
			p = Integer.parseInt(page);
		paging.setPage(p);

		// 검색 파라미터
		sdto.setDepartment_id(request.getParameter("department_id"));
		sdto.setFirst_name(request.getParameter("first_name"));
		sdto.setFirst(paging.getFirst());
		sdto.setEnd(paging.getLast());

		// 목록조회
		ArrayList<EmpDTO> list = EmpDAO.getInstance().getDBList(sdto);

		// 전체 건수
		int total = EmpDAO.getInstance().count(sdto);
		paging.setTotalRecord(total);

		// 결과저장
		request.setAttribute("list", list);
		request.setAttribute("paging", paging);

		request.getRequestDispatcher("./jsp/empList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
