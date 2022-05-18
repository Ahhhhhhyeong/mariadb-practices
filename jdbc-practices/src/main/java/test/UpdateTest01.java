package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.jar.Attributes.Name;

public class UpdateTest01 {

	public static void main(String[] args) {
		//update(9L, "자료1");
		DepartmentVO vo = new DepartmentVO();
		vo.setNo(4L);
		vo.setName("전략기획팀");
		update(vo);
	}

	private static boolean 	 update(DepartmentVO vo) {
		boolean result = false;
		Connection connection = null;
		Statement stat = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver"); // static에서 커넥션을 만듦
						
			// 2. 연결하기
			String url = "jdbc:mysql://127.0.0.1:3307/webdb?charset=utf8";
			connection = DriverManager.getConnection(url, "webdb", "webdb");

			// 3. Statement 생성
			stat = connection.createStatement();
				
			// 4. SQL 실행
			String sql = "update department set "
					+ "name =  '" + vo.getName() +"' "
					+ "where no = " + vo.getNo() + "";
			int count = stat.executeUpdate(sql);					
			result = count == 1;
		} catch (ClassNotFoundException e) {
			System.out.println("---FAIL---Driver Load " + e);
		}catch (SQLException e) {
			System.out.println("---FAIL---Driver Connected " + e);
		}finally {			
			try {
				if(stat != null) {
					stat.close();
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
