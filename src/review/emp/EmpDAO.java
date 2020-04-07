package review.emp;

import java.math.BigDecimal;
import java.sql.*;
import java.util.*;

/**
 * File : EmpDAO.java Desc : 사원관리 DAO 클래스
 * 
 * @author 김유미
 */
public class EmpDAO {

	Connection conn = null;
	PreparedStatement pstmt = null;
	Statement stmt = null;

	// 싱글톤 구현
	static EmpDAO instance;

	public static EmpDAO getInstance() {
		if (instance == null)
			instance = new EmpDAO();
		return instance;
	}

	// 수정된 사원정보 내용 갱신을 위한 메서드
	public boolean update(EmpDTO emp) {

		String sql = "UPDATE EMPLOUEES SET " + " FIRST_NAME = ?, " + " LAST_NAME = ?, " + " EMAIL = ?, "
				+ " PHONE_NUMBER = ?, " + " HIRE_DATE = ?, " + " JOB_ID = ?, " + " SALARY = ?, "
				+ " COMMISSION_PCT = ?, " + " MANAGER_ID = ?, " + " EMPLOYEE_ID = ? " + " WHERE EMPLOYEE_ID = ?";
		try {
			conn = ConnectionManager.getConnnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, emp.getFirst_name());
			pstmt.setString(2, emp.getLast_name());
			pstmt.setString(3, emp.getEmail());
			pstmt.setString(4, emp.getPhone_number());
			pstmt.setString(5, emp.getHire_date());
			pstmt.setString(6, emp.getSalary());
			pstmt.setString(7, emp.getCommission_pct());
			pstmt.setString(8, emp.getManager_id());
			pstmt.setString(9, emp.getEmployee_id());
			pstmt.setString(10, emp.getPhone_number());
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			ConnectionManager.close(conn);
		}
		return true;
	}

	// 특정 사원정보 삭제 메서드
	public boolean delete(int employee_id) {

		String sql = "DELETE FROM EMPLOYEES WHERE EMPLOYEE_ID=?";

		try {
			conn = ConnectionManager.getConnnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, employee_id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			ConnectionManager.close(conn);
		}
		return true;
	}

	// 신규 사원 추가 메서드
	public boolean insert(EmpDTO emp) {

		// String sql_seq = "select emp_seq.nextval from dual";
		String sql_seq = "SELECT MAX(EMPLOYEE_ID)+1 FROM EMPLOYEES";

		String sql = "INSERT INTO EMPLOYEES (EMPLOYEE_ID, FIRST_NAME, LAST_NAME ,"
				+ " EMAIL, PHONE_NUMBER, HIRE_DATE, JOB_ID, SALARY, COMMISSION_PCT," + " MANAGER_ID, DEPARTMENT_ID) "
				+ " VALUES( ?, ?, ?, ?, ?, ?, ?, ?,?, ?, ?)";

		BigDecimal seq = null;

		try {
			conn = ConnectionManager.getConnnection();

			// 시퀀스 조회
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql_seq);
			if (rs.next())
				seq = rs.getBigDecimal(1);

			// 사원등록
			pstmt = conn.prepareStatement(sql);
			pstmt.setBigDecimal(1, seq);
			pstmt.setString(2, emp.getFirst_name());
			pstmt.setString(3, emp.getLast_name());
			pstmt.setString(4, emp.getEmail());
			pstmt.setString(5, emp.getPhone_number());
			pstmt.setString(6, emp.getHire_date());
			pstmt.setString(7, emp.getJob_id());
			pstmt.setString(8, emp.getSalary());
			pstmt.setString(9, emp.getCommission_pct());
			pstmt.setString(10, emp.getManager_id());
			pstmt.setString(11, emp.getDepartment_id());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			ConnectionManager.close(conn);
		}
		return true;
	}

	// 사원 단건 조회
	public EmpDTO getEmp(int gb_id) {
		conn = ConnectionManager.getConnnection();
		String sql = " SELECT EMPLOYEE_ID," + "FIRST_NAME," + "LAST_NAME," + "EMAIL," + "PHONE_NUMBER," + "HIRE_DATE,"
				+ "JOB_ID," + "SALARY," + "COMMISSION_PCT," + "MANAGER_ID," + "DEPARTMENT_ID  " + "  FROM EMPLOYEES "
				+ " WHERE EMPLOYEE_ID = ? ";
		EmpDTO emp = new EmpDTO();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, gb_id);
			ResultSet rs = pstmt.executeQuery();
			// 데이터가 하나만 있으므로 rs.next()를 한번만 실행 한다.
			rs.next();
			emp.setEmployee_id(rs.getString("EMPLOYEE_ID"));
			emp.setFirst_name(rs.getString("FIRST_NAME"));
			emp.setLast_name(rs.getString("LAST_NAME"));
			emp.setEmail(rs.getString("EMAIL"));
			emp.setPhone_number(rs.getString("PHONE_NUMBER"));
			emp.setHire_date(rs.getString("HIRE_DATE"));
			emp.setJob_id(rs.getString("JOB_ID"));
			emp.setSalary(rs.getString("SALARY"));
			emp.setCommission_pct(rs.getString("COMMISSION_PCT"));
			emp.setManager_id(rs.getString("MANAGER_ID"));
			emp.setDepartment_id(rs.getString("DEPARTMENT_ID"));
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(conn);
		}
		return emp;
	}

	// 전체 사원 목록을 가져오는 메서드
	public ArrayList<EmpDTO> getDBList() {
		ArrayList<EmpDTO> datas = new ArrayList<EmpDTO>();

		String sql = "select * from employees order by EMPLOYEE_ID desc";
		try {
			conn = ConnectionManager.getConnnection();
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				EmpDTO emp = new EmpDTO();
				emp.setEmployee_id(rs.getString("EMPLOYEE_ID"));
				emp.setFirst_name(rs.getString("FIRST_NAME"));
				emp.setLast_name(rs.getString("LAST_NAME"));
				emp.setEmail(rs.getString("EMAIL"));
				emp.setPhone_number(rs.getString("PHONE_NUMBER"));
				emp.setHire_date(rs.getString("HIRE_DATE"));
				emp.setJob_id(rs.getString("JOB_ID"));
				emp.setSalary(rs.getString("SALARY"));
				emp.setCommission_pct(rs.getString("COMMISSION_PCT"));
				emp.setManager_id(rs.getString("MANAGER_ID"));
				emp.setDepartment_id(rs.getString("DEPARTMENT_ID"));
				datas.add(emp);
			}
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(conn);
		}
		return datas;
	}

	// 전체 건수 조회
	public int count() {
		int result = 0;
		try {
			conn = ConnectionManager.getConnnection();
			String sql = "select count(*) from employees";
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			rs.next();
			result = rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(conn);
		}
		return result;
	}

	// 페이지 처리 목록
	public ArrayList<EmpDTO> getDBPageList(int start, int end) {
		ArrayList<EmpDTO> datas = new ArrayList<EmpDTO>();
		try {
			conn = ConnectionManager.getConnnection();
			String sql = "select b.*   from (		select rownum rn, a.*  from ("
					+ "			select * from employees order by employee_id "
					+ ") a		) b   where rn between ? and ? 	";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				EmpDTO emp = new EmpDTO();
				emp.setFirst_name(rs.getString("first_name"));
				emp.setLast_name(rs.getString("last_name"));
				emp.setDepartment_id(rs.getString("department_id"));
				datas.add(emp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(conn);
		}
		return datas;
	}
}
