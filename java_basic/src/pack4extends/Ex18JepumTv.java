package pack4extends;

public class Ex18JepumTv extends Ex18Jepum {
	public Ex18JepumTv() {
		System.out.println("TV 생성자");
	}

	@Override
	public void volumeControl() {
		// 메소드 오버라이딩 강요당함
		System.out.println("TV 소리 조절");
	}

	
	
}