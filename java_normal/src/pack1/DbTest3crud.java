package pack1;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DbTest3crud {
	private Connection conn = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	private Properties properties = new Properties(); // ***.proerties 읽기용

	public DbTest3crud() {
		try {
			// 보안을 목적으로 연결정보를 펼도의 파일로 저장 후 읽기 - secure coding 가이드 라인을 따름
			properties.load(new FileInputStream("C:/work/jsou/java_normal/src/pack1/dbinfo.properties"));

			Class.forName(properties.getProperty("driver"));

			conn = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("user"),
					properties.getProperty("passwd"));
			dbProcess();
			System.out.println("프로그램 종료");
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

			
			/*
			conn.setAutoCommit(false);	// Transaction 수동
			// insert, update, delete 등의 작성을 한다. Transaction 시작
			// commit or rollback으로 Transaction 종료
			conn.setAutoCommit(true);
			*/
			
			// 자료 추가 -- Auto commit ( Transaction )
			String sqlinsert = "insert into sangdata values(5,'새우깡',2,1000)";
			stmt.executeUpdate(sqlinsert); // select 이외의 sql은 executeUpdate 사용
			
			// 참고 : insert, update, delete 는 성공하면 성공한 레코드 수, 실패하면 0을 반환
			// 자료 수정
			String sqlupdate = "update sangdata set sang='허니칩',su=17 where code = 5";
			//stmt.executeUpdate(sqlupdate);
			int upResult = stmt.executeUpdate(sqlupdate);
			//System.out.println("upResult: " + upResult);
			if (upResult > 0)
				System.out.println("수정 성공");
			else
				System.out.println("수정 실패");
			
			// 자료 읽기
			String sqlselect = "select * from sangdata";
			rs = stmt.executeQuery(sqlselect);
			int cou = 0;
			while (rs.next()) {
				System.out.println(rs.getString("code") + " " + rs.getString("sang") 
				+ " " + rs.getString("su") + " " + rs.getString("dan"));
				cou++;
			}
				
			// 자료 삭제
			String sqldelete = "delete from sangdata where code = 5";
			int delResult = stmt.executeUpdate(sqldelete);
			if (delResult > 0)
				System.out.println("삭제 성공");
			else
				System.out.println("삭제 실패");
			
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
		new DbTest3crud();
	}
}
