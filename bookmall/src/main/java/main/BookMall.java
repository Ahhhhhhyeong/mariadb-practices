package main;

import java.util.List;

import dao.BookDao;
import dao.CartDao;
import dao.CategoryDao;
import dao.MemberDao;
import dao.OrderDao;
import vo.BookVo;
import vo.CartVo;
import vo.CategoryVo;
import vo.MemberVo;
import vo.OrderVo;

public class BookMall {

	public static void main(String[] args) {
		categoryInput();
		bookInput();
		memberInput();
		cartInput();
		OrderInsert();
	}

	private static void OrderInsert() {
		OrderVo vo = new OrderVo();
		vo.setPrice("30000");
		vo.setShip("베이커가");
		vo.setMember_no(5);
		OrderDao.insert(vo);
		
		OrderVo Ovo = new OrderVo();
		Ovo.setBook_no(5);
		Ovo.setNo(3);
		Ovo.setAmount("1");
		OrderDao.insertOrderBook(Ovo);
		
		List<OrderVo> list = new OrderDao().findAll();
		for(OrderVo orderVo : list) {
			System.out.println(orderVo.getNo() + ", " + orderVo.getBook_title() + ", " + orderVo.getAmount() + ", " + orderVo.getPrice());
		}
		
	}

	private static void cartInput() {
		CartVo vo = new CartVo();
		
		vo.setBook_no(4);
		vo.setMember_no(2);
		vo.setAmount(3);
		CartDao.insert(vo);
		
		// Cart 내용 출력
		List<CartVo> list = new CartDao().findAll();
		for(CartVo cvo : list) {
			System.out.println(cvo.getMember_name() + ", " + cvo.getBook_title() + ", " + cvo.getAmount());
		}	
		System.out.println("==================================");
	}

	private static void memberInput() {
		MemberVo vo = new MemberVo();
		vo.setName("베지터");
		vo.setTel("01077778888");
		vo.setEmail("vegeta@gmail.com");
		vo.setPassword("1234");
		MemberDao.insert(vo);
		
		
		// member 목룍 보여주기
		List<MemberVo> list = new MemberDao().findAll();
		for(MemberVo mvo : list) {
			System.out.println(mvo.getName() + ", " + mvo.getEmail());
		}
		System.out.println("==================================");
	}

	private static void bookInput() {
		BookVo vo = new BookVo();
		vo.setTitle("부의 변곡점");
		vo.setPrice("15800");
		vo.setCategory_no(4);
		BookDao.insert(vo);
		
		// 책 목록 보여주기
		List<BookVo> list = new BookDao().findAll();
		for(BookVo bvo : list) {
			System.out.println(bvo.getNo() + ". " + bvo.getTitle() + 
					", "+ bvo.getPrice() + ", " + bvo.getCategory_name());
		}
		System.out.println("==================================");
	}

	private static void categoryInput() {
		CategoryVo vo = new CategoryVo();
		
		vo.setName("종교");
		CategoryDao.insert(vo);		
		
		// 카테고리 목록 보여주기
		List<CategoryVo> list = new CategoryDao().findAll();		
		for(CategoryVo cVo : list) {
			System.out.println(cVo .getNo() + ". " + cVo .getName());
		}
		System.out.println("==================================");			
	}

}
