package pack;

public class Test2 {
	public static void main(String[] args) {
		/* */ // = 주석 종류
		String irum = "신기해";
		System.out.println(irum); //ln = 줄바꿈
		System.out.print(irum);
		System.out.println();
		
		// 변수 : 값을 저장 할 수 있는 메모리 공간(새로운 값 입력시 덮어쓰기)
		// 변수명 : 변수에 대한 임의의 이름. 형식: 타입 변수명 = 리터럴(문자, 숫자 ...)
		// 상수 : 처음에 입력한 값이 계속 유지되는 메모리 공간
		// 변수 기본형 타입 : bcbsilfd
		// 기본형 처럼 사용하는 참조형 타입 : String
		
		System.out.println("정수에 대해,,,");
		// byte
		byte var1; //1바이트(-128 ~ 127) 정수 기억장치
		var1 = 10;
		var1 = 5;//덮어써서 10은 잊어짐
		System.out.println(var1);
		System.out.println(Byte.MAX_VALUE);
		System.out.println(Byte.MIN_VALUE);
		byte var2 = 123; // 대입(치환) 연산자
		//var2 = 128; 오류: 1바이트 범위 벗어남
		System.out.println("var2: " + var2);
		
		// short
		short var3 = 10; // 2바이트(-32768 ~ 32767) 정수 기억장소
		//var3 = 32768; 오류: 2바이트 범위 벗어남
		System.out.println("var3: " + var3);
		
		// int
		int var4 = 10; // 4바이트 (+- 약20억) 정수 기억장소
		//var4 = 2147483648; 오류: 4바이트 범위 벗어남
		System.out.println("var4: " + var4);
		
		System.out.println("형변환에 대해 ...");
		byte aa = 10; // 자동 형변환함 (int 타입의 10을 byte 타입으로 자동 형변환 후 기억)
		aa = (byte)10; // 강제 형변환 (cast 연산자를 이용해 casting 함)
		aa = (byte)200; //-56됨
		aa = 5;
		int imsi = 7;
		byte bb = 7;
		//byte cc = imsi; imsi에 뭐가 들어올지 모르기때문에 int랑 byte 호환 안됨
		byte cc = (byte)imsi; //imsi의 값을 byte로 고정
		System.out.println("aa: " + aa);
		System.out.println("bb: " + bb);
		
		// long 
		long var5 = 10; // 8바이트 정수 기억장소
		//var5 = 2147483648; 오류: int 범위가 벗어나면 L 붙여야됨
		//var5 = 9223372036854775808L; 오류: 8바이트 범위 벗어남
		System.out.println("var5: " + var5);
		
		System.out.println("실수에 대해,,,");
		// float
		float f1 = 3; // 4바이트 실수 기억장소 (소수 7자리까지)
		//정수는 실수로 자동 형변환 (promotion)
		//f1 = 123.12; 오류 : f 붙여야됨
		f1 = 123.12f;
		f1 = (float)123.12;
		System.out.println("f1 : " + f1);
		
		// double
		double d1 = 123;// 8바이트 실수 기억장소 (소수 15자리까지)
		d1 = 123.12;
		System.out.println("d1 : " + d1);
		
		System.out.println();
		int aa1 = (int)3.5; //소수점 버림
		System.out.println("aa1 : " + aa1);
		
		int aa2 = 12 +(int)10.5;
		aa2 = (int)(10.5 + 12); //숫자먼저 계산 22.5 => 22
		aa2 = (int)10.5 + 12; // 10 + 12 => 22
		System.out.println("aa2 : " + aa2);
		
		double aa3 = 12 + 10.5; // 정수는 실수화 후 연산에 참여 ex) 12 = 12.0
		System.out.println("aa3 : " + aa3);
		
		System.out.println("논리형(참, 거짓 결과의 자료형)에 대해,,,");
		// boolean
		boolean bu1 = true; //똑같은 변수 이름은 다시 선언 불가
		bu1 = false;
		System.out.println("bu1 : " + bu1);
		
		System.out.println("문자형(한 개의 문자 기억)에 대해,,,");
		// char
		char c1 = 'A'; // 'a'= 문자, "ab" = 문자열 c1 = 'bc'; c1 = "b"; 안됨
		System.out.println("c1 : "+ c1 + " " + (int)c1 + " "+ (char)65);
		// Ascli 코드에서 'A'는 십진수 65, 'a': 97, '0':48......
		
		System.out.println("안녕 " + (char)10 +"반가워");
		
		int abc = 0x0f; //16진수(0x리터럴)를 10진수 int 형으로 저장
		System.out.println("abc : "+ abc + " "+ Integer.toHexString(15));
		System.out.println("abc : "+ abc + " "+ Integer.toBinaryString(15));
		
		int abc2 = 007; //8진수(0리터럴)를 10진수 int 형으로 저장
		System.out.println("abc2 : "+ abc2);
		
		System.out.println();
		final double PI = 3.14; // 상수(final = 변동 불가)
		System.out.println("PI : "+ PI);
		
		
	}
}

