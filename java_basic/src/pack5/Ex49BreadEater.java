package pack5;

public class Ex49BreadEater extends Thread {
	private Ex49DBreadPlate breadPlate;

	public Ex49BreadEater(Ex49DBreadPlate breadPlate) {
		this.breadPlate = breadPlate;
	}

	@Override
	public void run() {
		for (int i = 0; i < 30; i++) { // 하루에 빵 생산 30개만
			breadPlate.eatBread();
		}
	}
}
