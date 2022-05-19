package bookshop.dao.test;

import java.util.List;

import bookshop.dao.BookDao;
import bookshop.vo.BookVo;

public class BookDaoTest {

	public static void main(String[] args) {
		testUpdate();
	}
	
	private static int testFindAll() {
		List<BookVo> list = new BookDao().findAll();	
		for(BookVo vo : list) {
			System.out.println();
		}
		return list.size();
	}

	public static void testInsert() {			
		BookVo vo = new BookVo();		
		
		vo.setTitle("트와일라잇");
		vo.setAuthoNo(7L);
		vo.setStateCode("재고있음");
		BookDao.insert(vo);		
		
		vo.setTitle("뉴문");
		vo.setAuthoNo(7L);
		vo.setStateCode("재고있음");
		BookDao.insert(vo);
		
		vo.setTitle("이클립스");
		vo.setAuthoNo(7L);
		vo.setStateCode("재고있음");
		BookDao.insert(vo);
		
		vo.setTitle("브레이킹던");
		vo.setAuthoNo(7L);
		vo.setStateCode("재고있음");
		BookDao.insert(vo);
		
		vo.setTitle("아리랑");
		vo.setAuthoNo(1L);
		vo.setStateCode("재고있음");
		BookDao.insert(vo);
		
		vo.setTitle("젊은그들");
		vo.setAuthoNo(2L);
		vo.setStateCode("재고있음");
		BookDao.insert(vo);
		
		vo.setTitle("아프니깐 청춘이다");
		vo.setAuthoNo(3L);
		vo.setStateCode("재고있음");
		BookDao.insert(vo);
		
		vo.setTitle("귀천");
		vo.setAuthoNo(4L);
		vo.setStateCode("재고있음");
		BookDao.insert(vo);
		
		vo.setTitle("태백산맥");
		vo.setAuthoNo(1L);
		vo.setStateCode("재고있음");
		BookDao.insert(vo);
		
		vo.setTitle("풀하우스");
		vo.setAuthoNo(5L);
		vo.setStateCode("재고있음");
		BookDao.insert(vo);	
	}
	
	private static void testUpdate() {
		BookVo vo = new BookVo();
		vo.setNo(4L);
		vo.setStateCode("대여중");
		
		BookDao dao = new BookDao();
		
		dao.update(vo);
		
		// test 성공 여부
		vo = dao.findByNo(4L);
		if("대여중".equals(vo.getStateCode())){
			System.out.println("OK");
		}
	}

}
