package kr.or.iei_1104;

import java.sql.*;

public class Application02 {

	private static final String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String DB_USER = "system";
	private static final String DB_PASS = "oracle";

	public static void main(String[] args) throws ClassNotFoundException {
		//1. Ŭ���� �ε�
		Class.forName("oracle.jdbc.driver.OracleDriver");

		//2. DB ����
		try (final Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			final String sql = "UPDATE emp SET comm = 0 WHERE comm IS NULL";
			final PreparedStatement pstmt = conn.prepareStatement(sql);
			final int affectedRows = pstmt.executeUpdate();
			System.out.println(affectedRows);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}