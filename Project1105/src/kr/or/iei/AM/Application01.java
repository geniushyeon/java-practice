package kr.or.iei.AM;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Application01 {
	private static final String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String DB_USER = "system";
	private static final String DB_PASS = "oracle";

	public static void main(String[] args) throws ClassNotFoundException {
		//1. 드라이버 로드
		Class.forName("oracle.jdbc.driver.OracleDriver");

		//2. 커넥션 요청
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			select(conn);

		} catch(SQLException throwables) {
			throwables.printStackTrace();
		}

	}
	
	private static void select(Connection conn) {
		final String sql = "SELECT * FROM emp";
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			final ResultSet rs = pstmt.executeQuery();
			
			//bof, eof
			
			while(rs.next()) {
				final int empno = rs.getInt("empno");
				final String ename = rs.getString("ename");
				final String job = rs.getString("job");
				final Integer sal = rs.getInt("sal");
				final Integer comm = rs.getInt("comm");
				System.out.println(empno);
				System.out.println(ename);
				System.out.println(job);
				System.out.println(sal);
				System.out.println(comm);
				System.out.println("=====================");
			}
			
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		
		}
	}
}