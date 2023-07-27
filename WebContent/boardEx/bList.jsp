<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="boardEx.BoardDAO" %>
<%@ page import="boardEx.BoardDTO" %>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>bList</title>
</head>
<body>
	
	<%
		String memberId = (String)session.getAttribute("memberId");
	%>
	
	<p style="text-align:right">
		환영합니다 <%=memberId %>님<br>
		<input type="button" value="마이페이지" onclick="location.href='../memberEx/mDetail.jsp'">
	</p>
	
	<div align="center">
		<h3>커뮤니티 게시글</h3>
		<table border="1">
			<tr>
				<td>번호</td>
				<td>제목</td>
				<td>작성자</td>
				<td>작성일</td>
				<td>조회수</td>
			</tr>
			<%
				int idx = 1;
				ArrayList<BoardDTO> boardList = BoardDAO.getInstance().getBoardList();
				
				for(BoardDTO boardDTO : boardList) {
			%>
					<tr>
						<td><%=idx++ %></td>
						<td><a href="bDetail.jsp?boardId=<%=boardDTO.getBoardId()%>"><%=boardDTO.getSubject() %></a></td>
						<td><%=boardDTO.getWriter() %></td>
						<td><%=boardDTO.getEnrollDt() %></td>
						<td><%=boardDTO.getReadCnt() %></td>
					</tr>
			<%
				}
			%>
			<tr>
				<td colspan="5">
					<input type="button" value="글쓰기" onclick="location.href='bWrite.jsp'">
				</td>
			</tr>
		</table>
	</div>

</body>
</html>