package pack2;

public class Ex2Student {
	private String name;
	private int grade;
	private double score;

	public Ex2Student(String name, int grade, double score) { // 매개변수는 지역변수
		this.name = "홍길동"; // 값 고정
		this.grade = 2;
		this.score = 88.4;
		
		this.name = name; // 생성자를 호출하며 값을 줄 수 있음
		this.grade = grade;
		this.score = score;
	}
	public void printSudentInfo() {
		//String name = "하하";//변수명이 같을 때 지역변수로 출력함. this.name으로 해야 생성자 값 읽음 
		System.out.println("이름: [" + name + "], 학년: [" + grade + "]학년, 평균 점수: [" + score + "]");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public void setScore(double score) {
		this.score = score;
	}
	// main메소드는 프로그램을 실행하기 위한 메소드. Ex2Student 멤버는 아님
	public static void main(String[] args) {
		Ex2Student student = new Ex2Student("제임스", 2, 90);
		student.printSudentInfo();
		
		System.out.println();
		Ex2Student student2 = new Ex2Student("홍길동", 3, 85.5);
		student2.printSudentInfo();
		student2.setScore(66.8);
		student2.printSudentInfo();

	}

}
