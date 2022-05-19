package dao.test;

import java.util.List;

import dao.BookDao;
import vo.BookVo;

public class BookDaoTest {

	public static void main(String[] args) {
		insertTest();
		findAllTest();		
	}

	private static void findAllTest() {
		List<BookVo> list = new BookDao().findAll();
		for(BookVo vo : list) {
			System.out.println("no: " + vo.getNo() + " Title: " + vo.getTitle() + 
					" Price: "+ vo.getPrice() + " CategoryNo: " + vo.getCategory_name());
		}
		
	}

	private static void insertTest() {
		BookVo vo = new BookVo();
		
		vo.setTitle("우리가 다리를 건널때");
		vo.setPrice("12600");
		vo.setCategory_no(1);
		boolean result = BookDao.insert(vo);
		
		vo.setTitle("기분을 관리하면 인생이 관리된다");
		vo.setPrice("17600");
		vo.setCategory_no(2);
		result = BookDao.insert(vo);
		
		if(result) {
			System.out.println("성공");
		}else {
			System.out.println("실패");
		}
	}

}
