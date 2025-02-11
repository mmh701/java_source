package pack4extends;

// Adapter class 는 특정 인터페이스의 추상 메소드를 일반 메소드로 오버라이딩한 추상 클래스이다
// 인터페이스의 추상 메소드를  implements 한 자식 클래스는 메소드 모두를 오버라이딩해야 하는 부담이 있다
// 이를 개선하기 위한 목적으로 Adapter class 를 사용할 수 있다
public abstract class Ex25FlyerAdapter implements Ex24Flyer{
	
	@Override
	public void fly() {

	}
	@Override
	public boolean isAnimal() {
		return false;
	}
}
