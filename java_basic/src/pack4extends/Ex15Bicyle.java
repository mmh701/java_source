package pack4extends;

public class Ex15Bicyle extends Ex15Vehicle{
	
	private int gearCount;
	
	public Ex15Bicyle(String brand, int speed, int gearCount) {
		super(brand, speed);
		this.gearCount = gearCount;
	}
	
	@Override
	public void describe() {
		System.out.println("This is a bicycle of brand " + brand + " with " + gearCount + " gears");
	}
	

}
