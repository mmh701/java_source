package pack2;

public class Ex2Programmer {
	public String nickName; // 초기값이 없으면 참조형이므로 null
	private int age; // 초기값이 없으면 0.은닉화된 필드(멤버변수, 전역변수)
	String spec = "정보처리 자격증";
	
	public static String motto = "자바에 아름답게 미치자"; // static -> 정적 필드. static 영역에 저장
	public final double WEIGHT = 66.78; // final 멤버필드는 값 수정 불가. 이름은 대문자로만 쓰기 권장
	public static final double PI = 3.14; // 정적 필드이고 수정 불가
	
	public Ex2Programmer() {
		// 생성자는 내용이 없는 경우 생략 가능(자동 생성)
		System.out.println("난 생성자야. 객체 생성시 1회만 호출 가능");
		nickName = "에러잡는 귀신";
		int number = 20; //지역변수(메소드 내에서 선언한 변수는 메소드 내에서만 유효)
		age = number + 5;
		
	}
	
	public void displayData() {
		System.out.println("-------------------------");
		String mySpec = responseSpec(); // 메소드가 다른 메소드 호출
		System.out.println(mySpec);
		//System.out.println(responseSpec());
		System.out.println("별명: "+ nickName + "\n나이: " + age);
		System.out.println("-------------------------");
	}
	
	private String responseSpec() {
		return "내가 가진 기술은 " + spec;
	}
	
	// private 멤버 외부에서 제어하기 위한 public 메소드 작성. 캡슐화
	public int getAge() { // 메소드 이름은 약속. get멤버변수(첫글자는 대문자) <== getter
		return age; // age 변수 자체를 반환하는 것이 아니라 age에 기억된 정수를 반환
	}
		
	public void setAge(int age) { // 메소드 이름은 약속. set멤버변수(첫글자는 대문자) <== setter
		this.age = age;
	}
	
	public void setAgeEx(int age, int password) { // 메소드 이름은 약속. set멤버변수(첫글자는 대문자) <== setter
		if(password == 123) {
			this.age = age;
			System.out.println("age 수정 성공");
			displayData();
		}else {
			System.out.println("비밀번호가 틀립니다(age 수정 불가)");
		}
	}
}
