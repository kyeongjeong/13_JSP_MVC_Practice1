package boardEx;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.DriverManager;

public class BoardDAO {
	
	private BoardDAO() {}
	private static BoardDAO instance = new BoardDAO();
	public static BoardDAO getInstance() {
		return instance;
	}
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public void getConnection() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/MVC1_PRACTICE?serverTimezone=Asia/Seoul", "root", "1234");
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void getClose() {
		if (rs != null)    try {rs.close();} catch (Exception e) {e.printStackTrace();}
		if (pstmt != null) try {pstmt.close();} catch (Exception e) {e.printStackTrace();}
		if (conn != null)  try {conn.close();} catch (Exception e) {e.printStackTrace();}
	}
	
	public void insertBoard() {
		
		try {
			
			getConnection();
			
			String sql = "";
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			getClose();
		}
	}
}
