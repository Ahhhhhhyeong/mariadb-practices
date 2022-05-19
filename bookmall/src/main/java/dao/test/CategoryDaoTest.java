package dao.test;

import java.util.List;

import dao.CategoryDao;
import vo.CategoryVo;

public class CategoryDaoTest {

	public static void main(String[] args) {
		testInsert();
		testFindAll();
	}

	private static void testFindAll() {
		List<CategoryVo> list = new CategoryDao().findAll();
		for(CategoryVo vo : list) {
			System.out.println("no: " + vo.getNo() + " name: " + vo.getName());
		}
	}

	private static void testInsert() {
		CategoryVo vo = new CategoryVo();
		
		vo.setName("소설");
		boolean result = CategoryDao.insert(vo);
		
		vo.setName("수필");
		result = CategoryDao.insert(vo);
		
		vo.setName("인문");
		result = CategoryDao.insert(vo);	
		
		vo.setName("경제");
		result = CategoryDao.insert(vo);
		
		vo.setName("예술");
		result = CategoryDao.insert(vo);
		
		if(result) {
			System.out.println("성공");
		}else {
			System.out.println("실패");
		}
	}

}
