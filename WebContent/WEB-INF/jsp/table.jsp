<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="Model.dbBean"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<table border="1" width="100%">
	<tr>
		<th>学籍番号</th>
		<th>氏名</th>
		<th>数学</th>
		<th>英語</th>
		<th>国語</th>
		<th>理科</th>
	</tr>
	<c:forEach var="onerecord" items="${record.allRecord }">
		<tr>
			<td><c:out value="${onerecord.studentNo}" /></td>
			<td><c:out value="${onerecord.studentName}" /></td>
			<td><c:out value="${onerecord.math}" /></td>
			<td><c:out value="${onerecord.english}" /></td>
			<td><c:out value="${onerecord.japanese}" /></td>
			<td><c:out value="${onerecord.science}" /></td>
		</tr>
	</c:forEach>
</table>
