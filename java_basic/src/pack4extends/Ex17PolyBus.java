package pack4extends;

public class Ex17PolyBus extends Ex17PolyCar {
	private int passenger = 10;
	
	public Ex17PolyBus() {
		System.out.println("난 Car의 자식인 Bus 생성자야");
	}
	
	@Override
	public void dispData() {
		System.out.println("버스 승객 수: " + passenger);
		System.out.println("버스 속도는 " + speed);
	}
	
	public void show() {
		System.out.println("버스 고유 메서드 show");
	}
	
}
