package bookshop.dao.test;

import java.util.List;

import bookshop.dao.BookDao;
import bookshop.vo.BookVo;

public class BookDaoTest {

	public static void main(String[] args) {
		BookVo vo = new BookVo();
		
		vo.setTitle("트와일라잇");
		vo.setAuthoNo(1L);
		vo.setStateCode("재고있음");
		testInsert(vo);
		
		vo.setTitle("뉴문");
		vo.setAuthoNo(1L);
		vo.setStateCode("재고있음");
		testInsert(vo);
		
		vo.setTitle("이클립스");
		vo.setAuthoNo(1L);
		vo.setStateCode("재고있음");
		testInsert(vo);
		
		vo.setTitle("브레이킹던");
		vo.setAuthoNo(1L);
		vo.setStateCode("재고있음");
		testInsert(vo);
		
		vo.setTitle("아리랑");
		vo.setAuthoNo(2L);
		vo.setStateCode("재고있음");
		testInsert(vo);
		
		vo.setTitle("젊은그들");
		vo.setAuthoNo(3L);
		vo.setStateCode("재고있음");
		testInsert(vo);
		
		vo.setTitle("아프니깐 청춘이다");
		vo.setAuthoNo(4L);
		vo.setStateCode("재고있음");
		testInsert(vo);
		
		vo.setTitle("귀천");
		vo.setAuthoNo(5L);
		vo.setStateCode("재고있음");
		testInsert(vo);
		
		vo.setTitle("태백산맥");
		vo.setAuthoNo(2L);
		vo.setStateCode("재고있음");
		testInsert(vo);
		
		vo.setTitle("풀하우스");
		vo.setAuthoNo(6L);
		vo.setStateCode("재고있음");
		testInsert(vo);
				
		int count = testFindAll();
		if(count == 10) {
			System.out.println("성공");
		}else {
			System.out.println("실패");
		}
	}
	
	private static int testFindAll() {
		List<BookVo> list = new BookDao().findAll();	
		for(BookVo vo : list) {
			System.out.println();
		}
		return list.size();
	}

	public static void testInsert(BookVo vo) {		 
		new BookDao().insert(vo);
	}

}
