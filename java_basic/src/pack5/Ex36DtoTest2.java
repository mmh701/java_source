package pack5;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex36DtoTest2 {
	private ArrayList<Ex36StudDto> list = new ArrayList<Ex36StudDto>();
	
	public void insertData() {
		while(true){
		Scanner sc = new Scanner(System.in);
		System.out.print("이름 입력: ");
		String name = sc.nextLine();
		System.out.print("국어 점수: ");
		int kor = sc.nextInt();
		System.out.print("영어 점수: ");
		int eng = sc.nextInt();
		
		Ex36StudDto student = new Ex36StudDto(); // Dto 객체 초기화
		student.setName(name);
		student.setKor(kor);
		student.setEng(eng);
		list.add(student);
		
		sc.nextLine();
		System.out.print("계속 할까요(y/n)? ");
		String yn = sc.nextLine();
		if(!yn.equals("y")) { break; }
		}
	}
	
	public void showData() {
		for(Ex36StudDto st:list) {
			System.out.println(st.getName() + "\t" + st.getKor() + "\t"  + st.getEng() + "\t" + (st.getKor()+st.getEng()));
		}
		System.out.println("응시인원: " + list.size() +"명");
	}
	
	public static void main(String[] args) {
		Ex36DtoTest2 test2 = new Ex36DtoTest2();
		test2.insertData();
		System.out.println("이름\t국어\t영어\t총점");
		test2.showData();
		
	}
}
