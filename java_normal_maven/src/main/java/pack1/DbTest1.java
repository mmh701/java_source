package pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbTest1 {
	private Connection conn = null; // DBMS와 연결 지원
	private Statement stmt = null; // SQL 문 실행 지원
	private ResultSet rs = null; // select의 결과에 접근 가능

	public DbTest1() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/test", "root", "123");

			stmt = conn.createStatement();

			rs = stmt.executeQuery("select code,sang,su,dan AS 단가 from sangdata");

			while (rs.next()) {
				String code = rs.getString("code");
				String sangpum = rs.getString("sang");
				int su = rs.getInt(3);
				int dan = rs.getInt("단가");
				System.out.println(code + "\t" + sangpum + "\t" + su + "\t" + dan);
			}

			String sql = "select count(*) AS cou from sangdata";
			rs = stmt.executeQuery(sql);
			rs.next();
			System.out.println("건수 : " + rs.getInt(1));
			System.out.println("건수 : " + rs.getInt("cou"));

		} catch (Exception e) {
			System.out.println("실패 : " + e.getMessage());
			return;
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new DbTest1();
	}

}
