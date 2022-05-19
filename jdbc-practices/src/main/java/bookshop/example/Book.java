package bookshop.example;

public class Book {
	private int bookNo;
	private String title;
	private String author;
	private int stateCode; // 0: 대여중 1: 재고있음
	
	public Book(int bookNo, String title, String author) {
		this.bookNo = bookNo;
		this.title = title;
		this.author = author;
		this.stateCode = 1;
	}

	public void print() {
		// println에서 삼항연산자 에러가 계속떠서 따로 뺌
		String state = (stateCode == 0) ? "대여중" : "재고있음"; 
		System.out.println("책제목: " +title
				+", 작가: " + author 
				+", 대여 유무: " + state);		
	}
	
	public void rent() {
		this.stateCode = 0;
		System.out.println(title + "이(가) 대여 됐습니다");
	}

	public int getBookNo() {
		return bookNo;
	}

	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}


	
	

}
