package pack5;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Ex38WorkMain {
	private ArrayList<Ex38WorkDto> list = new ArrayList<Ex38WorkDto>();
	LocalDate now = LocalDate.now();
	
	private void insertData(String[] datas) {
		for(String a:datas) {
			StringTokenizer tok = new StringTokenizer(a,",");
			int num = Integer.parseInt(tok.nextToken());
			String name = tok.nextToken();
			int money = Integer.parseInt(tok.nextToken());
			int year = Integer.parseInt(tok.nextToken());
			
			Ex38WorkDto work = new Ex38WorkDto(num, name, money, year);
			list.add(work);
		}
	}
	
	private void showData() {
		System.out.println("사번\t이름\t기본급\t근무년수\t근속수당\t공제액\t수령액");
		for(Ex38WorkDto w:list) {
			int nowyear = now.getYear();
			int year = nowyear - w.getYear();
			int allowance;
			if(year>=9) {
				allowance = 1000000;
			}else if(year>=4) {
				allowance = 450000;
			}else {
				allowance = 150000;
			}
			
			int m = w.getMoney() + allowance;
			double d;
			if(m>=3000000) {
				d=m*0.005;
			}else if(m>=2000000) {
				d=m*0.003;
			}else {
				d=m*0.0015;
			}
			
			double s = m-d;
			
			System.out.println(w.getNum()+"\t"+w.getName()+"\t"+w.getMoney()+"\t"+year+"\t"+allowance+"\t"+d+"\t"+s);
		}
		System.out.println("\n처리 건수: " + list.size() + "건");
	}
	
	public static void main(String[] args) {
		String[] datas = new String[3];
		datas[0] = "1,강나루,1500000,2005";
		datas[1] = "2,홍길동,1200000,2020";
		datas[2] = "3,이순신,1000000,2023";
		
		Ex38WorkMain wm = new Ex38WorkMain();
		wm.insertData(datas);
		wm.showData();
	}
}
