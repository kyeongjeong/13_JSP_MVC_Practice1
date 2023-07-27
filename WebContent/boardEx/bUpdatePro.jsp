<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="boardEx.BoardDAO" %>
<%@ page import="boardEx.BoardDTO" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>bUpdatePro</title>
</head>
<body>

	<%
		request.setCharacterEncoding("utf-8");
	
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setBoardId(Long.parseLong(request.getParameter("boardId")));
		boardDTO.setSubject(request.getParameter("subject"));
		boardDTO.setContent(request.getParameter("content"));
		
		BoardDAO.getInstance().updateBoard(boardDTO);
	%>

	<script>
		alert("수정되었습니다.");
		location.href = "bList.jsp";
	</script>
</body>
</html>