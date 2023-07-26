<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="memberEx.MemberDAO"%>
<%@page import="memberEx.MemberDTO"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>loginPro</title>
	<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
</head>
<body>
	
	<%
		request.setCharacterEncoding("utf-8");
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setMemberId(request.getParameter("memberId"));
		memberDTO.setPasswd(request.getParameter("passwd"));
		
		if(MemberDAO.getInstance().loginMember(memberDTO)) {
			
			session.setAttribute("memberId", request.getParameter("memberId"));
	%>
			<script>
				Swal.fire(
					
					'로그인 되었습니다',
					'<b style="color:green;">게시글 목록으로 이동합니다.</b>',
			        'success'
				)
				.then(function() {
					
					location.href = "../boardEx/bList.jsp";
				})
			</script>
	<%
		}
	%>
	
</body>
</html>