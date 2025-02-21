package pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

// 키보드로 직급을 입력하여 해당 직급에 해당하는 직원 자료 출력
public class DbTest6Ex {
	
		private Connection conn;
		private PreparedStatement pstmt;
		private ResultSet rs;
		
		public DbTest6Ex() {
			dbLoad();
			showData();
		}
		
		private void dbLoad() {
			try {
				Class.forName("org.mariadb.jdbc.Driver");
			} catch (Exception e) {
				System.out.println("loading fail : " + e);
				System.exit(0);
			}
		}
		
		private void showData() {
			try {
				conn = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/test", "root", "123");
				
				pstmt = conn.prepareStatement("SELECT jikwonno, jikwonname, busername, jikwonjik, jikwongen "
						+ "FROM jikwon inner join buser on busernum=buserno WHERE jikwonjik = ?");
				
				Scanner sc = new Scanner(System.in);
				System.out.print("직급 입력: ");
				String jik = sc.next();
				sc.close();
				pstmt.setString(1,jik);
				System.out.println("직원번호" + "\t" + "직원명" + "\t" + "부서명" + "\t" +"직급" + "\t" + "성별");
				
				rs = pstmt.executeQuery();
				int cou = 0;
				while(rs.next()) {
					System.out.println(rs.getString("jikwonno") + "\t" + rs.getString("jikwonname") 
					+ "\t" + rs.getString("busername") + "\t" + rs.getString("jikwonjik") + "\t" + rs.getString("jikwongen"));
					cou++;
				}
				System.out.println("인원 수: " + cou);
			} catch (Exception e) {
				System.out.println("showData err : " + e);
			} finally {
				try {
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
					if(conn != null) conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		public static void main(String[] args) {
			new DbTest6Ex();
		}
}
