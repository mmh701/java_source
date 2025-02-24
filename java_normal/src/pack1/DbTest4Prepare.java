package pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

// PreparedStatement : 선 처리 방식
// 동일한 sql문을 여러 클라이언트가 빈번하게 사용할 경우 효과적 ( 웹 프로그래밍 )
// ? 연산자를 사용함으로 보안을 강화하고 가독성을 향상시킬 수 있다
public class DbTest4Prepare {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public DbTest4Prepare() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/test", "root", "123");
			
		} catch (Exception e) {
			System.out.println("실패 : " + e.getMessage());
			try {
				if(conn != null) conn.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			System.exit(0);
		} 
	}
	
	private void dbProcess() {
		try {
			// 자료 추가
			String isql = "insert into sangdata values(?,?,?,?)";
			pstmt = conn.prepareStatement(isql);
			pstmt.setString(1, "5");
			pstmt.setString(2, "카페라떼");
			pstmt.setString(3, "6");
			pstmt.setInt(4, 6000);
			
			int re = pstmt.executeUpdate();
			if(re == 1) {
				System.out.println("추가 성공");
			}else {
				System.out.println("추가 실패");
			}
			
			// 자료 수정
			String usql = "update sangdata set sang=?,su=?,dan=? where code=?";
			pstmt = conn.prepareStatement(usql);
			pstmt.setString(1, "초코모카");
			pstmt.setInt(2, 11);
			pstmt.setInt(3, 5500);
			pstmt.setInt(4, 5);
			
			if(pstmt.executeUpdate() > 0) {
				System.out.println("수정 성공");
			}else {
				System.out.println("수정 실패");
			}
			
			// 자료 삭제
			String dsql = "DELETE FROM sangdata WHERE CODE=?";
			pstmt = conn.prepareStatement(dsql);
			pstmt.setString(1, "5");
			
			if(pstmt.executeUpdate() > 0) {
				System.out.println("삭제 성공");
			}else {
				System.out.println("삭제 실패");
			}
			
			// 전체 자료 읽기
			String sql = "select * from sangdata";
			pstmt = conn.prepareStatement(sql);	// 선처리 방식
			rs = pstmt.executeQuery();

			while (rs.next()) {
				System.out.println(rs.getString("code") + " " + rs.getString("sang") 
				+ " " + rs.getString("su") + " " + rs.getString("dan"));
				
			}
			
			System.out.println();
			// 부분 자료 읽기
			//String sql2 = "select * from sangdata where code=" + co;	// 문자열 더하기 : 시큐어 코딩 가이드에 위배
			String sql2 = "select * from sangdata where code=?"; 		// ? 연산자 사용
			pstmt = conn.prepareStatement(sql2);

			Scanner sc = new Scanner(System.in);
			System.out.print("번호 입력: ");
			String co = sc.nextLine();
			pstmt.setString(1, co); // 첫번째 ? 에 co 변수 값을 연결
			sc.close();
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
			System.out.println(rs.getString("code") + " " + rs.getString("sang") 
				+ " " + rs.getString("su") + " " + rs.getString("dan"));
			}
			System.out.println("읽기 완료");
			
			
		} catch (Exception e) {
			System.out.println("오류 : " + e.getMessage());
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}
	
	public static void main(String[] args) {
		DbTest4Prepare obj = new DbTest4Prepare();
		obj.dbProcess();
	}
}
