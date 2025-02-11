package pack;

public class Test3 {
	public static void main (String[] args) {
		//산술 연산자
		int a = 5; //(대입연산자) a 변수에 리터럴 5를 기억시킴
		int b = 3;
		int c = a+b;
		
		System.out.println(c);
		
		System.out.println(a + b); 
		System.out.println(a - b);
		System.out.println(a * b);
		System.out.println(a / b); // 몫
		System.out.println(a % b); // 나머지
		System.out.println(a / (double)b); //소수점까지 나누기
		
		System.out.println();
		//System.out.println(a/0); //runtime error
		System.out.println(a/0.0); // Intinity(무한)
		System.out.println(a%0.0); //NaN(Not a number) 숫자가 아니라서 숫자로 표현할 수 없는 상태
		
		System.out.println("산술 연산자 우선순위 : ");
		System.out.println(3 + 4 * 5);
		System.out.println((3+4)* 5);
		
		System.out.println("문자열 더하기");
		String ss1 = "대한"; // String은 기본형이 아니라 참조현변수임. 사용방법은 기본형 처럼 같다.
		String ss2 = "민국";
		System.out.println(ss1 + ss2);
		//System.out.println(ss1 - ss2); 이런거 없음
		System.out.println(ss2 + " " + 2025); // 2025 정수는 문자열로 자동 형변환 후 문자열 더하기를 함
		System.out.println(ss2 + " " + 2000 + 25);
		System.out.println(ss2 + " " +(2000 + 25));
		
		String ss3 = "5" + 6;
		System.out.println("ss3 : "+ss3);
		
		System.out.println("5"+6);
		System.out.println(5+6);
		System.out.println(Integer.toString(5) + 6); // "5"+6
		System.out.println(Integer.parseInt("5")+6); // 5+6
		
		System.out.println("누적");
		int no = 1;
		no = no + 1;
		no += 1;
		no++; // 증감 연산자 (후위)
		++no; // 증감 연산자 (전위)
		System.out.println("no : "+ no);
		
		int imsi = 5;
		int result = ++imsi +1;
		System.out.println("imsi : "+ imsi);
		System.out.println("result : "+ result);
		
		int imsi2 = 5;
		int result2 = imsi2++ +1;
		System.out.println("imsi2 : "+ imsi2);
		System.out.println("result2 : "+ result2);
		
		System.out.println("부호에 대해");
		int imsi3 = -7;
		System.out.println("imsi3 : ");
		System.out.println("imsi3 : ");
		System.out.println("imsi3 : ");
		System.out.println("imsi3 : ");
		System.out.println("imsi3 : ");
		System.out.println("imsi3 : ");
		
		
		
		
		
		
		
		
		System.out.println("끝");
	}
}
