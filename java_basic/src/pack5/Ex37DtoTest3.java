package pack5;

import java.util.ArrayList;
import java.util.StringTokenizer;

// 여러 개의 필드로 구성된 데이터가 문자열로 입력될 경우 필드별 문자 분리 후 레코드 처리
// 조건 : 문자열은 콤마(,) 등의 구분자로 구별되어 있다
// 출력은 이름 총점 평균
public class Ex37DtoTest3 {
	private ArrayList<Ex37HaksaengDto> list = new ArrayList<Ex37HaksaengDto>();

//	private void stringSplitTest() {
//		String imsi = "kbs,mbs,sbs";
//		StringTokenizer tokenizer = new StringTokenizer(imsi,",");
//		String s1 = tokenizer.nextToken();
//		String s2 = tokenizer.nextToken();
//		String s3 = tokenizer.nextToken();
//		System.out.println(s1 + " " + s2 + " " + s3);
//	}
	
	private void insertData(String[] datas) {
		//System.out.println(datas.length);
		for(int i=0; i < datas.length; i++) {
			StringTokenizer tok = new StringTokenizer(datas[i],",");
			String irum = tok.nextToken();
			int kor =Integer.parseInt(tok.nextToken());
			int eng =Integer.parseInt(tok.nextToken());
			int mat =Integer.parseInt(tok.nextToken());
			
			Ex37HaksaengDto dto = new Ex37HaksaengDto(irum, kor, eng, mat); // 생성자로 값 입력
			list.add(dto);
			
		}
	}

	private void showData() {
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
		for (Ex37HaksaengDto h:list) {
			int sum = h.getKor() + h.getEng() + h.getMat();
			double avg = sum/3.0;
			System.out.println(h.getName() + "\t" + h.getKor() + "\t" + h.getEng() + "\t" + h.getMat() + "\t" + sum + "\t" + avg);
		}
	}

	public static void main(String[] args) {
		
		String[] datas = new String[3];
		datas[0] = "김밥,100,100,100";
		datas[1] = "공기밥,90,78,77";
		datas[2] = "주먹밥,70,70,88";

		Ex37DtoTest3 test3 = new Ex37DtoTest3();
		// 참고 : 문자열 분리 클래스 경험하기
		test3.insertData(datas);
		test3.showData();

	}
}
