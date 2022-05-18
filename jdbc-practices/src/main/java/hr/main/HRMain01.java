package hr.main;

import java.util.List;
import java.util.Scanner;

import hr.dao.EmpolyeeDAO;
import hr.vo.EmpolyeesVo;

public class HRMain01 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("이름>");
		String name = scanner.nextLine();
		
		EmpolyeeDAO dao = new EmpolyeeDAO();
		List<EmpolyeesVo> list = dao.findByFirstNameOrLastName(name);
		
		for(EmpolyeesVo vo : list) {
			System.out.println(vo.getEmp_no() + ":" + vo.getFirstName() + ":" + vo.getLastName() + ":" + vo.getBirthday());	
		}
		
		scanner.close();

	}

}
