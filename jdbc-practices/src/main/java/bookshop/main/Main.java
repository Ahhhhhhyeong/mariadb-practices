package bookshop.main;

import java.util.List;
import java.util.Scanner;

import bookshop.dao.BookDao;
import bookshop.vo.BookVo;

public class Main {

	public static void main(String[] args) {
		displayBookInfo();

		Scanner scanner = new Scanner(System.in);
		System.out.print("대여 하고 싶은 책의 번호를 입력하세요:");
		int no = scanner.nextInt();
		scanner.close();
		
		new BookDao().update(no);

		 System.out.println("*****도서 정보 출력하기******");
		 displayBookInfo();
	}
	private static void displayBookInfo() {
		List<BookVo> list = new BookDao().findAll();
		for(BookVo vo : list) {
			System.out.println("책번호:" + vo.getNo()
					+ " 책제목: " +vo.getTitle()
					+", 작가: " + vo.getName() 
					+", 대여 유무: " + vo.getStateCode());	
		}
		
	}
}
