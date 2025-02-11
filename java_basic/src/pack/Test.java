package pack;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		//byte short int long, float double, char boolean
		byte a = 1;
		int b = 5;
		//byte c = a + b; 연산시 int 로 변환되기 때문에 하위 타입 적용안됨
		byte c = (byte) (a + b); //연산 후 byte 로 변경
		System.out.println("c : " + c);
		
		float d = 10.5f;
		double e = 5.6;
		//float f = d + e; 연산시 double 로 변환되기 때문에 하위 타입 적용안됨
		float f = (float)(d + e);
		System.out.println("f : " + f);
		double g = (float)d + e;
		System.out.println("g : " +  g);
		double h = (int)d + e;
		System.out.println("h : " + h);
		
		
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			System.out.print("양의 정수를 입력: ");
			int num = sc.nextInt();
			//System.out.println(num);
			if(num <= 1) { // 1 이하의 값이 입력되면 작업 종료
				System.out.println("2 이상의 정수를 입력하세요");
				break;
			}
			// 1부터 숫자까지의 합 출력
			int n = 1, total = 0;
			while(n<=num) {//키보드에서 입력한 숫자보다 작은 동안 반복
				total += n;
				n++;
			}
			System.out.println("합(total)은 " + total);
			sc.nextLine(); // num 받을때 입력 값 이후 엔터도 식별되기 때문에 엔터값을 따로 받아줘서 에러 없앰
			
			System.out.print("계속 할까요(y/n)? ");
			String imsi = sc.nextLine();
			if(imsi.equals("y")) { //! : 조건 부정
				continue;
			}
			else if (imsi.equals("n")) {
				System.out.println("작업 종료");
				break;
			}
			else {
				System.out.println("다시 입력");
				break;
			}
			
		}
		sc.close(); //사용 중인 자원 해제
		
		
		
		
		
		
		
	}
}
