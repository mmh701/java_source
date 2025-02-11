package pack5;

import java.io.FileNotFoundException;
import java.io.FileReader;


public class Ex31Try {
	public String name = "tom";
	
	public void test() {
		try {
		int a[] = {1,2,3};
		System.out.println("배열 값 출력: " + a[1]);
		//System.out.println("배열 값 출력: " + a[5]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("배열 오류: 지역이 우선");
		}
	}
	
	public void test2() throws Exception {
		FileReader fr2 = new FileReader("c:/work/kbs.txt");
	}

	public static void main(String[] args) {
		try {
			// aa.txt 없는 경우에만 catch 블럭 수행
			FileReader fr = new FileReader("c:/work/aa.txt");
			//FileReader fr = new FileReader("c:/work/aaa.txt");
		} catch (FileNotFoundException e) {
			System.out.println("파일 읽기 오류");
		}
		
		System.out.println("-------------");
		
		try {
			int su = 2;
			//int su = 0;
			int result = 10 / su;
			System.out.println("result: " + result);
			
			Ex31Try ex31Try = new Ex31Try();
			//Ex31Try ex31Try = null;
			System.out.println("이름은 " + ex31Try.name);
			
			
			ex31Try.test();
			

		} catch (ArithmeticException e) {
			System.out.println("나누기 오류: 0으로 나누기 불가");
		} catch (NullPointerException e) {
			System.out.println("참조변수 오류: " + e);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("배열 참조 오류: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("위 catch 이외의 오류는 여기서 처리");

		} finally {
			System.out.println("에러 유무 상관없이 반드시 수행");
		}
		System.out.println("-------------\n프로그램 종료");
	}
}
