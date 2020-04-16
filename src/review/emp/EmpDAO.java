package review.emp;

import java.math.BigDecimal;
import java.sql.*;
import java.util.*;

import javax.print.DocFlavor.STRING;

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
	public ArrayList<EmpDTO> getDBList(EmpSearchDTO dto) {
		ArrayList<EmpDTO> datas = new ArrayList<EmpDTO>();

		// 부서, first_name
		String where = " where 1 = 1 ";
		if (dto.getDepartment_id() != null && !dto.getDepartment_id().isEmpty()) {
			where += " and department_id = ? ";
		}
		if (dto.getFirst_name() != null && !dto.getFirst_name().isEmpty()) {
			where += " and upper(first_name) like '%' || upper(?) || '%' ";
		}
		String sql = "select a.* from ( select rownum rn, b.* from (  " + "select * from employees " + where
				+ " order by EMPLOYEE_ID desc" + ") b ) a where rn  between ? and ? ";
		System.out.println(sql);
		try {
			conn = ConnectionManager.getConnnection();
			pstmt = conn.prepareStatement(sql);
			int p = 0;
			if (dto.getDepartment_id() != null && !dto.getDepartment_id().isEmpty()) {
				pstmt.setString(++p, dto.getDepartment_id());
			}
			if (dto.getFirst_name() != null && !dto.getFirst_name().isEmpty()) {
				pstmt.setString(++p, dto.getFirst_name());
			}
			pstmt.setInt(++p, dto.getFirst());
			pstmt.setInt(++p, dto.getEnd());
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
	public int count(EmpSearchDTO dto) {
		int result = 0;
		try {
			conn = ConnectionManager.getConnnection();

			String where = " where 1 = 1 ";
			if (dto.getDepartment_id() != null && !dto.getDepartment_id().isEmpty()) {
				where += " and department_id = ? ";
			}
			if (dto.getFirst_name() != null && !dto.getFirst_name().isEmpty()) {
				where += " and upper(first_name) like '%' || upper(?) || '%' ";
			}

			String sql = "select count(*) from employees" + where;
			pstmt = conn.prepareStatement(sql);

			int p = 0;
			if (dto.getDepartment_id() != null && !dto.getDepartment_id().isEmpty()) {
				pstmt.setString(++p, dto.getDepartment_id());
			}
			if (dto.getFirst_name() != null && !dto.getFirst_name().isEmpty()) {
				pstmt.setString(++p, dto.getFirst_name());
			}

			ResultSet rs = pstmt.executeQuery();
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

	public List<Map<String, Object>> getRegion() {
		List<Map<String, Object>> list = new ArrayList<>();
		try {
			conn = ConnectionManager.getConnnection();
			String sql = "select city, l.country_id, country_name, region_name from locations l, countries c, regions r\r\n"
					+ "where l.country_id = c.country_id and c.region_id = r.region_id order by city";
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("city", rs.getString("city"));
				map.put("country_id", rs.getString("country_id"));
				map.put("country_name", rs.getString("country_name"));
				map.put("region_name", rs.getString("region_name"));
				list.add(map);
			}
		} catch (Exception e) {

		} finally {
			ConnectionManager.close(conn);
		}
		return list;
	}
}
