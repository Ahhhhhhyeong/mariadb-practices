package dao.test;

import java.util.List;

import dao.MemberDao;
import vo.MemberVo;

public class MemberDaoTest {

	public static void main(String[] args) {
		insertTest();
		findAllTest();
	}

	private static void findAllTest() {
		List<MemberVo> list = new MemberDao().findAll();
		for(MemberVo vo : list) {
			System.out.println(vo.getName() + ", " + vo.getEmail());
		}
		
	}

	private static void insertTest() {
		MemberVo vo = new MemberVo();
		
		vo.setName("코난");
		vo.setTel("01011112222");
		vo.setEmail("conan@gmail.com");
		vo.setPassword("1234");
		boolean result = MemberDao.insert(vo);
				
		
		if(result) {
			System.out.println("성공");
		}else {
			System.out.println("실패");
		}
		
	}

}
