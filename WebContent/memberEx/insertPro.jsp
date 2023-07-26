<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="memberEx.MemberDAO"%>
<%@page import="memberEx.MemberDTO"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>insertPro</title>
</head>
<body>
	
	<%
		request.setCharacterEncoding("utf-8");
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setMemberId(request.getParameter("memberId"));
		memberDTO.setPasswd(request.getParameter("passwd"));
		memberDTO.setMemberNm(request.getParameter("memberNm"));
		memberDTO.setSex(request.getParameter("sex"));
		memberDTO.setBirthDt(request.getParameter("birthDt"));
		
		memberDTO.setHp(request.getParameter("hp"));		
		if(request.getParameter("smsRecvAgreeYn") == null) {
			memberDTO.setSmsRecvAgreeYn("N");
		}
		else
			memberDTO.setSmsRecvAgreeYn("Y");
		
		memberDTO.setEmail(request.getParameter("email"));
		if(request.getParameter("emailRecvAgreeYn") == null) {
			memberDTO.setEmailRecvAgreeYn("N");
		}
		else
			memberDTO.setEmailRecvAgreeYn("Y");
		
		memberDTO.setZipcode(request.getParameter("zipcode"));
		memberDTO.setRoadAddress(request.getParameter("roadAddress"));
		memberDTO.setJibunAddress(request.getParameter("jibunAddress"));
		memberDTO.setNamujiAddress(request.getParameter("namujiAddress"));
		
		boolean isRegister = MemberDAO.getInstance().insertMember(memberDTO);
		if(isRegister) {
	%>
			<script>
				alert("가입되었습니다.");
				location.href = "main.jsp";
			</script>
	<%
		}
		else {
	%>
			<script>
				alert("중복된 아이디 입니다.");
				history.go(-1);s
			</script>
	<%
		}
	%>
	
</body>
</html>