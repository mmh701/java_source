package pack2;

public class Ex2BookMain {

	public static void main(String[] args) {
		Ex2Book book = new Ex2Book();
		book.printBookInfo();
		book.borrow("소년이 온다");
		book.returnBook();

	}

}
