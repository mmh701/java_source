package pack4extends;

public class Ex24FlyerBird implements Ex24Flyer{
	
	@Override
	public void fly() {
		System.out.println("날고 있는 새");
	}
	@Override
	public boolean isAnimal() {
		return false;
	}
}
