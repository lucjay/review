package review.emp;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AccountDAO {

	// 싱글톤
	static AccountDAO instance = new AccountDAO();

	public static AccountDAO getInstance() {
		return instance;
	}

	// 입출금처리
	public void withdraw(Connection conn, AccountDTO dto) {
		try {
			String sql = "update account set money = money + ? where id =?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getMoney());
			pstmt.setString(2, dto.getId());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
