package dao.test;

import java.util.List;

import dao.OrderDao;
import vo.OrderVo;

public class OrderDaoTest {

	public static void main(String[] args) {
//		insertTest();
//		insertOrderBookTest();
		findAllTest();
	}


	private static void insertOrderBookTest() {
		OrderVo vo = new OrderVo();
		vo.setBook_no(2);
		vo.setNo(1);
		vo.setAmount("2");
		OrderDao.insertOrderBook(vo);
	}


	private static void findAllTest() {
		List<OrderVo> list = new OrderDao().findAll();
		for(OrderVo vo : list) {
			System.out.println(vo.getNo() + ", " + vo.getBook_title() + ", " + vo.getAmount() + ", " + vo.getPrice());
		}	
	}

	private static void insertTest() {
		OrderVo vo = new OrderVo();
		vo.setPrice("35200");
		vo.setShip("베이커가");
		vo.setMember_no(2);
		boolean result = OrderDao.insert(vo);
		
		if(result) {
			System.out.println("성공");
		}else {
			System.out.println("실패");
		}
	}
	
	

}
