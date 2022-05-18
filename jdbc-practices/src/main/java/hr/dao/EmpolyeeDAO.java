package hr.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes.Name;

import hr.vo.EmpolyeesVo;

public class EmpolyeeDAO {

	public static void main(String[] args) {
		findByFirstNameOrLastName("A") ;
	}
	
	
	public static List<EmpolyeesVo> findByFirstNameOrLastName(String name) {
		List<EmpolyeesVo> result = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			//1. JDBC Driver 로딩 (JDBC Class 로딩: class loader)
			Class.forName("org.mariadb.jdbc.Driver");
			
			//2. 연결하기
			String url = "jdbc:mysql://192.168.10.41:3307/employees?charset=utf8";
			connection = DriverManager.getConnection(url, "hr", "hr");
			
			//3. SQL 준비
			String sql =
				" select  emp_no,first_name, last_name, date_format(hire_date, '%Y-%m-%d' )\r\n"
				+ "from employees  "
				+ "where first_name like ? "
				+ "   or last_name like ? "
				+ "order by hire_date limit 100";
			pstmt = connection.prepareStatement(sql);
			
			//4. Parameter Mapping
			pstmt.setString(1, "%" + name + "%");
			pstmt.setString(2, "%" + name + "%");
			
			//5. SQL 실행
			rs = pstmt.executeQuery();
			
			//6. 결과처리
			while(rs.next()) {
				Long no = rs.getLong(1);
				String firstname = rs.getString(2);
				String lastname = rs.getString(3);
				String hireDate = rs.getString(4);
				
				EmpolyeesVo vo = new EmpolyeesVo();
				vo.setEmp_no(no);
				vo.setFirstName(firstname);
				vo.setLastName(lastname);
				vo.setBirthday(hireDate);
				
				result.add(vo);
			}
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		} catch (SQLException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;		
	}


	public List<EmpolyeesVo> findBySalary(int minSalary, int maxSalary) {
		List<EmpolyeesVo> result = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			//1. JDBC Driver 로딩 (JDBC Class 로딩: class loader)
			Class.forName("org.mariadb.jdbc.Driver");
			
			//2. 연결하기
			String url = "jdbc:mysql://192.168.10.41:3307/employees?charset=utf8";
			connection = DriverManager.getConnection(url, "hr", "hr");
			
			//3. SQL 준비
			String sql =
				"select a.emp_no, a.first_name, a.last_name, b.salary\r\n"
				+ "  from employees a, salaries b "
				+ " where a.emp_no = b.emp_no "
				+ "  and b.salary between ? and ? "
				+ " order by salary desc";
			pstmt = connection.prepareStatement(sql);
			
			//4. Parameter Mapping
			pstmt.setLong(1,  minSalary);
			pstmt.setLong(2,  maxSalary);
			
			//5. SQL 실행
			rs = pstmt.executeQuery();
			
			//6. 결과처리
			while(rs.next()) {
				Long no = rs.getLong(1);
				String firstname = rs.getString(2);
				String lastname = rs.getString(3);
				Long salary = rs.getLong(4);
				
				EmpolyeesVo vo = new EmpolyeesVo();
				vo.setEmp_no(no);
				vo.setFirstName(firstname);
				vo.setLastName(lastname);
				vo.setSalary(Integer.parseInt(salary.toString()));
				
				result.add(vo);
			}
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		} catch (SQLException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;			
	}
}
