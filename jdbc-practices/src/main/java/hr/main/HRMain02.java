package hr.main;

import java.util.List;
import java.util.Scanner;

import hr.dao.EmpolyeeDAO;
import hr.vo.EmpolyeesVo;

public class HRMain02 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("salary[min max]>");
		int minSalary = scanner.nextInt();
		int maxSalary = scanner.nextInt();
		
		
		List<EmpolyeesVo> list = new EmpolyeeDAO().findBySalary(minSalary, maxSalary);
		
		// no:firstName:lastName:salary
		// order : 큰순서 리미트
		for(EmpolyeesVo vo : list) {
			System.out.println(vo.getEmp_no() + ":" + vo.getFirstName() + ":" + vo.getLastName() + ":" + vo.getSalary());
		}
		
		scanner.close();

	}

}
