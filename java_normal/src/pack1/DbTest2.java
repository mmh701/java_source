package pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbTest2 {
	private Connection conn = null;
	private Statement stmt = null;
	private ResultSet rs = null;

	public DbTest2() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/test", "root", "123");
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery("SELECT jikwonno, jikwonname, jikwonjik, busername FROM jikwon INNER join buser ON busernum = buserno WHERE jikwonjik IN('사원','대리')");
			
			while (rs.next()) {
				int jikwonno = rs.getInt(1);
				String jikwonname = rs.getString(2);
				String jikwonjik = rs.getString(3);
				String busername = rs.getString(4);
				System.out.println(jikwonno +"\t"+ jikwonname +"\t"+ jikwonjik +"\t"+ busername);
			}
			
			String sql = "SELECT COUNT(*) FROM jikwon WHERE jikwonjik IN('사원','대리');";
			rs = stmt.executeQuery(sql);
			rs.next();
			System.out.println("건수 : " + rs.getInt(1));
			
		} catch (Exception e) {
			System.out.println("실패 : " + e.getMessage());
		} finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new DbTest2();
	}

}
