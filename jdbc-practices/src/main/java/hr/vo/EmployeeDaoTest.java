package hr.vo;

import java.util.List;

import hr.dao.EmpolyeeDAO;

public class EmployeeDaoTest {

	public static void main(String[] args) {
		testFindByFirstNameOrLastName("ken");
	}
	public static void testFindByFirstNameOrLastName(String name) {
		List<EmpolyeesVo> list = new EmpolyeeDAO().findByFirstNameOrLastName(name);
		for(EmpolyeesVo vo :list) {
			System.out.println(vo);
		}
	}

}
