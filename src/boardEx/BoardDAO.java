package boardEx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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
	
	public void insertBoard(BoardDTO boardDTO) {
		
		//System.out.println(boardDTO);
		
		try {
			
			getConnection();
			
			String sql = "INSERT INTO BOARD(WRITER , EMAIL , SUBJECT , PASSWORD , CONTENT , READ_CNT , ENROLL_DT)";
			sql += "VALUES(? , ? , ? , ? , ? , 0 , NOW())";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardDTO.getWriter());
			pstmt.setString(2, boardDTO.getEmail());
			pstmt.setString(3, boardDTO.getSubject());
			pstmt.setString(4, boardDTO.getPassword());
			pstmt.setString(5, boardDTO.getContent());
			pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			getClose();
		}
	}
	
	public ArrayList<BoardDTO> getBoardList() {
		
		ArrayList<BoardDTO> boardList = new ArrayList<>();
		
		try {
			
			getConnection();
			
			pstmt = conn.prepareStatement("SELECT * FROM BOARD");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				BoardDTO boardTemp = new BoardDTO();
				boardTemp.setBoardId(rs.getLong("BOARD_ID"));
				boardTemp.setWriter(rs.getString("WRITER"));
				boardTemp.setEmail(rs.getString("EMAIL"));
				boardTemp.setSubject(rs.getString("SUBJECT"));
				boardTemp.setPassword(rs.getString("PASSWORD"));
				boardTemp.setContent(rs.getString("CONTENT"));
				
				boardList.add(boardTemp);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			getClose();
		}
		
		//System.out.println(boardList);
		
		return boardList;
	}
}
