package driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MydriverTest {

	public static void main(String[] args) {
		// 1. JDBC Driver 로딩(JDBC 클래스 로딩: class Loader)
		Connection connection = null;
		try {
				Class.forName("driver.MyDriver");			
				
				// 2. 연결하기
				String url = "jdbc:mariadb://127.0.0.1:3307/webdb?charset=utf8";
				connection = DriverManager.getConnection(url, "webdb", "webdb");
				
				System.out.println("CONNECTED!!");			
				
			} catch (ClassNotFoundException e) {
					System.out.println("---FAIL---Driver Load " + e);
				}catch (SQLException e) {
					System.out.println("---FAIL---Driver Error " + e);
				}finally {			
					try {
						if(connection != null) {
							connection.close();
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				
	}

}
