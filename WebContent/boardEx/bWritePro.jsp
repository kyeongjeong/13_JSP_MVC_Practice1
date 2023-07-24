<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="boardEx.BoardDAO" %>
<%@ page import="boardEx.BoardDTO" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>bWritePro</title>
	<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
</head>
<body>
	
	<%
		request.setCharacterEncoding("utf-8");
	
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setWriter(request.getParameter("writer"));
		boardDTO.setSubject(request.getParameter("subject"));
		boardDTO.setEmail(request.getParameter("email"));
		boardDTO.setPassword(request.getParameter("password"));
		
		BoardDAO.getInstance().insertBoard(boardDTO);
	%>
	
	<script>
		Swal.fire(
			
			'게시글이 등록되었습니다.',
			'<b style="color:green;">게시글 목록으로 이동합니다.</b>',
	        'success'
		)
		.then(function() {
			
			location.href = "bList.jsp";
		})
	</script>
	
</body>
</html>