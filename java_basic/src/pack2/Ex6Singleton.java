package pack2;
// 싱글톤 패턴이란? 객체의 인스턴스를 한개만 생성되게 하는 패턴. 메모리 절약, 데이터 공유가 편리...
public class Ex6Singleton {
	int kor = 100;
	String name = "tom";
	
	public Ex6Singleton() {
		System.out.println("Ex6Singleton 생성자");
	}
	
	public void kbs() {
		System.out.println("kbs");
	}
	
	//싱글톤 디자인 패턴
	private static Ex6Singleton singleton = new Ex6Singleton();
	
	public static Ex6Singleton getInstance() {
		return singleton;
	}
	
}
