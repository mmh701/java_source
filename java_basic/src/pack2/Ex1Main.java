package pack2;

public class Ex1Main { //ExMain은 main 메소드를 실행하기 위한 클래스임.
	public static void main(String[] args) {
		// main 메소드는 응용 프로그램의 시작을 위해 정해진 메소드이다.
		// Ex1Car 설계도로 객체를 생성. 이런 과정을 객체를 인스턴스화 라고함
		//다시말해 클래스로부터 객체를 만드는 과정을 클래스의 인스턴스화라고하며, 어떤 클래스로부터
		//만들어진 객체를 그 클래스의 인스턴스라고 한다.
		//객체는 모든 인스턴스를 대표하는 포괄적인 의미이다.
		// 클래스 --> 인스턴스화 --> 객체
		
		// Ex1Car.class를 주기억장치로 읽은 후 car1 객체변수를 선언.
		// new 키워드로 인스턴스를 진행. 이 때 Ex1Car()이라는 생성자를 호출
		Ex1Car car1 = new Ex1Car();
		// Ex1Car 멤버필드(전역변수) 호출-------
		System.out.println(car1.wheel); //접근지정자가 default이므로 호출 가능
		//System.out.println(car1.airBag); // private 멤버이므로 호출 불가
		System.out.println(car1.irum);
		
		System.out.println();
		// Ex1Car 멤버 메소드 호출-------
		// car1.abc(); // private 메소드이므로 호출불가
		car1.def(); // <- void 호출
		
		System.out.println();
		String ss = car1.driving(); // <- String 호출
		ss = "와우 " + ss;
		System.out.println(ss);
		
		System.out.println();
		car1.driving(); // 내용만
		System.out.println(car1.driving()); // return 값까지
		
		System.out.println();
		car1.drivingGood(2); // 매개변수가 있는 메소드를 호출 객체변수.메소드명(인자,,,) 인자,인수,argument

		System.out.println("\n==================================");
		Ex1Car car2 = new Ex1Car(); // 새로운 객체 생성
		// car1과 car2는 type이 같은 두 개의 객체 변수
		System.out.println(car2.wheel);
		car2.def();
		
	}

}

// 클래스를 공부하는 이유
// 1) 직접 객체를 생성 후 사용하기 위함
// 2) 다른 사람이 만든 클래스를 활용하기 위함