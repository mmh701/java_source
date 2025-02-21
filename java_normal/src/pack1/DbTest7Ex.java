package pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

// 키보드로 특정 직원의 번호와 이름을 입력한다. 
// 해당 직원이 jikwon 테이블에 없으면 "작업 종료" 메세지와 함께 프로그램 종료
// 예 : 이순신과 같은 부서에 근무하는 직원과 해당 직원이 관리하는 고객 출력
// --- 출력 형태 ------------------
// 직원명    부서명     근무지역    직급      고객명    고객전화     고객나이
// 한송이    총무부     서울       사원      천송이    333-7788       29   
// ...
// 총무부 연봉 평균 : *** (소수 첫째자리에서 반올림)
public class DbTest7Ex {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public DbTest7Ex() {
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

			
			pstmt = conn.prepareStatement("SELECT busername FROM jikwon "
					+ "INNER JOIN buser ON busernum=buserno where jikwonno = ? AND jikwonname = ? ;");
			
			Scanner sc = new Scanner(System.in);
			System.out.print("직원 번호 입력: ");
			int no = sc.nextInt();
			System.out.print("직원 이름 입력: ");
			String name = sc.next();
			sc.close();
			pstmt.setInt(1, no);
			pstmt.setString(2, name);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				String bname = rs.getString("busername");
				
				System.out.println("직원명" + "\t" + "부서명" + "\t" + "근무지역" + "\t" + "직급" + "\t" 
				+ "고객명" + "\t" + "고객전화" + "\t\t" + "고객나이");
				
				pstmt = conn.prepareStatement("SELECT jikwonname, busername, buserloc, jikwonjik, gogekname, gogektel, "
						+ "YEAR(CURDATE()) - YEAR(SUBSTRING(gogekjumin, 1, 6)) + 1 고객나이 FROM jikwon "
						+ "INNER JOIN buser ON busernum=buserno "
						+ "LEFT OUTER JOIN gogek ON jikwonno=gogekdamsano "
						+ "WHERE busername = ? ");
				
				pstmt.setString(1, bname);
				rs = pstmt.executeQuery();
				
				while (rs.next()) {
					System.out.println(
							rs.getString("jikwonname") + "\t" + rs.getString("busername") + "\t" + rs.getString("buserloc") + "\t"
									+ rs.getString("jikwonjik") + "\t" + rs.getString("gogekname") + "\t"
									+ rs.getString("gogektel") + "\t" + rs.getString("고객나이"));
				}
				
				pstmt = conn.prepareStatement("SELECT round(avg(jikwonpay),0) AS 연봉평균 FROM jikwon "
						+ "INNER JOIN buser ON busernum=buserno GROUP BY busername HAVING busername = ?");
				pstmt.setString(1, bname);
				rs = pstmt.executeQuery();
				rs.next();
				System.out.println(bname + " 연봉 평균: " + rs.getString("연봉평균"));
				
			} else {
				System.out.println("작업 종료");
			}
		} catch (Exception e) {
			System.out.println("showData err : " + e);
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new DbTest7Ex();
	}
}