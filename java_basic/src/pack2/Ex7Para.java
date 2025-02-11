package pack2;

//매개변수로 기본형 뿐만 아니라 참조형도 가능

class Person{ // 일반적으로 따로 파일을 작성해야 하지만 편의상 현재 클래스 파일과 같은 곳에 적음
	String name;
	int age;
	
	public Person(String name, int age){ // String name: 참조형, int age: 기본형
		this.name=name;
		this.age=age;
	}
}

class PersonService{
	public PersonService() {
		
	}
	
	public void changeName(Person person, String newName) {
		System.out.println("person 변수 기억 주소: " + person);
		person.name = newName;
	}
}


public class Ex7Para {
	
	
	public static void main(String[] args) {
		Person tom = new Person("한국인", 22);
		System.out.println("변경 전 이름: " + tom.name + " " + tom);
		System.out.println("tom 변수 기억 주소: " + tom);
		Person james;
		james = tom;
		System.out.println("james 변수 기억 주소: " + james);
		
		Person per = tom;
		System.out.println("per 변수 기억 주소: " + per);
		
		PersonService service = new PersonService();
		service.changeName(tom, "홍길동"); // person 변수가 가진 주소로 전달
		System.out.println("변경 후 이름: " + tom.name + " " + tom);
		
		
	}
}
