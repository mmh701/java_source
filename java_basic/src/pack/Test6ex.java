package pack;

import java.util.Scanner;

public class Test6ex {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String sang = "";
		int su = 0;
		double dan, kum, sekum = 0; 
		
		System.out.print("상품명 : ");
		sang = sc.nextLine();
		System.out.print("수량 : ");
		su = sc.nextInt();
		System.out.print("단가 : ");
		dan = sc.nextDouble();
		
		kum = su * dan;
		if (kum >= 50000) {
			sekum = kum / 10;
			
		}
		else if (kum >= 30000) {
			sekum = kum / 20;
			
		}
		else {
			sekum = kum * 3/100;
		}
			
		System.out.println("금액 : " + kum + " 세금 : " + sekum);
	}

}
