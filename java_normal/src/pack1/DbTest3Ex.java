package pack1;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

// jikwon 테이블로 직급별 연봉합, 연봉 평균 출력.
// 조건 1) 직급이 이사, 부장은 제외 2) 연봉이 null인 행도 제외

public class DbTest3Ex {
	private Connection conn = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	private Properties properties = new Properties();

	public DbTest3Ex() {
		try {
			properties.load(new FileInputStream("C:/work/jsou/java_normal/src/pack1/dbinfo.properties"));

			Class.forName(properties.getProperty("driver"));

			conn = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("user"),
					properties.getProperty("passwd"));
			dbProcess();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}

	}

	private void dbProcess() {
		try {
			stmt = conn.createStatement();
			String sqlselect = "SELECT jikwonjik,SUM(jikwonpay) AS 연봉합,AVG(jikwonpay) AS 연봉평균 "
					+ "FROM jikwon where jikwonpay IS NOT NULL AND "
					+ "jikwonjik != '이사' AND jikwonjik != '부장' GROUP BY jikwonjik";
			rs = stmt.executeQuery(sqlselect);
			int cou = 0;
			System.out.println("직급" + " " + "연봉합" + " " + "연봉평균");
			while (rs.next()) {
				System.out.println(rs.getString("jikwonjik") + " " 
			+ rs.getString("연봉합") + " " + rs.getString("연봉평균"));
				cou++;
			}
			
		} catch (Exception e) {
			System.out.println("실패 :" + e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new DbTest3Ex();
	}
}
