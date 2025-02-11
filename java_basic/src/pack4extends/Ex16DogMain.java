package pack4extends;

public class Ex16DogMain {
	public static void main(String[] args) {
		Ex16Dog dog = new Ex16Dog("개");
		dog.print();
		System.out.println(dog.callName());
		
		System.out.println();
		Ex16HouseDog houseDog = new Ex16HouseDog("집 개");
		houseDog.print();
		System.out.println(houseDog.callName());
		houseDog.show();
		
		System.out.println();
		Ex16WolfDog wolfDog = new Ex16WolfDog("늑대");
		wolfDog.print();
		System.out.println(wolfDog.callName());
		wolfDog.show();
		
		System.out.println();
		wolfDog.displayPrint();
		System.out.println("--------------");
		Ex16WolfDog bushdog = wolfDog; // 주소를 치환 ( 타입이 같은 경우 치환 성공 )
		wolfDog.print();
		bushdog.print();
		
		// promotion
		Ex16Dog dog2 = wolfDog; // 주소를 치환 ( 타입이 다른데도 불구하고 치환 성공 - 자식의 주소를 부모 객체변수에 주는 경우) - 업캐스팅 
		dog2.print(); // 오버라이딩된 메소드만 부모 객체변수명으로 호출 가능
		//dog2.show(); // 자식이 가진 고유 메소드는 부모 객체변수명으로 호출할 수 없다
		//Ex16WolfDog hidog = dog2; // Type mismatch: cannot convert from Ex16Dog to Ex16WolfDog
		Ex16WolfDog hidog = (Ex16WolfDog)dog2; // casting - 다운캐스팅
		hidog.print();
		
		System.out.println("-----3주차--------");
		Ex16Dog coyote = new Ex16Dog("코요태");			// 부모 클래스
		coyote.print();
		System.out.println(coyote.callName());
		Ex16WolfDog wolfDog2 = new Ex16WolfDog("늑대2");	// Dog의 자식 클래스
		wolfDog2.print();
		wolfDog2.show();
		
		coyote = wolfDog2; 	// promotion : 자식 객체 주소를 부모 객체변수에 지환
		coyote.print();		// 오버라이딩된 메소드 허용
		//coyote.show();	// 자식 고유 메소드는 호출 불가!
		coyote.getName();
		Ex16WolfDog wolfDog3 = null;
		//wolfDog3.show(); 	// java.lang.NullPoingterExeption;
		wolfDog3 = wolfDog2; 			// 타입이 같으므로 성공
		//wolfDog3 = houseDog;			// 타입이 다르므로 실패
		//wolfDog3 = coyote; 			// 타입이 다르므로 실패. 하지만 부모 타입인 coyote 변수는 자식의 주소를 기억 중.
		wolfDog3 = (Ex16WolfDog)coyote; // 그러므로 casting을 통해 치환할 수 있다
		wolfDog3.print();
	}																																																																																																																															
}
