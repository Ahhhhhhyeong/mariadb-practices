package hr.vo;

import java.util.List;

import hr.dao.EmpolyeeDAO;

public class SalaryDaoTest {

	public static void main(String[] args) {
		findBySalaryTest(46872, 47895);
	}
	
	public static void findBySalaryTest(int min, int max) {
		List<EmpolyeesVo> list = new EmpolyeeDAO().findBySalary(min, max);
		for(EmpolyeesVo vo : list) {
			System.out.println(vo);
		}
	}

}
