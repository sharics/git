<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<article>
	<table>
		<tr>
			<th>게시판입니다</th>
		</tr>
		<tr>
			<th>No</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
		<c:forEach var="b" items="${ boardList }">
		<tr>
			<td>${ b.bno }</td>
			<td>${ b.title }</td>
			<td>${ b.writer }</td>
			<td>${ b.reg_date }</td>
			<td>${ b.read_count }</td>
		</tr>
		</c:forEach>
	</table>
</article>