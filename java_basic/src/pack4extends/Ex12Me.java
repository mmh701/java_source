package pack4extends;
//다중상속 X (부모 - 자식1,2 O) (부모1,2 - 자식 X)
//할아버지 - 아버지 - 자식 (자식 -> 할아버지)로 바로 연결 불가
public final class Ex12Me extends Ex12Father{ // Me는 자식 클래스 생성 불가(final)
	private final int nai = 20;  //(final) 시 수정 불가
	public Ex12Me() {
		System.out.println("내 생성자");
	}	
	@Override
	public void say() {
		System.out.println("인생은 아름다워~~");
	}
	
	public final void Biking() { //Me의 자식 클래스는 Biking() Override 불가(final)
		System.out.println("자전거로 전국일주");
	}
	
	@Override
	public int getNai() {
		return nai;
	}
}
