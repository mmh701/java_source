package pack2;

public class Ex2Main {
	public static void main(String[] args) {
		Ex2Programmer programmer1 = new Ex2Programmer();
		System.out.println("보유기술: "+ programmer1.spec);
		programmer1.displayData();
		programmer1.nickName = "웹 전문가"; // public 멤버필드이므로 외부에서 값을 수정
		programmer1.spec = "1종보통 운전면허"; // default 멤버필드이므로 외부에서 값을 수정
		programmer1.displayData();
		
		//캡슐화된 멤버를 해당 클래스 밖에서 제어하기
		//programmer1.age; //접근 불가
		int nai = programmer1.getAge(); // public 메소드이므로 접근 가능
		System.out.println("programmer1 객체의 age: " + nai);
		
		programmer1.setAge(33); // publlic 메소드를 만들때 setter를 이용해 private 월드 값을 전달
		System.out.println("programmer1 객체 age: " + programmer1.getAge());
		programmer1.displayData();
		programmer1.setAgeEx(55, 123);
		System.out.println();
		
		System.out.println("static, final 관련---------");
		System.out.println("motto: " + programmer1.motto);
		System.out.println("motto: " + Ex2Programmer.motto);// static 사용시 클래스 이름으로 바로 접근 가능
		//programmer1.WEIGHT = 77.8; // final 시 수정 불가
		System.out.println("WEIGHT: " + programmer1.WEIGHT);
		System.out.println("PI: " + Ex2Programmer.PI);
		
		System.out.println("\n====================================");
		Ex2Programmer programmer2 = new Ex2Programmer();
		programmer2.displayData();
		
		System.out.println("객체 변수가 참조하는 주소에 대해(참고)...");
		System.out.println(programmer1 + " " +  programmer2); //.toString 생략가능
		System.out.println(programmer1.hashCode() + " " +  programmer2.hashCode());
		
		System.out.println("--전문가가 만든 클래스 경험------------");
		System.out.println(Integer.MAX_VALUE);
		
	}
}
