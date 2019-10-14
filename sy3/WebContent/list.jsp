<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图书列表</title>
<style>
   .ps{background-color:#99CCFF}
</style>
<script type="text/javascript">
function del_book(){
	confirm("您确定要删除该图书吗？");
}
</script>
</head>
<body>
<table border="1" align="center">
<tr>
<th>书名</th>
<th>作者</th>
<th>出版社</th>
<th>ISBN</th>
<th>图书类别</th>
<th>单价</th>
<th>编辑</th>
<th>删除</th>
</tr>
<c:forEach var="book" items="${list}">
<tr>
<td>${book.bookName}</td>
<td>${book.author}</td>
<td>${book.press}</td>
<td>${book.isbn }</td>
<td>${book.category }</td>
<td>${book.price }</td>
<td>
 <a href="${pageContext.request.contextPath}/FindBookByID?id=${book.id } ">
    <img src="${pageContext.request.contextPath }/images/i_edit.gif" style="CURSOR:hand">
 </a>
</td>
<td>
 <a href="${pageContext.request.contextPath}/DeleteBook?id=${book.id }" onClick="del_book()">
   <img src="${pageContext.request.contextPath }/images/i_edit.gif" style="CURSOR:hand">
 </a>
</td>
</tr>
</c:forEach>
</table>
<p align="center"><a href="/sy3/add.jsp"><b>增添图书</b></a></p>
</body>
</html>
    