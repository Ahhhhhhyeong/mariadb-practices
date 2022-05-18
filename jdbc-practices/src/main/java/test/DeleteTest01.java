package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteTest01 {

	public static void main(String[] args) {
//		delete((long) 5);
//		delete((long) 6);
//		delete((long) 7);
		
		deleteAll();
	}
	private static void deleteAll() {
		// 1. JDBC Driver 로딩(JDBC 클래스 로딩: class Loader)
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
				String sql = "delete from department";
				stat.executeUpdate(sql);
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
				
		
	}
	
	private static boolean delete(Long no) {
		// 1. JDBC Driver 로딩(JDBC 클래스 로딩: class Loader)
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
						String sql = "delete from department where no = " + no;
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
