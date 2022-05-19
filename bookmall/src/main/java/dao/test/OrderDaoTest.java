package dao.test;

import java.util.List;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

import dao.OrderDao;
import vo.OrderVo;

public class OrderDaoTest {
	// 현재 날짜 구하기
	static LocalDate now = LocalDate.now();
	// 포맷 정의
	static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
	// 포맷 적용
	private static String formatedNow = now.format(formatter);
	
	public static void main(String[] args) {
		insertTest();
		insertOrderBookTest();
		findAllTest();
	}


	private static void insertOrderBookTest() {				
		OrderVo vo = new OrderVo();
		vo.setBook_no(1);
		vo.setNo(formatedNow + "-" + "0001");
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
		// 현재 날짜 구하기
		LocalDate now = LocalDate.now();
		// 포맷 정의
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
		// 포맷 적용
		String formatedNow = now.format(formatter);
		
		OrderVo vo = new OrderVo();
		vo.setNo(formatedNow + "-" + "0001");
		vo.setPrice("35200");
		vo.setShip("베이커가");
		vo.setMember_no(1);
		boolean result = OrderDao.insert(vo);
		
		if(result) {
			System.out.println("성공");
		}else {
			System.out.println("실패");
		}
	}
	
	

}
