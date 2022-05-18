package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.jar.Attributes.Name;

public class UpdateTest02 {

	public static void main(String[] args) {
		//update(9L, "자료1");
		DepartmentVO vo = new DepartmentVO();
		vo.setNo(10L);
		vo.setName("전략기획팀");
		update(vo);
	}

	private static boolean update(DepartmentVO vo) {
		boolean result = false;
		Connection connection = null;
		PreparedStatement pstmt = null;
		
		try {
			//1. JDBC Driver 로딩 (JDBC Class 로딩: class loader)
			Class.forName("org.mariadb.jdbc.Driver");
			
			//2. 연결하기
			String url = "jdbc:mysql://192.168.10.41:3307/webdb?charset=utf8";
			connection = DriverManager.getConnection(url, "webdb", "webdb");
			
			//3. SQL 준비
			String sql =
				"update department" + 
				"   set name=?" +
			    " where no=?";
			pstmt = connection.prepareStatement(sql);
			
			//4. Parameter Mapping(binding)
			pstmt.setString(1, vo.getName());
			pstmt.setLong(2, vo.getNo());
			
			//5. SQL 실행
			int count = pstmt.executeUpdate();
			result = count == 1;
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		} catch (SQLException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		} finally {
			try {
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
