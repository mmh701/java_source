package pack5;

import java.util.ArrayList;
import java.util.List;

// List: 이름과 같이 목록처럼 데이터를 순서에 따라 관리, 중복 허용
public class Ex34List {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("볼펜");
		list.add("연필");
		list.add("볼펜");
		list.add("볼펜");
		list.add("마우스");
		System.out.println("list 크기: " + list.size());
		list.remove("볼펜"); // 중복 시 리스트 순서대로 지움
		list.remove(1);	// 리스트 순서의 번호 위치에 해당하는 항목 지움
		System.out.println("list 크기: " + list.size());
		System.out.println("list의 0번째는 " + list.get(0));
		
		System.out.println();
		
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		System.out.println();
		
		for(String data:list) {
			System.out.println(data);
		}
		
	}
}
