package pack4extends;
// 상속 : 현재(자식) 클래스를 먼저 읽고 없으면 부모 클래스 읽음
public class Ex12Father extends Ex12GrandFa{
	private int nai = 50;
	public String gabo = "청자 비슷한 물병";
	private int house = 1;
	
	public Ex12Father() {
		super(); // 부모 생성자 호출
		System.out.println("아버지 생성자");
	}
	
	@Override // annotation (뭔가를 처리하는 기능)
	//재정의(부모 자식 같은 메소드있을때) - 생략가능 (매개변수 등 다른 점이 있을때는 지워야함)
	public int getNai() {
		// 메소드 오버라이딩 : 부모와 똑같은 메소드를 자식에서 만듦.
		int imsi = 0; //부모와 다른 코드를 적을 수 있다. 
		return nai;
	}
	
	@Override
	public void say() {
		String ss = "아버지 말씀: 풀스택 개발자로 고~";
		System.out.println(ss);
	}
	
	public int getHouse() {
		return house;
	}
	
	public void showData() {
		String gabo = "맥북";
		System.out.println(gabo); // 지역변수 -> 자식(멤버변수) -> 부모
		System.out.println(this.gabo); // 자식(멤버변수) -> 부모
		System.out.println(super.gabo); //부모
		
		say();
		this.say();
		super.say();
	}
}
