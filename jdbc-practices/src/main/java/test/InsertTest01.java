package test;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class InsertTest01 {
	public static void main(String[] args) {
		insert("cs");
		insert("경영지원팀");
		insert("인프라");
	}
	
	
	public static boolean insert(String name) {
		// 1. JDBC Driver 로딩(JDBC 클래스 로딩: class Loader)
		boolean result = false;
		Connection connection = null;
		Statement stat = null; 
		try {
				Class.forName("org.mariadb.jdbc.Driver"); // static에서 커넥션을 만듦 / 오타 조심!
							
				// 2. 연결하기
				String url = "jdbc:mysql://192.168.10.41:3307/webdb?charset=utf8";
				connection = DriverManager.getConnection(url, "webdb", "webdb");

				// 3. Statement 생성
				stat = connection.createStatement();
					
				// 4. SQL 실행
				String sql = "INSERT INTO department values (null, '"+ name +"')";
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
