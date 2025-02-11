package pack3;

import java.util.Scanner;

public class Ex10MachineUse {
	
	public static void main(String[] args) {
		Ex10CoinIn coinIn = new Ex10CoinIn();
		Scanner sc = new Scanner(System.in);
		System.out.print("동전을 입력하세요: ");
		int coin = sc.nextInt();
		System.out.print("몇 잔을 원하세요: ");
		int cupCount = sc.nextInt();
		coinIn.calc(coin,cupCount);
		
	}
}
