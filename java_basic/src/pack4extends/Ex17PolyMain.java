package pack4extends;

public class Ex17PolyMain {
	public static void main(String[] args) {
		Ex17PolyCar car1 = new Ex17PolyCar();
		Ex17PolyBus bus1 = new Ex17PolyBus();
		Ex17PolyTaxi taxi1 = new Ex17PolyTaxi();
		System.out.println();
		
		car1.dispData();
		System.out.println(car1.getSpeed());
		
		System.out.println("----------\n버스에 대해");
		bus1.dispData();
		System.out.println(bus1.getSpeed());
		bus1.show();
		
		System.out.println("----------\n택시에 대해");
		taxi1.dispData();
		System.out.println(taxi1.getSpeed());
		
		System.out.println("=========주소 치환==========");
		Ex17PolyCar car2 = new Ex17PolyBus(); // 업캐스팅
		car2.dispData();
		//car2.show(); // 오버라이딩된 메소드만 가능( 자식 메소드 사용 불가 )
		System.out.println(car2.getSpeed());
		
		System.out.println();
		Ex17PolyCar car3 = taxi1; // 업캐스팅
		car3.dispData();
		System.out.println(car3.getSpeed());
		
		System.out.println("==========다형성===========");
		//Ex17PolyBus bus2 = new Ex17PolyCar(); // X
		Ex17PolyBus bus2 = (Ex17PolyBus)car2; // 다운캐스팅
		bus2.dispData();
		bus2.show();
		
		System.out.println();
		//Ex17PolyTaxi taxi2 = new Ex17PolyCar(); // X
		Ex17PolyTaxi taxi2 = (Ex17PolyTaxi)car3; // 다운캐스팅
		taxi2.dispData();
		
		//Ex17PolyTaxi taxi3 = (Ex17PolyTaxi)car1; // X (업캐스팅된 객체가 아니기 때문에)
		
		System.out.println("^^^^^^^^^^^");
		Ex17PolyCar p[] = new Ex17PolyCar[3]; // Car 타입의 배열 선언
		p[0] = car1;
		p[1] = bus1;
		p[2] = taxi1;
		p[0].dispData();
		p[1].dispData();
		p[2].dispData();
		
		System.out.println();
		for(int i=0; i < p.length; i++) {
			p[i].dispData();
		}
		
		System.out.println();
		for(Ex17PolyCar car:p) {
			car.dispData();
		}
	}
}
