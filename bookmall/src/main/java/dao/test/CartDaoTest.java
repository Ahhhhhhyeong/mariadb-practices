package dao.test;

import java.util.List;

import dao.CartDao;
import vo.CartVo;

public class CartDaoTest {

	public static void main(String[] args) {
		insertTest();
		findAllTest();
	}

	private static void findAllTest() {
		List<CartVo> list = new CartDao().findAll();
		for(CartVo vo : list) {
			System.out.println(vo.getMember_name() + ", " + vo.getBook_title() + ", " + vo.getAmount());
		}		
	}

	private static void insertTest() {
		CartVo vo = new CartVo();
		
		vo.setBook_no(1);
		vo.setMember_no(1);
		vo.setAmount(2);
		boolean result = CartDao.insert(vo);
		
		if(result) {
			System.out.println("성공");
		}else {
			System.out.println("실패");
		}
		
	}

}
