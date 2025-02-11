package pack5;

public class Ex49DBreadPlate {
	private int breadCount = 0; // 스레드 간 공유 자원

	public Ex49DBreadPlate() {
	}

	public synchronized void makeBread() {
		if (breadCount >= 10) {
			try {
				System.out.println("빵 생산 초과");
				this.wait(); // 활성화 상태인 스레드를 비활성화 상태로 전환
			} catch (InterruptedException e) {
			}
		}

		breadCount++; // 빵 생산
		System.out.println("빵을 만듦. 총 " + breadCount + "개");
		this.notify(); // 비활성화 상태인 스레드를 활성화 상태로 전환
	}

	public synchronized void eatBread() {
		if (breadCount < 1) {
			try {
				System.out.println("빵이 없어 기다림");
				this.wait();
			} catch (InterruptedException e) {
			}
		}
		breadCount--; // 빵 소비
		System.out.println("빵을 먹음. 총 " + breadCount + "개");
		this.notify();
	}
}
