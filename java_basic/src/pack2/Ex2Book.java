package pack2;

public class Ex2Book {
	String title;
	String author;
	boolean isAvailable;
	
	public Ex2Book() {
		title = "소년이 온다";
		author = "한강";
		isAvailable = true;
	}
	
	public void borrow(String t) {
		title = t;
		if (t == "소년이 온다") {
			isAvailable = false;
			System.out.println("대출 성공");
		}else {
			System.out.println("대출 실패");
		}
	}
	
	public void returnBook() {
		isAvailable = true;
		System.out.println("책 반납 완료");
	}

	public void printBookInfo() {
		System.out.println("책 제목: [" + title + "], 저자: [" + author + "], 대출 가능: [" + isAvailable + "]");
	}
}
