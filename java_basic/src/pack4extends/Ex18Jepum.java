package pack4extends;

// 전자 제품 부모 클래스 (추상)
abstract public class Ex18Jepum { // 전자 제품이 공통으로 가져야 할 멤버 선언
	public int volume = 0;
	
	public Ex18Jepum() {
		System.out.println("Jepum 추상 클래스 생성자");
	}
	
	abstract public void volumeControl(); // 추상메소드 { body } 가 없음 
	
	public void volumeShow() {
		System.out.println("소리 크기: " + volume);
	}
	
}
