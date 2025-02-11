package pack2;

public class Ex4Exam2 {
	
	private String name;
	private int age;
	
	public Ex4Exam2() {
		
	}
	
	public void printAge(String name, int age) {
		this.name=name;
		this.age=age;
		System.out.println("이름은 " + name + ", 나이는 " + age + "살입니다.");
	}
	public void printAge(String name) {
		this.name=name;
		System.out.println("이름은 " + name + ", 나이는 알 수 없습니다.");
	}
	public void printAge() {
		System.out.println("이름과 나이가 모두 없습니다.");
	}
	
	
	public static void main(String[] args) {
		Ex4Exam2 exam2 = new Ex4Exam2();
		exam2.printAge("홍길동",20);
		exam2.printAge("홍길동");
		exam2.printAge();
	}
}
