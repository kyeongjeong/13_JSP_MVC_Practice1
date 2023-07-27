<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="memberEx.MemberDAO" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>bWrite</title>
</head>
<body>

	<%
		String memberId = (String)session.getAttribute("memberId");
		String memberNm = MemberDAO.getInstance().getMemberNm(memberId);
	%>

	<p style="text-align:right">
		환영합니다 <%=memberId %>님<br>
		<input type="button" value="마이페이지" onclick="location.href='../memberEx/mDetail.jsp'">
	</p>
	
	<div align="center">
		<h3>커뮤니티 게시글 작성</h3>
		<form action="bWritePro.jsp" method="post">
			<table border="1">
				<tr>
					<td>작성자</td>
					<td><input type="text" value=<%=memberNm %> name="writer" disabled/></td>
				</tr>
				<tr>
					<td>제목</td>
					<td><input type="text" name="subject" /></td>
				</tr>
				<tr>
					<td>이메일</td>
					<td><input type="text" name="email" /></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="password" /></td>
				</tr>
				<tr>
					<td align="center">글내용</td>
					<td>
						<textarea rows="10" cols="50" name="content" ></textarea>
						<script>CKEDITOR.replace("content");</script>
					</td>
				</tr>
				</table>
				<p>
					<input type="submit" value="작성"/>
					<input type="button" value="목록보기" onclick="location.href='bList.jsp'">
				</p>
		</form>
	</div>
	
</body>
</html>