package pack4extends;

public class Ex24FlyerAirplane implements Ex24Flyer{
	
	@Override
	public void fly() {
		System.out.println("날고 있는 비행기");
	}
	@Override
	public boolean isAnimal() {
		return false;
	}
}
