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
			// 1) JDBC 업체가 제공하는 Driver 파일 로딩
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (Exception e) {
			System.out.println("로딩 실패 : " + e.getMessage());
			return;
		}

		try {
			// 2) DB 서버와 연결
			conn = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/test", "root", "123");
		} catch (Exception e) {
			System.out.println("연결 실패 : " + e.getMessage());
			return;
		}

		try {
			// 3) SQL문 실행 : select로 자료 읽기
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery("select code,sang,su,dan AS 단가 from sangdata");
			
			while (rs.next()) { // record pointer 이동 - pointer가 가리키고 있는 레코드만 참조 가능(내용 있으면 true, 내용 없으면 false)
				String code = rs.getString("code");
				String sangpum = rs.getString("sang");
				int su = rs.getInt(3);	// 칼럼 순서로도 가능
				int dan = rs.getInt("단가");	// 별명이 칼럼명됨
				System.out.println(code + "\t" + sangpum + "\t" + su + "\t" + dan);
			}
			
			String sql = "select count(*) AS cou from sangdata";
			rs = stmt.executeQuery(sql);
			rs.next();
			System.out.println("건수 : " + rs.getInt(1));
			System.out.println("건수 : " + rs.getInt("cou"));
			
		} catch (Exception e) {
			System.out.println("처리 실패 : " + e.getMessage());
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
		new DbTest1();
	}

}
