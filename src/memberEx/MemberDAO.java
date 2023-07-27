package memberEx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAO {

	private MemberDAO() {}
	private static MemberDAO instance = new MemberDAO();
	public static MemberDAO getInstance() {
		return instance;
	}
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private void getConnection() {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/MVC1_PRACTICE?serverTimezone=Asia/Seoul", "root", "1234");
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private void getClose() {
		if (rs != null)    {try {rs.close();}    catch (SQLException e) {}}
		if (pstmt != null) {try {pstmt.close();} catch (SQLException e) {}}
		if (conn != null)  {try {conn.close();}  catch (SQLException e) {}}
	}
	
	public boolean loginMember(MemberDTO memberDTO) {
		
		boolean isLogin = false;
		
		try {
			
			getConnection();
			pstmt = conn.prepareStatement("SELECT * FROM MEMBER WHERE MEMBER_ID = ? AND PASSWD = ?");
			pstmt.setString(1, memberDTO.getMemberId());
			pstmt.setString(2, memberDTO.getPasswd());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				isLogin = true;
			}
		}		
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			getClose();
		}
		
		return isLogin;
	}
	
	public boolean insertMember(MemberDTO memberDTO) {
		
		boolean isInsert = false;
		
		try {
			
			getConnection();
			pstmt = conn.prepareStatement("SELECT * FROM MEMBER WHERE MEMBER_ID = ?");
			pstmt.setString(1, memberDTO.getMemberId());
			rs = pstmt.executeQuery();
			
			if (rs.next())
				return isInsert;
			
			else {
				
				pstmt = conn.prepareStatement("INSERT INTO MEMBER VALUES(? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , NOW())");
				pstmt.setString(1, memberDTO.getMemberId());
				pstmt.setString(2, memberDTO.getMemberNm());
				pstmt.setString(3, memberDTO.getPasswd());
				pstmt.setString(4, memberDTO.getSex());
				pstmt.setString(5, memberDTO.getBirthDt());
				pstmt.setString(6, memberDTO.getHp());
				pstmt.setString(7, memberDTO.getSmsRecvAgreeYn());
				pstmt.setString(8, memberDTO.getEmail());
				pstmt.setString(9, memberDTO.getEmailRecvAgreeYn());
				pstmt.setString(10, memberDTO.getZipcode());
				pstmt.setString(11, memberDTO.getRoadAddress());
				pstmt.setString(12, memberDTO.getJibunAddress());
				pstmt.setString(13, memberDTO.getNamujiAddress());
				pstmt.executeUpdate();
			}
		}		
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			getClose();
		}
		
		return isInsert;
	}
	
	public MemberDTO getMemberDetail(String memberId) {
		
		MemberDTO memberDTO = new MemberDTO();
		
		try {
			
			getConnection();
			pstmt = conn.prepareStatement("SELECT * FROM MEMBER WHERE MEMBER_ID = ?");
			pstmt.setString(1, memberId);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				memberDTO.setMemberId(memberId);
				memberDTO.setMemberNm(rs.getString("MEMBER_NM"));
				memberDTO.setSex(rs.getString("SEX"));
				memberDTO.setBirthDt(rs.getString("BIRTH_DT"));
				memberDTO.setHp(rs.getString("HP"));
				memberDTO.setSmsRecvAgreeYn(rs.getString("SMS_RECV_AGREE_YN"));
				memberDTO.setEmail(rs.getString("EMAIL"));
				memberDTO.setEmailRecvAgreeYn(rs.getString("EMAIL_RECV_AGREE_YN"));
				memberDTO.setZipcode(rs.getString("ZIPCODE"));
				memberDTO.setRoadAddress(rs.getString("ROAD_ADDRESS"));
				memberDTO.setJibunAddress(rs.getString("JIBUN_ADDRESS"));
				memberDTO.setNamujiAddress(rs.getString("NAMUJI_ADDRESS"));
				memberDTO.setJoinDt(rs.getDate("JOIN_DT"));
			}
		}		
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			getClose();
		}
		
		return memberDTO;
	}
	
	public String getMemberNm(String memberId) {
		
		String memberNm = null;
		
		try {
			
			getConnection();
			pstmt = conn.prepareStatement("SELECT * FROM MEMBER WHERE MEMBER_ID = ?");
			pstmt.setString(1, memberId);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {			
				memberNm = rs.getString("MEMBER_NM");
			}
		}		
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			getClose();
		}
		
		return memberNm;
	}
}
