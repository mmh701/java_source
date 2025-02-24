package pack3Lambda;

@FunctionalInterface
interface HelloInter {	// 함수형 인터페이스임을 강조
	int calcData(int a, int b);
	//int calcData2(int a, int b);
}

public class MyLamda1 implements HelloInter{
	@Override
	public int calcData(int a, int b) {
		// 인터페이스의 추상 메소드 오버라이드 : 전통적 방법
		return a + b;
	}
	
//	@Override
//	public int calcData2(int a, int b) {
//		// 인터페이스의 추상 메소드 오버라이드 : 전통적 방법
//		return 0;
//	}
	
	
	public static void main(String[] args) {
		MyLamda1 my1 = new  MyLamda1();
		System.out.println(my1.calcData(3,4));
		
		System.out.println("람다식으로 표현");
		HelloInter inter = (a,b)-> a+b;
		System.out.println(inter.calcData(3, 4));
		
		HelloInter inter2 = (kbs,mbc) -> kbs*mbc;
		System.out.println(inter2.calcData(3,4));
		
	}
}