package pack3;

public class Ex10CoinIn {
	private int coin;
	private int jandon;
	
	public Ex10CoinIn() {
		Ex10Machine machine = new Ex10Machine();
		machine.showData();
	}
	
	void calc(int coin,int cupCount) {
		if (coin >= cupCount*200) {
			jandon = coin - cupCount*200;
			System.out.println("커피 "+ cupCount +"잔과 잔돈 " + jandon + "원");
		}else if (coin < cupCount*200) {
			System.out.println("요금이 부족합니다");
		}
	}
}
